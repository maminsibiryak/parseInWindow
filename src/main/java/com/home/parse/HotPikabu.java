package com.home.parse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by andrej on 12.07.17.
 */
public class HotPikabu {
    public static Document getPage() throws IOException {
        String url = "http://www.pikabu.ru/";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    public static HashMap<String, String> getPost(Document page) {
        HashMap<String, String> hashMap = new HashMap<>();
        Elements divStories = page.select("div[class=stories]");



    /*    for (Element div: divStories) {
            Elements storieRank = div.select("div[class=story__rating-count");
            Elements storiesHeader = div.select("div[class=story__header-title]");
            Elements stroiesLink = storiesHeader.select("a[class=story__title-link ]");


            hashMap.put(storieRank.text()+"|"+storiesHeader.text(), stroiesLink.attr("href"));
        }*/

        for (int i = 0; i < 20; i++) {
            Element storieRank = divStories.select("div[class=story__rating-count").get(i);
            Element storiesHeader = divStories.select("div[class=story__header-title]").get(i);
            Elements stroiesLink = storiesHeader.select("a[class=story__title-link ]");


            hashMap.put(storieRank.text() + "|" + storiesHeader.text(), stroiesLink.attr("href") + "\n");
        }


        return hashMap;
    }

    /*public static void printPost() throws IOException {
        Document page = getPage();
      HashMap<String,String> hashMap =  getPost(page);

        for (HashMap.Entry<String, String> e : hashMap.entrySet()
                ) {
            String key = e.getKey();
            String value = e.getValue();
            System.out.print(key + "||" + value);
            System.out.println();

        }



    }*/
}
