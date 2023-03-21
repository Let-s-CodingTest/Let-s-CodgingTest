def solution(numbers):
    answer = ''
    num_str = [str(num) for num in numbers]

    num_str.sort(key = lambda a: a*3, reverse=True)

    answer = str(int(answer.join(num_str)))

    return answer