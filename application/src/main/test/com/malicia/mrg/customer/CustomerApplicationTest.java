package com.malicia.mrg.customer;

import com.malicia.mrg.customer.controller.CustomerController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class CustomerApplicationTest {

    @Autowired
    private CustomerController controller;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

}