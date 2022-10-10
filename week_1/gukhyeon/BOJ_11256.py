T = int(input()) # input for test case 
for k in range(T):      # for loop T times
    J, N = map(int,(input().split()))    # J is candy qty, N is box qty.
    box=[]    # box list 
    for i in range(N):
        box.append(0) # box list indexs are same as N
    for i in range(N): # for N time loop, input R and C, also each box index have value of R *C
        R, C = map(int,(input().split())) 
        box[i] = R * C
    box.sort(reverse=True) # box sort reverse, because biggest box size are more advantageous to put a candy in a box
    idx=0
    result = 0
    while(True):
        J = J - box[idx] # less index, more bigger box size. 
        idx += 1 # each putting a box, index increases by 1
        result += 1 # result means box qty that needs to pack total candies
        if(J<=0): # all candies packed, break while-loop
            break 
    print(result)
