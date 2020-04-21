package parserSV;

import java.util.List;
import java.util.Properties;

public interface Sourse {



        void makeConnection(Properties config);

        void createDB();

        void createTable();

        void upload(List< Vacancy > exm);

        void dropTable();

        boolean check();

        List<String> print();

        void close();
    }


