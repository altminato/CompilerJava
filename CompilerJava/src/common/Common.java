/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import buffer.TListBuffer;
import misc.Codes.CharCode;

/**
 *
 * @author Antonio
 */
public final class Common {
    public static final char END_OF_FILE='\b';
    public static final char START_OF_FILE='\f';
    
    static int currentLineNumber;
    static int currentNestingLevel;
    static int errorCount;
    static TListBuffer list=null;
    
    public static void setCurrentLineNumber(int lineNumber){
        currentLineNumber=lineNumber;
    }
    
    public static int getCurrentLineNumber(){
        return currentLineNumber;
    }
    
    public static void increaseCurrentLineNumber(){
        currentLineNumber++;
    }
    
    public static void increaseCurrentLineNumber(int increase){
        currentLineNumber+=increase;
    }
    
    public static void increaseErrorCount(){
        errorCount++;
    }
    
    public static void increaseErrorCount(int increase){
        errorCount+=increase;
    }
    
    public static int getErrorCount(){
        return errorCount;
    }
    
    public static void setCurrentNestingLevel(int nestingLevel){
        currentNestingLevel=nestingLevel;
    }
    
    public static int getCurrentNestingLevel(){
        return currentNestingLevel;
    }
    
    public static CharCode charCodeMap[]= new CharCode[128];
    
    public static TListBuffer getListBuffer(){
        return list;
    }
    
    public static void setListBuffer(TListBuffer listBuffer){
        list=listBuffer;
    }
    
}
