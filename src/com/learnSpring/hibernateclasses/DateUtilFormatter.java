package com.learnSpring.hibernateclasses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilFormatter {
    private static SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
    public DateUtilFormatter(){
        super();
    }
    public Date dateFormatter(String date) throws ParseException {
        return dateFormat.parse(date);
    }
    public String dateStringFormatter(Date date){
        String dateStringResult;
        if(date != null){
          dateStringResult= dateFormat.format(date);
            return dateStringResult;
        }
        return null;
    }
}
