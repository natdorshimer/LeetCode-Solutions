package src.Solutions;


import src.structures.Pair;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author : Natalie Dorshimer
 * @since : 1/26/2020, Sun
 *
 *
 **/

/**
 * This is the same as Problem 64. The difference is that it's incremented by 1 for every unique
 * path that makes it to the origin. So the base case at (0,0) has a path length of 1
 * And every branch that makes it to the origin will have a value of one
 * This uses recursion so there will be up to two possible branches at each point.
 *
 * So if you're at point m,n, uniquePaths(m,n), is uniquePaths(m-1,n) + uniquePaths(m,n-1)
 * And then once you reach uniquePaths(0,0) it returns 1
 *
 * It also uses a dynamic-programming hash map to store the uniquePath if it was already found, preventing
 * over-calculating.
 *
 */
public class LeetCode_62 {
    public static int uniquePaths(int m, int n) {
        HashMap<Pair<Integer, Integer>, Integer> num_paths = new HashMap();
        num_paths.put(new Pair<Integer, Integer> (0,0), 1); //Base case: only 1 possible path to origin
        return uniquePaths_from(new Pair<Integer, Integer>(m-1, n-1),num_paths);

    }
    private static int uniquePaths_from
            (Pair<Integer, Integer> pos, HashMap<Pair<Integer, Integer>, Integer> num_paths) {

        //Dynamic programming call to speed things up and avoid recalculating
        if(num_paths.containsKey(pos))
            return num_paths.get(pos);


        //This gets both, one, or no possible paths
        int m_pos = pos.getKey();
        int n_pos = pos.getValue();
        LinkedList<Pair<Integer, Integer>> pos_list = new LinkedList<Pair<Integer,Integer>>();
        if(m_pos - 1 >= 0 && n_pos >= 0)
            pos_list.add(new Pair<Integer, Integer>(m_pos-1, n_pos));
        if(m_pos >= 0 && n_pos-1 >= 0)
            pos_list.add(new Pair<Integer, Integer>(m_pos, n_pos-1));

        //And this adds up the possible path lengths
        int add = 0;
        for(Pair<Integer, Integer> p : pos_list)
            add += uniquePaths_from(p, num_paths);

        //Stick it in the hash map to avoid having to calculate it again
        num_paths.put(pos, add);
        return add;
    }

    public static void uniquePaths_test() {

        Long t1 = System.currentTimeMillis();
        int ans = uniquePaths(7,3);
        Long t2 = System.currentTimeMillis();


        System.out.println("Answer: " + Integer.toString(ans));
        System.out.println("Runtime: " + Long.toString(t2-t1));
    }
}
