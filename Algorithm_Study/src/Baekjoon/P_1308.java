package Baekjoon;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class P_1308 {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        String a=br.readLine();
        String b=br.readLine();
        DateFormat df = new SimpleDateFormat("yyyy MM dd");
        Date firstDate = df.parse(a);
        Date secondDate = df.parse(b);

        long diff = secondDate.getTime() - firstDate.getTime();

        TimeUnit time = TimeUnit.DAYS;
        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
        if(diffrence<365243)
            System.out.println("D-"+diffrence);
        else
            System.out.println("gg");
    }
}
