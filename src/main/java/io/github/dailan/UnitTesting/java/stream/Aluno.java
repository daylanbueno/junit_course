package io.github.dailan.UnitTesting.java.stream;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Aluno {
    private String nome;
    private double nota;
}
