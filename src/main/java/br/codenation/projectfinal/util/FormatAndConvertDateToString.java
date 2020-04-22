package br.codenation.projectfinal.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatAndConvertDateToString {

    public static String converter(Date date){
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formater.format(date);
    }
}
