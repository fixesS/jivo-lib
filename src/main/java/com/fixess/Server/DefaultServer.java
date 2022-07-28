package com.fixess.Server;


import com.fixess.Editor.WebhookHandler;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
/**
 * Default implementation of JivoBotServer.
 * Managing Server.
 * @author Eduard Gorshkov
 * @version 1.0.3
 * @see com.fixess.Server.JivoBotServer
 */
public class DefaultServer implements JivoBotServer{
    private static final Logger logger = LoggerFactory.getLogger(DefaultServer.class);
    private HttpServer httpServer;
    private HttpContext context;
    private WebhookHandler webhookHandler;
    private int port;

    private String botToken;

    /**
     * Default constructor.
     * @param port Port for handling by server.
     * @param botToken Second part of full token(it's your bot id in BotProvider).
     * @param webhookHandler handles webhooks from jivosite.
     * @see WebhookHandler
     */
    public DefaultServer(int port,String botToken, WebhookHandler webhookHandler){
        this.port = port;
        this.botToken = botToken;
        this.webhookHandler = webhookHandler;
    }
    /**
     * Function of creation HttpServer.
     */
    private void createServer() throws IOException {
        httpServer = HttpServer.create();
        httpServer.bind(new InetSocketAddress(port),0);
        context = httpServer.createContext("/"+ botToken,webhookHandler);
        logger.debug("Server was created with port "+port);
    }

    /**
     * Function of starting server.
     * @throws IOException
     */
    @Override
    public void start() throws IOException {
        createServer();
        httpServer.start();
        logger.debug("Server was started.");
    }
    /**
     * Function of stopping server.
     */
    @Override
    public void stop() {
        httpServer.stop(1);
        logger.debug("Server was stopped");
    }
}
