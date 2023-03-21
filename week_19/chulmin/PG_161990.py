#바탕화면 정리
def solution(wallpaper):
    answer = []
    min_x, min_y, max_x, max_y = 1e9,1e9,0,0

    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[0])):
            if wallpaper[i][j] == '#':
                min_x = min(i, min_x)
                min_y = min(j, min_y)
                max_x = max(i, max_x)
                max_y = max(j, max_y)
    return[min_x, min_y, max_x +1, max_y+1]