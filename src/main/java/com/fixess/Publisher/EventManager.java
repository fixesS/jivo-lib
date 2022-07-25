package com.fixess.Publisher;

import com.fixess.Jivo.API.Botapi.Models.ClientMessage;
import com.fixess.Jivo.API.Update.Update;
import com.fixess.Listener.EventListener;

import java.util.*;

public class EventManager {
    private List<EventListener> listeners = new ArrayList<>();

    public EventManager(EventListener... listeners) {
        this.listeners.addAll(Arrays.asList(listeners));
    }

    public void addListener(EventListener listener){
        this.listeners.add(listener);
    }

    public void notify(Update update){
        for(EventListener listener: listeners){
            listener.updateReceived(update);
        }
    }
}
