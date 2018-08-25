package org.atoms.ticketmachine.features.venue;

import org.atoms.ticketmachine.jpa.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VenueRepository extends JpaRepository<Venue, UUID> {
}
