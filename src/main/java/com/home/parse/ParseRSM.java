package com.home.parse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by andrej on 04.06.17.
 */
public class ParseRSM {

    public static Document getPage() throws IOException {
        String url = "https://tv.mail.ru/ulan_ude/channel/929/";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    public static ArrayList<String> printRSM(Document page) {
        Elements mainDiv = page.select("div[class=p-programms]");
        Elements mainName = mainDiv.select("div[class=p-programms__items js-module]");
        GregorianCalendar calendar = new GregorianCalendar();
        Date hireDay = calendar.getTime();
        int hours = hireDay.getHours();
        int minutes = hireDay.getMinutes();

        String str = hireDay +" "+ Integer.toString(hours) +" : " + Integer.toString(minutes);
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add(str+"\n");

        for (int i = 0; i <15 ; i++) {


            for (Element names: mainName
                    ) {
                Element mainValue = names.select("div[class=p-programms__item__inner]").get(i);

            //   System.out.println(mainValue.text()+"\n");
                stringArrayList.add(mainValue.text()+"\n");
            }
        }
        return stringArrayList;
    }
    public static void main(String[] args) throws IOException {
        Document page = getPage();
        printRSM(page);


    }
}
