package com.fixess.Jivo.API.Update;

import com.fixess.Jivo.API.Botapi.Models.ClientMessage;
import com.fixess.Jivo.API.Service.DefaultService;
import com.fixess.Jivo.API.Service.JivoService;
/**
 * Data holder class. Consist of ClientMessage and JivoService.
 * @author Eduard Gorshkov
 * @version 1.0
 */
public class Update {
    private ClientMessage clientMessage;
    private JivoService jivoService;

    /**
     * Default constructor.
     * @param clientMessage received client message from jivosite.
     * @param jivoService service for sending messages to jivosite.
     */
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
