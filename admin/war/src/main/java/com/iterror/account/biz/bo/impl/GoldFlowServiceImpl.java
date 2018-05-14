package com.iterror.account.biz.bo.impl;

import com.iterror.account.biz.bo.GoldFlowService;
import com.iterror.account.biz.common.BaseService;
import com.iterror.account.dal.dataobject.GoldFlowDO;

public class GoldFlowServiceImpl extends BaseService implements GoldFlowService {

    @Override public GoldFlowDO addGoldFlow(GoldFlowDO goldFlowDO) {
        goldFlowDO.init();
        return dao.insert(goldFlowDO);
    }
}
