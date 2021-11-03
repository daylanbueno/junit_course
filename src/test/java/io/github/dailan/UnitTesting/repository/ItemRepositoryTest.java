package io.github.dailan.UnitTesting.repository;

import io.github.dailan.UnitTesting.model.Item;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void should_be_return_three_items() {
        List<Item> items = itemRepository.findAll();
        assertEquals(items.size(), 4);
    }

    @Test
    public void should_be_save_item_item() {
        Item item10 = testEntityManager.persist(Item.builder().id(10).name("Item10").price(100).quantity(10).build());

        Optional<Item> newItem = itemRepository.findById(10);

        assertTrue(newItem.isPresent());
    }
}
