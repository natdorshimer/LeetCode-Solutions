class Solution:

    @staticmethod
    def searchRange(nums: List[int], target: int) -> List[int]:
        ind_of = Solution.binSearch(nums, target)
        if ind_of == -1:
            return [-1, -1]
        ind1 = Solution.__binSearchDown(nums, target, 0, ind_of)
        ind2 = Solution.__binSearchUp(nums, target, ind_of, len(nums) - 1)
        return [ind1, ind2]


    @staticmethod
    def binSearch(nums, target):
        if len(nums) == 0:
            return -1
        return Solution.__binSearch(nums, target, 0, len(nums)-1)


    @staticmethod
    def __binSearch(nums, target, start, last):
        # Index creation logic
        if start+1 == last:
            if nums[start] == target:
                return start
            elif nums[start+1] == target:
                return start+1
            else:
                return -1
            
        pos = (start+last)//2
        if start == last and nums[pos] != target:
            return -1
        elif nums[pos] < target:
            return Solution.__binSearch(nums, target, pos, last)
        elif nums[pos] > target:
            return Solution.__binSearch(nums, target, start, pos)
        else:
            return pos

        
    @staticmethod
    def __binSearchUp(nums, target, start, last):
        # Index creation logic
        pos = (start+last)//2
        if start+1 == last:
            pos = last

        if nums[pos] != target and nums[pos - 1] == target:
            return pos - 1
        elif start == last and nums[pos] == target:
            return len(nums)-1
        elif nums[pos] == target:
            return Solution.__binSearchUp(nums, target, pos, last)
        elif nums[pos] != target:
            return Solution.__binSearchUp(nums, target, start, pos)

        
    @staticmethod
    def __binSearchDown(nums, target, start, last):
        pos = (start + last) // 2
        if start == last and nums[pos] == target:
            return 0
        if nums[pos] != target and nums[pos+1] == target:
            return pos+1
        elif nums[pos] == target:
            return Solution.__binSearchDown(nums, target, 0, pos)
        elif nums[pos] != target:
            return Solution.__binSearchDown(nums, target, pos, last)

