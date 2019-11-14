package com.leetcode.fan.bdfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :  PF_23
 * @Description : 广度优先遍历BFS（Breadth First Search）。
 * 其主要思想是从起始点开始，将其邻近的所有顶点都加到一个队列（FIFO）中去，
 * 然后标记下这些顶点离起始顶点的距离为1.最后将起始顶点标记为已访问，今后就不会再访问。
 * 然后再从队列中取出最先进队的顶点A，也取出其周边邻近节点，加入队列末尾，将这些顶点的距离相对A再加1，最后离开这个顶点A。
 * 依次下去，直到队列为空为止。从上面描述的过程我们知道每个顶点被访问的次数最多一次（已访问的节点不会再访问），
 * 而对于连通图来说，每个顶点都会被访问。
 * 加上每个顶点的邻接链表都会被遍历，因此BFS的时间复杂度是Θ（V+E），其中V是顶点个数，E是边数，也就是所有邻接表中的元素个数。
 * @date : 2019/10/14.
 */

public class Bfs {
    private static void bfs(HashMap<Character, LinkedList<Character>> graph, HashMap<Character, Integer> dist, char start) {
        Queue<Character> queue = new LinkedList<>();
        queue.add(start);//将s作为起始顶点加入队列
        dist.put(start, 0);
        int i = 0; // 距离

        while (!queue.isEmpty()) {
            char top = queue.poll();//取出队首元素
            i++;
            System.out.println("The " + i + "th element:" + top + " Distance from s is:" + dist.get(top));
            int d = dist.get(top) + 1;//得出其周边还未被访问的节点的距离
            for (Character c : graph.get(top)) {
                if (!dist.containsKey(c)) {//如果dist中还没有该元素说明还没有被访问 同visited(i)一个意思
                    dist.put(c, d);
                    queue.add(c);
                }
            }
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
        char start = 's';
        bfs(graph, dist, start);
    }
}

