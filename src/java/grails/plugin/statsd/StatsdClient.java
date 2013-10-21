package grails.plugin.statsd;

public interface StatsdClient {
    boolean send(double sampleRate, String... stats);
}
