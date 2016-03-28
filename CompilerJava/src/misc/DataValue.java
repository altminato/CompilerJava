/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misc;

/**
 *
 * @author Antonio
 */
public class DataValue{
        private int integer;
        private float real;
        private char character;
        private String stringElement;
        
        public DataValue(){}
        
        public void setInteger(int integer){
            this.integer=integer;
        }
        
        public int getInteger(){
            return integer;
        }
        
        public void setReal(float real){
            this.real=real;
        }
        
        public float getReal(){
            return real;
        }
        
        public void setCharacter(char character){
            this.character=character;
        }
        
        public char getCharacter(){
            return character;
        }
        
        public void setString(String stringElement){
            this.stringElement=stringElement;
        }
        
        public String getString(){
            return stringElement;
        }
    }
