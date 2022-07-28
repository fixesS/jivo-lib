package com.fixess.Utils;

/**
 * @author Eduard Gorshkov
 * @version 1.0
 */
public class TokenSplitter {
    public static String getBotTokenFromFullToken(String fullToken) throws Exception {
        if(fullToken == ""){
            throw new Exception("Token is empty");
        }else if (!fullToken.contains("/")) {
            throw new Exception("Token is invalid");
        }
        String[] token = fullToken.split("/");
        String BotToken = token[1];
        return BotToken;
    }
}
