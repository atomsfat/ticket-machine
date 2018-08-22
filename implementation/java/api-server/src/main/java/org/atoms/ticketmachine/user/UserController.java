package org.atoms.ticketmachine.user;

import org.atoms.ticketmachine.Util.PaginationUtil;
import org.atoms.ticketmachine.pojos.Customer;
import org.atoms.ticketmachine.pojos.Event;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@org.springframework.web.bind.annotation.RestController
public class UserController {

  @Value("${max.rows}")
  private int maxRows;

  @Autowired
  UserService userService;

  @GetMapping("/users")
  public ResponseEntity<List<Customer>> findAll(@RequestParam(name="page", defaultValue = "0")Integer page){
    PageRequest pageRequest =  PageRequest.of(page, maxRows);

    HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(pageRequest);

    Page<org.atoms.ticketmachine.jpa.Customer> customerPage = userService.findAll(pageRequest);
    return new ResponseEntity<>(customerPage.getContent().stream().map(UserController::entityToDto).
      collect(Collectors.toList()),headers, HttpStatus.OK);
  }

  @GetMapping("/user/{userID}")
  public Customer findById(@PathVariable(name="userID") String uuidStr){
    UUID uuid = UUID.fromString(uuidStr);
    return userService.findById(uuid).map(UserController::entityToDto).orElse(null);
  }

  @PostMapping("/user")
  @ResponseStatus(HttpStatus.CREATED)
  public Customer save(@Valid @RequestBody Customer customer){
    return UserController.entityToDto(userService.save(UserController.dtoToEntity(customer)));
  }

  public static org.atoms.ticketmachine.jpa.Customer dtoToEntity(Customer pojo){
    ModelMapper mapper = new ModelMapper();
    return mapper.map(pojo, org.atoms.ticketmachine.jpa.Customer.class);
  }
  public static Customer entityToDto(org.atoms.ticketmachine.jpa.Customer entity){
    ModelMapper mapper = new ModelMapper();
    return mapper.map(entity, Customer.class);
  }
}
