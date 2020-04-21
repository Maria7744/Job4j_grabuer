package parser;

import java.util.List;

public interface ListFind {
    void collectUrls(String url);

    List<String> pollTenUrls();

}

