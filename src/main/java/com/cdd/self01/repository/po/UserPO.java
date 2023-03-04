package com.cdd.self01.repository.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author cdd
 * @Description  用户。表名与字段生成不一样时需要自己配置
 */
@Data
@TableName("user")
@EqualsAndHashCode(callSuper = true)
public class UserPO extends BasePO{
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer age;
    private String email;
}
