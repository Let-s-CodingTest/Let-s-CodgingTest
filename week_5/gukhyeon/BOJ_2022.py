
import math

x,y,c=map(float,input().split())

start, end=0, min(x,y)

while(abs(end-start)>0.000001):
    mid=(start+end) / 2.0
    h1=math.sqrt(x*x-mid*mid)
    h2=math.sqrt(y*y-mid*mid)
    h=(h1*h2)/(h1+h2)
    if h > c:
        start=mid
    else:
        end=mid
print("%.3f"%round(mid,3))