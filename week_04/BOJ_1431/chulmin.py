n = int(input())
nums = [input() for i in range(n)]

#만약 서로 길이가 같다면
#모든 자리수 합, 모든 자리수의 합 비교해서 작은 합을 가지는 것이 먼저온다.

def get_sum(num):
    sum = 0

    for i in num:
        if i.isdigit(): #하나씩 읽었을 때 숫자이면
            sum+=int(i) # 합 누적
    return sum

nums.sort(key= lambda num:(len(num), get_sum(num), num)) #길이, 합, 사전순으로 오름 차순 정렬

for i in nums:
    print(i)