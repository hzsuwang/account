package com.iterror.account.biz.bo;

import com.iterror.account.dal.dataobject.AccountDO;

import java.util.List;
import java.util.Map;

public interface AccountService {
    /**
     * 通过用户id 远程调用
     *
     * @param userId
     * @return
     */
    public AccountDO getByUserId(long userId);

    /**
     * 批量读取用户账户信息
     *
     * @param uids
     * @return
     */
    public List<AccountDO> queryListByUids(List<Long> uids);

    /**
     * 批量读取用户账户信息
     *
     * @param uids
     * @return
     */
    public Map<Long, AccountDO> queryMapByUids(List<Long> uids);

    /**
     * @param userId
     * @param gold
     * @param goldSrc
     * @param comment
     * @return
     */
    public int updateAccountGold(long userId, int gold, int goldSrc, String comment);

    /**
     * @param userId
     * @param point
     * @param pointSrc
     * @param comment
     * @return
     */
    public int updateAccountPoint(long userId, int point, int pointSrc, String comment);
}
