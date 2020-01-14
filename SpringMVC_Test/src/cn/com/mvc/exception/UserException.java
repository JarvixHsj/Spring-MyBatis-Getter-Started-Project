package cn.com.mvc.exception;

import cn.com.mvcUtil.ExceptionPropertyUtil;

import java.io.IOException;

/**
 * Created By xiaoweiping 2020/1/14 16:34
 **/
public class UserException extends Exception {
    //异常信息
    private String message;
    public UserException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        try {
            return new ExceptionPropertyUtil().getExceptionMsg(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
