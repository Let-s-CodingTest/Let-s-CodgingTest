#DNA 비밀번호
def is_valid_password(check, a, c, g, t):
    if check['A']>=a and check['C']>=c and check['G']>=g and check['T']>=t:
        return True
s,p=map(int,input().split())
dna_str=input()
#비밀번호 체크리스트를 생성한다.
a,c,g,t=map(int,input().split())
cur_checklist={
    'A': 0,
    'C': 0,
    'G': 0,
    'T': 0
}
#슬라이딩 윈도우 생성
tmp=dna_str[:p]
for i in tmp:
    if i in cur_checklist.keys():
        cur_checklist[i]=cur_checklist.get(i,0)+1
cnt=0
if is_valid_password(cur_checklist, a, c, g, t):
    cnt+=1

s_idx=0
e_idx=s_idx+p
for i in range(s-p):
    cur_checklist[dna_str[s_idx+i]]-=1
    cur_checklist[dna_str[e_idx+i]]+=1
    if is_valid_password(cur_checklist, a, c, g, t):
        cnt+=1
print(cnt)
