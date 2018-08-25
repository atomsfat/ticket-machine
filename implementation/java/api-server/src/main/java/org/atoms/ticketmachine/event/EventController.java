package org.atoms.ticketmachine.event;

import org.atoms.ticketmachine.GenericController;
import org.atoms.ticketmachine.pojos.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController extends GenericController<Event, EventService> {

  @Autowired
  public EventController(@Value("${app.max.rows}") final int maxRows, final EventService eventService) {
    super(maxRows, eventService);
  }

  @GetMapping("/events")
  @Override
  public ResponseEntity<List<Event>> findAll(final @RequestParam(name = "page", defaultValue = "0") Integer page) {
    return super.findAll(page);
  }
}
