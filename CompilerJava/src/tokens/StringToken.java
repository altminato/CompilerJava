/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokens;

import buffer.TextInBuffer;
import common.Common;
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
        char character;
        String temporalString="";
        temporalString+="'";
        character=buffer.getChar();
        
        while(character != Common.END_OF_FILE){
            if(character=='\''){ //Look for another Quote.
                //Fetched a Quote, now check for adjasent quote.
                character=buffer.getChar();
                if(character != '\''){
                    break;
                }
            }else if(character == Common.END_OF_LINE){
                character=' ';
            }
            //Append current char to string, then get the next char
            temporalString+=character;
            character=buffer.getChar();
        }
        
        if(character== Common.END_OF_FILE){
            //Error();
        }
        
        temporalString+="'";
        string=temporalString;
    }
    
    @Override
    public boolean isDelimiter(){
        return true;
    }
    
    @Override
    public void Print(){
        System.out.println("\t>> string:\t\t"+string);
        Common.getListBuffer().putLine();
    }
}
