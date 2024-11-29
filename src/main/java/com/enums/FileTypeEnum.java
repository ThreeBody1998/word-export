package com.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * description 文件类型枚举
 * @Author 周建泽
 * @Date 2024-11-27 14:18
 */
@AllArgsConstructor
@Getter
public enum FileTypeEnum {
    /**
     * 简历文件
     */
    RESUME(1, "resume");

    /**
     * 类型
     */
    private final int type;
    /**
     * 模块名称
     */
    private final String moduleName;
}
