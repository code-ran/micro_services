package com.ransibi.order.service;

import com.ransibi.order.mapper.OrderMapper;
import com.ransibi.order.pojo.Order;
import com.ransibi.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    public Order queryOrderById(Long orderId) {
        Order order = orderMapper.findById(orderId);

        Long userId = order.getUserId();
        String port = "8081";
//        String url = "http://127.0.0.1:" + port + "/user/" + userId;
        //从注册中心里拿
        String url ="http://user-service/user/"+userId;
        //开始远程调用
        User resultUser = restTemplate.getForObject(url, User.class);
        order.setUser(resultUser);

        return order;
    }
}
