import sys
input = sys.stdin.readline
def dfs(x, y, number):
    if len(number) == 6: 
        if number not in answer: 
            answer.append(number)
        return
        
    dx = [-1, 1, 0, 0] 
    dy = [0, 0, -1, 1] 
    for k in range(4):
        vx = x + dx[k]
        vy = y + dy[k]
        
        if 0 <= vx < 5 and 0 <= vy < 5: 
            dfs(vx, vy, number + board[vx][vy]) 



board = [list(map(str, input().split())) for i in range(5)]
answer = []
for i in range(5):
    for j in range(5):
        dfs(i, j, board[i][j]) 
print(len(answer))