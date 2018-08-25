package org.atoms.ticketmachine.venue;

import org.atoms.ticketmachine.GenericService;
import org.atoms.ticketmachine.jpa.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class VenueService extends GenericService<Venue, org.atoms.ticketmachine.pojos.Venue, VenueRepository> {

  @Autowired
  public VenueService(final VenueRepository venueRepository,
                      final Function<Venue, org.atoms.ticketmachine.pojos.Venue> mapEntityToPojo,
                      final Function<org.atoms.ticketmachine.pojos.Venue, Venue> mapPojoToEntity) {
    super(venueRepository, mapEntityToPojo, mapPojoToEntity);
  }
}
