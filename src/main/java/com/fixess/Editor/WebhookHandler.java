package com.fixess.Editor;

import com.fixess.Jivo.API.Botapi.Models.ClientMessage;
import com.fixess.Jivo.API.Service.DefaultService;
import com.fixess.Jivo.API.Service.JivoService;
import com.fixess.Jivo.API.Update.Update;
import com.fixess.Publisher.EventManager;
import com.fixess.Utils.GsonParser;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Handler of webhooks from jivosite
 * @author Eduard Gorshkov
 * @version 1.0.3
 * @see org.apache.http.impl.bootstrap.HttpServer
 */
public class WebhookHandler implements HttpHandler {
    private static final Logger logger = LoggerFactory.getLogger(WebhookHandler.class);
    private EventManager eventManager;
    private JivoService jivoService;

    /**
     * Default constructor
     * @param eventManager Manager of EventListeners.
     * @see EventManager
     */
    public WebhookHandler(EventManager eventManager){
        this.eventManager = eventManager;
        logger.debug("WebhookHadler was created");
    }

    /**
     * Function of setting EventManager
     * @param eventManager Manager of EventListeners.
     * @see EventManager
     */
    public void setEventManager(EventManager eventManager){
        this.eventManager = eventManager;
        logger.debug("EventManager was set");
    }

    /**
     * Fucntion of setting JivoService
     * @param jivoService Service for interacting with jivosite.
     * @see JivoService
     */
    public void setJivoService(JivoService jivoService){
        this.jivoService = jivoService;
        logger.debug("JivoService was set");
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        byte[] bytesFromBody = httpExchange.getRequestBody().readAllBytes();
        String json = new String(bytesFromBody);

        ClientMessage clientMessage = GsonParser.parseClientMessage(json);

        if(clientMessage == null){
            logger.error("GsonParser cannot create object from JSON. ResponseBody :"+json);
            return;
        }
        logger.debug("ClientMessage was created");
        Update update = new Update(clientMessage,jivoService);

        eventManager.notify(update);

        String hey = "OK";
        byte[] bytes = hey.getBytes();
        httpExchange.sendResponseHeaders(200,bytes.length);
        OutputStream outputStream = httpExchange.getResponseBody();
        outputStream.write(bytes);
        outputStream.close();
    }
}
