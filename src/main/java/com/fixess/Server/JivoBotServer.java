package com.fixess.Server;

import org.apache.http.impl.bootstrap.HttpServer;

import java.io.IOException;

/**
 * @author Eduard Gorshkov
 * @version 1.0
 */
public interface JivoBotServer {
    void start() throws IOException;
    void stop();

}
