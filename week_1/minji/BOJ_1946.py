import sys

input=sys.stdin.readline
T=int(input())
for _ in range(T) :
    N=int(input())

    scores=[list(map(int, input().split())) for _ in range(N)]
    scores.sort() #뒤에 있는 지원자는 앞에 있는 지원자들의 면접 성적보다 크면 합격
    interview_score=scores[0][1]
    ans = 1 #서류 성적이 제일 높은 지원자는 무조건 합격
    for i in range(N) :
        if scores[i][1] < interview_score : #i번째 지원자보다 면접 성적이 높아야함
            ans+=1
            interview_score=scores[i][1]

    print(ans)