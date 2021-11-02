package io.github.dailan.UnitTesting.service.impl;

import io.github.dailan.UnitTesting.model.Item;
import io.github.dailan.UnitTesting.repository.ItemRepository;
import io.github.dailan.UnitTesting.service.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessServiceImpl implements ItemBusinessService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item retriveHardcodeItem() {
        return null;
    }

    @Override
    public List<Item> retriveAllItems() {
        return itemRepository.findAll();
    }
}
