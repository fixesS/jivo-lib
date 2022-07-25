package com.fixess.Jivo.API.Botapi.Models;

import com.fixess.Jivo.API.Botapi.Models.Message.Message;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClientMessage {
    private String event;
    private String id;
    private String client_id;
    private String chat_id;
    private Message message;

}
