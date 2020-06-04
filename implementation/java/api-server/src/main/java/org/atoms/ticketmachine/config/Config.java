package org.atoms.ticketmachine.config;

import com.fasterxml.jackson.databind.JsonNode;
import io.burt.jmespath.JmesPath;
import io.burt.jmespath.jackson.JacksonRuntime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

  @Bean
  public JmesPath<JsonNode> jmespath() {
    return new JacksonRuntime();
  }


}
