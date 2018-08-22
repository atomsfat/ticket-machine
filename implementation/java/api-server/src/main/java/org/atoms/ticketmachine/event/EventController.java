package org.atoms.ticketmachine.event;


import org.atoms.ticketmachine.pojos.Event;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.web.bind.annotation.RestController
public class EventController {

  @Value("${max.rows}")
  private int maxRows;

  @Autowired
  EventService eventService;

  @GetMapping("/events")
  public List<Event> findAll(@RequestParam(name="page", defaultValue = "0")Integer page){
    PageRequest pageRequest =  PageRequest.of(page, maxRows);

    Page<org.atoms.ticketmachine.jpa.Event> eventPage = eventService.findAll(pageRequest);
    return eventPage.getContent().stream().map(EventController::entityToDto).
      collect(Collectors.toList());
  }

  public static org.atoms.ticketmachine.jpa.Event  dtoToEntity(Event pojo){
    ModelMapper mapper = new ModelMapper();
    return mapper.map(pojo, org.atoms.ticketmachine.jpa.Event.class);
  }
  public static Event entityToDto(org.atoms.ticketmachine.jpa.Event entity){
    ModelMapper mapper = new ModelMapper();
    return mapper.map(entity, Event.class);
  }
}
