package org.atoms.ticketmachine.Ticket;

import org.atoms.ticketmachine.GenericService;
import org.atoms.ticketmachine.jpa.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TicketService extends GenericService<Ticket, org.atoms.ticketmachine.pojos.Ticket, TicketRepository> {

  @Autowired
  public TicketService(final TicketRepository ticketRepository,
                       final Function<Ticket, org.atoms.ticketmachine.pojos.Ticket> mapEntityToPojo,
                       final Function<org.atoms.ticketmachine.pojos.Ticket, Ticket> mapPojoToEntity) {
    super(ticketRepository, mapEntityToPojo, mapPojoToEntity);
  }
}
