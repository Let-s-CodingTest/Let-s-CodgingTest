from collections import deque

for _ in range(int(input())): # 공간복잡도 줄어드는가?
    N = int(input()) 
    firstDeque = deque(input().split()) # 우선 덱 선언
    resultDeque = deque(firstDeque.popleft()) # 답으로 출력할 덱, 첫 원소를 빼서 초기화까지한다.
    while firstDeque: # 이렇게 짜면 firstDeque이 끝날때까지 순회함.
        element = firstDeque.popleft()  # 순회하면서 하나씩 원소를 빼서 저장( 다 돌면 firstDeque에는 하나도 안 남음)
        if(element > resultDeque[0]): # 아래부터는 단순하게 resultDeque 첫 원소보다 작으면 왼쪽으로, 크면 오른쪽으로 붙인다.
            resultDeque.append(element)
        else:
            resultDeque.appendleft(element)
    print(''.join(resultDeque)) # join으로 덱의 원소를 모두 하나의 문자열로 바꾼 뒤 출력