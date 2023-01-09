def get_primary_num_eratos(N):
    nums = [True] * (N)

    for i in range(2, len(nums) // 2 + 1):
        if nums[i] == True:
            for j in range(i+i, N, i):
                nums[j] = False
    return [i for i in range(2, N) if nums[i] == True]


def is_palindrome(num):
    result = False
    if str(num) == str(num)[::-1]:
        result = True

    return result