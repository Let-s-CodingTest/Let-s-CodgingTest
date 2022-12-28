def solution(k, tangerine):
    answer = 0
    qty = []
    idx = list(set(tangerine))

    for i in range(len(idx)):                             
        qty.append(tangerine.count(idx[i]))                 

    while k!=0 :                                        
        if k >= max(qty):                                
            answer += 1
            k -= max(qty)
            qty.remove(max(qty))
        else :                                          
            answer += 1
            return answer
            
    return answer
solution(6,[1, 3, 2, 5, 4, 5, 2, 3]	)