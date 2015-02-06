class SimplePath:
    def simplifyPath(self,path):
        dirs = path.split('/')
        stack = []
        for dir in dirs:
            if len(dir) > 0:
                if dir == ".." and len(stack) > 0:
                    stack.pop()
                elif dir != "." and dir != "..":
                    stack.append(dir)
        if len(stack) == 0:return "/"
        s = ""
        for dir in stack:
            s += "/" + dir
        return s
