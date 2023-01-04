package org.chubxu.easyexcel.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Student
 * @Description TODO
 * @Since 1.0.0
 * @Date 2022/12/21 22:05
 * @Author chubxu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int age;
    private String name;
    private String address;
}
