from ast import List


class Solution:
    def leastBricksForBrickWallProblem(self, wall: List[List[int]]) -> int:
        # initialize base case by setting position zero to have no gaps
        # mapping position between bricks to the count of gaps throughout all rows in that position
        countGap = { 0 : 0 }

        for row in wall:
            # current position => adding each brick in row to tell us position
            total = 0
            # row[:-1] removes the last (most recent I think) brick 
            # because we're not wanting to count gaps of the right most position
            for brick in row[:-1]:
                # take each brick and add it to the total
                # this gives our current position
                total += brick
                # at this position increment by one
                # it's possible that this total 
                # hasn't been added yet to hash-map.
                # To account for it we add the value
                # currently at the position, but if the
                # value doesn't exist then it will just be 0
                countGap[total] = 1 + countGap.get(total, 0)
        # return the total # of rows and subtract 
        # the maximum amount of gaps found at one position 
        # (this should return the fewest amount of bricks found at one position)
        return len(wall) - max(countGap.values())