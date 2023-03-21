import sys
input=sys.stdin.readline
n, m, r=map(int, input().split())
arr=[list(map(int, input().split())) for _ in range(n)]

for k in range(r) :
    for i in range(min(n, m)//2) : #돌려야하는 사각형 개수
        x, y=i, i #ex (0, 0)
        temp=arr[i][i]
        for j in range(i+1, n-i) : #아래로 이동
            x=j #ex 열의 index=0 행만 1씩 증가 (x는 1씩 커지고 y는 그대로)
            prev=arr[x][y]
            arr[x][y]=temp
            temp=prev
        #ex x=3, y=0
        for j in range(i+1, m-i) : #오른쪽으로 이동
            y=j #ex 행은 3 열만 1씩 증가(x는 그대로 y만 1씩 증가)
            prev=arr[x][y]
            arr[x][y]=temp
            temp=prev
        #ex x=3, y=3
        for j in range(n-i-2, i-1, -1)  : #위로 이동
            x=j #ex 열은 3 행은 1씩 감소(x 1씩 감소 y는 그대로)
            prev=arr[x][y]
            arr[x][y]=temp
            temp=prev
        #ex x=0 y=3
        for j in range(m-i-2, i-1, -1) : #왼쪽으로 이동
            y=j #ex 행은 0 열은 1씩 감소(x는 그대로, y는 1씩 감소)
            prev=arr[x][y]
            arr[x][y]=temp
            temp=prev

for i in arr :
    print(*i) #list앞에 *붙이면 공백으로 구분해서 출력

