import sys, re
input=sys.stdin.readline
expressions=list(map(str, input().split('-')))
result=0
expression = expressions[0].split('+')
for expr in expression :
    result+=int(expr)

for expression in expressions[1:] :
    expression=expression.split('+')
    for expr in expression :
        result-=int(expr)
print(result)
