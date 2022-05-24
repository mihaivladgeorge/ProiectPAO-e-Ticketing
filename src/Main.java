import Services.*;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        ClientService cliServ = new ClientService();
        TicketingService tickServ = new TicketingService();

        Scanner in = new Scanner(System.in);

        //cliServ.addClientsCSV();
        //tickServ.addVenuesCSV();
        //tickServ.addEventsCSV();
        //cliServ.addTicketsCSV();

        tickServ.addEventsDB(DBEventService.getAllEvents());
        tickServ.addVenuesDB(DBVenueService.getAllVenues());
        cliServ.addClientsDB(DBClientService.getAllClients());

        while(true) {
            System.out.println("Which action would you like to use?");
            System.out.println("1. Add New Client\t2. Add Venue\t3. Add Event");
            System.out.println("4. Show Clients\t5. Show Venues\t6. Show Events");
            System.out.println("7. Buy Ticket\t8. Modify Client\t9. Modify Venue");
            System.out.println("10. Modify Event\t11. Add event to venue\t12. Delete Venue");
            System.out.println("13. Delete Event\t14. Delete Client");
            int choice = in.nextInt();
            in.nextLine();

            switch(choice) {
                case 1:
                    cliServ.addClient();
                    break;
                case 2:
                    tickServ.addVenue();
                    break;
                case 3:
                    tickServ.addEvent();
                    break;
                case 4:
                    cliServ.printClients();
                    break;
                case 5:
                    tickServ.printVenues();
                    break;
                case 6:
                    tickServ.printEvents();
                    break;
                case 7:
                    System.out.print("Choose the id of the client who wants to buy a ticket:");
                    int id = in.nextInt();
                    in.nextLine();
                    cliServ.buyTicket(id, tickServ.createTicket(), false);
                    break;
                case 8:
                    System.out.print("Choose the id of a client to change the name:");
                    id = in.nextInt();
                    in.nextLine();
                    cliServ.modifyClientName(id);
                    break;
                case 9:
                    System.out.print("Choose the id of a venue to change the name:");
                    id = in.nextInt();
                    in.nextLine();
                    tickServ.modifyVenueName(id);
                    break;
                case 10:
                    System.out.print("Choose the id of an event to change the name:");
                    id = in.nextInt();
                    in.nextLine();
                    tickServ.modifyEventName(id);
                    break;
                case 11:
                    System.out.print("Choose the id of the venue:");
                    int idVen = in.nextInt();
                    in.nextLine();
                    System.out.print("Choose the id of the event:");
                    int idEv = in.nextInt();
                    in.nextLine();
                    tickServ.addEventToVenue(idEv, idVen);
                    break;
                case 12:
                    System.out.print("Choose the id of a venue to delete it:");
                    id = in.nextInt();
                    in.nextLine();
                    tickServ.deleteVenue(id);
                    break;
                case 13:
                    System.out.print("Choose the id of an event to delete it:");
                    id = in.nextInt();
                    in.nextLine();
                    tickServ.deleteEvent(id);
                    break;
                case 14:
                    System.out.print("Choose the id of a client to delete it:");
                    id = in.nextInt();
                    in.nextLine();
                    cliServ.deleteClient(id);
                    break;
            }
        }
    }
}
