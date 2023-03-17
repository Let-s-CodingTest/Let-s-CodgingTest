#기사 단원의 무기
def get_divide_num(k, limit, power):
    cnt=0
    for i in range(1, int(k**(0.5)) + 1):
        #i가 k의 약수인 경우
        if k % i == 0:
            #i가 k의 제곱근이라면
            if i == (k//i):
                cnt+=1
            else: #제곱근이 아닌 경우
                cnt+=2
        if cnt > limit:
            return power
    return cnt

def solution(number, limit, power):
    divide_num=[get_divide_num(i, limit, power) for i in range(1, number+1)]
    result = sum(divide_num)
    return result