package com.iterror.account.dal.dataobject;

import com.iterror.account.dal.common.BaseDO;
import lombok.Data;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Table;

@Data @Table("it_account") @Comment("充值记录表") public class AccountDO extends BaseDO {

    @Column("userId") @Comment("用户id") private   long userId;
    @Column("gold") @Comment("用户金币数") private  long gold;
    @Column("point") @Comment("用户总积分数") private long point;
}
