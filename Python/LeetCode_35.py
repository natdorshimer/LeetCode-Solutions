class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        start, end = 0, len(nums) - 1
        mid = (start + end) // 2

        if not nums:
            return 0

        while start < end:
            if nums[mid] < target:
                start = mid + 1
            elif nums[mid] > target:
                end = mid-1
            elif nums[mid] == target:
                return mid
            mid = (start + end) // 2

        if nums[start] < target:
            return start + 1
        if nums[start] > target or nums[start] == target:
            return start