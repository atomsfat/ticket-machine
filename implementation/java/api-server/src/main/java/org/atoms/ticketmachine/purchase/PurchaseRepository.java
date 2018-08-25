package org.atoms.ticketmachine.purchase;

import org.atoms.ticketmachine.jpa.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PurchaseRepository extends JpaRepository<Purchase, UUID> {
}
