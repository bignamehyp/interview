import heapq

class Solution:
    """
    @param nums: A list of integers.
    @return: The median of numbers
    """
    def medianII(self, nums):
        # write your code here
        minHeap = []
        maxHeap = []
        soln = []
        for n in nums:
            soln.append(self.getMedian(n, minHeap, maxHeap))
        return soln
        
    def getMedian(self, n, minHeap, maxHeap):
        if len(minHeap) == 0 or n >= minHeap[0]:
            heapq.heappush(minHeap, n)
        else:
            heapq.heappush(maxHeap, -n)
            
        if len(minHeap) > len(maxHeap) + 1:
            topMin = heapq.heappop(minHeap)
            heapq.heappush(maxHeap, -topMin)
        elif len(maxHeap) > len(minHeap):
            topMax = heapq.heappop(maxHeap)
            heapq.heappush(minHeap, -topMax)
                            
        if len(minHeap) > len(maxHeap):
            return minHeap[0]
        else:
            return -maxHeap[0]
        