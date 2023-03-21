k = int(input())
ropes = []

for i in range(k):
    ropes.append(int(input()))
  
ropes.sort(reverse=True)

result = []

for i in range(k):
    result.append(ropes[i] * (i + 1))

print(max(result))