package com.dot2.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Result {
    private String error;
    private int code;

    public Result(String error, ErrorCode code) {
        this.error = error;
        this.code = code.getCode();
    }

    public enum ErrorCode {
        Unauthorized(401),
        Forbidden(403),
        UserNotFound(40401),
        ;
        private int code;

        public int getCode() {
            return code;
        }

        ErrorCode(int code) {
            this.code = code;
        }
    }


}
