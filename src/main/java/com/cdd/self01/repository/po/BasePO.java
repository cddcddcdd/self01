package com.cdd.self01.repository.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: siyu
 * @CreateTime: 2021-07-01 15:42
 * @Description:
 */
@Getter
@Setter
public class BasePO {

    @TableId(type = IdType.AUTO)
    private Integer id;

    protected Date createAt;

    protected Date updateAt;

    @Override
    public String toString() {
        return "BasePO{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
