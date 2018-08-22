package org.atoms.ticketmachine.Util;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;

public class PaginationUtil {

  static public HttpHeaders generatePaginationHttpHeaders(Pageable pageable){
    HttpHeaders headers = new HttpHeaders();
    headers.add("offset", "" + pageable.getOffset());
    headers.add("pageSize", "" + pageable.getPageSize());
    headers.add("pageNumber", "" + pageable.getPageNumber());
    return headers;
  }
}
