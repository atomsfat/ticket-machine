package org.atoms.ticketmachine.jpa;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import java.util.UUID;

@Entity
@Data
public class Venue {

  @Id
  @GeneratedValue(generator = "uuidVenue")
  @GenericGenerator(name = "uuidVenue", strategy = "org.hibernate.id.UUIDGenerator")
  private UUID id;
  private String name;
  private Double lat;
  private Double lon;
  private String city;
  private String country;
  private String county;
  private String state;
  private String street;
  private String hrefMaps;
  @Version
  private long version;
}
