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
    
    public static enum ErrorCode{
        NONE,
        UNRECOGNIZABLE,
        TOO_MANY,
        UNEXPECTED_END_OF_FILE,
        INVALID_NUMBER,
        INVALID_FRACTION,
        INVALID_EXPONENT,
        TOO_MANY_DIGITS,
        REAL_OUT_OF_RANGE,
        INTEGER_OUT_OF_RANGE,
        MISSING_RIGHT_PARENT,
        INVALID_EXPRESSION,
        INVELID_ASSIGMENT,
        MISSING_IDENTIFIER,
        MISSING_COLON_EQUAL,
        UNDEFINED_IDENTIFIER,
        STACKOVERFLOW,
        INVALID_STATEMENT,
        UNEXPECTED_TOKEN,
        MISSING_SEMICOLON,
        MISSING_COMMA,
        MISSING_DO,
        MISSING_UNTIL,
        MISSING_THEN,
        INVALID_FOR_CONTROL,
        MISSING_OF,
        INVALID_CONSTANT,
        MISSING_CONSTANT,
        MISSING_COLON,
        MISSING_END,
        MISSING_TO_OR_DOWNTO,
        REDEFINED_IDENTIFIER,
        MISSING_EQUAL,
        INVALID_TYPE,
        NOT_A_TYPE_IDENTIFIER,
        INVALID_SUBRANGE_TYPE,
        NOT_A_CONSTANT_IDENTIFIER,
        MISSING_DOTDOT,
        INCOMPATIBLE_TYPES,
        INVALID_TARGET,
        INVALID_IDENTIFIER_USAGE,
        INCOMPATIBLE_ASSIGNMENT,
        MIN_GT_MAX,
        MISSING_LEFT_BRACKET,
        MISSING_RIGHT_BRACKET,
        INVALID_INDEX_TYPE,
        MISSING_BEGIN,
        MISSING_PERIOD,
        TOO_MANY_SUBSCRIBS,
        INVALID_FIELD,
        NESTING_TOO_DEEP,
        MISSING_PROGRAM,
        ALREADY_FORWARDED,
        WRONG_NUMBER_OF_PARAMS,
        INVALID_VAR_PARAM,
        NOT_A_RECORD_VARIABLE,
        MISSING_VARIABLE,
        CODE_SEGMENT_OVERFLOW,
        UNIMPLEMENTED_FEATURE
    };
    
    
    
    public static void abortTranslation(AbortCode code){
        System.out.println("Fatal translator error: "+abortMessage[code.ordinal()]);
        System.exit(code.ordinal());
    }
    
    public static void error(ErrorCode errorCode){
        
    }
}
