package com.fixess.Jivo.API.Service;

import com.fixess.Jivo.API.Botapi.Models.BotMessage;
import com.fixess.Jivo.API.Botapi.Models.InviteAgentMessage;
import com.fixess.Utils.GsonParser;
import com.fixess.Utils.TokenHidder;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Default implenetation of JivoService
 * Service for interacting with jivosite.
 * @author Eduard Gorshkov
 * @version 1.0
 * @see com.fixess.Jivo.API.Service.JivoService
 */
public class DefaultService implements JivoService {
    private static final Logger logger = LoggerFactory.getLogger(DefaultService.class);
    private String fullToken;

    /**
     * Default constructor.
     * @param fullToken Token for your bot. It's consists of webhoook token and bot token. You cah get it on Jivo website.
     */
    public DefaultService(String fullToken) throws Exception {
        this.fullToken = fullToken;
        logger.debug("DefaultService was created with token: "+ TokenHidder.hide(fullToken));
    }

    /**
     * Function of sending bot message to chat.
     * @param botMessage Data holder object. Converts to JSON by Gson.
     * @throws IOException
     * @see BotMessage
     * @see GsonParser
     */
    @Override
    public void sendBotMessage(BotMessage botMessage) throws IOException {
        String urlAddress = "https://bot.jivosite.com/webhooks/"+ fullToken;


        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(urlAddress);
        StringEntity params = new StringEntity(GsonParser.parseBotMessageToJson(botMessage));

        request.addHeader("content-type", "application/json");
        request.setEntity(params);

        HttpResponse response = httpClient.execute(request);
        logger.debug("BotMessage was sent with response : "+response.toString());
    }
    /**
     * Function of inviting Agent to chat.
     * @param inviteAgentMessage Data holder object. Converts to JSON by Gson.
     * @throws IOException
     * @see InviteAgentMessage
     * @see GsonParser
     */
    @Override
    public void sendInviteAgentMessage(InviteAgentMessage inviteAgentMessage) throws IOException{
        String urlAddress = "https://bot.jivosite.com/webhooks/"+ fullToken;


        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(urlAddress);
        StringEntity params = new StringEntity(GsonParser.parseInviteAgentMessageToJson(inviteAgentMessage));

        request.addHeader("content-type", "application/json");
        request.setEntity(params);

        HttpResponse response = httpClient.execute(request);
        logger.debug("InviteAgentMessage was sent with response : "+response.toString());
    }
}
