package Model;

import java.util.StringTokenizer;

public class User {
    String time;
    String date;

    public User(String date) {
        StringTokenizer st = new StringTokenizer(date,"-");
        String a;
        String b;
            a=st.nextToken();
            b=st.nextToken();
            this.time = b;
        this.date = a;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
