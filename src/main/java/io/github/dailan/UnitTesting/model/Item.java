package io.github.dailan.UnitTesting.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@Entity
public class Item {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private int price;
    private int quantity;

}
