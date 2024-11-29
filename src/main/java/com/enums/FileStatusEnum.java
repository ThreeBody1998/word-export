package com.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * description 文件状态枚举
 * @Author 周建泽
 * @Date 2024-11-27 16:11
 */
@Getter
@AllArgsConstructor
public enum FileStatusEnum {

    /**
     * 已上传未绑定
     */
    UPLOAD_SUCCESS(1, "已上传未绑定"),
    /**
     * 已绑定
     */
    BIND_SUCCESS(2, "已绑定");

    private final int status;

    private final String desc;
}
