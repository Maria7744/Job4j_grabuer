package parser;

import java.util.List;
import java.util.Properties;

public interface Loadermy {


        void makeConnection(Properties config);

        void createDB();

        void createTable();

        void upload(List<Node> exm);

        void dropTable();

        boolean check();

        List<String> print();

        void close();
    }


