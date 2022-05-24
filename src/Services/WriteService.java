package Services;

import Cards.CreditCard;
import Clients.Client;
import Ticketing.Event;
import Ticketing.Ticket;
import Ticketing.Venue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class WriteService {

    private static WriteService instance = null;

    private WriteService() {}

    public static WriteService getInstance() {
        if(instance == null) {
            instance = new WriteService();
        }
        return instance;
    }


    public void writeCLientCSV(Client cli) {
        try(var out = new BufferedWriter(new FileWriter("Files/clients.csv", true))) {
            String crdString;
            if (cli.getCard() instanceof CreditCard) {
                crdString = "credit";
            }
            else {
                crdString = "debit";
            }

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            crdString = crdString + ","
                    + cli.getCard().getNumber() + ","
                    + sdf.format(cli.getCard().getExpirationDate()) + ","
                    + cli.getCard().getCVV() + ","
                    + cli.getCard().getBalance();


            String obj = "\n" + cli.getId() + ","
                    + cli.getLastName() + ","
                    + cli.getFirstName() + ","
                    + sdf.format(cli.getBirthday()) + ","
                    + cli.getAddress() + ","
                    + crdString;

            out.write(obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeVenuesCSV(Venue ven) {
        try(var out = new BufferedWriter(new FileWriter("Files/venues.csv", true))) {
            String obj = "\n" + ven.getId() + ","
                    + ven.getName() + ","
                    + ven.getLocation() + ","
                    + ven.getPriceMultiplier();

            out.write(obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeEventsCSV(Event ev) {
        try(var out = new BufferedWriter(new FileWriter("Files/events.csv", true))) {
            String obj = "\n" + ev.getId() + ","
                    + ev.getName() + ","
                    + ev.getGenre() + ","
                    + ev.getLengthMinutes() + ","
                    + ev.getBasePrice();

            out.write(obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeTicketsCSV(int id, Ticket ticket) {
        try(var out = new BufferedWriter(new FileWriter("Files/tickets.csv", true))) {
            Event ev = ticket.getEvent();
            Venue ven = ticket.getVenue();
            String objEv = "\n" + id + ","
                    + ev.getId() + ","
                    + ev.getName() + ","
                    + ev.getGenre() + ","
                    + ev.getLengthMinutes() + ","
                    + ev.getBasePrice() + ",";

            String obj = objEv + ven.getId() + ","
                    + ven.getName() + ","
                    + ven.getLocation() + ","
                    + ven.getPriceMultiplier();

            out.write(obj);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
