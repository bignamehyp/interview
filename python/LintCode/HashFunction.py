class Solution:
    """
    @param key: A String you should hash
    @param HASH_SIZE: An integer
    @return an integer
    """
    def hashCode(self, key, HASH_SIZE):
        # write your code here
        base = 33
        hashKey = 0
        for c in key:
            hashKey = hashKey * base + ord(c)
            hashKey = hashKey % HASH_SIZE
        return hashKey % HASH_SIZE