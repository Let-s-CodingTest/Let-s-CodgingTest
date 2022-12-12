def solution(s):
    list = []
    for i in range(len(s)):
        if s[i] == '(':
            list.append(s[i])
        else:
            if len(list) == 0:
                return False
            list.pop()

    return len(list) == 0