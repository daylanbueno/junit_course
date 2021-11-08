package io.github.dailan.UnitTesting.java.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ImprimindoObjetos {

    public static void main(String[] args) {
        List<String> aprovados = Arrays.asList("Lia", "Bia", "Jaco", "");

        System.out.println("Com for...  ");
        for (String nome: aprovados) {
            System.out.println(nome);
        }

        System.out.println("Com iterator...  ");
        Iterator<String> iterator = aprovados.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Com stream...");
        aprovados.stream().forEach(System.out::println);

    }
}
