package com.fixess;

import com.fixess.Editor.WebhookHandler;
import com.fixess.Jivo.API.Service.DefaultService;
import com.fixess.Publisher.EventManager;
import com.fixess.Server.DefaultServer;

public class JivoBotApplication {
    private String token;


    public JivoBotApplication(EventManager eventManager, int port, String jivoToken){
        this.token = jivoToken;

        DefaultService jivoService = new DefaultService(token);
        WebhookHandler webhookHandler = new WebhookHandler(eventManager);
        webhookHandler.setJivoService(jivoService);

        try{
            DefaultServer server = new DefaultServer(port,webhookHandler);
            server.start();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
