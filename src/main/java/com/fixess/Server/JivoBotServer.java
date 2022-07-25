package com.fixess.Server;

import org.apache.http.impl.bootstrap.HttpServer;

import java.io.IOException;

public interface JivoBotServer {
    void start() throws IOException;
    void stop();

}
