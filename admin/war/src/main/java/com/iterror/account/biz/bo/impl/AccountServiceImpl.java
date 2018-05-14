package com.iterror.account.biz.bo.impl;

import com.iterror.account.biz.bo.AccountService;
import com.iterror.account.biz.common.BaseService;
import com.iterror.account.dal.dataobject.AccountDO;
import com.iterror.account.dal.dataobject.GoldFlowDO;
import com.iterror.account.dal.dataobject.PointFlowDO;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service public class AccountServiceImpl extends BaseService implements AccountService {

    @Override public AccountDO getByUserId(long userId) {
        AccountDO accountDO = dao.fetch(AccountDO.class, Cnd.where("user_id", "=", userId));
        if (accountDO == null) {
            accountDO = new AccountDO();
            accountDO.setUserId(userId);
            accountDO.init();
            accountDO = dao.insert(accountDO);
        }
        return accountDO;
    }

    @Override public List<AccountDO> queryListByUids(List<Long> uids) {
        return null;
    }

    @Override public Map<Long, AccountDO> queryMapByUids(List<Long> uids) {
        return null;
    }

    @Override @Transactional(rollbackFor = Exception.class) public int updateAccountGold(long userId, int gold, int goldSrc, String comment) {
        AccountDO accountDO = getByUserId(userId);

        if (gold == 0) {
            return 1;
        }
        Date nowTime = new Date();
        long leftGold = accountDO.getGold() + gold;
        int result = 1;
        if (gold < 1) {
            dao.update(AccountDO.class, Chain.makeSpecial("gold", "+" + gold).add("edit_time", nowTime), Cnd.where("user_id", "=", userId));
        } else {
            dao.update(AccountDO.class, Chain.makeSpecial("gold", "+" + gold).add("edit_time", nowTime), Cnd.where("user_id", "=", userId));
        }

        if (result == 1) {
            GoldFlowDO goldFlowDO = new GoldFlowDO();
            goldFlowDO.init();
            goldFlowDO.setGold(gold);
            goldFlowDO.setSrcType(goldSrc);
            goldFlowDO.setLeftGold(leftGold);
            goldFlowDO.setUserId(userId);
            goldFlowDO.setComment(comment);
            dao.insert(goldFlowDO);
        }
        return result;
    }

    @Override @Transactional(rollbackFor = Exception.class) public int updateAccountPoint(long userId, int point, int pointSrc, String comment) {
        if (point == 0) {
            return 1;
        }

        AccountDO accountDO = getByUserId(userId);
        long leftPoint = accountDO.getPoint() + point;
        int result = 1;
        Date nowTime = new Date();
        if (point < 0) {
            if (accountDO.getPoint() + point < 0) {
                //积分不够
                return 0;
            }

            dao.update(AccountDO.class, Chain.makeSpecial("point", "-"+Math.abs(point)).add("edit_time", nowTime), Cnd.where("user_id", "=", userId));
        } else {
            dao.update(AccountDO.class, Chain.makeSpecial("point", "+" + point).add("edit_time", nowTime), Cnd.where("user_id", "=", userId));
        }
        if (result == 1) {
            PointFlowDO pointFlow = new PointFlowDO();
            pointFlow.init();
            pointFlow.setPoint(point);
            pointFlow.setSrcType(pointSrc);
            pointFlow.setUserId(userId);
            pointFlow.setComment("");
            pointFlow.setLeftPoint(leftPoint);
            dao.insert(pointFlow);
        }
        return result;
    }
}
