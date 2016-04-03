/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokens;

import buffer.TextInBuffer;
import common.Common;
import misc.Codes;

/**
 *
 * @author Antonio
 */
public class NumberToken extends Token{
    
    public NumberToken(){
        super();
    }
    
    @Override
    public void getToken(TextInBuffer buffer){
        int maxDigitCount=4;
        char character=buffer.getCurrentChar();
        int digitCount=0;
        String temporalNumber="";
        boolean countErrorFlag=false;
        value.setInteger(0);
        
        do{
            temporalNumber+=character;
            if(++digitCount>maxDigitCount){
                countErrorFlag=true;
            }
            character=buffer.getChar();
        }while(Common.charCodeMap[character] == Codes.CharCode.DIGIT);
        
        if(!countErrorFlag){
            try{
                value.setInteger(Integer.parseInt(temporalNumber));
            }catch(Exception ex){
                countErrorFlag=true;
            }
        }
        string=temporalNumber;
        code=countErrorFlag? Codes.TokenCode.ERROR : Codes.TokenCode.NUMBER;
    }
    
    @Override
    public void Print(){
        System.out.println("\t>> number:\t\t"+value.getInteger());
        Common.getListBuffer().putLine();
    }
}
