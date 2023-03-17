#홀수 홀릭 호석
import sys
input=sys.stdin.readline
min_val=1e9
max_val=0
def count_odd(x):
    cnt=0
    for i in x:
        if int(i) in [1,3,5,7,9]:
            cnt+=1
    return cnt

def recursive_plus(num, x):
    global min_val
    global max_val

    if len(num) == 1:
        min_val = min(min_val, x + count_odd(num))
        max_val = max(max_val, x + count_odd(num))
        return

    elif len(num) == 2:
        new_num = str(int(num[0]) + int(num[1]))
        recursive_plus(new_num, x + count_odd(num))

    elif len(num) >= 3:
        odd_cnt = count_odd(num)
        for i in range(1,len(num)):
            for j in range(i+1, len(num)):
                cut_num_sum = int(num[:i]) + int(num[i:j]) + int(num[j:])
                recursive_plus(str(cut_num_sum), x + odd_cnt)

n=input().rstrip()
recursive_plus(n, 0)
print(min_val, max_val)