package com.leetcode.fan.bdfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author :  PF_23
 * @Description :DFS（Depth First Search）
 * 深度优先搜索是从起始顶点开始，递归访问其所有邻近节点，比如A节点是其第一个邻近节点，
 * 而B节点又是A的一个邻近节点，则DFS访问A节点后再访问B节点，
 * 如果B节点有未访问的邻近节点的话将继续访问其邻近节点，否则继续访问A的未访问邻近节点，
 * 当所有从A节点出去的路径都访问完之后，继续递归访问除A以外未被访问的邻近节点。
 * @date : 2019/10/14.
 */

public class Dfs {
    private static int count = 0;
    private static void dfs(HashMap<Character , LinkedList<Character>> graph, HashMap<Character, Boolean> visited)
    {
        visit(graph, visited, 'u');//为了和图中的顺序一样，我认为控制了DFS先访问u节点
        visit(graph,visited,'w');
    }

    private static void visit(HashMap<Character, LinkedList<Character>> graph, HashMap<Character, Boolean> visited, char start) {
        if (!visited.containsKey(start)) {
            count++;
            System.out.println(start);
            System.out.println(count);
//            System.out.println("The time into element "+start+":"+count);//记录进入该节点的时间
            visited.put(start, true);
            for (Character c :
                    graph.get(start)) {
                if (!visited.containsKey(c)) {
                    visit(graph, visited, c);
                }
            }
            count++;
//            System.out.println("The time out element "+start+":"+count);//记录离开该节点的时间
        }
    }

    public static void main(String[] args) {
        // s顶点的邻接表
        LinkedList<Character> list_s = new LinkedList<>();
        list_s.add('w');
        list_s.add('r');
        LinkedList<Character> list_w = new LinkedList<>();
        list_w.add('s');
        list_w.add('i');
        list_w.add('x');
        LinkedList<Character> list_r = new LinkedList<>();
        list_r.add('s');
        list_r.add('v');
        LinkedList<Character> list_x = new LinkedList<>();
        list_x.add('w');
        list_x.add('i');
        list_x.add('u');
        list_x.add('y');
        LinkedList<Character> list_v = new LinkedList<>();
        list_v.add('r');
        LinkedList<Character> list_i = new LinkedList<>();
        list_i.add('u');
        list_i.add('x');
        list_i.add('w');
        LinkedList<Character> list_u = new LinkedList<>();
        list_u.add('i');
        list_u.add('x');
        list_u.add('y');
        LinkedList<Character> list_y = new LinkedList<>();
        list_y.add('u');
        list_y.add('x');
        HashMap<Character, LinkedList<Character>> graph = new HashMap<>();
        graph.put('s', list_s);
        graph.put('w', list_w);
        graph.put('r', list_r);
        graph.put('x', list_x);
        graph.put('v', list_v);
        graph.put('i', list_i);
        graph.put('y', list_y);
        graph.put('u', list_u);
        HashMap<Character, Integer> dist = new HashMap<>();
//        char start = 's';
        HashMap<Character, Boolean> visited = new HashMap<>();
        dfs(graph, visited);
    }
}

