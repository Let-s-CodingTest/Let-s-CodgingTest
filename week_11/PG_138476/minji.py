def solution(k, tangerine):
    answer = 0
    tangerine.sort()
    sizes={}
    for size in tangerine :
        sizes[size]=sizes.get(size, 0)+1
    #개수가 많은 순으로 정렬
    sizes=sorted(sizes.values(), key=lambda x:-x)
    print(sizes)
    count=0
    for i in range(len(sizes)):
        count += sizes[i]
        if count>=k :
            return i+1
    return len(sizes)

print(solution(6, [1, 3, 2, 5, 4, 5, 2, 3]))
print(solution(4, [1, 3, 2, 5, 4, 5, 2, 3]))
print(solution(2, [1, 1, 1, 1, 2, 2, 2, 3]))