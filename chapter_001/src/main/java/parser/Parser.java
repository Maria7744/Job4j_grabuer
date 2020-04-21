package parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

public class Parser implements Job {
   private static final Logger LOG = LogManager.getLogger(Parser.class.getName());

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap temp = jobExecutionContext.getJobDetail().getJobDataMap();
        Properties prop = new Properties();
        Calendar cal = Calendar.getInstance();
        Date date;
        prop.putAll(temp);
        Loadermy sqlbase = (Loadermy) new UploadTo();
        sqlbase.makeConnection(prop);
        sqlbase.createDB();
        sqlbase.createTable();
        if (sqlbase.check()) {
            cal.add(Calendar.DATE, -1);
            date = (Date) cal.getTime();
        } else {
            cal.set(Calendar.DAY_OF_YEAR, 1);
            date = (Date) cal.getTime();
        }
        String url = "https://www.sql.ru/forum/job/1";
        ListFind seacher = new ParserList();
        Linked links = new ParserLinked();
        Inform getIngo = new Parserad();

        start(url, date, seacher,
                links, getIngo, sqlbase);
    }

    public void start(String url, Date date, ListFind seacher,
                      Linked links, Inform getIngo, Loadermy dbuser) {
        seacher.collectUrls(url);
        List<String> circleArray = seacher.pollTenUrls();
        while (!circleArray.isEmpty()) {
            Part onethread = Part.getExample(circleArray, links, getIngo, date, dbuser);
            onethread.run();
        }
    }
}


