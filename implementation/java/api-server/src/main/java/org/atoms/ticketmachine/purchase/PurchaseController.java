package org.atoms.ticketmachine.purchase;

import org.atoms.ticketmachine.GenericController;
import org.atoms.ticketmachine.pojos.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PurchaseController extends GenericController<Purchase, PurchaseService> {

  @Autowired
  public PurchaseController(@Value("${app.max.rows}") final int maxRows, final PurchaseService purchaseService) {
    super(maxRows, purchaseService);
  }

  @Override
  @PostMapping("/purchase")
  public Purchase save(@Valid @RequestBody final Purchase purchase) {
    return super.save(purchase);
  }

  @Override
  @GetMapping("/purchases")
  public ResponseEntity<List<Purchase>> findAll(@RequestParam(name = "page", defaultValue = "0") final Integer page) {
    return super.findAll(page);
  }


}
