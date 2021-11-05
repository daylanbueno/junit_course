package io.github.dailan.UnitTesting.java.lambdas;

import java.util.Arrays;
import java.util.List;

public class Foreach {

    public static void main(String[] args) {

        List<String> aprovados = Arrays.asList("Bia", "Edu", "Lia", "Ana");
        System.out.println("Forma tradicional");
        for (String nome: aprovados) {
            System.out.println(nome);
        }

        System.out.println("\nForma com lambda versão #01");
        aprovados.forEach((nome) ->  System.out.println(nome + "."));

        System.out.println("\nForma Method Reference");
        aprovados.forEach(System.out::println);

    }
}
