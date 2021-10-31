package io.github.dailan.UnitTesting.controller;

import io.github.dailan.UnitTesting.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @GetMapping("/dummy-item")
    public Item dummyItem() {
      return  Item.builder().id(1)
                .name("Bread")
                .price(100)
                .quantity(10).build();
    }
}
