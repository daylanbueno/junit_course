package io.github.dailan.UnitTesting.java.lambdas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class CalculoTest {

    @Test
    @DisplayName("deve somar dois valores")
    public void deveFazeSoma() {
        Calculo soma = (x,y) -> x+y;
        double resultado = soma.executar(10, 5);
        Assertions.assertEquals(15, resultado);
    }

    @Test
    @DisplayName("deve fazer a multplicação dado x e y")
    public void deveFazerMultiplicacao() {
        Calculo multiplicacao = (x,y) -> x * y;
        double resultado = multiplicacao.executar(10, 5);
        Assertions.assertEquals(50, resultado);
    }

    @Test
    @DisplayName("deve fazer a subtracao dado x e y")
    public void deveFazerASubtracao() {
        Calculo subtracao = (x,y) -> x - y;
        double resultado = subtracao.executar(10, 5);
        Assertions.assertEquals(5, resultado);
    }

    @Test
    @DisplayName("deve ser capaz de dividir dado x  e y")
    public void deveFazerAdivisao() {
        Calculo divisao = (x,y) -> x / y;
        double resultado = divisao.executar(10,2);
        Assertions.assertEquals(5, resultado);
    }
}
