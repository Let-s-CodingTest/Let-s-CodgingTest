'''
pypy 통과

퀸의 경우 같은 열이나 행에 있으면 공격 가능
-> 퀸은 한 행에 하나씩 존재해야한다. 그래서 1차원 배열을 사용해서 같은 행에 존재하는 경우 배제

boards 의미
-> board[x]=y-> x+1번째 행 y+1번째 열에 퀸이 놓임
'''
n=int(input())
boards=[0]*n
ans=0
def check(x):
    for i in range(x) :
        if boards[x]==boards[i] :
            return False
        elif abs(boards[x]-boards[i])==abs : # 같은 열에 존재하는지 확인
            return False
    return True
def dfs(x):
    global ans
    if x==n :
        ans+=1
        return
    else :
        for i in range(n) :
            boards[x]=i
            if check(x)==True:
                dfs(x+1)

dfs(0)
print(ans)