package grails.plugin.statsd;

import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoopStatsdClient implements StatsdClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(NoopStatsdClient.class);
    private static final Joiner JOINER = Joiner.on("; ");

    @Override
    public boolean send(double sampleRate, String... stats) {
        LOGGER.debug("Send stats {}", JOINER.join(stats));
        return false;
    }
}
