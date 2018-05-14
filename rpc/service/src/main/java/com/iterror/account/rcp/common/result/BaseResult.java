package com.iterror.account.rcp.common.result;

import lombok.Data;

@Data
public class BaseResult implements java.io.Serializable {

    private int    rc;
    private String msg;
}
