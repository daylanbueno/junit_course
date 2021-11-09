package io.github.dailan.UnitTesting.java.stream;

import java.util.Arrays;
import java.util.List;

public class DesafioFilter1 {

    // dados uma lista de carros
    // deve filtrar os carros cuja o ano for maior que 2017
    // o deve filtrar somente os carros cuja valor for menor que 50000
    // os carros  que forem menores que 50000 dever ser caracterizado como popular

    public static void main(String[] args) {
        Carro fiatMobi = Carro.builder().nome("Fiat Mobi").ano(2019).valor(45000d).build();
        Carro hondaCivic = Carro.builder().nome("Honda Civic").ano(2020).valor(99000d).build();
        Carro corolla = Carro.builder().nome("Corolla").ano(2015).valor(61000d).build();
        Carro fordKa = Carro.builder().nome("Ford Ka").ano(2020).valor(48000d).build();
        Carro fiesta = Carro.builder().nome("Ford Fiesta").ano(2014).valor(45000d).build();

        List<Carro> carros = Arrays.asList(fiatMobi,hondaCivic,corolla,fordKa,fiesta);

        carros.stream()
                .filter(carro -> carro.getAno()  > 2017)
                .filter(carro -> carro.getValor() < 50000d)
                .map(carro -> carro.getNome() + " é popular e seu valor é "+carro.getValor()+ " ano de fabricação "+ carro.getAno())
                .forEach(System.out::println);

    }
}
