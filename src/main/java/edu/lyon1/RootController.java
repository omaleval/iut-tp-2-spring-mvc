package edu.lyon1;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class RootController {

  @RequestMapping("/")
  public ModelAndView test(@RequestHeader HttpHeaders headers) {

    ModelAndView mav = new ModelAndView();
    mav.addObject("titre", "titre");
    mav.addObject("corps", "corps");
    List<HttpHeader> ListeHeaders = headers
        .entrySet()
        .stream()
        .map(e -> new HttpHeader(e.getKey(), String.join(",", e.getValue())))
        .collect(Collectors.toList());
    mav.addObject("headers", ListeHeaders);
    mav.setViewName("template");
    return mav;
  }

  private class HttpHeader{

    final String name;
    final String value;

    private HttpHeader(String name, String value) {
      this.name = name;
      this.value = value;
    }

    public String getName() {
      return name;
    }

    public String getValue() {
      return value;
    }

  }

}
