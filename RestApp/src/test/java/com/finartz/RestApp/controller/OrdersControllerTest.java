package com.finartz.RestApp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.finartz.RestApp.model.Basket;
import com.finartz.RestApp.model.CreditCard;
import com.finartz.RestApp.model.Orders;
import com.finartz.RestApp.model.User;
import com.finartz.RestApp.service.OrdersService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(OrdersController.class)
public class OrdersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrdersService ordersService;

    @MockBean
    private UserDetailsService userDetailsService;

    private ObjectWriter objectWriter;

    @Before
    public void init() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        objectWriter = mapper.writer().withDefaultPrettyPrinter();
    }

    @Test
    public void whenGetAllOrders_thenReturnOrders() throws Exception {

        User user = User.builder().name("Ali Akay").build();

        CreditCard creditCard = CreditCard.builder().user(user).build();

        Basket basket = Basket.builder().user(user).build();

        String strDate = "30/12/2021 15:35";
        Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(strDate);

        Orders orders = Orders.builder()
                .id(1L)
                .basket(basket)
                .creditCard(creditCard)
                .date((java.sql.Date) date)
                .totalPrice((float) 66.45)
                .build();

        List<Orders> ordersList = Arrays.asList(orders);

        Mockito.when(ordersService.findAll()).thenReturn(ordersList);

        mockMvc.perform(get("/orders")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].basket.user.name", Matchers.is("Ali Akay")));

    }

    @Test
    public void whenGetOrdersById_thenReturnOrders() throws Exception {

        User user = User.builder().name("Ali Akay").build();

        CreditCard creditCard = CreditCard.builder().user(user).build();

        Basket basket = Basket.builder().user(user).build();

        String strDate = "30/12/2021 15:35";
        Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(strDate);

        Orders orders = Orders.builder()
                .id(1L)
                .basket(basket)
                .creditCard(creditCard)
                .date((java.sql.Date) date)
                .totalPrice((float) 66.45)
                .build();

        Mockito.when(ordersService.findById(1L)).thenReturn(orders);

        mockMvc.perform(get("/orders/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("basket.user.name", Matchers.is("Ali Akay")));

    }

    @Test
    public void whenCreateNewOrders_thenReturnOrders() throws Exception {

        User user = User.builder().name("Ali Akay").build();

        CreditCard creditCard = CreditCard.builder().user(user).build();

        Basket basket = Basket.builder().user(user).build();

        String strDate = "30/12/2021 15:35";
        Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(strDate);

        Orders orders = Orders.builder()
                .id(1L)
                .basket(basket)
                .creditCard(creditCard)
                .date((java.sql.Date) date)
                .totalPrice((float) 66.45)
                .build();

        Mockito.when(ordersService.create(orders)).thenReturn(orders);

        String requestJson = objectWriter.writeValueAsString(orders);

        mockMvc.perform(post("/orders")
                .contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("basket.user.name", Matchers.is("Ali Akay")));
    }

    @Test
    public void whenUpdateOrders_thenReturnOrders() throws Exception {

        User user = User.builder().name("Ali Akay").build();

        CreditCard creditCard = CreditCard.builder().user(user).build();

        Basket basket = Basket.builder().user(user).build();

        String strDate = "30/12/2021 15:35";
        Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(strDate);

        Orders orders = Orders.builder()
                .id(1L)
                .basket(basket)
                .creditCard(creditCard)
                .date((java.sql.Date) date)
                .totalPrice((float) 66.45)
                .build();

        orders.setTotalPrice((float) 60.99);

        Mockito.when(ordersService.update(orders)).thenReturn(orders);

        String requestJson = objectWriter.writeValueAsString(orders);

        mockMvc.perform(put("/orders")
                .contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalPrice", Matchers.is(60.99)));
    }

    @Test
    public void whenDeleteOrders_thenReturnOrders() throws Exception {

        User user = User.builder().name("Ali Akay").build();

        CreditCard creditCard = CreditCard.builder().user(user).build();

        Basket basket = Basket.builder().user(user).build();

        String strDate = "30/12/2021 15:35";
        Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(strDate);

        Orders orders = Orders.builder()
                .id(1L)
                .basket(basket)
                .creditCard(creditCard)
                .date((java.sql.Date) date)
                .totalPrice((float) 66.45)
                .build();

        Mockito.when(ordersService.findById(1L)).thenReturn(orders);

        String requestJson = objectWriter.writeValueAsString(orders);

        mockMvc.perform(delete("/orders/1")
                .contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk());
    }


}