package com.fixess.Editor;

import com.fixess.Jivo.API.Botapi.Models.ClientMessage;
import com.fixess.Jivo.API.Service.DefaultService;
import com.fixess.Jivo.API.Service.JivoService;
import com.fixess.Jivo.API.Update.Update;
import com.fixess.Publisher.EventManager;
import com.fixess.Utils.GsonParser;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class WebhookHandler implements HttpHandler {
    private EventManager eventManager;
    private JivoService jivoService;

    public WebhookHandler(EventManager eventManager){
        this.eventManager = eventManager;
    }

    public void setEventManager(EventManager eventManager){
        this.eventManager = eventManager;
    }
    public void setJivoService(JivoService jivoService){
        this.jivoService = jivoService;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        byte[] bytesFromBody = httpExchange.getRequestBody().readAllBytes();// reading bytes from body
        String json = new String(bytesFromBody);

        GsonParser gsonParser = new GsonParser();
        ClientMessage clientMessage = gsonParser.parseClientMessage(json);//JSON -> Object

        if(clientMessage == null){
            return;
        }

        Update update = new Update(clientMessage,jivoService);

        eventManager.notify(update);

        String hey = "connection is working";
        byte[] bytes = hey.getBytes();
        httpExchange.sendResponseHeaders(200,bytes.length);
        OutputStream outputStream = httpExchange.getResponseBody();
        outputStream.write(bytes);
        outputStream.close();
    }
}
