package teoria;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;
//Предположим, что нам нужно в консоль выводить сообщение раз в 10 секунд.
public class AllertRabbit {
    public static void main(String[] args) {
        try {
            //1. Конфигурирование.
            //В объект Scheduler мы будем добавлять задачи, которые хотим выполнять периодически.
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            //2. Создание задачи.
            JobDetail job = newJob(Rabbit.class).build();
           //3. Создание расписания.
            //Конструкция  настраивает периодичность запуска. В нашем случае,
            // мы будем запускать задачу через 10 секунд и делать это бесконечно.
            SimpleScheduleBuilder times = simpleSchedule()
                    .withIntervalInSeconds(9)
                    .repeatForever();

            // Задача выполняется через триггер.Здесь можно указать,
            // когда начинать запуск. Мы хотим сделать это сразу.
            Trigger trigger = newTrigger()
                    .startNow()
                    .withSchedule(times)
                    .build();
           //5. Загрузка задачи и триггера в планировщик
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }
//quartz каждый раз создает объект с типом org.quartz.Job.
// Вам нужно создать класс реализующий этот интерфейс.
//
//Внутри этого класса нужно описать требуемые действия. В нашем случае - это вывод на консоль текста.
    public static class Rabbit implements Job {
        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            System.out.println("Rabbit runs here ...");
        }
    }
}

