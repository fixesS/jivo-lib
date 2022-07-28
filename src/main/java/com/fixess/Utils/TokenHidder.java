package com.fixess.Utils;

/**
 * @author Eduard Gorshkov
 * @version 1.0
 */
public class TokenHidder {
    public static String hide(String token) throws Exception {
        if(token == ""){
            throw new Exception("Token is empty");
        }if(token.length()<6){
            throw new Exception("Token has not enough length");
        }
        int length = token.length();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(token, 0, 5);
        for(int i =6 ; i<=length;i++){
            stringBuffer.append("*");
        }
        String result = stringBuffer.toString();
        return result;
    }
}
