package io.github.dailan.UnitTesting.java.stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DesafioMap {
    public static void main(String[] args) {

        System.out.println("\nconverter to bynary");
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<String> numBynary = nums.stream().map(num -> {
            String bNum = Integer.toBinaryString(num);
            return bNum + " ";
        }).collect(Collectors.toList());
        numBynary.forEach(System.out::print);

        System.out.println("\ninverter of bynary");
        List<String> numStringReverse = numBynary
                .stream().map(bNum -> new StringBuffer(bNum).reverse().toString()).collect(Collectors.toList());

        numStringReverse.forEach(System.out::print);

        System.out.println("\nrevert ");
        numStringReverse.stream().map((item) -> new StringBuffer(item)
                .reverse().toString().replace(" ", ""))
                .map((it) -> Integer.parseInt(it, 2))
                .forEach(System.out::print);

    }
}
