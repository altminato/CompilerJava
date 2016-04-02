/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buffer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Antonio
 */
public class TListBuffer extends TextOutBuffer{
    public static final int MAXIMUM_LINES_PER_PAGE=50;
    private String date;
    private int pageNumber;
    private int lineCount;
    private boolean listFlag=true;
    
    public TListBuffer(String filename){
        super(filename);
        initialize(filename);
    }
    
    @Override
    public void putLine(){
        if(getListFlag() && (lineCount == MAXIMUM_LINES_PER_PAGE)){
            printPageHeader();
        }
        
        System.out.println(currentText);
        currentText="";
        
        lineCount++;
    }
    
    @Override
    public void putLine(String line){
        super.putLine(line);
    }
    
    public void putLine(String line, int lineNumber, int nestingLevel){
        System.out.println(lineNumber+" "+nestingLevel+": "+line);
        putLine();
    }
    
    public void printPageHeader(){
        char formFeedChar = '\f';
        
        System.out.println(formFeedChar+" Page "+pageNumber+" "+filename+" "+ date);
        lineCount=0;
    }
    
    private void initialize(String filename){
        pageNumber=0;
        this.filename=filename;
        date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        printPageHeader();
    }
    
    public void setListFlag(boolean listFlag){
        this.listFlag=listFlag;
    }
    
    public boolean getListFlag(){
        return listFlag;
    }
}
