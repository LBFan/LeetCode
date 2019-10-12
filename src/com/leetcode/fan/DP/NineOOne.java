package com.leetcode.fan.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/10/10.
 */

public class NineOOne {
    private List<Element> list;

    public NineOOne() {
        list = new ArrayList<>();
    }

    public int next(int price) {
        int result;
        if (list.isEmpty()) {
            result = 1;
            list.add(new Element(price, result, -1));
        } else {
            Element element = doHelp(list.size() - 1, price);
            list.add(element);
            result = element.getCount();
        }
        return result;
    }

    private Element doHelp(int index, int price) {
        if (index < 0) {
            return new Element(price, 1, index);
        }
        Element element = list.get(index);
        if (price >= element.getPrice()) {
            Element tempElement = doHelp(element.getNext(), price);

            return new Element(price, tempElement.getCount() + element.getCount(), tempElement.getNext());
        } else {
            return new Element(price, 1, index);
        }
    }

    class Element {
        private Integer price;
        private Integer count;
        private Integer next;

        public Element(Integer price, Integer count, Integer next) {
            this.price = price;
            this.count = count;
            this.next = next;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Integer getNext() {
            return next;
        }

        public void setNext(Integer next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        int s = (int) Math.round(1.5);
        System.out.println(s);
    }
}

