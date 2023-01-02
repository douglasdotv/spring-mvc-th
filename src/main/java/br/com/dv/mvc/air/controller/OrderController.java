package br.com.dv.mvc.air.controller;

import br.com.dv.mvc.air.model.Order;
import br.com.dv.mvc.air.model.OrderDTO;
import br.com.dv.mvc.air.repository.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String form(Model model) {
        model.addAttribute("dto", new OrderDTO());
        return "order/newOrderForm";
    }

    @PostMapping("newOrder")
    public String newOrder(@Valid OrderDTO dto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("dto", dto);
            return "order/newOrderForm";
        }
        Order order = dto.toOrder();
        orderRepository.save(order);
        return "redirect:/home";
    }

}
