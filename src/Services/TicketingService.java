package Services;

import Ticketing.Event;
import Ticketing.Ticket;
import Ticketing.Venue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicketingService {

    ArrayList<Event> events = new ArrayList<>();
    ArrayList<Venue> venues = new ArrayList<>();

    ReadService readServ;
    WriteService writeServ;
    AuditService auditServ;

    public TicketingService() {
        readServ = ReadService.getInstance();
        writeServ = WriteService.getInstance();
        auditServ = AuditService.getInstance();
    }

    public Venue addVenue() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Venue Information: ");
        System.out.print("Enter Venue Id");
        int id = in.nextInt();
        in.nextLine();
        System.out.print("Enter Venue Name");
        String name = in.nextLine();
        System.out.print("Enter Venue Location");
        String location = in.nextLine();
        System.out.print("Enter Venue Price Multiplier");
        float priceMultiplier = in.nextFloat();
        in.nextLine();

        Venue ven = new Venue(id, name, location, priceMultiplier);
        venues.add(ven);

        auditServ.writeLogs("addedVenue");

        writeServ.writeVenuesCSV(ven);

        DBVenueService.addVenue(ven);

        return ven;
    }

    public List<Venue> addVenuesDB(List<Venue> vens) {
        this.venues.addAll(vens);
        return vens;
    }

    public List<Event> addEventsDB(List<Event> eves) {
        this.events.addAll(eves);
        return eves;
    }

    public Venue getVenueById(int id) {
        for(Venue item:venues) {
            if(item.getId() == id)
                return item;
        }
        System.out.println("Venue not found");
        return null;
    }

    public Venue modifyVenueName(int id) {
        Venue ven = this.getVenueById(id);
        Scanner in = new Scanner(System.in);
        System.out.print("Enter new name for the venue:");
        String name = in.nextLine();
        ven.setName(name);

        auditServ.writeLogs("modifiedVenue");

        DBVenueService.updateVenue(ven, name);

        return ven;
    }

    public void deleteVenue(int id) {
        for (Venue o : this.venues) {
            if (o.getId() == id) {
                DBVenueService.deleteVenue(o);
                this.venues.remove(o);
                break;
            }
        }
    }

    public void deleteEvent(int id) {
        for (Event o : this.events) {
            if (o.getId() == id) {
                DBEventService.deleteEvent(o);
                this.events.remove(o);
                break;
            }
        }
    }

    public void printVenues() {
        for(Venue item:venues) {
            System.out.println(item.toString());
        }
        auditServ.writeLogs("showedVenues");
    }

    public Event addEvent() {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter Event Informations: ");
        System.out.print("Enter Event Id: ");
        int id = in.nextInt();
        in.nextLine();
        System.out.print("Enter Event Name: ");
        String name = in.nextLine();
        System.out.print("Enter Event Genre: ");
        String genre = in.nextLine();
        System.out.print("Enter Event Length in Minutes: ");
        int length = in.nextInt();
        in.nextLine();
        System.out.print("Enter Event Base Price: ");
        float basePrice = in.nextFloat();
        in.nextLine();

        Event ev = new Event(id, name, genre, length, basePrice);
        events.add(ev);

        writeServ.writeEventsCSV(ev);

        auditServ.writeLogs("addedEvent");

        DBEventService.addEvent(ev);

        return ev;
    }

    public Event modifyEventName(int id) {
        Event ev = this.getEventsById(id);
        Scanner in = new Scanner(System.in);
        System.out.print("Enter new name for the event:");
        String name = in.nextLine();
        ev.setName(name);

        auditServ.writeLogs("modifiedEvent");

        DBEventService.updateEvent(ev, name);

        return ev;
    }

    public void printEvents() {
        for(Event item:events) {
            System.out.println(item.toString());
        }
        auditServ.writeLogs("showedEvents");
    }

    public Event getEventsById(int id) {
        for(Event item:events) {
            if(item.getId() == id)
                return item;
        }
        System.out.println("Event not found");
        return null;
    }

    public void addEventToVenue(int evId, int venId) {
        Event ev = getEventsById(evId);
        Venue ven = getVenueById(venId);
        ven.addEvent(ev);

        auditServ.writeLogs("addedEventToVenue");
    }

    public Ticket createTicket() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose a venue by its id: ");
        this.printVenues();
        int venueChoice = in.nextInt();
        System.out.println(venueChoice);
        in.nextLine();
        System.out.println("Choose an event by its id: ");
        this.getVenueById(venueChoice).printEvents();
        int eventChoice = in.nextInt();
        in.nextLine();
        boolean found = false;
        for(Event item:this.getVenueById(venueChoice).getEvents()) {
            if (item.getId() == eventChoice) {
                found = true;
                break;
            }
        }
        if(found) {
            Venue ven = this.getVenueById(venueChoice);
            Event ev = this.getEventsById(eventChoice);

            Ticket ticket = new Ticket(ev, ven);

            auditServ.writeLogs("createdTicket");

            return ticket;
        }
        System.out.println("This venue does not host this event");
        return null;
    }

    public void addVenuesCSV() {
        ArrayList<String> list = readServ.readCSV("Files/venues.csv");
        for(String line:list) {
            String [] fields = line.replaceAll(" ", "").split(",");
            Venue ven;
            ven = new Venue(Integer.parseInt(fields[0]),
                    fields[1],
                    fields[2],
                    Float.parseFloat(fields[3]));
            venues.add(ven);
        }
    }

    public void addEventsCSV() {
        ArrayList<String> list = readServ.readCSV("Files/events.csv");
        for(String line:list) {
            String [] fields = line.replaceAll(" ", "").split(",");
            Event ev;
            ev = new Event(Integer.parseInt(fields[0]),
                    fields[1],
                    fields[2],
                    Integer.parseInt(fields[3]),
                    Float.parseFloat(fields[4]));
            events.add(ev);
        }
    }

}
