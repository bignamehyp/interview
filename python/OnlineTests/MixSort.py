import sys
line = sys.stdin.readline().strip()
ori = line.split(' ')
letters = []
numbers = []
for c in ori:
    if c.isdigit():
        numbers.append(c)
    else:
        letters.append(c)

numbers.sort()
letters.sort()
i = 0
j = 0
soln = []
for c in ori:
    if c.isdigit():
        soln.append(numbers[i])
        i += 1
    else:
        soln.append(letters[j])
        j += 1
return ' '.join(soln)
