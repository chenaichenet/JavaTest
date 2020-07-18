/**
 * FileName: MyException
 * Author:   嘉平十七
 * Date:     2020/7/18 17:38
 * Description: 异常类
 * notes：
 */
package com.demo6.exception;

public class MyException extends Exception {
    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }
}