package io.github.dailan.UnitTesting.java.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
    Essa classe mostra como pegar maior (maior valor) em uma lista usando a interface comparetor
 */
public class MinMax {

    public static void main(String[] args) {
        Aluno mateus = Aluno.builder().nome("Mateus").nota(8.5).build();
        Aluno ana = Aluno.builder().nome("Ana").nota(5.5).build();
        Aluno bia = Aluno.builder().nome("Bia").nota(6.5).build();
        Aluno amanda = Aluno.builder().nome("Amanda").nota(9.5).build();
        Aluno dilan = Aluno.builder().nome("Dilan").nota(10.0).build();
        List<Aluno> alunos = Arrays.asList(mateus,ana,bia,amanda,dilan);

        Comparator<Aluno> maiorNota  = (aluno, outroAluno) -> {
            if(aluno.getNota() > outroAluno.getNota()) return 1;
            if(aluno.getNota() < outroAluno.getNota()) return -1;
            return 0;
        };
        System.out.println("Maior nota "+alunos.stream().max(maiorNota).get());
        System.out.println("Menor nota"+alunos.stream().min(maiorNota).get());
    }
}
