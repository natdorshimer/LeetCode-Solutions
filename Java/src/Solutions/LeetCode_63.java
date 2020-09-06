package src.Solutions;

import src.structures.Pair;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author : Natalie Dorshimer
 * @since : 1/26/2020, Sun
 *
 * Problem 63: This is the same as Problem 62 only you have to bar possible paths from
 * taking on values where obstacleGrid[m][n] == 0
 *
 * You also need base cases for the origin being blocked and the end being blocked,
 * since there's no possible paths at that point
 **/
public class LeetCode_63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        //Can't reach the end if it's blocked or if the origin is blocked
        int m = obstacleGrid.length; int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1] == 1 || obstacleGrid[0][0] == 1)
            return 0;

        HashMap<Pair<Integer, Integer>, Integer> num_paths = new HashMap();
        num_paths.put(new Pair<Integer, Integer> (0,0), 1); //Base case: can reach origin otherwise it's 0
        return uniquePaths_from
                (obstacleGrid,new Pair<Integer, Integer>(m-1, n-1),num_paths);

    }
    private static int uniquePaths_from
            (int[][] obstacleGrid, Pair<Integer, Integer> pos, HashMap<Pair<Integer, Integer>, Integer> num_paths) {

        //Dynamic programming call to speed things up and avoid recalculating
        if(num_paths.containsKey(pos))
            return num_paths.get(pos);


        //This gets both, one, or no possible paths
        //This checks to see if there's an obstacle in the way so you can't get to that pos
        //obstacle[m][n] == 1 means there's an obstacle and there's no path that way
        int m_pos = pos.getKey();
        int n_pos = pos.getValue();
        LinkedList<Pair<Integer, Integer>> pos_list = new LinkedList<Pair<Integer,Integer>>();
        if(m_pos - 1 >= 0 && n_pos >= 0 && obstacleGrid[m_pos-1][n_pos]!=1)
            pos_list.add(new Pair<Integer, Integer>(m_pos-1, n_pos));
        if(m_pos >= 0 && n_pos-1 >= 0 && obstacleGrid[m_pos][n_pos-1]!=1)
            pos_list.add(new Pair<Integer, Integer>(m_pos, n_pos-1));

        //And this adds up the possible path lengths
        int add = 0;
        for(Pair<Integer, Integer> p : pos_list)
            add += uniquePaths_from(obstacleGrid, p, num_paths);

        //Stick it in the hash map to avoid having to calculate it again
        num_paths.put(pos, add);
        return add;
    }

    public static void uniquePathsWithObstacles_test() {

        int[][] test_case = new int[][] {
                new int[] {0,1}
        };

        Long t1 = System.currentTimeMillis();
        int ans = uniquePathsWithObstacles(test_case);
        Long t2 = System.currentTimeMillis();


        System.out.println("Answer: " + Integer.toString(ans));
        System.out.println("Runtime: " + Long.toString(t2-t1));
    }
}
