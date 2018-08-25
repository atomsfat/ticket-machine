package org.atoms.ticketmachine.features.ticket;

import org.atoms.ticketmachine.jpa.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {
}
