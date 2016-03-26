/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buffer;

import java.io.*;
/**
 *
 * @author Antonio
 */
public class TextInBuffer {
    
    private final String filename;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    
    public TextInBuffer(String filename){
        this.filename=filename;
        try{
            fileReader=new FileReader(this.filename);
            bufferedReader=new BufferedReader(fileReader);
            String line=null;
            while((line=bufferedReader.readLine()) != null){
                System.out.println(line);
            }
            bufferedReader.close();
            fileReader.close();
        }catch(Exception ex){
            System.out.println("Error opening file "+ex.getMessage());
        }
    }
}
