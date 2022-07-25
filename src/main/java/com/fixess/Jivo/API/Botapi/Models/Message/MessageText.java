package com.fixess.Jivo.API.Botapi.Models.Message;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Data holder object of message that type is TEXT
 * @author Eduard Gorshkov
 * @version 1.0
 * @see Message
 *
 */
@Getter
@Setter
@ToString
public class MessageText extends Message{
    private String type = Type.TEXT.getType();


}
