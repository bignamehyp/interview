class WordLadderII:
    # @param start, a string
    # @param end, a string
    # @param dict, a set of string
    # @return a list of lists of string
    def findLadders(self, start, end, dict):
        queue = collections.deque()
        queue.append(end)
        prevs = {}
        levels = {}
        levels[end] = 1
        while queue:
            word = queue.popleft()
            for i in range(len(word)):
                part1 = word[:i]
                for c in 'abcdefghijklmnopqrstuvwxyz':
                    if word[i] != c:
                        child = part1 + c + word[i+1:]
                        if child in dict:
                            if child not in levels:
                                queue.append(child)
                                levels[child] = levels[word] + 1
                                if child not in prevs:
                                    prevs[child] = set()
                                prevs[child].add(word)
                            else:
                                if levels[child] - levels[word] == 1:
                                    prevs[child].add(word)

        solns = []
        if start in levels:
            self.dfs([start], prevs, end, levels[start], solns)
        return solns
    def dfs(self, soln, prevs, end, level, solns):
        if len(soln) == level:
            if soln[-1] == end:
                solns.append(soln[:])
            return
        if soln[-1] not in prevs:
            return
        for child in prevs[soln[-1]]:
            soln.append(child)
            self.dfs(soln, prevs, end, level, solns)
            soln.pop()