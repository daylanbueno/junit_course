package io.github.dailan.UnitTesting.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Match  {

    // deve pegar alunos aprovados
    // deve mostrar os alunos reprovados.
    // deve calcular média de alunos aprovados.
    // deve calcular média geral.

    public static void main(String[] args) {
        Aluno mateus = Aluno.builder().nome("Mateus").nota(8.5).build();
        Aluno ana = Aluno.builder().nome("Ana").nota(5.5).build();
        Aluno bia = Aluno.builder().nome("Bia").nota(6.5).build();
        Aluno amanda = Aluno.builder().nome("Amanda").nota(9.5).build();
        Aluno dilan = Aluno.builder().nome("Dilan").nota(8.5).build();

        List<Aluno> alunosReprovados = Arrays.asList(ana,bia);

        List<Aluno> alunos = Arrays.asList(mateus,ana,bia,amanda,dilan);
        System.out.println("#Alunos aprovados");
        obterAlunosAprovados(alunos).forEach(System.out::println);

        System.out.println("\n#Alunos reprovados");
        obterAlunosReprovados(alunos).forEach(System.out::println);

        System.out.println("\n#Média dos alunos aprovados");
        Double mediaAprovados = obterMediaAlunosAprovados(alunos);
        System.out.println("Resultado é  "+ String.format("%.2f", mediaAprovados));

        System.out.println("\n#Média geral dos aprovados");
        System.out.println("Resultado é  "+ String.format("%.2f", obterMediaGeralAlunos(alunos)));

        boolean AllAlunoAprovado = alunosReprovados.stream().allMatch(aluno -> aluno.getNota() > 7);
        System.out.println("\n#AllMatch - Todos os  alunos estão aprovados? "+AllAlunoAprovado);

        boolean hasAlunoAprovado = alunosReprovados.stream().noneMatch(aluno -> aluno.getNota() >= 7);
        System.out.println("\n#AllMatch - Tem algum  aluno aprovado? "+hasAlunoAprovado);

    }

    public static List<Aluno> obterAlunosAprovados(List<Aluno> alunos) {
        return alunos.stream()
                .filter((aluno) -> aluno.getNota() >=7).collect(Collectors.toList());
    }

    public static List<Aluno> obterAlunosReprovados(List<Aluno> alunos) {
        return alunos.stream()
                .filter(aluno -> aluno.getNota() < 7)
                .collect(Collectors.toList());
    }

    public static Double obterMediaAlunosAprovados(List<Aluno> alunos) {
        List<Aluno> alunosAprovados = obterAlunosAprovados(alunos);
        Double somatoraNotas = alunosAprovados
                .stream()
                .map(aluno -> aluno.getNota())
                .reduce(0d, (it, prox) -> it + prox);
        return somatoraNotas / alunosAprovados.size();
    }

    public static Double obterMediaGeralAlunos(List<Aluno> alunos) {
        return alunos.stream()
                .map( aluno -> aluno.getNota())
                .reduce(0d, (notaAtual, proxNota) ->  notaAtual + proxNota) / alunos.size();
    }
}
