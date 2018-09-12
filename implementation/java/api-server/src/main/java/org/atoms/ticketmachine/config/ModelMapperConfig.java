package org.atoms.ticketmachine.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;

@Configuration
public class ModelMapperConfig {


  @Bean
  ModelMapper configureModelMapper() {

    ModelMapper modelMapper = new ModelMapper();

    modelMapper.createTypeMap(Date.class, OffsetDateTime.class)
      .setConverter(context -> OffsetDateTime.ofInstant(context.getSource().toInstant(), ZoneId.systemDefault()));

    modelMapper.createTypeMap(OffsetDateTime.class, Date.class)
      .setConverter(context -> Date.from(context.getSource().atZoneSameInstant(ZoneId.systemDefault()).toInstant()));

    return modelMapper;
  }



}
