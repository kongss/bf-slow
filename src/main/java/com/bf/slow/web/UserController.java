package com.bf.slow.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * xx
 *
 * @author kongshuaishuai
 * Created on 2019/5/20 12:48
 * Email is kongshuaishuai@mrfresh.com
 * Copyright is
 */
@Slf4j
@RestController
@RequestMapping(value = "/user", produces = {"application/json;charset=UTF-8"})
public class UserController {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        System.out.println("strings: "+strings);
        List<String> stringList = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        System.out.println("stringList: "+stringList);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> collect = numbers.stream().map(i -> i * i).collect(Collectors.toList());
        System.out.println(collect);
        IntStream intStream = numbers.stream().mapToInt(x -> x);
        IntSummaryStatistics statistics = intStream.summaryStatistics();
        System.out.println(statistics);

        System.out.println("---------------------------");

        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
        random.ints().limit(10).sorted().forEach(System.out::println);


        long count = strings.stream().filter(s -> !s.isEmpty()).count();
        System.out.println(count);

    }

}
