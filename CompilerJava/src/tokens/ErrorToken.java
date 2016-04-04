/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokens;

import buffer.TextInBuffer;
import misc.Codes.TokenCode;

/**
 *
 * @author Antonio
 */
public class ErrorToken extends Token {
    public ErrorToken(){
        super();
        code=TokenCode.ERROR;
    }
    
    @Override
    public void getToken(TextInBuffer buffer){
        string="";
        string+=buffer.getCurrentChar();
        //buffer.getChar();
    }
    
    @Override
    public boolean isDelimiter(){
        return false;
    }
    
    @Override
    public void Print(){
        
    }
}
