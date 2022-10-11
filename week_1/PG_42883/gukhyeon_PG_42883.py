import itertools
def solution(number, k):
    answer = ''
    answer = max(list((''.join(w) for w in list(itertools.combinations(number,len(number)-k)))))
    return answer