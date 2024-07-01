package franxx.code.mvc.resolver;

import franxx.code.mvc.model.Partner;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class PartnerArgumentResolver implements HandlerMethodArgumentResolver {
  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return parameter.getParameterType().equals(Partner.class);
  }

  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
    HttpServletRequest servletRequest = (HttpServletRequest) webRequest.getNativeRequest();
    String header = servletRequest.getHeader("X-API-KEY");

    if (header != null) {
      // query to db
      return Partner.of(header, "Sample Partner");
    }

    throw new RuntimeException("unauthorized exception");
  }
}
