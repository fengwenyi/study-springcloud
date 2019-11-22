package com.fengwenyi.springcloud_common_model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/11/22 11:27
 */
@Data
@Accessors(chain = true)
public class UserModel {

    /** 昵称 */
    private String nickname;

    /** 年龄 */
    private Integer age;
}
