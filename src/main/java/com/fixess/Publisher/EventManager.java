package com.fixess.Publisher;

import com.fixess.Jivo.API.Update.Update;
import com.fixess.Listener.EventListener;

import java.util.*;
/**
 * Manager of EventListeners.
 * @author Eduard Gorshkov
 * @version 1.0
 */
public class EventManager {
    /**
     * List of listeners.
     */
    private List<EventListener> listeners = new ArrayList<>();

    /**
     * Default constructor.
     * @param listeners List of listeners to add to general list.
     */
    public EventManager(EventListener... listeners) {
        this.listeners.addAll(Arrays.asList(listeners));
    }

    /**
     * Function adding one listener.
     * @param listener listener to add to general list.
     */
    public void addListener(EventListener listener){
        this.listeners.add(listener);
    }

    /**
     * Function that calls "updateReceived" function in listeners.
     * @param update update contains of ClientMessage and JivoService.
     * @see com.fixess.Jivo.API.Botapi.Models.ClientMessage
     * @see com.fixess.Jivo.API.Service.JivoService
     */
    public void notify(Update update){
        for(EventListener listener: listeners){
            listener.updateReceived(update);
        }
    }
}
