class CloneGraph:
    def CloneGraph(self, node):
        if node is None:return None
        nodes = dict()
        visited = sets.Set()
        queue = collections.deque()
        queue.append(node)
        visited.add(parent.label)
        while queue:
            parent = queue.pop()
            copied = UndirectedGraphNode(parent.label)
            nodes[parent.label]= copied
            for child in parent.neighbors:
                if not child.label in visited:
                    queue.append(child)
                    visited.add(child.label)
        visited = sets.Set()
        queue = collections.deque()
        queue.append(node)
        visited.add(parent.label)
        while queue:
             parent = queue.pop()             
             for child in parent.neighbors:
                nodes[parent.label].neighbors.append(nodes[child.label])
                if not child.label in visited:
                    queue.append(child)
                    visited.add(child.label)

        return nodes[node.label]