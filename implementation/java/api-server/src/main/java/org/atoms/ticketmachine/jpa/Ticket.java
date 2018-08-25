package org.atoms.ticketmachine.jpa;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import java.util.UUID;

@Entity
@Data
public class Ticket {

  @Id
  private UUID id;
  @OneToOne
  private Event event;
  @ManyToOne
  @JoinColumn(name = "purchase_id")
  private Purchase purchase;
  @OneToOne
  private Seat seat;
  private Double finalPrice;
  @Version
  private long version;
}
