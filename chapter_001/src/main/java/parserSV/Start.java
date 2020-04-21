package parserSV;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import parser.Config;
import parser.Parser;
import parser.StartFind;

import java.util.Properties;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class Start {

    private static final Logger LOG = LogManager.getLogger(StartFind.class.getName());

    public static void main(String[] args) {
        String conf;
        if (args.length > 0) {
            conf = args[0];
        } else {
            conf = "app.properties";
        }
        parser.Config config = new Config();
        Properties prop;
        prop = config.getConfig(conf);
        String pattern = prop.getProperty("cron.time");
        //jdbc.driver=..
        //
        //jdbc.url=...
        //
        //jdbc.username=...
        //
        //jdbc.password=...
        //
        //cron.time=...
        try {
            SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
            Scheduler sched = schedFact.getScheduler();
            sched.start();
            JobDataMap map = new JobDataMap();
            map.put("jdbc.driver", prop.getProperty("jdbc.driver"));
            map.put("jdbc.url", prop.getProperty("jdbc.url"));
            map.put("jdbc.username", prop.getProperty("jdbc.username"));
            map.put("jdbc.password", prop.getProperty("jdbc.password"));

            JobDetail job = newJob(Parser.class)
                    .setJobData(map)
                    .build();
            Trigger triggerOne = newTrigger()
                    .startNow()
                    .build();
            sched.scheduleJob(job, triggerOne);

            JobDetail jobTwo = newJob(Parser.class)
                    .setJobData(map)
                    .build();
            Trigger triggerTwo = newTrigger()
                    .withSchedule(cronSchedule(pattern))
                    .build();
            sched.scheduleJob(jobTwo, triggerTwo);
        } catch (Exception e) {
            LOG.error(" error", e);
        }
    }
}

