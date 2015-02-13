class WildcardMatching:
    def isMatch(self, s, p):
        s_star = -1
        p_star = -1
        s_pos = 0
        p_pos = 0
        
        while s_pos  < len(s):
            if p_pos < len(p) and (s[s_pos] == p[p_pos] or p[p_pos] == '?'):
                s_pos += 1
                p_pos += 1
                continue
            if p_pos < len(p) and p[p_pos] == '*':
                s_star = s_pos
                p_star = p_pos
                p_pos += 1
                continue
            if s_star >= 0:
                s_star += 1
                s_pos = s_star
                p_pos = p_star + 1
                continue
            return False

        while p_pos < len(p):
            if p[p_pos] != '*':
                return False
            p_pos += 1
        return True
                