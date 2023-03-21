n = input().split('-')
nums = []

#최댓값을 구하기 위해선, 덧셈 부분을 더해주어서 최댓값을 만들어주어야 한다.
for i in n:
  sum = 0
  for j in i.split('+'):
    sum+= int(j)
  nums.append(sum)

firstNum = nums[0]

for i in range(1, len(nums)):
  firstNum-=nums[i]

print(firstNum)