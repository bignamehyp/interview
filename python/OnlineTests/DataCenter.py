import sys
line = sys.stdin.readline().strip()
numDataCenters = int(line)
dataSets = {}
for i in range(1, numDataCenters + 1):
    line = sys.stdin.readline().strip()
    lists = line.split(' ')
    for dataSet in lists[1:]:
        dataSets[dataSet] = dataSets.get(dataSet, set()].add(i)

for dataSet, dataCenters in dataSets.iteritems():
    source = list(dataCenters)[0]
    for i in range(1, numDataCenters + 1):
        if i not in dataCenters:
            print(dataSet + ' ' + str(source) + ' ' + str(i))
print('done')
