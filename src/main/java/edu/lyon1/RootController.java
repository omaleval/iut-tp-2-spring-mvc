package edu.lyon1;

import java.util.Collections;
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
    mav.addObject("titre", "IUT");
    mav.addObject("corps", "bonjour");
    mav.addObject("headers", headers.keySet());
    mav.setViewName("template");
    return mav;
  }

}
