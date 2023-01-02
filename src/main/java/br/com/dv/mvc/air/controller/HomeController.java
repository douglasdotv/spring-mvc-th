package br.com.dv.mvc.air.controller;

import br.com.dv.mvc.air.model.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/home")
    public String home(Model model) {
        Query query = entityManager.createQuery("Select p from Order p", Order.class);
        List<Order> orderList = query.getResultList();
        model.addAttribute("orderList", orderList);
        return "home";
    }

}
