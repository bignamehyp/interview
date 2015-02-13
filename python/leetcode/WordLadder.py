class WordLadder:
    def ladderLength(self, start, end, dict):
        queue = collections.deque()
        queue.append([start,1])
        dict.remove(start) 
        while queue:
            word,d = queue.popleft()
            if word == end:
                return d
            for i in range(len(word)):
                part1 = word[:i]
                for c in 'abcdefghijklmnopqrstuvwxyz':
                    if word[i] != c:
                        child = part1 + c + word[i+1:]
                        if child in dict:
                            queue.append([child, d+1])
                            dict.remove(child)
        return 0
            