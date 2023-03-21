import sys
input = sys.stdin.readline

def doMachine(command, value):
    stack = [value]
    for cmd in command:
        if cmd in ["POP", "INV", "DUP"]:
            if len(stack) < 1:
                return "ERROR"
            if cmd == "POP":
                stack.pop()
            elif cmd == "INV":
                stack[-1] *= -1
            elif cmd == "DUP":
                stack.append(stack[-1])
        elif cmd in ["SWP", "ADD", "SUB", "MUL", "DIV", "MOD"]:
            if len(stack) < 2:
                return "ERROR"
            first = stack.pop()
            second = stack.pop()
            if cmd == "SWP":
                stack.append(first)
                stack.append(second)
            elif cmd == "ADD":
                stack.append(first+second)
            elif cmd == "SUB":
                stack.append(second-first)
            elif cmd == "MUL":
                stack.append(first*second)
            elif cmd == "DIV":
                if first == 0:
                    return "ERROR"
                result = abs(second)//abs(first)
                if first*second < 0:
                    result *= -1
                stack.append(result)
            elif cmd == "MOD":
                if first == 0:
                    return "ERROR"
                result = abs(second)%abs(first)
                if second < 0:
                    result *= -1
                stack.append(result)
        elif "NUM" in cmd:
            num = int(cmd.split()[1])
            stack.append(num)
        if len(stack) > 0 and abs(stack[-1]) > 10**9:
            return "ERROR"
    if len(stack) != 1:
        return "ERROR"
    return stack[-1]

machines = []
while True:
    machine = []
    tmp = input().rstrip()
    if tmp == "QUIT":
        break
    while True:
        if tmp == "END":
            break
        machine.append(tmp)
        tmp = input().rstrip()
    N = int(input())
    values = [int(input()) for _ in range(N)]
    input()
    machines.append([machine, values])

for machine in machines:
    for v in machine[1]:
        print(doMachine(machine[0],v))
    print()


