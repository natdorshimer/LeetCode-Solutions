package src.Solutions;

/**
 * @author : Natalie Dorshimer
 * @since : 1/25/2020, Sat
 **/

import src.structures.Pair;

import java.util.*;

/**
 * Problem 64: Minimum Path Sum: Given an mxn grid filled with non negative numbers, find a path from
 * top left to bottom right which minimizes the sum of all numbers along its path
 *
 * So we want to go from nums[0][0] to nums[m][n] and minimize the sum along the way
 * We can minimize time by creating a HashMap<Pair<pos1,pos2> that tracks the pre-calculated minimum sum to that point
 * In this solution we start at the very end of the grind and then check the minimum paths of each of the nearest paths
 *
 * It does eventually calculate all path lengths, but it stores the calculation so it doesn't waste computation time repeating
 **/
public class LeetCode_64 {

    public static int minPathSum(int[][] grid) {
        if(grid == null || grid[0] == null)
            return 0;

        HashMap<Pair<Integer,Integer>,Integer> sum_path = new HashMap(); //We'll store the minimum path lengths here
        sum_path.put(new Pair<Integer, Integer> (0,0), grid[0][0]);
        Pair<Integer, Integer> end = new Pair<Integer, Integer>(grid.length-1, grid[0].length-1);
        return minPathTo(grid, sum_path,end);
    }

    private static int minPathTo(int[][] grid, HashMap<Pair<Integer,Integer>,Integer> sum_path, Pair<Integer, Integer> pos){

        if(sum_path.containsKey(pos))
            return sum_path.get(pos);

        //There's two possible paths to take since we're starting at the very edge
        int m_pos = pos.getKey();
        int n_pos = pos.getValue();
        LinkedList<Pair<Integer, Integer>> pos_list = new LinkedList<Pair<Integer,Integer>>();
        if(m_pos - 1 >= 0 && n_pos >= 0)
            pos_list.add(new Pair<Integer, Integer>(m_pos-1, n_pos));
        if(m_pos >= 0 && n_pos-1 >= 0)
            pos_list.add(new Pair<Integer, Integer>(m_pos, n_pos-1));

        //I can't set min_length to 0 otherwise Math.min won't work
        //It's easiest to just check if it was initialized (-1 == not initialized)
        int min_length = -1;
        for(Pair<Integer, Integer> p : pos_list){
            int p_length = minPathTo(grid, sum_path, p);
            sum_path.put(p, p_length);
            if(min_length == -1) min_length = p_length;
            min_length = Math.min(min_length, p_length);
        }

        return grid[m_pos][n_pos]+min_length;
    }

    public static void minPathSum_test() {
        int[][] test_case = new int[][] {
                        new int[] {1,2,5,6,7},
                        new int[] {3,2,1,8,9},
                        new int[] {6,2,1,1,1},
                        new int[] {1,2,5,6,7},
                        new int[] {1,2,5,6,7}
                };

        for(int[] l : test_case)
            System.out.println(Arrays.toString(l));

        Long t1 = System.currentTimeMillis();
        int ans = minPathSum(test_case);
        Long t2 = System.currentTimeMillis();


        System.out.println("Answer: " + Integer.toString(minPathSum(test_case)));
        System.out.println("Runtime: " + Long.toString(t2-t1));
    }

}
