package com.coding.school.webApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class CarRepairApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarRepairApplication.class, args);

//        /*Database --> TIMESTAMP, Model --> java.sql.Timestamp
//        * The following code transforms the data taken from front end to Timestamp*/
//        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
//        String dateStr = "2017-10-11 18:30"; //input string format
//        try {
//            Date date = format.parse(dateStr);
//            Timestamp timestamp = new Timestamp(date.getTime());
//            System.out.println(timestamp);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

    }
}
