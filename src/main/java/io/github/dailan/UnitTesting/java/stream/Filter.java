package io.github.dailan.UnitTesting.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filter {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9);
        //numeros.stream().filter((item) -> item != 5).forEach(System.out::print);

        Aluno bia = Aluno.builder().nome("Bia").nota(7.8).build();
        Aluno ana = Aluno.builder().nome("Ana").nota(5.8).build();
        Aluno dany = Aluno.builder().nome("dany").nota(4.6).build();
        Aluno dailan = Aluno.builder().nome("dailan").nota(9.8).build();
        Aluno dilan = Aluno.builder().nome("Dilan").nota(10).build();
        List<Aluno> alunos = Arrays.asList(bia,ana,dany,dailan,dilan);

        List<String> alunosAprovados = alunos.stream()
                .filter(aluno -> aluno.getNota() >= 7)
                .map(aluno -> aluno.getNome() + ", parabéns você foi aprovado (a)")
                .collect(Collectors.toList());

        alunosAprovados.stream().forEach(System.out::println);
        obterNomeAlunosReprovados(alunos).stream().forEach(System.out::println);
        obterAlunosAprovados(alunos).stream().forEach(System.out::println);

    }

    private static List<String> obterNomeAlunosReprovados(List<Aluno> alunos) {
        return alunos.stream()
                .filter(aluno -> aluno.getNota() < 7)
                .map(aluno -> aluno.getNome() +" nota: "+aluno.getNota())
                .collect(Collectors.toList());
    }

    public static List<String> obterAlunosAprovados(List<Aluno> alunos) {
        Predicate<Aluno> aprovado = a -> a.getNota() >=7;
        Function<Aluno, String> saudacaoAprovado = aluno -> aluno.getNome() + ", parabéns você foi aprovado(a) "+ aluno.getNota();
       return alunos.stream()
                .filter(aprovado)
                .map(saudacaoAprovado).collect(Collectors.toList());
    }
}
