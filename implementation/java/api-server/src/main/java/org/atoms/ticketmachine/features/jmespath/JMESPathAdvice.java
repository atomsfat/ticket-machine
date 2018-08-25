package org.atoms.ticketmachine.features.jmespath;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.burt.jmespath.Expression;
import io.burt.jmespath.JmesPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.io.IOException;

@ControllerAdvice
public class JMESPathAdvice  implements ResponseBodyAdvice<Object> {

  private JmesPath<JsonNode> jmespath;

  @Autowired
  public JMESPathAdvice(final JmesPath<JsonNode> jmespath) {
    this.jmespath = jmespath;
  }

  @Override
  public boolean supports(final MethodParameter returnType,
                          final Class<? extends HttpMessageConverter<?>> converterType) {
    return true;
  }

  @Override
  public Object beforeBodyWrite(final  Object body, final MethodParameter returnType,
                                final MediaType selectedContentType,
                                final Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                final ServerHttpRequest request, final ServerHttpResponse response) {
    String filterBy = ((ServletServerHttpRequest) request).getServletRequest().getParameter("filterBy");



    JsonNode result = null;

    if (filterBy != null && !filterBy.isEmpty()) {
      Expression<JsonNode> expression = jmespath.compile(filterBy);
      ObjectMapper mapper = new ObjectMapper();

      JsonNode input = null;
      try {
        input = mapper.readTree(body.toString());
      } catch (IOException e) {
        e.printStackTrace();
      }
       result = expression.search(input);

    }

    if (result == null) {
      return body;
    } else {
      return result.toString();
    }
  }
}
