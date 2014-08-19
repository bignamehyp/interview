class MergeKSortedList:
    def mergeKLists(self, lists):
        heap = []
        for list in lists:
            if list:
                heapq.heappush(heap, ( list.val, list ))
        head = None
        node = None
        while heap:
            val, minNode = heapq.heappop(heap)
            if head is None:
                head = minNode
            else:
                node.next = minNode
            node = minNode
            
            minNode = minNode.next
            if minNode:
                heapq.heappush(heap, (minNode.val, minNode ))
        return head