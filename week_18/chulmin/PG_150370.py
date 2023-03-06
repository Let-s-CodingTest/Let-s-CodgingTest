#코딩테스트 연습
#2023 KAKAO BLIND RECRUITMENT
#개인정보 수집 유효기간

def extract_date(date):
    return date.split(".")

def extract_today_date(today):
    return today.split(".")

def solution(today, terms, privacies):
    dic_term=dict()
    tmp_list, privacy_list,res=[],[],[]
    for i in range(len(terms)):
        tmp_list.append(terms[i].split(" "))
        dic_term[tmp_list[i][0]] = int(tmp_list[i][1])

    for p in privacies:
        privacy_list.append(p.split(" "))

    for idx,pl in enumerate(privacy_list):
        year = int(extract_date(pl[0])[0])
        month = int(extract_date(pl[0])[1])
        day = int(extract_date(pl[0])[2])
        limit_month = dic_term[pl[1]]

        if month+limit_month > 12:
            if (month+limit_month) % 12 == 0:
                year+= ((month+limit_month) // 12)-1
                month=12
            else:
                year += (month+limit_month) // 12
                month = (month+limit_month) % 12
        else:
            month += limit_month

        if validate_date(year,month,day,today,idx):
            res.append(validate_date(year,month,day,today,idx))

    return res

def validate_date(year,month,day,today,idx):

    today_year = int(extract_today_date(today)[0])
    today_month = int(extract_today_date(today)[1])
    today_day = int(extract_today_date(today)[2])

    if today_year > year:
        return idx+1
    elif today_year == year and today_month > month:
        return idx+1
    elif today_year == year and today_month == month:
        if today_day >= day:
            return idx+1
    return False