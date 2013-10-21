package grails.plugin.statsd;

import org.apache.commons.pool.PoolableObjectFactory;

public class StatsdPoolFactory implements PoolableObjectFactory {

    final private String host;
    final private int port;

    public StatsdPoolFactory(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public StatsdClient makeObject() throws Exception {
        return new StatsdClientImpl(host, port);
    }

    public void destroyObject(Object o) throws Exception {
        ((StatsdClientImpl) o).close();
    }

    public boolean validateObject(Object o) {
        return ((StatsdClientImpl) o).isOpen();
    }

    public void activateObject(Object o) throws Exception {
        // Objects don't require setup when sent out
    }

    public void passivateObject(Object o) throws Exception {
        // Objects don't require changes to be returned to pool
    }
}
