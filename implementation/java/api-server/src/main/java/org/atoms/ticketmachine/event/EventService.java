package org.atoms.ticketmachine.event;

import org.atoms.ticketmachine.GenericService;
import org.atoms.ticketmachine.jpa.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class EventService extends GenericService<Event,
  org.atoms.ticketmachine.pojos.Event, EventRepository> {

  @Autowired
  public EventService(final EventRepository eventRepository,
                      final Function<Event, org.atoms.ticketmachine.pojos.Event> mapEntityToPojo,
                      final Function<org.atoms.ticketmachine.pojos.Event, Event> mapPojoToEntity) {
    super(eventRepository, mapEntityToPojo, mapPojoToEntity);
  }
}
