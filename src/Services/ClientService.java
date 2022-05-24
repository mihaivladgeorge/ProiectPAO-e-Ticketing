package Services;

import Cards.Card;
import Cards.CreditCard;
import Cards.DebitCard;
import Clients.Client;
import Ticketing.Event;
import Ticketing.Ticket;
import Ticketing.Venue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ClientService {

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    CardService crdServ = new CardService();
    ArrayList<Client> allClients = new ArrayList<>();

    ReadService readServ;
    WriteService writeServ;
    AuditService auditServ;

    public ClientService() {
        readServ = ReadService.getInstance();
        writeServ = WriteService.getInstance();
        auditServ = AuditService.getInstance();
    }

    public Client addClientHard() {
        Client cli;
        try {
            cli = new Client("andreescu",
                    "andrei",
                    sdf.parse("17-10-2000"),
                    "Strada Georgescu Solomon Nr. 5",
                    1,
                    crdServ.addCardHard());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        allClients.add(cli);

        auditServ.writeLogs("addedClientHardCoded");

        return cli;
    }

    public Client addClient() throws ParseException {
        Scanner in = new Scanner(System.in);
        System.out.println("New Client data:");
        System.out.print("Enter Client Last Name: ");
        String lastname = in.nextLine();
        System.out.print("Enter Client First Name: ");
        String firstname = in.nextLine();
        System.out.print("Enter Client Birthday(DD-MM-YYYY): ");
        String birthday = in.nextLine();
        System.out.print("Enter Client Address: ");
        String address = in.nextLine();
        System.out.print("Enter Client Id: ");
        int id = in.nextInt();
        in.nextLine();
        Card crd = crdServ.addCard();

        Client cli;
        try {
            cli = new Client(lastname, firstname, sdf.parse(birthday), address, id, crd);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        allClients.add(cli);

        writeServ.writeCLientCSV(cli);

        auditServ.writeLogs("addedClient");

        DBClientService.AddClient(cli, crd);
        DBCardService.addCard(crd, cli.getId());
        return cli;
    }

    public Client getClient(int id) {
        for(Client item:allClients) {
            if(item.getId() == id)
                return item;
        }
        System.out.println("Client not found");
        return null;
    }

    public Client modifyClientName(int id) throws ParseException {
        Client cli = this.getClient(id);
        Scanner in = new Scanner(System.in);
        System.out.print("Enter new last name for the client:");
        String lastname = in.nextLine();
        System.out.print("Enter new first name for the client:");
        String firstname = in.nextLine();

        cli.setLastName(lastname);
        cli.setFirstName(firstname);

        auditServ.writeLogs("modifiedClient");

        DBClientService.updateClient(cli, lastname, firstname);

        return cli;
    }

    public void printClients() {
        for(Client item:allClients) {
            System.out.println(item.toString());
        }
        auditServ.writeLogs("showedClients");
    }

    public List<Client> addClientsDB(List<Client> clis) {
        this.allClients.addAll(clis);
        return clis;
    }

    public void deleteClient(int id) throws ParseException {
        for (Client o : this.allClients) {
            if(o.getId() == id) {
                DBClientService.deleteClient(o);
                this.allClients.remove(o);
                break;
            }
        }
    }

    public void buyTicket(int id, Ticket ticket, boolean startup) {
        if(ticket != null) {
            Client cli = this.getClient(id);
            if (cli.getCard().makeTransaction(ticket.getPrice())) {
                this.getClient(id).addTicket(ticket);
                if(!startup)
                    writeServ.writeTicketsCSV(id, ticket);
                auditServ.writeLogs("clientBoughtTicket");
                DBCardService.updateCard(cli.getCard(), cli.getId(), cli.getCard().getBalance() - ticket.getPrice());
            }
            else
                System.out.println("Tranzactia nu se poate finaliza, sold insuficient");
        }
    }

    public void addClientsCSV() {
        ArrayList<String> list = readServ.readCSV("Files/clients.csv");
        for(String line: list) {
            String [] fields = line.replaceAll(" ", "").split(",");
            try {
                Card crd = null;
                if (fields[5].equals("credit")) {
                    crd = new CreditCard(fields[6],
                            sdf.parse(fields[7]),
                            Integer.parseInt(fields[8]),
                            Float.parseFloat(fields[9]));
                }
                else if(fields[5].equals("debit")) {
                    crd = new DebitCard(fields[6],
                            sdf.parse(fields[7]),
                            Integer.parseInt(fields[8]),
                            Float.parseFloat(fields[9]));
                }
                int Id = Integer.parseInt(fields[0]);
                Client client = new Client(fields[1],
                        fields[2],
                        sdf.parse(fields[3]),
                        fields[4],
                        Id,
                        crd);
                allClients.add(client);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void addTicketsCSV() {
        ArrayList<String> list = readServ.readCSV("Files/tickets.csv");
        for (String line : list) {
            String[] fields = line.replaceAll(" ", "").split(",");
            int ownerId = Integer.parseInt(fields[0]);
            Event ev;
            ev = new Event(Integer.parseInt(fields[1]),
                    fields[2],
                    fields[3],
                    Integer.parseInt(fields[4]),
                    Float.parseFloat(fields[5]));
            Venue ven;
            ven = new Venue(Integer.parseInt(fields[6]),
                    fields[7],
                    fields[8],
                    Float.parseFloat(fields[9]));
            Ticket ticket;
            ticket = new Ticket(ev, ven);

            this.buyTicket(ownerId, ticket, true);
        }
    }
}
