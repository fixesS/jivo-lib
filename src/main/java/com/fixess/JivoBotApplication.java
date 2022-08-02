package com.fixess;

import com.fixess.Editor.WebhookHandler;
import com.fixess.Jivo.API.Service.DefaultService;
import com.fixess.Publisher.EventManager;
import com.fixess.Server.DefaultServer;
import com.fixess.Utils.TokenSplitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Main class that creates Jivo bot.
 * @author Eduard Gorshkov
 * @version 1.0.3
 */

public class JivoBotApplication {
     private final static Logger logger = LoggerFactory.getLogger(JivoBotApplication.class);
    private String fullToken;

    /**
     * Constructor.
     * Creates JivoBotApplication, creates handler for server and starts HttpServer.
     * @param eventManager Manager of EventListeners.
     * @param port Port for handling by server.
     * @param fullToken Token for your bot. It's consists of provider id and bot token. You cah get it on Jivo website.
     * @see EventManager
     */
    public JivoBotApplication(EventManager eventManager, int port, String fullToken){
        this.fullToken = fullToken;
        try{
            DefaultService jivoService = new DefaultService(fullToken);

            WebhookHandler webhookHandler = new WebhookHandler(eventManager);
            webhookHandler.setJivoService(jivoService);

            DefaultServer server = new DefaultServer(port, TokenSplitter.getBotTokenFromFullToken(fullToken),webhookHandler);
            server.start();
            logger.info("Bot was started");
        }catch (Exception e){
            logger.error("Bot was not started cause :"+e.getMessage());
            e.printStackTrace();
        }
    }
}
