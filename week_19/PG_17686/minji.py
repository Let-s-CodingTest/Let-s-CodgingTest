'''
숫자도 사전순 정렬이므로 확장자와 이름으로 나눠서 정렬
'''
def solution(files):
    answer = []

    file_seq=[]
    for idx, file in enumerate(files) :
        head, num, tail = '','',''
        file=file.lower()
        for i in range(len(file)) :
            if file[i].isdigit():
                head = file[:i]
                num=file[i:]
                break
        for j in range(len(num)) :
            if not num[j].isdigit() :
                tail=num[j:]
                num=num[:j]
                break
        file_seq.append([head, num, tail, idx])

    file_seq.sort(key=lambda x:(x[0], int(x[1])))
    for file in file_seq :
        answer.append(files[file[3]])
    return answer

print(solution(["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]))
print(solution(["F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"]))