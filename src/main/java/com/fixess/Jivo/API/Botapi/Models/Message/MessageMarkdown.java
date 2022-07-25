package com.fixess.Jivo.API.Botapi.Models.Message;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MessageMarkdown extends Message{
    private String type = Type.MARKDOWN.getType();

    private String content;
}
