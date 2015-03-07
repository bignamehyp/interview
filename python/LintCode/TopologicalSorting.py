# Definition for a Directed graph node
# class DirectedGraphNode:
#     def __init__(self, x):
#         self.label = x
#         self.neighbors = []

class Solution:
    """
    @param graph: A list of Directed graph node
    @return: A list of integer
    """
    def topSort(self, graph):
        # write your code here
        incoming = {}
        for node in graph:
            if node not in incoming:
                incoming[node] = set()
            for des in node.neighbors:
                if des not in incoming:
                    incoming[des] = set()
                incoming[des].add(node)
        soln = []
        V = len(graph)
        while len(incoming) > 0:
            for node in graph:
                if node in incoming and len(incoming[node]) == 0:
                    soln.append(node)
                    del incoming[node]
                    for des in node.neighbors:
                        incoming[des].remove(node)
        return soln
                    
            