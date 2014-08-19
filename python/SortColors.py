class SortColors:
    def SortColors(self, A):
        red = -1
        blue = len(A)
        white = 0
        while white < blue:
            if A[white] == 0:
                red += 1
                A[white] = A[red]
                A[red] = 0
                white+=1
            elif A[white] == 2:
                blue -= 1
                A[white]  = A[blue]
                A[blue] = 2
            else:
                white+=1