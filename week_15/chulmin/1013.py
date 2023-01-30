import sys
input = sys.stdin.readline

n = int(input()) # (100+1+ | 01)+
for _ in range(n):
    signal = input().rstrip()
    isRightPattern = True

    while len(signal) > 0:
        if signal.startswith("01"): # 01로 시작
            signal = signal[2:]

        elif signal.startswith("100"): # 100으로 시작
            signal = signal[3:]

            while len(signal) > 0 and signal[0] == '0': # 이어지는 0 소거
                signal = signal[1:]
            if len(signal) == 0: # 뒤에 1이 하나는 나와야 함
                isRightPattern = False
                break

            signal = signal[1:] # 처음에 이어지는 1 소거

            while len(signal) > 0 and signal[0] == '1':
                if len(signal) >= 3 and signal[1] == '0' and signal[2] == '0':
                    break # 100이 다시 나오는 패턴을 위해 보류
                else: # 이어지는 1 소거
                    signal = signal[1:]

        else:
            isRightPattern = False
            break
    if isRightPattern: print("YES")
    else: print("NO")