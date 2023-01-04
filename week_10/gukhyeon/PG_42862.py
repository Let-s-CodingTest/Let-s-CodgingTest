def solution(n, lost, reserve):
    answer = 0
    student = []
    for i in range(n):
        student.append(1)
    for i in lost:
        i -= 1
        student[i] -=1
    print(student)
    for i in reserve:
        i -= 1
        student[i] += 1
    print(student)
    idx = 0
    for i in student:
        if(i != 0):
            idx += 1
            continue
        elif (i == 0 ):
            if(idx == 0):
                if(student[idx+1] >= 2):
                    student[idx+1] -= 1
                    student[idx] += 1
                    # i += 1
            else:
                if(student[idx-1] >= 2):
                    student[idx-1] -= 1
                    student[idx] += 1
                    # i += 1
                elif(student[idx+1] >= 2):
                    student[idx+1] -= 1
                    student[idx] += 1
                    # i += 1
        idx += 1
    print(student)
    for i in student:
        if(i>=1):
            answer += 1
    return answer