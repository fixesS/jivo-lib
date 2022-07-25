package com.fixess.Jivo.API.Botapi.Models.Message;

import lombok.Getter;

public enum Type {
    TEXT{
        String type = "TEXT";
        @Override
        public String getType() {
            return type;
        }
    },
    BUTTONS{
        String type = "BUTTONS";
        @Override
        public String getType() {
            return type;
        }
    },
    MARKDOWN{
        String type = "MARKDOWN";
        @Override
        public String getType() {
            return type;
        }
    };
    public abstract String getType();
}

