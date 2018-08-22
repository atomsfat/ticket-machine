package org.atoms.ticketmachine.event;

import org.atoms.ticketmachine.jpa.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@org.springframework.stereotype.Service
public class EventService {

  @Autowired
  EventRepository eventRepository;

  public Page<Event> findAll(Pageable pageable){
    return eventRepository.findAll(pageable);
  }

}

