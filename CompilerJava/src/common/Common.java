/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author Antonio
 */
public final class Common {
    static int currentLineNumber;
    static int currentNestingLevel;
    
    public static void setCurrentLineNumber(int lineNumber){
        currentLineNumber=lineNumber;
    }
    
    public static int getCurrentLineNumber(){
        return currentLineNumber;
    }
    
    public static void setCurrentNestingLevel(int nestingLevel){
        currentNestingLevel=nestingLevel;
    }
    
    public static int getCurrentNestingLevel(){
        return currentNestingLevel;
    }
}
