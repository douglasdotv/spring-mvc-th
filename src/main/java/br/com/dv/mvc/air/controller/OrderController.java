package br.com.dv.mvc.air.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("order")
public class OrderController {

    @GetMapping("form")
    public String form() {
        return "order/newOrderForm";
    }

    @PostMapping("newOrder")
    public String newOrder() {
        return "redirect:/home";
    }

}
