"""
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
"""
class TwoSum:
    def __init__(self):
        self.table = {}
        
    def add(self, number):
        self.table[number] = self.table.get(number, 0) + 1
        
    def find(self, value):
        for i in self.table:
            find = value - i
            if find in self.table and not (i == find and self.table[find] < 2):
                return True
        return False