package io.github.dailan.UnitTesting.java.stream;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Carro {
    private String nome;
    private Double valor;
    private Integer ano;
}
