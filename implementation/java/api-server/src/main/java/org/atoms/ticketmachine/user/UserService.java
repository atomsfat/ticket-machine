package org.atoms.ticketmachine.user;

import org.atoms.ticketmachine.jpa.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

@org.springframework.stereotype.Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public Page<Customer> findAll(Pageable pageable){
    return userRepository.findAll(pageable);
  }

  public Customer save(Customer customer){
    return userRepository.save(customer);
  }

  public Optional<Customer> findById(UUID uuid){
    return  userRepository.findById(uuid);
  }
}
