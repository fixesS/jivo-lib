package com.fixess.Jivo.API.Service;

import com.fixess.Jivo.API.Botapi.Models.BotMessage;
import com.fixess.Jivo.API.Botapi.Models.InviteAgentMessage;

import java.io.IOException;

public interface JivoService {
    void sendBotMessage(BotMessage botMessage)throws IOException;
    void sendInviteAgentMessage(InviteAgentMessage inviteAgentMessage)throws IOException;
}
