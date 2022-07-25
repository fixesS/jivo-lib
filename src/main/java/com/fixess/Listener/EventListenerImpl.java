package com.fixess.Listener;

import com.fixess.Jivo.API.Botapi.Models.BotMessage;
import com.fixess.Jivo.API.Botapi.Models.ClientMessage;
import com.fixess.Jivo.API.Botapi.Models.Message.Message;
import com.fixess.Jivo.API.Botapi.Models.Message.MessageText;
import com.fixess.Jivo.API.Service.DefaultService;
import com.fixess.Jivo.API.Service.JivoService;
import com.fixess.Jivo.API.Update.Update;

/**
 * Example of implementation EventListener.
 * @author Eduard Gorshkov
 * @version 1.0
 * @see com.fixess.Listener.EventListener
 */
public class EventListenerImpl implements EventListener{
    /**
     * Function where developer can write his own logic.
     * @param update update contains of ClientMessage and JivoService.
     * @see com.fixess.Jivo.API.Botapi.Models.ClientMessage
     * @see com.fixess.Jivo.API.Service.JivoService
     */
    @Override
    public void updateReceived(Update update) {
        ClientMessage clientMessage = update.getClientMessage();
        JivoService jivoService = update.getJivoService();

        Message message = clientMessage.getMessage();
        String text = message.getText();

        Message newMessage = new MessageText();
        newMessage.setText(text);

        BotMessage botMessage = new BotMessage(clientMessage.getClient_id(), clientMessage.getChat_id(), newMessage);

        try{
            jivoService.sendBotMessage(botMessage);
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
