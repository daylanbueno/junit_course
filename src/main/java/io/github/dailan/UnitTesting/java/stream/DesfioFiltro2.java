package io.github.dailan.UnitTesting.java.stream;

import java.util.Arrays;
import java.util.List;

public class DesfioFiltro2 {

    // mostrar produtos em promoção
    // deve mostrar os produtos que estão com promoção maior ou igual a 30% e estão com frete grátis.

    public static void main(String[] args) {
        Produto notebook  = Produto.builder().nome("Notebook").valor(1000).desconto(0.30).freteGratis(true).build();
        Produto calca  = Produto.builder().nome("Calça").valor(100).freteGratis(false).desconto(0.30).build();
        Produto impressora  = Produto.builder().nome("Impressora").freteGratis(true).valor(999).desconto(0.14).build();

        List<Produto> produtos = Arrays.asList(notebook,calca,impressora);
        produtos.stream()
                .filter(produto -> produto.getDesconto() >= 0.30)
                .filter(produto -> produto.isFreteGratis())
                .map(produto ->  "Super promoção "+produto.getNome()+ " com fréte grátis")
                .forEach(System.out::println);
    }
}
