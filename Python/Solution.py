from ast import List


class Solution:
    def leastBricksForBrickWallProblem(self, wall: List[List[int]]) -> int:
        # initialize base case by setting position zero to have no gaps
        # mapping position between bricks to the count of gaps throughout all rows in that position
        countGap = { 0 : 0 }

        