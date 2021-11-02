package io.github.dailan.UnitTesting.controller;

import io.github.dailan.UnitTesting.model.Item;
import io.github.dailan.UnitTesting.service.ItemBusinessService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ItemBusinessService itemBusinessService;

    @SneakyThrows
    @Test
    public void should_be_one_item() {

        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("id").value(1))
                .andReturn();

    }

    @SneakyThrows
    @Test
    public void should_be_one_item_be_business() {
        Item bread = Item.builder()
                .id(1)
                .name("Bread")
                .price(100)
                .quantity(10).build();

        when(itemBusinessService.retriveHardcodeItem()).thenReturn(bread);

        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("id").value(bread.getId()))
                .andReturn();

    }

    @SneakyThrows
    @Test
    public void should_be_return_all_itens() {
        Item newItem = Item.builder()
                .id(1)
                .name("Item")
                .price(100)
                .quantity(10).build();

        List<Item> itens = Arrays.asList(newItem);

        when(itemBusinessService.retriveAllItems()).thenReturn(itens);

        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-itens")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("[0].id").isNotEmpty())
            .andExpect(MockMvcResultMatchers.jsonPath("[0].id").value(itens.get(0).getId()))
            .andExpect(MockMvcResultMatchers.jsonPath("[0].name").value(itens.get(0).getName()))
            .andExpect(MockMvcResultMatchers.jsonPath("[0].price").value(itens.get(0).getPrice()))
            .andExpect(MockMvcResultMatchers.jsonPath("[0].quantity").value(itens.get(0).getQuantity()))
            .andReturn();

    }
}
