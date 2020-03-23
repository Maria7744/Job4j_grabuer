package parserSV;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ParserSimple {
    public static void main(String[] args) throws Exception {
        List<String> zapr = new ArrayList<>();
        String url = "https://www.superjob.ru";
        String vacansia;
        Document document = Jsoup.connect(url).get();
        Elements elements = document.select("span[class=_1rS]");
        for (Element element : elements) {
            vacansia =element.select("span[class=_1rS]").first().text();
            System.out.println(elements);
            if (checkPatter(vacansia)) {
                zapr.add(element.getElementsByTag("span[class=_1rS]").first().attr("href"));
            }
        }
    }
    public static boolean checkPatter(String text) {
        return text.matches(".*[Jj][Aa][Vv][Aa]+.*") & !text.matches(".*[Ss][Cc][Rr][Ii][Pp][Tt]+.*");
    }


        }


