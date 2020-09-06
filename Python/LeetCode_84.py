class Solution:
    @staticmethod
    def largestRectangleArea(heights: List[int]) -> int:
        index_list = []
        max_area = -1
        for i in range(len(heights)+1):
            if len(index_list) == 0:
                index_list.append(i)
            elif i < len(heights) and heights[index_list[-1]] <= heights[i]:
                index_list.append(i)
            else:
                while len(index_list) != 0 and (i >= len(heights) or heights[index_list[-1]] > heights[i]):
                    val = heights[index_list.pop()]
                    index = 0 if len(index_list) == 0 else index_list[-1]
                    width = (i - index)
                    if len(index_list) != 0:
                        width -= 1
                    area = val*width
                    max_area = max(area, max_area)
                index_list.append(i)
        return max(0,max_area)
