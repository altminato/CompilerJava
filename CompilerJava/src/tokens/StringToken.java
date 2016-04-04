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
public class StringToken extends Token{
    public StringToken(){
        super();
        code=TokenCode.STRING;
    }
    
    @Override
    public void getToken(TextInBuffer buffer){
        
    }
    
    @Override
    public boolean isDelimiter(){
        return true;
    }
    
    @Override
    public void Print(){
        
    }
}
