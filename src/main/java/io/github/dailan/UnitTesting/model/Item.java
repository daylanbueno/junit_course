package io.github.dailan.UnitTesting.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
    private Integer id;
    private String name;
    private int price;
    private int quantity;

}
