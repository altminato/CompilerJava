/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokens;

import buffer.TextInBuffer;
import misc.Codes.*;
import misc.DataValue;

/**
 *
 * @author Antonio
 */
public abstract class Token {
    
    protected TokenCode code;
    protected DataType type;
    protected DataValue value;
    protected String string;
    
    public Token(){
        code=TokenCode.DUMMY;
        type=DataType.DUMMY;
        value=new DataValue();
        string="";
    }
    
    public TokenCode getCode(){
        return code;
    }
    
    public DataType getType(){
        return type;
    }
    
    public DataValue getDataValue(){
        return value;
    }
    
    public String getString(){
        return string;
    }
    
    public abstract void getToken(TextInBuffer buffer);
    
    public abstract void Print();
    
    public abstract boolean isDelimiter();
}
