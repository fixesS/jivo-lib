package com.fixess.Listener;

import com.fixess.Jivo.API.Update.Update;

public interface EventListener {
    void updateReceived(Update update);
}
