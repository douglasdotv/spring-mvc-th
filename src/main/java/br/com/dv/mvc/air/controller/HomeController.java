package br.com.dv.mvc.air.controller;

import br.com.dv.mvc.air.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        Order order = new Order();

        order.setProductName("Smartphone Xiaomi Redmi 9A 32GB/2GB Ram Azul");
        order.setProductUrl("https://www.amazon.com.br/Smartphone-Xiaomi-Redmi-9A-32GB/dp/B08CH6X6M5/ref=sr_1_1?qid=1672603320&refinements=p_89%3AXiaomi&s=electronics&sr=1-1&ufe=app_do%3Aamzn1.fos.25548f35-0de7-44b3-b28e-0f56f3f96147");
        order.setImageUrl("https://m.media-amazon.com/images/I/51bseWUDNOL._AC_SX679_.jpg");
        order.setProductDescription("Smartphone - Redmi 9A - 2GB - 32GB - Sky Blue - Xiaomi");

        List<Order> orderList = List.of(order);
        model.addAttribute("orderList", orderList);

        return "home";
    }

}
