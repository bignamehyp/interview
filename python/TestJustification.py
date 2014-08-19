class Solution:
    # @param words, a list of strings
    # @param L, an integer
    # @return a list of strings
    def fullJustify(self, words, L):
        w_pos = 0
        lines = []
        while w_pos < len(words):
            w_end = w_pos + 1
            while w_end < len(words) and len(' '.join(words[w_pos:w_end+1])) <= L:
                w_end += 1
            spaces = L - len(''.join(words[w_pos:w_end]))
            
            if w_end == len(words):
                line = ' '.join(words[w_pos:])
                line += (L - len(line)) * ' '
            elif w_end == w_pos + 1:
                line = words[w_pos] + ' ' * spaces
            else:
                perSpace = spaces / (w_end - w_pos - 1)
                temp = spaces % ( w_end - w_pos - 1)
                if temp == 0:
                    line = (perSpace *' ').join(words[w_pos:w_end])
                else:
                    line = ((perSpace +1) * ' ').join(words[w_pos:w_pos+temp+1])
                    line += perSpace * ' '
                    line += (perSpace * ' ').join(words[w_pos+temp+1:w_end])
                    
            lines.append(line)
            w_pos = w_end
        return lines
        
      
