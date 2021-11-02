package io.github.dailan.UnitTesting.service.impl;

import io.github.dailan.UnitTesting.model.Item;
import io.github.dailan.UnitTesting.service.ItemBusinessService;
import org.springframework.stereotype.Service;

@Service
public class ItemBusinessServiceImpl implements ItemBusinessService {

    @Override
    public Item retriveHardcodeItem() {
        return null;
    }
}
