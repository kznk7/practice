package oit.is.room2.practice.controller;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;

import oit.is.room2.practice.model.Fruit;
import oit.is.room2.practice.model.FruitMapper;

@Controller
@RequestMapping("/sample5")
public class Sample51Controller {

  @Autowired
  FruitMapper fMapper;

  @GetMapping("step1")
  public String sample51() {
    return "sample51.html";
  }

  @GetMapping("step2")
  public String sample52(ModelMap model) {
    ArrayList<Fruit> fruits2 = fMapper.selectAllFruit();
    model.addAttribute("fruits2", fruits2);
    return "sample51.html";
  }

}
