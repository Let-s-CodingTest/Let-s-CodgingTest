import sys
input = sys.stdin.readline

endValue = 1000000000
X, Y = map(int,input().split())
Z = (Y  * 100 // X) 
mid = X+1 // 2

end = X
start= 1

if(Z>=99):
    result = -1
else:
    while(start<= end):
        mid = (start + end) // 2
        if(((Y+mid)*100) // (X + mid) > Z):
            result = mid
            end = mid - 1
        else:
            start = mid + 1
print(result)



