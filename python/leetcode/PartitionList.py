class PartitionList:
    def partition(self, head, x):
        smallerHead = None
        largerHead = None
        smaller = None
        larger = None
        while head:
            if head.val >= x:
                if not larger:
                    largerHead = head
                    larger = head
                else:
                    larger.next = head
                    larger = larger.next
            else:
                if not smaller:
                    smallerHead = head                
                    smaller = head
                else:
                    smaller.next = head
                    smaller = smaller.next
            head = head.next
        if larger:
            larger.next = None
            
        if smallerHead:
            smaller.next = largerHead
            return smallerHead
        else:
            return largerHead
                
