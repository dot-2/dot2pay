package com.dot2.dot2pay.common.exception;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class Result {

    interface WithoutCodeView{};
    interface WithCodeView extends WithoutCodeView {};

    private String error;
    private int code;

    public Result(String error, ErrorCode code) {
        this.error = error;
        this.code = code.getCode();
    }

    @JsonView(WithoutCodeView.class)
    public String getError() {
        return error;
    }

    @JsonView(WithCodeView.class)
    public int getCode() {
        return code;
    }

    public enum ErrorCode {
        Unauthorized(401),
        Forbidden(403),
        UserNotFound(40401),
        EntityDuplicate(42201)
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
