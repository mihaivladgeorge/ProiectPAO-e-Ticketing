package Services;

import Entities.VenueEntity;
import Repositories.EventRepository;
import Repositories.VenueRepository;
import Ticketing.Event;
import Ticketing.Venue;

import java.util.ArrayList;
import java.util.List;

public class DBVenueService {

    public static List<Venue> getAllVenues() {
        List<VenueEntity> venueEnitites = VenueRepository.findAll();
        List<Venue> result = new ArrayList<>();

        TicketingService ticketingService = new TicketingService();

        for(VenueEntity venE:venueEnitites) {
            result.add(new Venue(venE.getId(), venE.getName(), venE.getLocation(), venE.getPriceMultiplier()));
        }

        return result;
    }

    public static void addVenue(Venue ven) {
        VenueEntity venueEntity = new VenueEntity();
        venueEntity.setId(ven.getId());
        venueEntity.setName(ven.getName());
        venueEntity.setLocation(ven.getLocation());
        venueEntity.setPriceMultiplier(ven.getPriceMultiplier());

        VenueRepository.addVenue(venueEntity);
    }

    public static void updateVenue(Venue ven, String replacement) {
        VenueEntity venueEntity = new VenueEntity();
        venueEntity.setId(ven.getId());
        venueEntity.setName(ven.getName());
        venueEntity.setLocation(ven.getLocation());
        venueEntity.setPriceMultiplier(ven.getPriceMultiplier());

        VenueRepository.updateVenue(venueEntity, replacement);
    }

    public static void deleteVenue(Venue ven) {
        VenueEntity venueEntity = new VenueEntity();
        venueEntity.setId(ven.getId());
        venueEntity.setName(ven.getName());
        venueEntity.setLocation(ven.getLocation());
        venueEntity.setPriceMultiplier(ven.getPriceMultiplier());

        VenueRepository.deleteVenue(venueEntity);
    }
}
