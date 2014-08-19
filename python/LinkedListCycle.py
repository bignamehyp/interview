class LinkedListCycle:
    def hasCycle(self, head):
        if head == None or head.next == None:
            return False
        slow = head.next
        fast = head.next.next
        while slow != fast:
            if not slow:
                return False
            slow = slow.next
            if not fast:
                return False
            else:
                fast = fast.next                
            if not fast:
                return False
            else:
                fast = fast.next
    
        return True
            
         
        
