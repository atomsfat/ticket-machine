package org.atoms.ticketmachine.jpa;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashMap;
import java.util.UUID;

@Entity
@Data
public class Payment {

  @Id
  private UUID id;
  private String provider;
  @Type(type = "jsonb")
  @Column(columnDefinition = "json")
  private HashMap meta;
  private String status;
  @ManyToOne
  private Purchase purchase;
  @Version
  private long version;

}
