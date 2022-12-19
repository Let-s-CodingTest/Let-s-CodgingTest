import sys
def solution(s):
    titles = s.title()
    word = titles.split(" ")
    for i in range(len(word)):
        if (word[i][0].isdigit() and len(word[i]) != 0):
            word[i] = word[i].lower()

    return " ".join(word)