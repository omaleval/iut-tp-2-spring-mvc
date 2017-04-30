package edu.lyon1;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class RootController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView test(@RequestHeader HttpHeaders headers) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("titre", "IUT");
    mav.addObject("corps", "bonjour");
    List<HttpHeader> attributeValue = headers
        .entrySet()
        .stream()
        .map(e -> new HttpHeader(
            e.getKey(),
            String.join(",", e.getValue())
        ))
        .collect(Collectors.toList());
    mav.addObject("headers",
        attributeValue);
    mav.setViewName("template");
    return mav;
  }

  @ResponseBody
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public String rootPost() {
    return "OK";
  }

  @ResponseBody
  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public User user(@RequestParam("nom") String nom, @RequestParam("prenom") String prenom) {
    return new User(prenom, nom);
  }

  private class HttpHeader {

    private final String name;
    private final String value;

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
