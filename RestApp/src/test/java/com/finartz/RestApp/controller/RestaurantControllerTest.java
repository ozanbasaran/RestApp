package com.finartz.RestApp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.finartz.RestApp.model.enumerated.Status;
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

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestaurantService restaurantService;

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
    public void whenGetAllRestaurant_thenReturnRestaurant() throws Exception {

        com.finartz.RestApp.model.User user = (com.finartz.RestApp.model.User) User.builder().build();

        Branch branch = Branch.builder().build();

        Restaurant restaurant = Restaurant.builder()
                .id(1L)
                .name("Kral Burger")
                .status(Status.APPROVED)
                .user(user)
                .branchList(Arrays.asList(branch))
                .build();

        List<Restaurant> restaurantList = Arrays.asList(restaurant);

        Mockito.when(restaurantService.findAll()).thenReturn(restaurantList);

        mockMvc.perform(get("/restaurant")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].name", Matchers.is("Kral Burger")));

    }

    @Test
    public void whenGetRestaurantById_thenReturnRestaurant() throws Exception {

        com.finartz.RestApp.model.User user = (com.finartz.RestApp.model.User) User.builder().build();

        Branch branch = Branch.builder().build();

        Restaurant restaurant = Restaurant.builder()
                .id(1L)
                .name("Kral Burger")
                .status(Status.APPROVED)
                .user(user)
                .branchList(Arrays.asList(branch))
                .build();

        Mockito.when(restaurantService.findById(1L)).thenReturn(restaurant);

        mockMvc.perform(get("/restaurant/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", Matchers.is("Kral Burger")));

    }

    @Test
    public void whenCreateNewRestaurant_thenReturnRestaurant() throws Exception {

        com.finartz.RestApp.model.User user = (com.finartz.RestApp.model.User) User.builder().build();

        Branch branch = Branch.builder().build();

        Restaurant restaurant = Restaurant.builder()
                .id(1L)
                .name("Kral Burger")
                .status(Status.APPROVED)
                .user(user)
                .branchList(Arrays.asList(branch))
                .build();

        Mockito.when(restaurantService.create(restaurant)).thenReturn(restaurant);

        String requestJson = objectWriter.writeValueAsString(restaurant);

        mockMvc.perform(post("/restaurant")
                .contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("name", Matchers.is("Kral Burger")));
    }

    @Test
    public void whenUpdateRestaurant_thenReturnRestaurant() throws Exception {

        com.finartz.RestApp.model.User user = (com.finartz.RestApp.model.User) User.builder().build();

        Branch branch = Branch.builder().build();

        Restaurant restaurant = Restaurant.builder()
                .id(1L)
                .name("Kral Burger")
                .status(Status.APPROVED)
                .user(user)
                .branchList(Arrays.asList(branch))
                .build();

        restaurant.setName("Kral Restaurant");

        Mockito.when(restaurantService.update(restaurant)).thenReturn(restaurant);

        String requestJson = objectWriter.writeValueAsString(restaurant);

        mockMvc.perform(put("/restaurant")
                .contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", Matchers.is("Kral Restaurant")));
    }

    @Test
    public void whenDeleteRestaurant_thenReturnRestaurant() throws Exception {

        com.finartz.RestApp.model.User user = (com.finartz.RestApp.model.User) User.builder().build();

        Branch branch = Branch.builder().build();

        Restaurant restaurant = Restaurant.builder()
                .id(1L)
                .name("Kral Burger")
                .status(Status.APPROVED)
                .user(user)
                .branchList(Arrays.asList(branch))
                .build();

        Mockito.when(restaurantService.deleteById(1L)).thenReturn(restaurant);

        String requestJson = objectWriter.writeValueAsString(restaurant);

        mockMvc.perform(delete("/restaurant/1")
                .contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk());
    }


}