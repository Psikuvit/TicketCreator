package psikuvit.ticketcreator;

import java.util.UUID;

public class Ticket {

    UUID ticketOpener;
    String ticketID;

    public Ticket(UUID ticketOpener, String ticketID) {
        this.ticketOpener = ticketOpener;
        this.ticketID = ticketID;
    }

    public String getTicketID() {
        return ticketID;
    }

    public UUID getTicketOpener() {
        return ticketOpener;
    }
}
