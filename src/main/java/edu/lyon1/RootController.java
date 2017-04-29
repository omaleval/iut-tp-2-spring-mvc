package edu.lyon1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class RootController {

  public List<String> list = new ArrayList<>();

  @RequestMapping("/")
  public ModelAndView test(@RequestHeader HttpHeaders headers) {

    Map map = HttpHeaders.getParameterMap();

    //list = Collections.list(headers);

    ModelAndView mav = new ModelAndView();
    mav.addObject("titre", "titre");
    mav.addObject("corps", "corps");
    mav.addObject("liste", list);

    mav.setViewName("template");
    return mav;
  }

}
