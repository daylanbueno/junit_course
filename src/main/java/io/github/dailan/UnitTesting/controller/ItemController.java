package io.github.dailan.UnitTesting.controller;

import io.github.dailan.UnitTesting.model.Item;
import io.github.dailan.UnitTesting.service.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

;import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService itemBusinessService;

    @GetMapping("/dummy-item")
    public Item dummyItem() {
      return  Item.builder().id(1)
                .name("Bread")
                .price(100)
                .quantity(10).build();
    }

    @GetMapping("/item-from-business")
    public Item itemFromBusiness() {
        return  itemBusinessService.retriveHardcodeItem();
    }

    @GetMapping("/all-itens")
    public List<Item> retriveAllItens() {
        return itemBusinessService.retriveAllItems();
    }

}
