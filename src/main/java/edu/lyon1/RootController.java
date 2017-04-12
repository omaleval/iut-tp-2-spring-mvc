package edu.lyon1;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class RootController {

  @RequestMapping("/")
  public ModelAndView test(HttpServletRequest request) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("titre", "titre");
    mav.addObject("corps", "corps");
    mav.setViewName("template");
    return mav;
  }

}
