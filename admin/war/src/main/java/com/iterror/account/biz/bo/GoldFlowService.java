package com.iterror.account.biz.bo;

import com.iterror.account.dal.dataobject.GoldFlowDO;

public interface GoldFlowService {

    /**
     * @param goldFlowDO
     * @return
     */
    public GoldFlowDO addGoldFlow(GoldFlowDO goldFlowDO);
}
