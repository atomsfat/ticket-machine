package org.atoms.ticketmachine.config;

import com.fasterxml.jackson.databind.JsonNode;
import io.burt.jmespath.JmesPath;
import io.burt.jmespath.jackson.JacksonRuntime;
import org.atoms.ticketmachine.jpa.Customer;
import org.atoms.ticketmachine.jpa.Event;
import org.atoms.ticketmachine.jpa.Ticket;
import org.atoms.ticketmachine.jpa.Purchase;
import org.atoms.ticketmachine.jpa.Venue;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class Config {

  @Bean
  public JmesPath<JsonNode> jmespath() {
    return new JacksonRuntime();
  }


}
