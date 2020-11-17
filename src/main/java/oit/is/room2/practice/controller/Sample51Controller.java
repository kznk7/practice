package oit.is.room2.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/sample5")
public class Sample51Controller {

  @GetMapping("step1")
  public String sample51() {
    return "sample51.html";
  }

}
