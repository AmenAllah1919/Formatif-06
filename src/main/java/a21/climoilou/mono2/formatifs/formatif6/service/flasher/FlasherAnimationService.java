package a21.climoilou.mono2.formatifs.formatif6.service.flasher;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

import java.util.Random;

public class FlasherAnimationService extends ScheduledService {


    @Override
    protected Task<Boolean> createTask() {
        return new FlasherAnimationTask();
    }


    private class FlasherAnimationTask extends Task<Boolean> {
        int n = 0;

        @Override
        protected Boolean call() throws Exception {
            boolean estValide = false;
            if (n == 0) {
                n++;
                estValide = true;
            } else {
                n--;
            }

            return estValide;
        }
    }

}
