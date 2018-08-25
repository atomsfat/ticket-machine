package org.atoms.ticketmachine.venue;

import org.atoms.ticketmachine.GenericController;
import org.atoms.ticketmachine.pojos.Venue;
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
public class VenueController extends GenericController<Venue, VenueService> {

  @Autowired
  public VenueController(@Value("${app.max.rows}") final  int maxRows, final VenueService venueService) {
    super(maxRows, venueService);
  }

  @Override
  @PostMapping("/venue")
  public Venue save(@Valid @RequestBody final Venue venue) {
    return super.save(venue);
  }

  @Override
  @GetMapping("/venues")
  public ResponseEntity<List<Venue>> findAll(@RequestParam(name = "page", defaultValue = "0") final Integer page) {
    return super.findAll(page);
  }


  @Override
  @GetMapping("/venues/{uuid}")
  public Venue findById(@PathVariable(name = "uuid") final   String uuidStr) {
    return super.findById(uuidStr);
  }
}
