package com.leetcode.fan.apriori;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/08/05.
 */

public class Item implements Comparable {

    private String value;
    private Item preItem; // 前继节点Item
    private List<Item> nextItem = new ArrayList<>(); // 后续节点Item

    private Item sibling; // 关联节点

    private int counter;

    Item() {

    }

    Item(String value) {
        this.value = value;
    }

    void addCounter() {
        this.counter += 1;
    }

    Item getSibling() {
        return sibling;
    }

    void setSibling(Item sibling) {
        this.sibling = sibling;
    }

    void addNextItem(Item item) {
        this.nextItem.add(item);
    }

    List<Item> getNextItem() {

        return this.nextItem;
    }

    String getValue() {
        return value;
    }

    void setValue(String value) {
        this.value = value;
    }

    Item getPreItem() {
        return preItem;
    }

    void setPreItem(Item preItem) {
        this.preItem = preItem;
    }

    int getCounter() {
        return counter;
    }

    void setCounter(int counter) {
        this.counter = counter;
    }

    public int compareTo(Object o) {
        Item i = (Item) o;
        return Integer.compare(i.counter, this.counter);
    }

}

