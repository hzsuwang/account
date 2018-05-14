package com.iterror.account.dal.common;

import lombok.Data;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Id;

import java.util.Date;

@Data
public class BaseDO implements java.io.Serializable{

    @Id
    @Comment("序号")
    private long id;

    @Column("deleted")
    @Comment("删除标记")
    private int deleted;

    @Column("create_time")
    @Comment("创建时间")
    private Date createTime;

    @Column("edit_time")
    @Comment("修改时间")
    private Date editTime;

    public void init() {
        Date nowTime = new Date();
        createTime = nowTime;
        editTime = nowTime;
    }

    public void flashEditTime() {
        Date nowTime = new Date();
        editTime = nowTime;
    }

    public void flashEditTime(Date nowTime) {
        if (nowTime == null) {
            flashEditTime();
        } else {
            editTime = nowTime;
        }
    }

}
