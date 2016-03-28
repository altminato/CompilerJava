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
public class SpecialToken extends Token{
    public SpecialToken(){
        super();
    }
    
    @Override
    public void getToken(TextInBuffer buffer){
        char character=buffer.getCurrentChar();
        buffer.getChar();
        code= (character=='.')?Codes.TokenCode.PERIOD:Codes.TokenCode.ERROR;
    }
    
    @Override
    public void Print(){
        System.out.println(getList().getText()+"\t special: "+string);
        getList().putLine();
    }
}
