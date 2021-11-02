package io.github.dailan.UnitTesting.service;

import io.github.dailan.UnitTesting.model.Item;
import io.github.dailan.UnitTesting.repository.ItemRepository;
import io.github.dailan.UnitTesting.service.impl.ItemBusinessServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class ItemServiceTest {

    @MockBean
    private ItemRepository itemRepository;

    private ItemBusinessService itemBusinessService;

    @BeforeEach
    public void setUp() {
        this.itemBusinessService = new ItemBusinessServiceImpl(itemRepository);
    }

    @Test
    public void should_be_return_all_itens() {
        Item item = Item.builder().id(1001).name("Item1").price(100).quantity(10).build();
        Mockito.when(itemRepository.findAll()).thenReturn(Arrays.asList(item));

        List<Item> itens = itemBusinessService.retriveAllItems();

        Assertions.assertEquals(itens.size(), 1);
        Assertions.assertEquals(itens.get(0).getName(), item.getName());
    }

    @Test
    public void should_be_return_all_itens_with_values_present() {
        Item item = Item.builder().id(1001).name("Item1").price(100).quantity(10).build();
        Mockito.when(itemRepository.findAll()).thenReturn(Arrays.asList(item));

        List<Item> itens = itemBusinessService.retriveAllItems();

        Assertions.assertEquals(itens.size(), 1);
        Assertions.assertEquals(itens.get(0).getName(), item.getName());
        Assertions.assertEquals(itens.get(0).getValue(), 1000);
    }
}
