from collections import deque
def bfs(begin, target, words,visited):
    queue = deque()
    queue.append((begin, 0))

    while queue:
        cur, depth = queue.popleft()

        if cur == target:
            return depth

        #현재 단어, words의 단어를 하나씩 비교
        for i in range(len(words)):
            cnt = 0
            if not visited[i]:
                for j in range(len(cur)):
                    if cur[j] != words[i][j]:
                        cnt+=1
                if cnt == 1:
                    queue.append((words[i],depth+1))
                    visited[i] = True



def solution(begin, target, words):
    if target not in words:
        return 0
    visited = [False for _ in range(len(words))]
    return bfs(begin, target, words,visited)