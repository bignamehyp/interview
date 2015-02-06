class RotateList:
    def rotateRight(self, head, k):
        if head == None:return None
        fast = head
        len = 0
        while fast:
            len += 1
            fast = fast.next
        k = k % len
        if k == 0: return head
        fast = head
        for i in range(1,k):
            fast = fast.next
        prev = None
        cur = head
        while fast.next != None:
            prev = cur
            cur = cur.next
            fast = fast.next
        if prev == None:return head
        prev.next = None
        fast.next = head
        return cur
