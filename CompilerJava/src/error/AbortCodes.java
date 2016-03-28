/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package error;

/**
 *
 * @author Antonio
 */
public final class AbortCodes {
    
    static int errorCount=0;
    
    public static enum AbortCode{
        ABORT_INVALID_COMMAND_LINE_ARGS,
        ABORT_SOURCE_FILE_OPEN_FAILED,
        ABORT_FORM_FILE_OPEN_FAILED,
        ABORT_ASSEMBLY_FILE_OPEN_FAILED,
        ABORT_TOO_MANY_SINTAX_ERRORS,
        ABORT_STACK_OVERFLOW,
        ABORT_CODE_SEGMENT_OVERFLOW,
        ABORT_NESTING_TOO_DEEP,
        ABORT_RUNTIME_ERROR,
        ABORT_UNIMPLEMENTED_FEATURE
    }
    
    public static String abortMessage[]={
      "",
      "Invalid command line arguments",
      "Failed to open source file",
      "Failed to open intermediate from file",
      "Failed to open assembly file",
      "Too many syntax errors",
      "Stack overflow",
      "Code segment overflow",
      "Nesting too deep",
      "Runtime error",
      "Unimplemented feature"
    };
    
    public static void setErrorCount(int count){
        errorCount=count;
    }
    
    public static int getErrorCount(){
        return errorCount;
    }
    
    public static void abortTranslation(AbortCode code){
        System.out.println("Fatal translator error: "+abortMessage[code.ordinal()]);
        System.exit(code.ordinal());
    }
}
