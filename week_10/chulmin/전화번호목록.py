#Solution 1. 이중 Loop문 사용 - 내 방식
def solution(phone_book):
    answer=True
    for i in range(len(phone_book)):
        for j in range(i+1, len(phone_book)):

            #서로가 서로의 접두어인지 확인한다.
            if phone_book[i].startswith(phone_book[j]):
                answer=False
            if phone_book[j].startswith(phone_book[i]):
                answer=False
    return answer

#Solution 2. hash 사용
def solution(phone_book):
    #1. hash_map를 만든다
    hash_map = {}

    #2. phone_book을 순회하며, 전화번호:1의 형태로 1에서 만든 hash_map을 초기화해준다.
    for phone in phone_book:
        hash_map[phone] = 1

    #3. 부분 문자열이 hash_map에 존재하면 접두어가 존재하는 경우.
    for phone in phone_book:
        pre = ""
        for number in phone:
            pre+=number

            if pre in hash_map and pre != phone:
                return False
    return True