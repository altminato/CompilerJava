/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buffer;

import common.Common;
import error.AbortCodes;
import java.io.*;
/**
 *
 * @author Antonio
 */
public abstract class TextInBuffer {
    
    protected final String filename;
    protected FileReader fileReader;
    protected BufferedReader bufferedReader;
    protected int currentLinePosition;
    protected String currentLine=null;
    protected char currentChar=Common.START_OF_FILE;
    
    public TextInBuffer(String filename, AbortCodes.AbortCode abortCode){
        this.filename=filename;
        try{
            fileReader=new FileReader(this.filename);
            bufferedReader=new BufferedReader(fileReader);
        }catch(Exception ex){
            AbortCodes.abortTranslation(abortCode);
        }
    }
    public abstract String getLine();
    
    public char getCurrentChar(){
        return currentChar;
    }
    
    public char getChar(){
        if((currentLine==null) || (currentLinePosition >= currentLine.length())){
            currentLine=getLine();
            currentLinePosition=0;
        }
        //If we get a null line, the it is the end of the file.
        if(currentLine==null){
            currentChar=Common.END_OF_FILE;
            return Common.END_OF_FILE;
        }
        currentChar=currentLine.charAt(currentLinePosition);
        currentLinePosition++;
        return currentChar;
    }
    
    public char putBackChar(){
        currentLinePosition--;
        currentChar=currentLine.charAt(currentLinePosition);
        return currentChar;
    }
}
