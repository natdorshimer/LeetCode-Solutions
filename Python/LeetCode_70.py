"""
 * @author : Natalie Dorshimer
 * @since : 1/26/2020, Sun
"""

"""
Problem 70: Climbing Stairs
It takes n steps to reach the top of the stairs. Each time you can either climb 
1 or two steps. In how many distinct ways can you climb to the top?

This is just a sum of paths problem

Paths(top) = Paths(top-1) + Paths(top - 2)

We can store the calculations in a hash map/dictionary to avoid recalculations

This is literally the fibonacci series 
"""


class Solution(object):

    @staticmethod
    def climbStairs(n):
        paths_dict = {0: 1, 1: 1}  # base cases: 1 path to itself at 0, 1 path to 1 (no way to take two steps)
        for i in range(2, n+1):
            paths_dict[i] = paths_dict[i-1] + paths_dict[i-2]
        return paths_dict[n]

    @staticmethod
    def climbStairs_test():
        return Solution.climbStairs(8)


print(Solution.climbStairs_test())


