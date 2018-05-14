package com.iterror.account.dal.dataobject;

import com.iterror.account.dal.common.BaseDO;
import lombok.Data;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Table;

@Data @Table("it_point_flow") @Comment("积分明细") public class PointFlowDO extends BaseDO {

    @Column("userId") @Comment("用户id") private long userId;

    @Column("point") @Comment("积分变化数") private    long   point;
    @Column("comment") @Comment("备注") private     String comment;
    @Column("src_type") @Comment("积分来源类型") private int    srcType;
    @Column("left_point") @Comment("剩余积分") private long   leftPoint;
}
