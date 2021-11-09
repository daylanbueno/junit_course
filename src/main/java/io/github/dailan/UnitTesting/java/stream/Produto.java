package io.github.dailan.UnitTesting.java.stream;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Produto {
    private String nome;
    private double valor;
    private double desconto;
    private boolean freteGratis;
}
