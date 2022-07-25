package com.fixess;

import com.fixess.Editor.WebhookHandler;
import com.fixess.Jivo.API.Service.DefaultService;
import com.fixess.Publisher.EventManager;
import com.fixess.Server.DefaultServer;

/**
 * Main class that creates Jivo bot.
 * @author Eduard Gorshkov
 * @version 1.0.1
 */

public class JivoBotApplication {
    private String token;

    /**
     * Constructor.
     * Creates JivoBotApplication, creates handler for server and starts HttpServer.
     * @param eventManager Manager of EventListeners.
     * @param port Port for handling by server.
     * @param jivoToken Token for your bot. You cah get it on Jivo website.
     * @see EventManager
     */
    public JivoBotApplication(EventManager eventManager, int port, String jivoToken){
        this.token = jivoToken;

        DefaultService jivoService = new DefaultService(token);
        WebhookHandler webhookHandler = new WebhookHandler(eventManager);
        webhookHandler.setJivoService(jivoService);

        try{
            DefaultServer server = new DefaultServer(port,jivoToken.split("/")[1],webhookHandler);
            server.start();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
