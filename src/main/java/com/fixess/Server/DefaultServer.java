package com.fixess.Server;


import com.fixess.Editor.WebhookHandler;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
/**
 * Default implementation of JivoBotServer.
 * Managing Server.
 * @author Eduard Gorshkov
 * @version 1.0
 * @see com.fixess.Server.JivoBotServer
 */
public class DefaultServer implements JivoBotServer{
    private HttpServer httpServer;
    private HttpContext context;
    private WebhookHandler webhookHandler;
    private int port;

    private String receiveToken;

    /**
     * Default constructor.
     * @param port Port for handling by server.
     * @param receiveToken Second part of origin token(it's your bot id in BotProvider).
     * @param webhookHandler handles webhooks from jivosite.
     * @see WebhookHandler
     */
    public DefaultServer(int port,String receiveToken, WebhookHandler webhookHandler){
        this.port = port;
        this.receiveToken = receiveToken;
        this.webhookHandler = webhookHandler;
    }
    /**
     * Function of creation HttpServer.
     */
    private void createServer() throws IOException {
        httpServer = HttpServer.create();
        httpServer.bind(new InetSocketAddress(port),0);
        context = httpServer.createContext("/"+receiveToken,webhookHandler);
    }

    /**
     * Function of starting server.
     * @throws IOException
     */
    @Override
    public void start() throws IOException {
        createServer();
        httpServer.start();
    }
    /**
     * Function of stopping server.
     */
    @Override
    public void stop() {
        httpServer.stop(1);
    }
}
