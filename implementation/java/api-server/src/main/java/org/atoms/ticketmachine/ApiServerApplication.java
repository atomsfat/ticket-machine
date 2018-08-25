package org.atoms.ticketmachine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ApiServerApplication {

  public static void main(final String[] args) {
    SpringApplication.run(ApiServerApplication.class, args);
  }
}
