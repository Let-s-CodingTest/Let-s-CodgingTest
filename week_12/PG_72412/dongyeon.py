import bisect

def solution(info, query):
    answers = []
    database = {}
    for language in ['cpp', 'java', 'python', '-']:
        for job in ['backend', 'frontend', '-']:
            for career in ['junior', 'senior', '-']:
                for food in ['chicken', 'pizza', '-']:
                    database[language+job+career+food] = []
    for i in info:
        language, job, career, food, score = i.split()
        for l in [language, '-']:
            for j in [job, '-']:
                for c in [career, '-']:
                    for f in [food, '-']:
                        database[l+j+c+f].append(int(score))

    for key in database.keys():
        database[key].sort()

    for q in query:
        arr, score = q.replace(" and ","").split()
        idx = bisect.bisect_left(database[arr], int(score))
        answer = len(database[arr]) - idx
        answers.append(answer)
    return answers

print(solution(["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"],
               ["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"]))
