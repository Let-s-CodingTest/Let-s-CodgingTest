def solution(A,B):
    answer = 0

    A = sorted(A, reverse=True)
    B = sorted(B)

    while A:
        answer += A.pop() * B.pop()
    return answer