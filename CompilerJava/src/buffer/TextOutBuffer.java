/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buffer;

/**
 *
 * @author Antonio
 */
public abstract class TextOutBuffer {
    protected String filename;
    protected String currentText;
    public TextOutBuffer(String filename){
        this.filename=filename;
    }
    
    public abstract void putLine();
    
    protected void putLine(String line){
        currentText=line;
        putLine();
    }
    
    public String getText(){
        return currentText;
    }
}
