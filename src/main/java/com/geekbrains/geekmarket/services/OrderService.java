package com.geekbrains.geekmarket.services;

import com.geekbrains.geekmarket.entities.Order;
import com.geekbrains.geekmarket.entities.OrderItem;
import com.geekbrains.geekmarket.entities.ShoppingCart;
import com.geekbrains.geekmarket.entities.User;
import com.geekbrains.geekmarket.repositories.OrderItemRepository;
import com.geekbrains.geekmarket.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private OrderItemRepository orderItemRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    public void setOrderItemRepository(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public void saveOrder(HttpSession httpSession) {
        ShoppingCart cart = (ShoppingCart) httpSession.getAttribute("cart");
        User theUser = (User) httpSession.getAttribute("user") ;
        if (cart != null && theUser != null) {
            Order order = new Order() ;
            order.setPrice(cart.getTotalCost());
            order.setUser(theUser.getId());
            orderRepository.save(order) ;
            cart.getItems().forEach(i -> i.setOrder(order));
            orderItemRepository.saveAll(cart.getItems()) ;
            httpSession.setAttribute("cart", new ShoppingCart());
        }
    }
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

}
