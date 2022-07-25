package com.fixess.Jivo.API.Botapi.Models;

import com.fixess.Jivo.API.Botapi.Models.Message.Message;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;
/**
 * Data holder object of message to client in chat.
 * @author Eduard Gorshkov
 * @version 1.0
 */
@ToString
public class BotMessage {
    private String event = Event.BOT_MESSAGE.getEvent();
    @Getter
    private String id = UUID.randomUUID().toString();;
    @Setter
    @Getter
    private String client_id;
    @Setter
    @Getter
    private String chat_id;
    @Setter
    @Getter
    private Message message;

    public BotMessage(String client_id,String chat_id,Message message){
        this.client_id = client_id;
        this.chat_id = chat_id;
        this.message = message;
    }
}
