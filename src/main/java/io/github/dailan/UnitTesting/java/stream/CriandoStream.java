package io.github.dailan.UnitTesting.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class CriandoStream {

    public static void main(String[] args) {
        Consumer<String> print = System.out::print;
        Stream<String> langs = Stream.of("Java, ", "Lua, ", "JS\n");
        langs.forEach(print);

        String[] maisLang  = { "Python, ","Lisp, ","Perl, ", "GO\n"};
        Stream.of(maisLang).forEach(print);
        Arrays.stream(maisLang).forEach(print);
        Arrays.stream(maisLang, 1, 4).forEach(print);

        List<String> arrayLangs = Arrays.asList("C,", "PHP, ", "KOTLIN\n");
        arrayLangs.stream().forEach(print);
        arrayLangs.parallelStream().forEach(print);

    }
}
