package com.fixess.Jivo.API.Botapi.Models;

import com.fixess.Jivo.API.Botapi.Models.Event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;
/**
 * Data holder object of message to invite agent to chat.
 * @author Eduard Gorshkov
 * @version 1.0
 */
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

    /**
     * Default constructor.
     * @param client_id id of client in chat
     * @param chat_id id of chat
     */
    public InviteAgentMessage(String client_id, String chat_id){
        this.client_id = client_id;
        this.chat_id = chat_id;
    }
}
