package com.testng.qa.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String makeDirByDate(String basePath) {
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String datePath = basePath + File.separator + date;
        File theDir = new File(datePath);
        if (!theDir.exists()){
            theDir.mkdirs();
        }
        return datePath;
    }

}
