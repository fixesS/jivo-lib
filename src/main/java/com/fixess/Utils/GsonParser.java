package com.fixess.Utils;

import com.fixess.Jivo.API.Botapi.Models.BotMessage;
import com.fixess.Jivo.API.Botapi.Models.ClientMessage;
import com.fixess.Jivo.API.Botapi.Models.InviteAgentMessage;
import com.google.gson.Gson;

/**
 * Util class for parse data holder objects to Json.
 * @author Eduard Gorshkov
 * @version 1.0
 */
public class GsonParser {
    /**
     * JSON to ClientMessage by Gson.
     * @param json response from jivosite.
     * @return object of ClientMessage.
     * @see ClientMessage
     */
    public ClientMessage parseClientMessage(String json){
        Gson gson = new Gson();
        ClientMessage clientMessage = gson.fromJson(json,ClientMessage.class);
        return clientMessage;
    }

    /**
     * BotMessage to JSON by Gson.
     * @param botMessage message to chat.
     * @return JSON of BotMessage.
     * @see BotMessage
     */
    public String parseBotMessageToJson(BotMessage botMessage){
        Gson gson = new Gson();
        String json = gson.toJson(botMessage);
        return json;
    }

    /**
     * InviteAgentMessage to JSON by Gson
     * @param inviteAgentMessage
     * @return JSON of InviteAgentMessage
     * @see InviteAgentMessage
     */
    public String parseInviteAgentMessageToJson(InviteAgentMessage inviteAgentMessage){
        Gson gson = new Gson();
        String json = gson.toJson(inviteAgentMessage);
        return json;
    }
}
