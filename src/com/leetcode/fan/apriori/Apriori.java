package com.leetcode.fan.apriori;

import java.io.*;
import java.util.*;

/**
 * @author :  PF_23
 * @Description : apriori算法实现
 * 发现频繁项集的过程：
 * (1)构建FP树；
 * <p>
 * (2)从FP树中挖掘频繁项集。
 * -1 从FP树中获得条件模式基；
 * -2 利用条件模式基，构建一个条件FP树；
 * -3 迭代重复-1和-2，直到树包含一个元素项为止。
 * @date : 2019/08/05.
 */

public class Apriori {

    /**
     * 最小支持度
     */
    private int minSup;

    public void setMinSup(int minSup) {
        this.minSup = minSup;
    }

    /**
     * 1.构造数据集
     *
     * @param fileName
     * @return
     */
    public List<String> buildData(String... fileName) {
        List<String> data = new ArrayList<>();
        if (fileName.length != 0) {
            File file = new File(fileName[0]);
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    data.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            data.add("I1 I2 I5");
            data.add("I2 I4");
            data.add("I2 I3");
            data.add("I1 I2 I4");
            data.add("I1 I3");
            data.add("I2 I3");
            data.add("I1 I3");
            data.add("I1 I2 I3 I5");
            data.add("I1 I2 I3");
        }
        return data;
    }

    /**
     * 2.构造频繁1项列表，同时作为树的项头表
     * 统计每个出现的次数，剪掉小于支持度的项
     *
     * @param data
     * @return
     */
    private Item[] buildF1Items(List<String> data) {
        List<Item> itemList = new ArrayList<>();
        Map<String, Item> resultMap = new HashMap<>();
        // 第一遍遍历数据集
        for (String trans : data) {
            String[] items = trans.trim().split(" ");
            for (String item : items) {
                if (resultMap.get(item) == null) {
                    Item newItem = new Item();
                    newItem.setValue(item);
                    newItem.setCounter(1);
                    resultMap.put(item, newItem);
                } else {
                    resultMap.get(item).addCounter();
                }
            }
        }
        Set<String> keySet = resultMap.keySet();
        for (String key : keySet) {
            itemList.add(resultMap.get(key));
        }
        List<Item> result = new ArrayList<>();
        // 把支持度小于minSup的项从列表中删除
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getCounter() >= this.minSup) {
                result.add(itemList.get(i));
            }
        }
        // 对列表进行排序
        Item[] f1Items = result.toArray(new Item[0]);
        Arrays.sort(f1Items);
        return f1Items;
    }

    /**
     * 3. 构造fpTree：真正意义上的第一步
     *
     * @param data
     * @param f1Items
     * @return
     */
    public Item buildFPTree(List<String> data, Item[] f1Items) {
        Item fpTree = new Item();
        List<Item> subItems;
        // 对每一条事务进行处理
        for (String trans : data) {
            // 得出每条事件中涉及的元素项
            String[] items = trans.trim().split(" ");
            // 对items中的元素按其在频繁1项集中出现次数排序
            items = sortItem(items, f1Items);
            // 把items的值加入到fpTree中
            subItems = fpTree.getNextItem();
            if (subItems.size() == 0) {
                this.addLeaf(fpTree, items, f1Items);
            } else {
                Item temp = null;
                for (int i = 0; i < items.length; i++) {
                    int j = 0;
                    int size = subItems.size();
                    for (; j < subItems.size(); j++) {
                        if (subItems.get(j).getValue().equals(items[i])) {
                            temp = subItems.get(j);
                            temp.addCounter();
                            subItems = temp.getNextItem();
                            break;
                        }
                    }
                    if (j == size) {
                        if (temp == null) {
                            this.addLeaf(fpTree, Arrays.copyOfRange(items, i,
                                    items.length), f1Items);
                        } else {
                            this.addLeaf(temp, Arrays.copyOfRange(items, i,
                                    items.length), f1Items);
                        }
                        break;
                    }
                }
            }
        }
        return fpTree;
    }

    /**
     * 3.1 对元素数组根据其在f1中出面的频繁进行排序
     *
     * @param items
     * @param f1Items
     * @return
     */
    private String[] sortItem(String[] items, Item[] f1Items) {
        String[] temp = new String[f1Items.length];
        int i;
        for (String item : items) {
            for (i = 0; i < f1Items.length; i++) {
                if (item.equals(f1Items[i].getValue())) {
                    temp[i] = item;
                }
            }
        }
        List<String> list = new ArrayList<>();
        int j = 0;
        for (i = 0; i < temp.length; i++) {
            if (temp[i] != null) {
                list.add(temp[i]);
            }
        }

        return list.toArray(new String[0]);
    }

    /**
     * 3.2 给FPTree的节点添加子节点序列
     *
     * @param preItem
     * @param items
     * @param f1Items
     */
    private void addLeaf(Item preItem, String[] items, Item[] f1Items) {
        if (items.length > 0) {
            Item item = new Item(items[0]);
            item.setCounter(1);
            item.setPreItem(preItem);
            preItem.addNextItem(item);

            for (Item i : f1Items) {
                if (i.getValue().equals(items[0])) {
                    Item temp = i;
                    while (temp.getSibling() != null) {
                        temp = temp.getSibling();
                    }
                    temp.setSibling(item);
                    break;
                }
            }
            if (items.length > 1) {
                addLeaf(item, Arrays.copyOfRange(items, 1, items.length),
                        f1Items);
            }
        }
    }

    /**
     * 输出fpTree
     *
     * @param root
     */
    public void printFPTree(Item root) {
        System.out.print(root.getValue() + ":" + root.getCounter() + "\n后续节点数:"
                + root.getNextItem().size());
        System.out.println();
        for (Item item :
                root.getNextItem()) {
            System.out.println(item.getValue());
        }
        System.out.println();
        System.out.println("============================");
        List<Item> subItems = root.getNextItem();
        if (subItems.size() != 0) {
            for (Item subItem : subItems) {
                printFPTree(subItem);
            }
            System.out.println("一条路径");
            System.out.println();
        }

    }

    /**
     * 输出频繁1项集
     *
     * @param f1Items
     */
    public void printF1Items(Item[] f1Items) {
        for (Item item : f1Items) {
            while ((item = item.getSibling()) != null) {
                System.out.print("item: " + item.getValue() + ": "
                        + item.getCounter() + " ,");
                System.out.println();
                System.out.println("==========================================");
                if (item.getPreItem() != null) {
                    System.out.println("前继节点：" + item.getPreItem().getValue());
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    /**
     * 4. 生成条件模式基
     *
     * @param f1Items
     * @return
     */
    private Map<String, List<String>> buildCondBase(Item[] f1Items) {

        Item item; // 横向处理时的当前节点
        Item preItem; // 横向处理的当前节点对应的纵向节点
        int counter;
        StringBuffer data;

        Map<String, List<String>> condBaseMap = new HashMap<>();
        List<String> conditionBase; // 条件模式基
        // 逆向遍历频繁1项集(但不需处理其第一项)
        for (int i = f1Items.length - 1; i > 0; i--) {

            conditionBase = new ArrayList<>();
            item = f1Items[i].getSibling();
            while (item != null) { // 横向处理

                counter = item.getCounter();
                preItem = item.getPreItem();
                data = new StringBuffer();
                while (preItem.getValue() != null) { // 纵向处理
                    data.append(preItem.getValue() + " ");
                    preItem = preItem.getPreItem();
                }
                for (int j = 0; j < counter; j++) {
                    if (data.toString().trim() != ""
                            && data.toString().trim().length() > 0) {
                        conditionBase.add(data.toString().trim());
                    }
                }
                item = item.getSibling();
            }
            condBaseMap.put(f1Items[i].getValue(), conditionBase);
        }

        return condBaseMap;
    }

    /**
     * 输出条件模式基
     *
     * @param condBaseMap
     */
    public void printCondBase(Map<String, List<String>> condBaseMap) {

        Set<String> items = condBaseMap.keySet();
        List<String> conBase;
        for (String item : items) {
            System.out.print("Item: " + item);
            conBase = condBaseMap.get(item);
            System.out.println(", " + conBase.size());
            for (String str : conBase) {
                System.out.println(str + " ");
            }
        }
    }

    /**
     * 输出条件fp树
     *
     * @param condFPTreeMap
     */
    public void printCondFPTree(Map<String, Item> condFPTreeMap) {
        Set<String> items = condFPTreeMap.keySet();
        for (String item : items) {
            System.out.println("Item: " + item);
            this.printFPTree(condFPTreeMap.get(item));
        }
    }

    /**
     * 5. 生成条件FP树
     *
     * @param condBaseMap
     * @return
     */
    private Map<String, Item> buildCondFPTree(
            Map<String, List<String>> condBaseMap) {

        Map<String, Item> condFPTreeMap = new HashMap<>();
        List<String> condBase;
        Item condFPTree;
        Set<String> items = condBaseMap.keySet();
        for (String item : items) {
            condBase = condBaseMap.get(item);
            condFPTree = this
                    .buildFPTree(condBase, this.buildF1Items(condBase));
            // 删除condFPTree树中节点出现次数少于最小支持度的点
            this.delLTminSup(condFPTree);
            condFPTreeMap.put(item, condFPTree);
        }
        return condFPTreeMap;
    }

    /**
     * 5.1  删除树中节点计数小于最小支持度的节点
     *
     * @param root
     */
    private void delLTminSup(Item root) {
        List<Item> subItems = root.getNextItem();
        if (subItems.size() != 0) {
            for (int i = 0; i < subItems.size(); i++) {
                if (subItems.get(i).getCounter() < this.minSup) {
                    subItems.remove(i);
                } else {
                    delLTminSup(subItems.get(i));
                }
            }
        }
    }

    /**
     * 6.产生频繁模式 根据前面生成的条件FP树，分别产生相应元素相关的频繁模式
     *
     * @param condFPTreeMap
     * @return
     */
    public Map<String, List<List<String>>> fpGrowth(Map<String, Item> condFPTreeMap) {
        List<List<String>> result;
        Map<String, List<List<String>>> resultMap = new HashMap<>();
        Set<String> items = condFPTreeMap.keySet();
        Item condFPTree;
        List<String> pathList; // 一个条件fp树中所有的路径
        List<String> stack = new ArrayList<>();

        for (String item : items) {
            pathList = new ArrayList<>();
            condFPTree = condFPTreeMap.get(item);
            buildPath(stack, condFPTree, pathList);

            for (String str : pathList) {
                result = new ArrayList<>();
                if (str.trim().length() != 0) {
                    String[] temp = str.trim().split(" ");
                    List<String> nodeList = new ArrayList<>();
                    nodeList.addAll(Arrays.asList(temp));

                    buildSubSet(nodeList, result);

                    if (resultMap.get(item) == null) {
                        resultMap.put(item, result);
                    } else {
                        List<List<String>> list = resultMap.get(item);
                        for (List<String> strings : result) {
                            list.add(strings);
                        }
                        resultMap.put(item, list);
                    }
                }
            }
        }
        return resultMap;
    }

    /**
     * 生成树的每一条路径
     *
     * @param stack
     * @param root
     * @param pathList
     */
    private void buildPath(List<String> stack, Item root, List<String> pathList) {

        if (root != null) {
            stack.add(root.getValue());
            if (root.getNextItem().size() == 0) {
                changeToPath(stack, pathList); // 把值栈中的值转化为路径
            } else {
                List<Item> items = root.getNextItem();
                for (int i = 0; i < items.size(); i++) {
                    buildPath(stack, items.get(i), pathList);
                }
            }
            stack.remove(stack.size() - 1);
        }
    }

    /**
     * 6.1.1 把值栈中的值转化为路径
     *
     * @param path
     * @param pathList
     */
    private void changeToPath(List<String> path, List<String> pathList) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < path.size(); i++) {
            if (path.get(i) != null) {
                sb.append(path.get(i) + " ");
            }

        }
        pathList.add(sb.toString().trim());

    }

    /**
     * 生成子集
     *
     * @param sourceSet
     * @param result
     */
    private void buildSubSet(List<String> sourceSet, List<List<String>> result) {

        if (sourceSet.size() == 1) {
            List<String> set = new ArrayList<String>();
            set.add(sourceSet.get(0));
            result.add(set);
        } else if (sourceSet.size() > 1) {

            buildSubSet(sourceSet.subList(0, sourceSet.size() - 1), result);
            int size = result.size();

            List<String> single = new ArrayList<String>();
            single.add(sourceSet.get(sourceSet.size() - 1));
            result.add(single);

            List<String> clone;
            for (int i = 0; i < size; i++) {
                clone = new ArrayList<String>();
                for (String str : result.get(i)) {
                    clone.add(str);
                }
                clone.add(sourceSet.get(sourceSet.size() - 1));

                result.add(clone);
            }
        }
    }

    /**
     * 输出频繁集
     *
     * @param fpSetMap
     */
    public void printFPSet(Map<String, List<List<String>>> fpSetMap) {
        List<List<String>> fpSet;
        Set<String> items = fpSetMap.keySet();
        for (String item :
                items) {
            System.out.println(item);
            fpSet = fpSetMap.get(item);
            for (int i = 0; i < fpSet.size(); i++) {
                for (String str : fpSet.get(i)) {
                    System.out.print(str + ", ");
                }
                System.out.println(item);
            }
        }
    }

    public static void main(String[] args) {
        Apriori apriori = new Apriori();
        //设置最小支持度
        apriori.setMinSup(3);
//        List<String> data = apriori.buildData("foods.txt");
        List<String> data = apriori.buildData();
        Item[] f1Items = apriori.buildF1Items(data);
        Item fpTree = apriori.buildFPTree(data, f1Items);
        System.out.println("------------------------------------");
        // 输出fp-tree
        System.out.println("输出fp-tree");
        apriori.printFPTree(fpTree);
        System.out.println("------------------------------------");

        // 输出频繁1项集
        System.out.println("输出频繁1项集");
        apriori.printF1Items(f1Items);
        // 生成条件模式基
        System.out.println("------------------------------------");
        Map<String, List<String>> condBase = apriori.buildCondBase(f1Items);
        // 输出条件模式基
        System.out.println("输出条件模式基");
        System.out.println("------------------------------------");
        apriori.printCondBase(condBase);
        // 生成条件PF树
        Map<String, Item> condFPTree = apriori.buildCondFPTree(condBase);
        System.out.println("------------------------------------");
        System.out.println("输出条件fp树");
        apriori.printCondFPTree(condFPTree);
        Map<String, List<List<String>>> fpSetMap = apriori.fpGrowth(condFPTree);
        // 输出频繁集
        System.out.println("------------------------------------");
        System.out.println("输出频繁集");
        apriori.printFPSet(fpSetMap);
    }
}

