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


public class DefaultService implements JivoService {
    private String jivoToken;

    public DefaultService(String jivoTOken){
        this.jivoToken = jivoTOken;
    }
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
