package a21.climoilou.mono2.formatifs.formatif6.service.flasher;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class FlasherAnimationService extends Service<ScheduledService> {


    @Override
    protected Task<ScheduledService> createTask() {
        return new FlasherAnimationTask();
    }


    private class FlasherAnimationTask extends Task<ScheduledService> {

        @Override
        protected ScheduledService call() throws Exception {

            return null;
        }
    }

}
