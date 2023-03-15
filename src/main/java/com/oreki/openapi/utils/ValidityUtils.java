package com.oreki.openapi.utils;

import com.oreki.openapi.common.ErrorCode;
import com.oreki.openapi.exception.ThrowUtils;

/**
 * @author Fu Qiujie
 * @since 2023/3/14
 */
public class ValidityUtils {
    public static void validId(Long id) {
        ThrowUtils.throwIf(id == null || id <= 0, ErrorCode.NOT_FOUND_ERROR);
    }
}
