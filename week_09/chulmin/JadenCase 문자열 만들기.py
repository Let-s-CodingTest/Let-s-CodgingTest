def solution(s):
    answer = ''
    list_s = s.split(" ")
    for i in list_s:
        answer+=i.capitalize() + ' ' #capitalize() : 문자열의 첫번째 문자만 대문자로 변환해줌
    return answer[:-1]