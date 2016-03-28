/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilerjava;

import buffer.*;
import common.Common;
import scanner.TextScanner;

/**
 *
 * @author Antonio
 */
public class CompilerJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Java Pascal Compiler");
        String inputFile="test.txt";
        System.out.println("Reading input file");
        TSourceBuffer buffer=new TSourceBuffer(inputFile);
        TextScanner textScanner=new TextScanner(buffer);
        
        char line;
        while((line=buffer.getChar())!= Common.END_OF_FILE){
            System.out.println("*"+line+"*");
            
        }
        
    }
    
}
