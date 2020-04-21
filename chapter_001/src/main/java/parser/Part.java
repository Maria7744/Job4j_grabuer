package parser;

import java.util.*;
import java.util.stream.Collectors;

public class Part
    implements Runnable {

        Linked links;
        Inform getIngo;
        LinkedList<String> urls;
        Loadermy dbuser;
        Date date;

    private Part(List<String> urls, Linked links, Inform getIngo, Date date, Loadermy dbuser) {
            this.links = links;
            this.getIngo = getIngo;
            this.urls = new LinkedList<>(urls);
            this.dbuser = dbuser;
            this.date = date;
        }

        static Part getExample(List<String> urls, Linked links, Inform getIngo, Date date, Loadermy dbuser) {
            return new Part(urls, links, getIngo, date, dbuser);
        }

    /*public static Part getExemple(List<String> circleArray, Linked links, Inform getIngo, java.sql.Date date, Loadermy dbuser) {
    }*/

    @Override
        public void run() {
            List<String> urlforAd = new ArrayList<>();
            for (var e : urls) {
                urlforAd.addAll(links.parsePage(e));
            }
            List<Node> nodeList = new ArrayList<>();
            for (var e : urlforAd) {
                nodeList.add(getIngo.checkPage(e, date));
            }
            nodeList = nodeList.parallelStream().filter(Objects::nonNull).collect(Collectors.toList());
            dbuser.upload(nodeList);
        }
    }

