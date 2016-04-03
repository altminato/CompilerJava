/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers;

import buffer.TextInBuffer;
import common.Common;
import error.AbortCodes;
import misc.Codes;
import misc.Codes.TokenCode;
import scanner.TextScanner;
import tokens.Token;

/**
 *
 * @author Antonio
 */
public class SimpleParser {
    private final TextScanner textScanner;
    private Token token;
    private TokenCode tokenCode;
    
    public SimpleParser(TextInBuffer buffer){
        textScanner=new TextScanner(buffer);
    }
    
    private void getToken(){
        token=textScanner.getToken();
        tokenCode=token.getCode();
    }
    
    public void parse(){
        //Loop to extract and print tokens
        //Until the end of the source file
        do{
            getToken();
            if(tokenCode != Codes.TokenCode.ERROR){
                token.Print();
            }else{
                System.out.println("\t>> *** ERROR ***\t"+token.getString());
                Common.increaseErrorCount();
            }
            
        }while(tokenCode != Codes.TokenCode.END_OF_FILE);
        
        System.out.println(Common.getCurrentLineNumber()+" source lines.");
        System.out.println(Common.getErrorCount()+" syntax errors.");
    }
}
