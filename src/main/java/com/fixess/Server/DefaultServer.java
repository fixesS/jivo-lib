package com.fixess.Server;


import com.fixess.Editor.WebhookHandler;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class DefaultServer implements JivoBotServer{
    private HttpServer httpServer;
    private HttpContext context;
    private WebhookHandler webhookHandler;
    private int port;

    public DefaultServer(int port, WebhookHandler webhookHandler){
        this.port = port;
        this.webhookHandler = webhookHandler;
    }

    private void createServer() throws IOException {
        httpServer = HttpServer.create();
        httpServer.bind(new InetSocketAddress(port),0);
        context = httpServer.createContext("/",webhookHandler);
    }
    @Override
    public void start() throws IOException {
        createServer();
        httpServer.start();
    }

    @Override
    public void stop() {
        httpServer.stop(1);
        System.out.println("Stop");
    }
}
