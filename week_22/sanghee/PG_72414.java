import java.util.*;
class PG_72414 {
    public String solution(String play_time, String adv_time, String[] logs) {
        int play_time_sec = convertTimetoInt(play_time);
        int adv_time_sec = convertTimetoInt(adv_time);
        long[] play_count = new long[play_time_sec+1];
        for(String log : logs){
            String[] times = log.split("-");
            play_count[convertTimetoInt(times[0])]++;
            play_count[convertTimetoInt(times[1])]--;
        }
        for(int i=1; i<=play_time_sec;i++)   play_count[i] += play_count[i-1];//i초에서 재생중인 횟수
        for(int i=1; i<=play_time_sec;i++)   play_count[i] += play_count[i-1];//i초까지 누적 재생시간
        long max = play_count[adv_time_sec-1];
        int index=0;
        for(int i=0; i+adv_time_sec<=play_time_sec; i++){
            long time = play_count[i+adv_time_sec] - play_count[i];
            if(max < time){
                index = i+1;
                max = time;
            }
        }
        return convertInttoTime(index);
    }
    int convertTimetoInt(String str){
        String[] hms = str.split(":");
        return Integer.valueOf(hms[0])*3600 + Integer.valueOf(hms[1])*60 + Integer.valueOf(hms[2]);
    }
    String convertInttoTime(int time){
        int h = time/3600;
        time = time%3600;
        int m = time/60;
        time = time%60;
        return String.format("%02d:%02d:%02d",h,m,time);
    }
}