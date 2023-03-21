nums = list(range(1,10001))
remove = []

for num in nums: # 1-10000 까지의 수 반복
  for j in str(num): # 수를 문자열로 변환하여 반복
    num += int (j) # int형으로 변환 후 원래의 수와 더해줌 -> 생성자가 있는 수들 계산
  if num <= 10000:
      remove.append(num) #생성자가 있는 수는 제거 리스트에 추가

for remove_num in set(remove): # 중복 제거를 위해 set() 활용
  nums.remove(remove_num) #1-10000까지 수에서 제거 리스트에 있는 수 제거 

#생성자가 있는 수를 제거한 리스트의 숫자 출력 
for num in nums:
  print(num) 