package org.atoms.ticketmachine;

import org.atoms.ticketmachine.util.PaginationUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

/**
 * @param <P> POJO
 * @param <S> Service
 */
public class GenericController<P, S extends GenericService<?, P, ?>> {

  private int maxRows;
  private S s;

  public GenericController(final int maxRows, final S s) {
    this.maxRows = maxRows;
    this.s = s;
  }

  public ResponseEntity<List<P>> findAll(final Integer page) {
    PageRequest pageRequest = PageRequest.of(page, maxRows);

    HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(pageRequest);
    Page<P> pPage = s.findAllPojos(pageRequest);

    return new ResponseEntity<>(pPage.getContent(), headers, HttpStatus.OK);
  }

  public P findById(final String uuidStr) {
    UUID uuid = UUID.fromString(uuidStr);
    return s.findPojoById(uuid).orElse(null);
  }

  public P save(final P p) {
    return s.savePojo(p);
  }
}
