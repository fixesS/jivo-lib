package com.fixess.Utils;

/**
 * @author Eduard Gorshkov
 * @version 1.0
 */
public class TokenSplitter {
    /**
     *
     * @param fullToken Token for your bot. It's consists of webhoook token and bot token. You cah get it on Jivo website.
     * @return BotToken: Second part of full token(it's your bot id in BotProvider).
     * @throws Exception
     */
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
