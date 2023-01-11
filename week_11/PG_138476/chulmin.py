def solution(k, tangerine):
    answer = 0
    orange = dict()

    # (오렌지 크기, 갯수)의 딕셔너리 생성
    for i in tangerine:
        orange[i] = orange.get(i, 0) + 1

    # 크기별로 내림 차순 정렬
    sorted_ornage = sorted(orange.items(), reverse = True, key = lambda x : x[1])

    #귤 크기 종류가 최소이면서, k개의 갯수를 판매하라.
    for key, value in sorted_ornage:
        if k<=0:
            break

        k-=value # 개수가 가장 귤의 수 만큼 차감 [(2,2) (3,2) (5,2)]
        answer+=1
    return answer