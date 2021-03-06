package org.atoms.ticketmachine.jpa;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Event {

  @Id
  private UUID id;
  private String name;
  private String hrefDescription;
  @ManyToMany(mappedBy = "events")
  private List<Promoter> promoters;
  @OneToOne
  private Venue venue;
  @OneToOne
  private SeatScheme seatScheme;
  private long capacity;
  @Version
  private long version;

}
