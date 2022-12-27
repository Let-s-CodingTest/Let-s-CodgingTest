def solution(N, stages):
    answer = []
    result = []

    #각 단계 수
    for i in range(1, N+1):
        stop_player = 0
        success_player = 0

        for j in stages: # 사용자가 멈춰 있는 스테이지의 번호 동안
            if i < j:
                success_player+=1
            elif i == j :
                success_player +=1
                stop_player +=1
        try:
            answer.append((i, stop_player / success_player))
        except:
            answer.append((i, 0))

    answer.sort(key=lambda x: x[1], reverse=True)

    for i in answer:
        result.append(i[0])

    return result