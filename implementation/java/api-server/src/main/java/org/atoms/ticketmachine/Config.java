package org.atoms.ticketmachine;

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

  @Bean
  Function<Customer, org.atoms.ticketmachine.pojos.Customer> mapCustomerEntityToPojo() {
    return entity -> {
      ModelMapper mapper = new ModelMapper();
      return mapper.map(entity, org.atoms.ticketmachine.pojos.Customer.class);
    };
  }

  @Bean
  Function<org.atoms.ticketmachine.pojos.Customer, Customer> mapCustomerPojoToEntity() {
    return pojo -> {
      ModelMapper mapper = new ModelMapper();
      return mapper.map(pojo, Customer.class);
    };
  }

  @Bean
  Function<org.atoms.ticketmachine.pojos.Event, Event> mapEventPojoToEntity() {
    return pojo -> {
      ModelMapper mapper = new ModelMapper();
      return mapper.map(pojo, Event.class);
    };
  }

  @Bean
  Function<Event, org.atoms.ticketmachine.pojos.Event> mapEventEntityToPojo() {
    return entity -> {
      ModelMapper mapper = new ModelMapper();
      return mapper.map(entity, org.atoms.ticketmachine.pojos.Event.class);
    };
  }

  @Bean
  Function<Ticket, org.atoms.ticketmachine.pojos.Ticket> mapTicketEntityToPojo() {
    return entity -> {
      ModelMapper mapper = new ModelMapper();
      return mapper.map(entity, org.atoms.ticketmachine.pojos.Ticket.class);
    };
  }

  @Bean
  Function<org.atoms.ticketmachine.pojos.Ticket, Ticket> mapTicketPojoToEntity() {
    return pojo -> {
      ModelMapper mapper = new ModelMapper();
      return mapper.map(pojo, Ticket.class);
    };
  }

  @Bean
  Function<Purchase, org.atoms.ticketmachine.pojos.Purchase> mapPurchaseEntityToPojo() {
    return entity -> {
      ModelMapper mapper = new ModelMapper();
      return mapper.map(entity, org.atoms.ticketmachine.pojos.Purchase.class);
    };
  }

  @Bean
  Function<org.atoms.ticketmachine.pojos.Purchase, Purchase> mapPurchasePojoToEntity() {
    return pojo -> {
      ModelMapper mapper = new ModelMapper();
      return mapper.map(pojo, Purchase.class);
    };
  }

  @Bean
  Function<Venue, org.atoms.ticketmachine.pojos.Venue> mapVenueEntityToPojo() {
    return entity -> {
      ModelMapper mapper = new ModelMapper();
      return mapper.map(entity, org.atoms.ticketmachine.pojos.Venue.class);
    };
  }

  @Bean
  Function<org.atoms.ticketmachine.pojos.Venue, Venue> mapVenuePojoToEntity() {
    return pojo -> {
      ModelMapper mapper = new ModelMapper();
      return mapper.map(pojo, Venue.class);
    };
  }

}
