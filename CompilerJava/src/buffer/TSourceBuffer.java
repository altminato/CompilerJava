/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buffer;

import common.Common;
import error.AbortCodes;
import java.io.IOException;

/**
 *
 * @author Antonio
 */
public class TSourceBuffer extends TextInBuffer{
    private String line;
    public TSourceBuffer(String filename){
        super(filename, AbortCodes.AbortCode.ABORT_FORM_FILE_OPEN_FAILED);
    }
    
    @Override
    public String getLine(){
        try{
            line=bufferedReader.readLine();
            
            
        }catch(IOException ex){
            System.out.println("Error getting line: "+ex.getMessage());
            line = null;
        }
        
        //returning null will mean the end of the file.
        return line;
    }
}
