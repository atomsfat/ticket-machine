package org.atoms.ticketmachine.features.purchase;

import org.atoms.ticketmachine.features.GenericService;
import org.atoms.ticketmachine.jpa.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PurchaseService extends GenericService<Purchase,
  org.atoms.ticketmachine.pojos.Purchase, PurchaseRepository> {


  @Autowired
  public PurchaseService(final PurchaseRepository purchaseRepository,
                         final Function<Purchase, org.atoms.ticketmachine.pojos.Purchase> mapEntityToPojo,
                         final Function<org.atoms.ticketmachine.pojos.Purchase, Purchase> mapPojoToEntity) {
    super(purchaseRepository, mapEntityToPojo, mapPojoToEntity);
  }
}
