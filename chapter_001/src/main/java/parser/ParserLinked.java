package parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ParserLinked implements Linked{
    private static final Logger LOG = LogManager.getLogger(ParserLinked.class.getName());

    private static Document getPage() throws IOException {
        String url = "www.superjob.ru/vacancy/search/";
        Document page = Jsoup.parse(new URL(url),3000);
        return page;

    }
    @Override
    public List<String> parsePage(String url) {
        List<String> answer = new ArrayList<>();
        String name;

        try {
            Document page = Jsoup.connect(url).get();
            Elements table = page.getElementsByClass("span[class=_1rS]");
            for (var e : table) {
                name = e.select("a").first().text();
                if (checkPatter(name)) {
                    answer.add(e.getElementsByTag("a").first().attr("href"));
                }
            }
        } catch (IOException ex) {
            LOG.error("main connect to site error", ex);
        }
        return answer;
    }

    public static boolean checkPatter(String text) {
        return text.matches(".*[Jj][Aa][Vv][Aa]+.*") & !text.matches(".*[Ss][Cc][Rr][Ii][Pp][Tt]+.*");
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getPage());
    }
}

