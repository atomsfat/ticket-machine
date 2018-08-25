package org.atoms.ticketmachine.features.event;

import org.atoms.ticketmachine.jpa.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
}
