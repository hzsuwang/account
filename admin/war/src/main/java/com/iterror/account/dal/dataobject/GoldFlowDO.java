package com.iterror.account.dal.dataobject;

import com.iterror.account.dal.common.BaseDO;
import lombok.Data;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Table;

@Data @Table("it_gold_flow") @Comment("金币明细表") public class GoldFlowDO extends BaseDO {

    @Column("userId") @Comment("用户id") private    long   userId;                                  // 用户id
    @Column("gold") @Comment("铜币变化数量") private    long   gold;                                    // 铜币变化数量
    @Column("comment") @Comment("备注") private     String comment;                                 // 备注
    @Column("src_type") @Comment("来源") private     int    srcType;                                 // 来源
    @Column("left_gold") @Comment("剩余金币") private long   leftGold;                                // 剩余金币

}
