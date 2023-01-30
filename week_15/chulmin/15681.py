import sys
from collections import defaultdict
sys.setrecursionlimit(100000000)
input = sys.stdin.readline

def makeTree(currentNode, parent):
    for node in graph[currentNode]:
        if node != parent:
            childInfo[currentNode].append(node)
            parentInfo[node] = currentNode
            makeTree(node, currentNode)

def countSubtreeNodes(currentNode):
    size[currentNode] = 1 # 자신도 자신을 루트로 하는 서브트리에 포함되므로 0이 아닌 1에서 시작
    for node in childInfo[currentNode]:
        countSubtreeNodes(node)
        size[currentNode] += size[node]

n, r, q = map(int, input().split()) # 정점의 수, 루트 번호, 쿼리의 수
childInfo = defaultdict(list) # 자신의 자식들을 저장
parentInfo = defaultdict() # 자신의 부모를 저장
size = [0] * (n+1)
graph = [[] for _ in range(n+1)] # 그래프 형태로 노드를 입력받는다.
for _ in range(n-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

makeTree(r, -1) # 주어진 루트를 중심으로 그래프를 트리 형태로 변환한다.
countSubtreeNodes(r) # 각 노드에 대해 서브트리의 정점 개수를 구한다.
for _ in range(q): # 결과 출력
    print(size[int(input())])