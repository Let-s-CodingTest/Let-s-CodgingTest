import sys
input=sys.stdin.readline

v, e=map(int, input().split())
parent=[x for x in range(v+1)]
edges=[]
for _ in range(e) :
    a, b, c=map(int, input().split())
    edges.append([c, a, b])

edges.sort()
def find(parent, node):
    if parent[node]!=node :
        parent[node]=find(parent, parent[node])
    return parent[node]
def union(node_v, node_e) :
    root1=find(parent, node_v)
    root2=find(parent, node_e)
    if root1 < root2:
        parent[root2]=root1
    else:
        parent[root1]=root2


total_cost=0
for cost, a, b in edges :
    if find(parent, a)!=find(parent, b) :
        total_cost+=cost
        union(a, b)

print(total_cost)