package org.atoms.ticketmachine.jpa;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
@Entity
@Data
public class SeatScheme {

  @Id
  private UUID id;
  @Type(type = "jsonb")
  @Column(columnDefinition = "json")
  private HashMap definition;
  private int capacity;
  @OneToMany(mappedBy = "seatScheme")
  private List<Seat> seats;
  @Version
  private long version;

}
