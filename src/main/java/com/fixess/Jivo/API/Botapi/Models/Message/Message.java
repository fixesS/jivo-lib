package com.fixess.Jivo.API.Botapi.Models.Message;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Getter
@Setter
@ToString
public class Message {
    private String type;
    private String text;
    private String timestamp = String.valueOf(Instant.now().getEpochSecond());

}
