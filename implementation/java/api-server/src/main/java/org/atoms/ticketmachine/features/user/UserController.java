package org.atoms.ticketmachine.features.user;

import org.atoms.ticketmachine.features.GenericController;
import org.atoms.ticketmachine.pojos.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController extends GenericController<Customer, UserService> {

  @Autowired
    public UserController(@Value("${app.max.rows}") final int maxRows, final UserService userService) {
    super(maxRows, userService);
  }

  @Override
  @GetMapping("/users")
  public ResponseEntity<List<Customer>> findAll(@RequestParam(name = "page", defaultValue = "0") final  Integer page) {
    return super.findAll(page);
  }

  @Override
  @GetMapping("/user/{uuid}")
  public Customer findById(@PathVariable(name = "uuid") final String uuidStr) {
    return super.findById(uuidStr);
  }

  @Override
  @PostMapping("/user")
  public Customer save(@Valid @RequestBody final Customer customer) {
    return super.save(customer);
  }




}
