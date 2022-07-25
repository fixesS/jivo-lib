package com.fixess.Jivo.API.Service;

import com.fixess.Jivo.API.Botapi.Models.BotMessage;
import com.fixess.Jivo.API.Botapi.Models.InviteAgentMessage;
import com.fixess.Utils.GsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

/**
 * Default implenetation of JivoService
 * Service for interacting with jivosite.
 * @author Eduard Gorshkov
 * @version 1.0
 * @see com.fixess.Jivo.API.Service.JivoService
 */
public class DefaultService implements JivoService {
    private String jivoToken;

    /**
     * Default constructor.
     * @param jivoTOken Token for your bot. You cah get it on Jivo website.
     */
    public DefaultService(String jivoTOken){
        this.jivoToken = jivoTOken;
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
        String urlAddress = "https://bot.jivosite.com/webhooks/"+jivoToken;

        GsonParser gsonParser = new GsonParser();

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(urlAddress);
        StringEntity params = new StringEntity(gsonParser.parseBotMessageToJson(botMessage));

        request.addHeader("content-type", "application/json");
        request.setEntity(params);

        HttpResponse response = httpClient.execute(request);
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
        String urlAddress = "https://bot.jivosite.com/webhooks/"+jivoToken;

        GsonParser gsonParser = new GsonParser();

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(urlAddress);
        StringEntity params = new StringEntity(gsonParser.parseInviteAgentMessageToJson(inviteAgentMessage));

        request.addHeader("content-type", "application/json");
        request.setEntity(params);

        HttpResponse response = httpClient.execute(request);
    }
}
