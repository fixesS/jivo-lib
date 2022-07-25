package com.fixess.Utils;

import com.fixess.Jivo.API.Botapi.Models.BotMessage;
import com.fixess.Jivo.API.Botapi.Models.ClientMessage;
import com.fixess.Jivo.API.Botapi.Models.InviteAgentMessage;
import com.google.gson.Gson;

public class GsonParser {
    public ClientMessage parseClientMessage(String json){
        Gson gson = new Gson();
        ClientMessage clientMessage = gson.fromJson(json,ClientMessage.class);
        return clientMessage;
    }
    public String parseBotMessageToJson(BotMessage botMessage){
        Gson gson = new Gson();
        String json = gson.toJson(botMessage);
        return json;
    }
    public String parseInviteAgentMessageToJson(InviteAgentMessage inviteAgentMessage){
        Gson gson = new Gson();
        String json = gson.toJson(inviteAgentMessage);
        return json;
    }
}
