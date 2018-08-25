package org.atoms.ticketmachine.jpa;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Purchase {

  @Id
  private UUID id;
  @OneToMany(mappedBy = "purchase")
  private List<Ticket> tickets;
  @OneToOne
  private Event event;
  @OneToMany(mappedBy = "purchase")
  private List<Payment> payments;
  @ManyToOne
  private Customer customer;
  @Version
  private long version;

}
