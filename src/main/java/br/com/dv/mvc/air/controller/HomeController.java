package br.com.dv.mvc.air.controller;

import br.com.dv.mvc.air.model.Order;
import br.com.dv.mvc.air.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    private final OrderRepository orderRepository;

    @Autowired
    public HomeController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/home")
    public ModelAndView home() {
        List<Order> orderList = orderRepository.findAll();
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("orderList", orderList);
        return mv;
    }

}
