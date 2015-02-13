"""
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
"""
class Solution:
    def __init__(self):
        self.table = []
        
    def add(self, num):
        self.table[num] = self.table.get(num, 0) + 1
        
    def find(self, value):
        for i in self.table:
            find = value - i
            if find in table and not (i == find and table[find] < 2):
                return True
        return False