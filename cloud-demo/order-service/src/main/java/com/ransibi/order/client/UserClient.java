package com.ransibi.order.client;

import com.ransibi.order.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: ransibi
 * @Date: 2025/03/09/15:26
 * @Description:
 */
@FeignClient("user-service")
public interface UserClient {
    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}
