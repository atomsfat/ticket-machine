package org.atoms.ticketmachine.jpa;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import java.util.UUID;

@Entity(name = "people")
@Data
public class User {

  @Id
  private UUID id;
  private String userPool;
  private String externald;
  private String username;
  private String phoneNumber;
  private String email;
  @Version
  private long version;

}
