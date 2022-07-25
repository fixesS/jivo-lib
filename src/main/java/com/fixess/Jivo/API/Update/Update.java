package com.fixess.Jivo.API.Update;

import com.fixess.Jivo.API.Botapi.Models.ClientMessage;
import com.fixess.Jivo.API.Service.DefaultService;
import com.fixess.Jivo.API.Service.JivoService;

public class Update {
    private ClientMessage clientMessage;
    private JivoService jivoService;

    public Update(ClientMessage clientMessage, JivoService jivoService){
        this.clientMessage = clientMessage;
        this.jivoService = jivoService;
    }
    public ClientMessage getClientMessage(){
        return clientMessage;
    }
    public JivoService getJivoService(){
        return jivoService;
    }
}
