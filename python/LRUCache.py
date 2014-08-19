class LRUCache:
     
    
    # @param capacity, an integer
    def __init__(self, capacity):
        self.capacity = capacity
        self.head = None
        self.last = None
        self.cache = {}
        
    # @return an integer
    def get(self, key):
        if key in self.cache:
            node = self.cache[key]
            if node is not self.last:
                self.detach(node)
                self.attach(node)            
            return node.value
        else:
            return -1
            
    def detach(self, node):
        del self.cache[node.key]
        if node == self.head:
            self.head = node.next
            if node.next != None:
                node.next.prev = None
        else:
            prev = node.prev
            next = node.next
            prev.next = next
            next.prev = prev
            
    def attach(self,node):
        self.cache[node.key] = node
        if self.head is None:
            self.head = node
            self.last = node
        else:
            self.last.next = node
            node.prev = self.last
            self.last = self.last.next

        
        
    # @param key, an integer
    # @param value, an integer
    # @return nothing
    def set(self, key, value):
        if key in self.cache:
            self.get(key)
            self.last.value = value
        else:
            node = CacheEntity(key, value)
            self.attach(node)
        if len(self.cache) > self.capacity:
            if self.head is not None:
                self.detach(self.head)
    

class CacheEntity:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None
        self.prev = None