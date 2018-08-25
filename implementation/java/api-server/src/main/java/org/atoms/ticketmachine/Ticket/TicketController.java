package org.atoms.ticketmachine.Ticket;

import org.atoms.ticketmachine.GenericController;
import org.atoms.ticketmachine.pojos.Ticket;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TicketController extends GenericController<Ticket, TicketService> {

  public TicketController(@Value("${app.max.rows}") final int  maxRows, final TicketService ticketService) {
    super(maxRows, ticketService);
  }

  @Override
  @PostMapping("/ticket")
  public Ticket save(@Valid @RequestBody final Ticket ticket) {
    return super.save(ticket);
  }
}
