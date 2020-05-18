package teoria;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SqlRuParse {
        public static void main(String[] args) throws Exception {
            //Откройте ссылку https://www.sql.ru/forum/job-offers в браузере
            Document doc = Jsoup.connect("https://www.sql.ru/forum/job-offers").get();
            //нужен этот критерий поиска
            // //Ячейка с именем имеет аттрибут class=postslisttopic. jsoup может извлечь все элементы с этим аттрибутом
            Elements row = doc.select(".postslisttopic");
            for (Element td : row) {

                //Нам нужен первый элемент. Это ссылка. У нее мы получаем адрес и текст.
                Element href = td.child(0);
                System.out.println(href.attr("href"));
                System.out.println(href.text());


                //извлекаем дату

                Elements dat = doc.select(".altCol");
                for (Element d : dat) {

                    //Нам нужен первый элемент. Это ссылка. У нее мы получаем адрес и текст.
                    Element data = d.child(1);
                    System.out.println(data.attr("data"));
                }
            }

        }
    }
