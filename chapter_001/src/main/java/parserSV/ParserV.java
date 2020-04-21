package parserSV;

/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import parser.ParserLinked;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;*/

public class ParserV {}
   /* private static final Logger LOG = LogManager.getLogger(ParserLinked.class.getName());
    private static Document getPage() throws IOException {
        String url = "www.superjob.ru/vacancy/search/";
        Document page = Jsoup.parse(new URL(url),
                3000);
        return page;

    }

    private static Pattern pattern = Pattern.compile("");

    private static String getDateFromString(String stringDate) throws Exception {
        Matcher matcher = pattern.matcher(stringDate);
        if (matcher.find()) {
            return matcher.group();

        }
        throw new Exception("can,t extract vacansia j from string");

    }

    //\d{2}\.\d{2}
    public static void main(String[] args) throws Exception {
        Document page;
        page = getPage();
        // String url = "";
       // Document page = Jsoup.connect(url).get();
        Element table = page.select("span[class=_1rS]").first();
         Elements elements = table.select("tr[class = wd");
        String name;

        for (Element element : elements) {
            name = element.select("span[class=_1rS]span[class=_1rS]").first().text();
            /* String date = getDateFromString(dateString);*/


         /*   System.out.println(getPage() + "java");

        }
    }
}*/


  /* private static boolean checkPatter(String text)  {
        return text.matches(".*[Jj][Aa][Vv][Aa]+.*") & !text.matches(".*[Ss][Cc][Rr][Ii][Pp][Tt]+.*");
    }*/






