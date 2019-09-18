package com.leetcode.fan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/09/16.
 */

public class TestList {
    public static List<Integer> testList() {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list2.add(10);
        list2.add(11);
        list2.add(12);
        list.addAll(list1);
        list.addAll(list2);
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = testList();
        for (Integer el : list) {
            System.out.print(el + "\t");
        }

    }
}

