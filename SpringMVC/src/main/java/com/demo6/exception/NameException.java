/**
 * FileName: NameException
 * Author:   嘉平十七
 * Date:     2020/7/18 17:39
 * Description: 异常子类
 * notes：
 */
package com.demo6.exception;

/*用户姓名异常*/
public class NameException extends MyException {
    public NameException() {
        super();
    }

    public NameException(String message) {
        super(message);
    }
}