countZero=[1,0]
countOne=[0,1]

n = int(input())
max = 1

for i in range(0,n):
    inputNum = int(input())

    if(max < inputNum):
        for j in range(max+1, inputNum+1):
            countZero.append(countZero[j-1]+countZero[j-2])
            countOne.append(countOne[j-1]+countOne[j-2])

        max = inputNum

    print('%d %d'%(countZero[inputNum],countOne[inputNum]))
