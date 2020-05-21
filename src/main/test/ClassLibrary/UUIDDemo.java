/**
 * FileName: UUIDDemo
 * Author:   嘉平十七
 * Date:     2020/5/19 16:28
 * Description: UUID类
 * History:
 * notes：通用唯一识别码
 */
package main.test.ClassLibrary;

import java.util.UUID;

public class UUIDDemo {
    public static void main(String[] args) {
        UUID uuid=UUID.randomUUID();
        System.out.println(uuid);
        System.out.println(uuid.toString());
    }
}