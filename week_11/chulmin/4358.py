import sys
input = sys.stdin.readline

trees = {}
count = 0
while True:
    species = input().rstrip()
    #탈출 조건
    if not species:
        break
    # 종 입력을 받음
    trees[species] = trees.get(species, 0) + 1

    count+=1

tree_list = list(trees.keys())
tree_list.sort()

for t in tree_list:
    print('%s %.4f' %(t, trees[t]/count*100))



