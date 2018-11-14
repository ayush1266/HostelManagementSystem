package org.thakur.ayush.hostelmanagementsystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by win on 08-11-2018.
 */

public class StringToDate {
    public Date stringToDate(String aDate) {

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = format.parse(aDate);
            return  date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Date getCurrentDate(){
        Date c = Calendar.getInstance().getTime();
        return c;
    }
}
