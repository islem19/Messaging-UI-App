package dz.islem.chatmessagingapp.util;

public class Utils {

    public static String formatTime(long time){
        time /= 1000;
        String min = String.valueOf((time / 60) % 60);
        if (((time/60) % 60) < 10 ) min = "0"+min;
        String hour = String.valueOf((time / 3600)% 24);
        return hour+":"+min ;
    }
}
