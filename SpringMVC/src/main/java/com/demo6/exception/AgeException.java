/**
 * FileName: AgeException
 * Author:   嘉平十七
 * Date:     2020/7/18 17:40
 * Description: 子类异常
 * notes：
 */
package com.demo6.exception;

/*年龄异常*/
public class AgeException extends MyException {
    public AgeException() {
        super();
    }

    public AgeException(String message) {
        super(message);
    }
}