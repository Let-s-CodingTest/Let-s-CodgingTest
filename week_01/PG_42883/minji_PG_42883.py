'''
테스트 10 시간초과
테스트 12 틀림
'''
def solution(number, k):
    answer = ''
    numbers = list(number)
    length=len(numbers)-k
    while k > 0 and len(numbers)>0 and len(answer)<length:
        idx = numbers.index(max(numbers))
        if idx > k:
            idx = numbers.index(max(numbers[:k + 1]))
            answer += numbers[idx]
        else:
            answer += numbers[idx]

        if idx == len(numbers) - 1:
            return answer
        k -= idx
        numbers = numbers[idx + 1:]
        #print("k : " + str(k))
        #print(numbers)

    if len(numbers) > 0 and k==0:
        answer += ''.join(numbers)
    return answer