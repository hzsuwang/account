package com.iterror.account.biz.common.util;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class StringUtil extends StringUtils {
    
    public static String getIdsStr(List<Long> ids) {
        if (ids == null || ids.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ids.size(); i++) {
            if (i == (ids.size() - 1)) {
                sb.append(ids.get(i));
            } else {
                sb.append(ids.get(i)).append(",");
            }
        }
        return sb.toString();
    }
}
