'''
python
append(x) : 리스트 끝에 x를 그대로 넣음
extend(iterable)  : 리스트 끝에 iterable 자료형의 항목 각각을 array의 끝에 하나씩 추가
arr=[1, 2, 3]
arr.append([4, 5]) -> [1, 2, 3, [4, 5]]
arr.extend([4, 5]) -> [1, 2, 3, 4, 5]
'''
from itertools import product

def solution(word):
    answer = 0
    vowel = ['A', 'E', 'I', 'O', 'U']
    l = []
    for i in range(1, 6):
        l.extend(map(''.join, product(vowel, repeat=i)))
    l.sort()
    return l.index(word) + 1