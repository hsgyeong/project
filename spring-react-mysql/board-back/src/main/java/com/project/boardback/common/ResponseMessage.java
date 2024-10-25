package com.project.boardback.common;

public interface ResponseMessage {

    // HTTP Status 200
    String SUCCESS = "Success.";

    // HTTP Status 400
    String VALIDATION_FAILED = "Validation Failed.";
    String DUPLICATE_EMAIL = "Duplicated email.";
    String DUPLICATE_NICKNAME = "Duplicated nickname.";
    String DUPLICATE_TEL_NUMBER = "Duplicated tel number.";
    String NOT_EXISTED_USER = "This user does not exist.";
    String NOT_EXISTED_BOARD = "This board does not exist.";
    
    // HTTP Status 401
    String SIGN_IN_FAIL = "Sign In Failed.";
    String AUTHORIZATION_FAIL = "Authorization Failed.";
        
    // HTTP Status 403
    String NO_PERMISSION = "Do not have Permission.";
    
    // HTTP Status 500
    String DATABASE_ERROR = "Database Error.";
    
}
