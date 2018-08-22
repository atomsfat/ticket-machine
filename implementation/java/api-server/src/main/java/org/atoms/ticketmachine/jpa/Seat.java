package org.atoms.ticketmachine.jpa;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Seat {

  @Id
  private UUID id;
  private String name;
  private String row;
  @Column(name = "columna")
  private String column;
  private Double price;
  private Double commission;
  private String Status;
  private String section;
  private String type;
  @ManyToOne
  private SeatScheme seatScheme;
  @Version
  private long version;
}
