package com.iterror.account.biz.bo.rpcimpl;

import com.iterror.account.biz.bo.AccountService;
import com.iterror.account.dal.dataobject.AccountDO;
import com.iterror.account.rcp.bto.AccountBTO;
import com.iterror.account.rcp.common.result.BaseResult;
import com.iterror.account.rcp.common.result.RespCode;
import com.iterror.account.rcp.service.AccountServiceRpc;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountServiceRpcImpl implements AccountServiceRpc {

    @Autowired AccountService accountService;

    @Override public AccountBTO getByUserId(long userId) {
        AccountDO accountDO = accountService.getByUserId(userId);
        AccountBTO accountBTO = new AccountBTO();
        BeanUtils.copyProperties(accountDO, accountBTO);

        return accountBTO;
    }

    @Override public List<AccountBTO> queryListByUids(List<Long> uids) {
        List<AccountDO> accountDOS = accountService.queryListByUids(uids);

        List<AccountBTO> accountBTOList = new ArrayList<>();
        if (accountDOS == null || accountDOS.size() == 0) {
            return accountBTOList;
        }
        for (AccountDO accountDO : accountDOS) {
            AccountBTO accountBTO = new AccountBTO();
            BeanUtils.copyProperties(accountDO, accountBTO);
            accountBTOList.add(accountBTO);
        }

        return accountBTOList;
    }

    @Override public Map<Long, AccountBTO> queryMapByUids(List<Long> uids) {
        List<AccountDO> accountDOS = accountService.queryListByUids(uids);

        Map<Long, AccountBTO> accountBTOMap = new HashMap<>();
        if (accountDOS == null || accountDOS.size() == 0) {
            return accountBTOMap;
        }
        for (AccountDO accountDO : accountDOS) {
            AccountBTO accountBTO = new AccountBTO();
            BeanUtils.copyProperties(accountDO, accountBTO);
            accountBTOMap.put(accountDO.getUserId(), accountBTO);
        }
        return accountBTOMap;
    }

    @Override public BaseResult updateAccountGold(long userId, int gold, int goldSrc, String comment) {
        BaseResult baseResult = new BaseResult();
        int result = accountService.updateAccountGold(userId,gold,goldSrc,comment);
        baseResult.setMsg(RespCode.SUCCESS.getMsg());
        baseResult.setRc(RespCode.SUCCESS.getCode());
        if (result == 0) {
            baseResult.setMsg(RespCode.NOT_SUFFICIENT_FUNDS.getMsg());
            baseResult.setRc(RespCode.NOT_SUFFICIENT_FUNDS.getCode());
            return baseResult;
        }
        return baseResult;
    }

    @Override public BaseResult updateAccountPoint(long userId, int point, int pointSrc, String comment) {
        BaseResult baseResult = new BaseResult();
        int result = accountService.updateAccountPoint(userId,point,pointSrc,comment);
        baseResult.setMsg(RespCode.SUCCESS.getMsg());
        baseResult.setRc(RespCode.SUCCESS.getCode());
        if (result == 0) {
            baseResult.setMsg(RespCode.NOT_SUFFICIENT_FUNDS.getMsg());
            baseResult.setRc(RespCode.NOT_SUFFICIENT_FUNDS.getCode());
            return baseResult;
        }
        return baseResult;
    }
}
