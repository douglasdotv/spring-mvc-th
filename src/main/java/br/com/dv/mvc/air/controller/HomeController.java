package br.com.dv.mvc.air.controller;

import br.com.dv.mvc.air.model.Order;
import br.com.dv.mvc.air.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final OrderRepository orderRepository;

    @Autowired
    public HomeController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<Order> orderList = orderRepository.findAll();
        model.addAttribute("orderList", orderList);
        return "home";
    }

}
