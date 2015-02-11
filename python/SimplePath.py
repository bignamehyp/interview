class SimplePath:
    def simplifyPath(self, path):
        subdirs = path.split('/')
        stack = []
        for dir in subdirs:
            if dir == '..':
                if len(stack) > 0:
                    stack.pop()
            elif len(dir) > 0 and dir != '.':
                stack.append(dir)
        return '/' + '/'.join(stack)