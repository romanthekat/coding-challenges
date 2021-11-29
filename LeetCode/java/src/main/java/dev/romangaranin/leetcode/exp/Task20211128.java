package dev.romangaranin.leetcode.exp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
O(n)
PriorityQueue
 */
public class Task20211128 {
    public static void main(String[] args) {
        var s = new Solution();

        printCoors(s.kClosest(new int[][]{{1, 3}}, 1));
        printCoors(s.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1));
        printCoors(s.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2));
    }

    protected static void printCoors(int[][] coors) {
        for (int[] ar : coors) {
            System.out.printf("%s ", Arrays.toString(ar));
        }
        System.out.println();
    }

    static class Solution {
        public int[][] kClosest(int[][] points, int k) {
            var queue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    var diff = getDistance(o1) - getDistance(o2);

                    if (diff > 0) {
                        return 1;
                    } else if (diff == 0) {
                        return 0;
                    } else {
                        return -1;
                    }
                }

                private double getDistance(int[] coor) {
                    return Math.sqrt((Math.pow(coor[0], 2) + Math.pow(coor[1], 2)));
                }
            });

            for (var coor : points) {
                queue.offer(coor);
            }

            var result = new int[k][];

            //TODO optimize/keep only K elements here
            for (int i = 0; i < k; i++) {
                result[i] = queue.poll();
            }

            return result;
        }
    }
}
