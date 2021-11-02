package io.github.dailan.UnitTesting.service;

import io.github.dailan.UnitTesting.model.Item;

import java.util.List;

public interface ItemBusinessService {
    public Item retriveHardcodeItem();
    public List<Item> retriveAllItems();
}
