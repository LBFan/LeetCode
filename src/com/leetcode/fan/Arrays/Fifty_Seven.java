package com.leetcode.fan.Arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by : PF
 * Date on : 2018/11/7.
 * <p>
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1:
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * <p>
 * 示例 2:
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */

public class Fifty_Seven {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
//        List<Interval> result = new ArrayList<>();
//        if (intervals == null || intervals.size() < 1) {
//            result.add(newInterval);
//            return result;
//        }
//
//        // 首先将新区间插入到原来的intervals中
//        int len = intervals.size();
//        int[] starts = new int[len+ 1];
//        int[] ends = new int[len + 1];
//        // 将原区间的首尾数字存放在两个数组中
//        for(int i = 0; i < len; i++) {
//            starts[i] = intervals.get(i).start;
//            ends[i] = intervals.get(i).end;
//        }
//
//        for (int i = len - 1; i > 0; i--) {
//            if(starts[i] > newInterval.start && newInterval.start > starts[i - 1]) {
//                for (int j = len - 1; j >=i; j--) {
//                    starts[ j+ 1] = starts[j];
//                    ends[ j+ 1] = ends[j];
//                }
//                starts[i] = newInterval.start;
//                ends[i] = newInterval.end;
//                break;
//            }
//        }
//
//        List<Interval> newIntervals = new ArrayList<Interval>();
//        for (int i = 0; i < starts.length; i++) {
//            newIntervals.add(new Interval(starts[i], ends[i]));
//        }
//        // 按照56题进行区间合并
//        Interval pre = null;
//        for (Interval item: newIntervals) {
//            if(pre == null || pre.end < item.start){
//                result.add(pre);
//                pre = item;
//            } else if (pre.end < item.end) {
//                pre.end = item.end;
//            }
//        }
//        // 返回合并后的最终区间
//        return result;

        // 保存结果的集合
        List<Interval> result = new ArrayList<>();

        // 输入集非空
        if (intervals != null) {
            // 遍历元素
            for (Interval item : intervals) {
                // newInterval == null 表示插入的区间已经处理完了
                // 将比插入区间小的区间加入结果集中
                if (newInterval == null || item.end < newInterval.start) {
                    result.add(item);
                }
                // 将比插入区间大的区间加入结果集中，同时将插入的区间加入结果集
                else if (item.start > newInterval.end) {
                    result.add(newInterval);
                    result.add(item);
                    newInterval = null;
                }
                // 插入区间有重叠，更新插入区间
                else {
                    newInterval.start = Math.min(newInterval.start, item.start);
                    newInterval.end = Math.max(newInterval.end, item.end);
                }
            }
        }

        // 如果插入区间非空说明插入区间还未被处理
        if (newInterval != null) {
            result.add(newInterval);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));

        Interval interval = new Interval(2, 5);
        List<Interval> result = new Fifty_Seven().insert(intervals, interval);
        if (result != null || result.size() > 0) {
            for (Interval re :
                    result) {
                System.out.println("[" + re.start + ", " + re.end + "] ");
            }
        }

    }

}


