package com.fixess.Jivo.API.Botapi.Models.Message;

import com.fixess.Jivo.API.Botapi.Models.Message.Button.Button;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Data holder object of message that type is BUTTONS
 * @author Eduard Gorshkov
 * @version 1.0
 * @see Message
 */
@Getter
@Setter
@ToString
public class MessageButtons extends Message {

    private String type = Type.BUTTONS.getType();

    private String title;
    private List<Button> buttons;
}
