package org.atoms.ticketmachine.jpa;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import java.util.UUID;

@Entity
@Data
public class Venue {

  @Id
  private UUID id;
  private String name;
  private Long lat;
  private Long lon;
  private String city;
  private String country;
  private String state;
  private String address;
  private String hrefMaps;
  @Version
  private long version;
}
