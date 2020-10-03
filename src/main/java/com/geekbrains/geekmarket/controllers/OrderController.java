package com.geekbrains.geekmarket.controllers;

import com.geekbrains.geekmarket.entities.ShoppingCart;
import com.geekbrains.geekmarket.entities.SystemUser;
import com.geekbrains.geekmarket.entities.User;
import com.geekbrains.geekmarket.repositories.OrderItemRepository;
import com.geekbrains.geekmarket.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService ;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/fill")
    public String saveNewOrder(HttpSession httpSession) {
        orderService.saveOrder(httpSession);
        return "redirect:/";
    }
}
