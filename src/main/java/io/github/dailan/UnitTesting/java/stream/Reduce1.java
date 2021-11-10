package io.github.dailan.UnitTesting.java.stream;

import java.util.Arrays;
import java.util.List;

public class Reduce1 {

    /// criar método para fazer somatória simples sem reducer.
    // criar método com uso do reduce fazer somatória
    public static void main(String[] args) {
        List<Integer> arrayNum = Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println(somarValoresArraySimples(arrayNum));

        Integer total1 = arrayNum.stream()
                .reduce((it, itProx) -> it + itProx).get();
        System.out.println("Total1 : "+ total1);

        Integer total2 = arrayNum.stream()
                .reduce(100, (it, prox) -> it + prox);
        System.out.println("Total2 : "+ total2);


        Integer totalSomaMaior5 = arrayNum.stream()
                .filter((it) -> it <= 5)
                .reduce((it, prox) -> it + prox).get();

        System.out.println("totalSomaMaior5 : "+ totalSomaMaior5);

    }

    public static Integer somarValoresArraySimples(List<Integer> numeros) {
        Integer sum = 0;
        for (Integer num : numeros) {
            sum +=num;
        }
        return sum;
    }
}
