package Clients;

import Cards.Card;
import Ticketing.Event;
import Ticketing.Ticket;
import Ticketing.Venue;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Client extends Person{
    private int Id;
    private Card card;
    ArrayList<Ticket> tickets = new ArrayList<>();

    @Override
    public String toString() {
        String ticketString = new String();
        for(Ticket item:tickets) {
            ticketString = ticketString + item + '\n' + "\t\t";
        }
        return "Client{" +
                "lastName='" + this.lastName + '\'' +
                ", firstName='" + this.firstName + '\'' +
                ", birthday='" + this.birthday + '\'' +
                ", address='" + this.address + '\'' +
                ", id='" + this.Id + '\'' +
                ", " + '\n' + '\t' + this.card.toString() +
                ", " + '\n' + '\t' + ticketString +
                '}';
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Client(String lastName, String firstName, Date birthday, String address, int id, Card card) {
        super(lastName, firstName, birthday, address);
        Id = id;
        this.card = card;
    }

    public Client() {
        super();
        this.Id = -1;
        this.card = null;
    }

}
