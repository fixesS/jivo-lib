package com.fixess.Jivo.API.Botapi.Models;

import com.fixess.Jivo.API.Botapi.Models.Event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@ToString
public class InviteAgentMessage {
    private String event = Event.INVITE_AGENT.getEvent();
    @Getter
    private String id = UUID.randomUUID().toString();;
    @Getter
    @Setter
    private String client_id;
    @Getter
    @Setter
    private String chat_id;

    public InviteAgentMessage(String client_id, String chat_id){
        this.client_id = client_id;
        this.chat_id = chat_id;
    }
    public InviteAgentMessage(){

    }
}
