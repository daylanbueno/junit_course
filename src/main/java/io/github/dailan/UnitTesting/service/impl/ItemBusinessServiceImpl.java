package io.github.dailan.UnitTesting.service.impl;

import io.github.dailan.UnitTesting.model.Item;
import io.github.dailan.UnitTesting.repository.ItemRepository;
import io.github.dailan.UnitTesting.service.ItemBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemBusinessServiceImpl implements ItemBusinessService {

    private final ItemRepository itemRepository;

    @Override
    public Item retriveHardcodeItem() {
        return null;
    }

    @Override
    public List<Item> retriveAllItems() {
        List<Item> itens = itemRepository.findAll();
        for (Item item: itens) {
            item.setValue(item.getPrice() * item.getQuantity());
        }
        return itens;
    }
}
