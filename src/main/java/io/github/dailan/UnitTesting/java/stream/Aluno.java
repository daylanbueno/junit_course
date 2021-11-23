package io.github.dailan.UnitTesting.java.stream;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Aluno {
    private String nome;
    private double nota;

    @Override
    public String toString() {
        return "O aluno "+this.nome + " tem "+ this.getNota();
    }
}
