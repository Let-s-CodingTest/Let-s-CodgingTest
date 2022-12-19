def solution(clothes):
    hash_map = dict()
    answer = 1
    #서로 다른 옷의 조합의 수를 return해라.

    #1. 옷을 종류별로 구분해봅시다.
    for c,t in clothes:
        hash_map[t] = hash_map.get(t,0)+1 #type이 존재하지 않으면 값을 0으로 해라.

    #2. 입지 않은 경우를 추가하여 모든 조합을 계산해줍니다.
    for t in hash_map:
        answer *= hash_map.get(t)+1

    #3. 모두 입지 않은 경우를 한가지 제거해줍니다.
    return answer-1
