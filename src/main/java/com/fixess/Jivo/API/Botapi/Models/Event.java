package com.fixess.Jivo.API.Botapi.Models;

public enum Event {
    BOT_MESSAGE{
        final String event = "BOT_MESSAGE";
        @Override
        public String getEvent(){
            return event;
        }
    },
    INVITE_AGENT{
        final String event = "INVITE_AGENT";
        @Override
        public String getEvent() {
            return event;
        }
    };
    public abstract String getEvent();
}
