package com.fixess.Jivo.API.Botapi.Models.Message;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

/**
 * Data holder object of message
 * @author Eduard Gorshkov
 * @version 1.0
 */
@Getter
@Setter
@ToString
public class Message {
    private String text;
    private String timestamp = String.valueOf(Instant.now().getEpochSecond());

}
