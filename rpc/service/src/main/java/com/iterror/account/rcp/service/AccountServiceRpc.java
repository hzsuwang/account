package com.iterror.account.rcp.service;

import com.iterror.account.rcp.bto.AccountBTO;
import com.iterror.account.rcp.common.result.BaseResult;

import java.util.List;
import java.util.Map;

public interface AccountServiceRpc {

    /**
     * 通过用户id 远程调用
     *
     * @param userId
     * @return
     */
    public AccountBTO getByUserId(long userId);

    /**
     * 批量读取用户账户信息
     *
     * @param uids
     * @return
     */
    public List<AccountBTO> queryListByUids(List<Long> uids);

    /**
     * 批量读取用户账户信息
     *
     * @param uids
     * @return
     */
    public Map<Long, AccountBTO> queryMapByUids(List<Long> uids);

    /**
     * @param userId
     * @param gold
     * @param goldSrc
     * @param comment
     * @return
     */
    public BaseResult updateAccountGold(long userId, int gold, int goldSrc, String comment);

    /**
     * @param userId
     * @param point
     * @param pointSrc
     * @param comment
     * @return
     */
    public BaseResult updateAccountPoint(long userId, int point, int pointSrc, String comment);
}
