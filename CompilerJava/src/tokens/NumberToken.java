/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokens;

import buffer.TextInBuffer;
import common.Common;
import misc.Codes;
import misc.Codes.CharCode;
import misc.Codes.DataType;
import misc.Codes.TokenCode;

/**
 *
 * @author Antonio
 */
public class NumberToken extends Token{
    private char character;
    private String numberString;
    private int digitCount;
    private boolean countErrorFlag;
    
    public NumberToken(){
        super();
        code=TokenCode.NUMBER;
    }
    
    @Override
    public void getToken(TextInBuffer buffer){
        int maxInteger=32767;
        int maxExponent=37;
        
        float numValue=0;
        
        int numbersBeforeDecimalPoint=0;
        int numbersAfterDecimalPoint=0;
        
        char exponentSign='+';
        float eValue=0;
        int exponent=0;
        boolean sawDotDotFlag=false;
        
        character=buffer.getCurrentChar();
        digitCount=0;
        numberString="";
        countErrorFlag=false;
        code=TokenCode.ERROR;
        type=DataType.INTEGER;
        
        Object accumulatedValue=accumulateValue(buffer, numValue);
        if(accumulatedValue==null){
            return;
        }
        numValue=(float)accumulatedValue;
        
        numbersBeforeDecimalPoint=digitCount;
        
        //If the current character is a dot, see if it is a single dot or double dot.
        if(character=='.'){
            character=buffer.getChar();
            if(character=='.'){
                //Measn we have a .. token. Beck up the buffer so that we can extract it as a token.
                sawDotDotFlag=true;
                buffer.putBackChar();
            }else{
                type=DataType.REAL;
                numberString+='.';
                //A dot means we have a fraction part, acumulate it
                accumulatedValue=accumulateValue(buffer, numValue);
                if(accumulatedValue==null){
                    return;
                }
                numValue=(float)accumulatedValue;
                numbersAfterDecimalPoint=digitCount-numbersBeforeDecimalPoint;
            }
        }
        
        //Get the exponent part, if any. There cannot be an exponent part
        //if we already saw the '..' token.
        
        if(!sawDotDotFlag && ((character == 'E') || (character=='e'))){
            type=DataType.REAL;
            numberString+=character;
            
            character=buffer.getChar();
            
            if(character=='+' || character=='-'){
                numberString+=exponentSign=character;
                character=buffer.getChar();
            }
            
            //Accumulate the number of the value after 'E'
            
            digitCount=0;
            
            accumulatedValue=accumulateValue(buffer, eValue);
            if(accumulatedValue==null){
                return;
            }
            eValue=(float)accumulatedValue;
            if(exponentSign=='-'){
                eValue=-eValue;
            }
        }
        
        //Where there too many digits
        
        if(countErrorFlag){
            //Error();
            return;
        }
        
        //Calculate and check the final exponent value
        //and then use it to adjust the number's value
        exponent=(int)eValue-numbersAfterDecimalPoint;
        if((exponent+numbersBeforeDecimalPoint < -maxExponent) ||
           (exponent+numbersBeforeDecimalPoint > maxExponent)){
            //Error()
            return;
        }
        
        if(exponent != 0){
            numValue*= (float)Math.pow(10, exponent);
        }
        
        //Check and set the numeric value
        
        if(type==DataType.INTEGER){
            if(numValue < -maxInteger || numValue > maxInteger){
                //Error()
                return;
            }
            value.setInteger((int)numValue);
        }else{
            value.setReal(numValue);
        }
        
        
        string=numberString;
        code=Codes.TokenCode.NUMBER;
    }
    
    @Override
    public boolean isDelimiter(){
        return false;
    }
    
    @Override
    public void Print(){
        if(type==DataType.INTEGER){
            System.out.println("\t>> integer:\t\t"+value.getInteger());
        }else{
            System.out.println("\t>> real:\t\t"+value.getReal());
        }
        Common.getListBuffer().putLine();
    }
    
    private Object accumulateValue(TextInBuffer buffer, float value/*, ErrorCode errorCode*/){
        int maxDigitCount=20;
        
        if(Common.charCodeMap[character] != CharCode.DIGIT){
            //Error(ec)
            return null;
        }
        
        do{
            numberString+=character;
            value=10*value+((Character.getNumericValue(character)));
            if(++digitCount>maxDigitCount){
                countErrorFlag=true;
            }
            character=buffer.getChar();
        }while(Common.charCodeMap[character] == CharCode.DIGIT);
        
        return value;
    }
}
