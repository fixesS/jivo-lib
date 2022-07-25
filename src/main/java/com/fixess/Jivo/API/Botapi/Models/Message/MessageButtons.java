package com.fixess.Jivo.API.Botapi.Models.Message;

import com.fixess.Jivo.API.Botapi.Models.Message.Button.Button;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class MessageButtons extends Message {

    private String type = Type.BUTTONS.getType();


    private String title;
    private List<Button> buttons;
}
