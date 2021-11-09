package io.github.dailan.UnitTesting.java.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Map {

    public static void main(String[] args) {
         Consumer<Integer> println = System.out::print;
         Consumer<String> printStrng = System.out::print;

         List<Integer> numeros = Arrays.asList(5, 6, 10, 15, 9, 8, 7);

         numeros.stream().forEach(println);
         System.out.println("");
         numeros.stream().map(item -> item * 2).forEach(println);

         List<String> marcas = Arrays.asList("\nBMW ", "Fiat ", "Audi ");
         marcas.stream().forEach(printStrng);
         List<String> marcasUps = marcas.stream().map((marca) -> marca.toUpperCase()).collect(Collectors.toList());
         marcasUps.forEach(printStrng);


    }
}
