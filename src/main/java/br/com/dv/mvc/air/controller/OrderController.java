package br.com.dv.mvc.air.controller;

import br.com.dv.mvc.air.model.Order;
import br.com.dv.mvc.air.model.OrderDTO;
import br.com.dv.mvc.air.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("order")
public class OrderController {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("form")
    public String form() {
        return "order/newOrderForm";
    }

    @PostMapping("newOrder")
    public String newOrder(OrderDTO dto) {
        Order order = dto.toOrder();
        orderRepository.save(order);
        return "redirect:/home";
    }

}
