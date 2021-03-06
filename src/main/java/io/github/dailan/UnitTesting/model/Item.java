package io.github.dailan.UnitTesting.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    private Integer id;
    private String name;
    private int price;
    private int quantity;
    @Transient
    private int value;
}
