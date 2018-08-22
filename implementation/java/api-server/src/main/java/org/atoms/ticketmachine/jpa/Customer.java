package org.atoms.ticketmachine.jpa;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Customer extends User {

  @OneToMany(mappedBy = "customer")
  private List<Purchase> purchases;

}
