import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import static java.util.concurrent.TimeUnit.SECONDS;

public class InfoTime {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

    public void timeCounter() {
        Runnable time = new Runnable() {
            public long counter = 0;

            @Override
            public void run() {
                while (true) {
                    System.out.println(counter);
                    counter++;

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        scheduler.schedule(time,0, SECONDS);
    }

    public void fiveSecondsMessage() {
        Runnable message = () -> System.out.println("Минуло 5 секунд");
        scheduler.scheduleAtFixedRate(message, 5, 5, SECONDS);
    }
    public static void main(String[] args) {
        InfoTime infoTime = new InfoTime();
        infoTime.timeCounter();
        infoTime.fiveSecondsMessage();
    }
}

