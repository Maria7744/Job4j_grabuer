package parserSV;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserSimple {
    private static final Logger LOG = LogManager.getLogger(ParserSimple.class.getName());



    public List<String> parsePage(String url) {
        List<String> zapr = new ArrayList<>();

        //String url;// = "https://www.superjob.";
        String name;
        try {
        Document document = Jsoup.connect(url).get();
        Elements elements = document.select("span[class=_1rS]");
        for (Element element : elements) {
            name = element.select("span[class=_1rS]").first().text();
            System.out.println(elements);
            if (checkPatter(name)) {
                zapr.add(element.getElementsByTag("span[class=_1rS]").first().attr("href"));
            }
        }

    }catch (IOException ex) {
        LOG.error("ошибка в соединении", ex);
    }
        return zapr;
    }

        public static boolean checkPatter (String text){
            return text.matches(".*[Jj][Aa][Vv][Aa]+.*") & !text.matches
                    (".*[Ss][Cc][Rr][Ii][Pp][Tt]+.*");
        }

}





