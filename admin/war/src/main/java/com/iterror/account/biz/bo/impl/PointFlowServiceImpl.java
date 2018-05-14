package com.iterror.account.biz.bo.impl;

import com.iterror.account.biz.bo.PointFlowService;
import com.iterror.account.biz.common.BaseService;
import com.iterror.account.dal.dataobject.PointFlowDO;

public class PointFlowServiceImpl extends BaseService implements PointFlowService {

    @Override public PointFlowDO addPointFlow(PointFlowDO pointFlowDO) {
        pointFlowDO.init();
        return dao.insert(pointFlowDO);
    }
}
