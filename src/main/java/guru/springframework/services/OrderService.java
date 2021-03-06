package guru.springframework.services;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import guru.springframework.domain.Buyer;
import guru.springframework.domain.Order;
import guru.springframework.domain.OrderStatus;

public interface OrderService {

    Order getById(Integer id);

    Order save(Order Order) throws Exception;

    void delete(Integer id);
    
    Page<Order> list(Integer salesManId,OrderStatus OrderStatus,Pageable pageable);

}
