/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokens;

import buffer.TextInBuffer;
import misc.Codes;

/**
 *
 * @author Antonio
 */
public class EOFToken extends Token{
    public EOFToken(){
        super();
    }
    
    @Override
    public void getToken(TextInBuffer buffer){
        code= Codes.TokenCode.END_OF_FILE;
    }
    
    @Override
    public void Print(){
        
    }
}
