package org.atoms.ticketmachine.user;


import org.atoms.ticketmachine.jpa.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<Customer, UUID> {
}
