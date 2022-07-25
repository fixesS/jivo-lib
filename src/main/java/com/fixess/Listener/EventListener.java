package com.fixess.Listener;

import com.fixess.Jivo.API.Update.Update;
/**
 * @author Eduard Gorshkov
 * @version 1.0
 */
public interface EventListener {
    void updateReceived(Update update);
}
