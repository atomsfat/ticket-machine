package org.atoms.ticketmachine.features.user;

import org.atoms.ticketmachine.features.GenericService;
import org.atoms.ticketmachine.jpa.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserService extends GenericService<Customer,
  org.atoms.ticketmachine.pojos.Customer, UserRepository> {

  @Autowired
  public UserService(final UserRepository userRepository,
                     final Function<Customer, org.atoms.ticketmachine.pojos.Customer> mapEntityToPojo,
                     final Function<org.atoms.ticketmachine.pojos.Customer, Customer> mapPojoToEntity) {
    super(userRepository, mapEntityToPojo, mapPojoToEntity);
  }
}
