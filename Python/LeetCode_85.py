class Solution:
    @staticmethod
    def largestRectangleArea(heights: List[int]) -> int:
        index_list = []
        max_area = 0
        for i in range(len(heights)+1):
            # If the stack is empty or the value at the top of the stack is less than or equal to the current value
            if len(index_list) == 0 or (i < len(heights) and heights[index_list[-1]] <= heights[i]):
                index_list.append(i)
            else:
                # While the stack is not empty and the last value on the stack is greater than the current value
                while len(index_list) != 0 and (i == len(heights) or heights[index_list[-1]] > heights[i]):
                    val = heights[index_list.pop()]
                    dist = 0 if len(index_list) == 0 else index_list[-1]+1
                    area = val*(i-dist)
                    max_area = max(area, max_area)
                index_list.append(i)
        return max_area

    @staticmethod
    def maximalRectangle(matrix: List[List[str]]) -> int:
        if len(matrix) == 0:
            return 0
        hist = [0 for i in range(len(matrix[0]))]
        rect_max = 0
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                hist[j] = (hist[j] + 1) if matrix[i][j] == '1' else 0
            rect_max = max(rect_max, Solution.largestRectangleArea(hist))
        return rect_max