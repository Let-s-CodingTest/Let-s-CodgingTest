import sys
input = sys.stdin.readline

def check(str, s, e):
    while s < e:
        if str[s] != str[e]:
            l_remove = pseudo_check(str, s + 1, e)
            r_remove = pseudo_check(str, s, e - 1)
            if l_remove or r_remove:
                return 1
            else:
                return 2
        else:
            s+=1
            e-=1
    return 0

def pseudo_check(str, s, e):
    while s<e:
        if str[s] != str[e]:
            return False
        else:
            s+=1
            e-=1
    return True

n = int(input())
for i in range(n):
    str = input().rstrip()
    s = 0
    e = len(str) - 1
    print(check(str,s,e))