package biz.suckow.business;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.Logger;

/**
 * Created by tobias on 9/23/16.
 */
public class LoggerProducer {

    @Produces
    public Logger produce(InjectionPoint point) {
        return Logger.getLogger(point.getClass().getSimpleName());
    }
}
