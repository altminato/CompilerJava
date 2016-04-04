/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokens;

import buffer.TextInBuffer;
import misc.Codes;
import misc.Codes.TokenCode;

/**
 *
 * @author Antonio
 */
public class EOFToken extends Token{
    public EOFToken(){
        super();
        code=TokenCode.END_OF_FILE;
    }
    
    @Override
    public void getToken(TextInBuffer buffer){
        code= Codes.TokenCode.END_OF_FILE;
    }
    
    @Override
    public boolean isDelimiter(){
        return false;
    }
    
    @Override
    public void Print(){
        
    }
}
