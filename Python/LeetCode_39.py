from copy import deepcopy
class Solution:
    @staticmethod
    def combinationSum(candidates: List[int], target: int) -> List[List[int]]:
        if target == 0:
            return [[]]
        ans_list = []
        candidates.sort()
        ans_set = Solution.combinationSum_ans(candidates, target, [])
        for tpl in ans_set:
            ans_list.append(list(tpl))
        return ans_list

    @staticmethod
    def combinationSum_ans(candidates, target, dp=[]):
        target_set = set()
        if len(dp) <= target:
            for i in range(len(dp), target+1):
                dp.append(None)
        if dp[target] is None:
            for c in candidates:
                if c == target:
                    target_set.add(tuple([c]))
                else:
                    if c > target:
                        break
                    else:
                        comb = Solution.combinationSum_ans(candidates, target-c, dp)
                    for tpl in comb:
                        if tpl:
                            target_list = list(tpl)
                            target_list.append(c)
                            target_list.sort()
                            target_tuple = tuple(target_list)
                            target_set.add(target_tuple)
            dp[target] = target_set
            return target_set
        else:
            return dp[target]

    @staticmethod
    def test(num):
        return Solution.combinationSum([8, 7, 4, 3], num)
