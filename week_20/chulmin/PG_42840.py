#모의고사
def solution(answers):
    nums1=[1,2,3,4,5]
    nums2=[2,1,2,3,2,4,2,5]
    nums3=[3,3,1,1,2,2,4,4,5,5]
    res=[0,0,0]
    ans=[]
    for i in range(len(answers)):
        if answers[i] == nums1[i%5]:
            res[0]+=1
        if answers[i] == nums2[i%8]:
            res[1]+=1
        if answers[i] == nums3[i%10]:
            res[2]+=1
    #점수가 가장 높은 학생이 누구인지 판별해서 배열에 담아 리턴하도록 해야 한다.
    for i in range(len(res)):
        if res[i] == max(res):
            ans.append(i+1)
    return ans