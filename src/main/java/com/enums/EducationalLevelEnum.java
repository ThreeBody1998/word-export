package com.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 教育程度枚举类
 * @Author 周建泽
 * @Date 2024-11-26 17:19
 */

@Getter
@AllArgsConstructor
public enum EducationalLevelEnum {
    /**
     * 初中
     */
    JUNIOR_HIGH_SCHOOL(0, "初中"),
    /**
     * 高中
     */
    HIGH_SCHOOL(1, "高中"),
    /**
     * 专科
     */
    SPECIALTY(2, "专科"),
    /**
     * 本科
     */
    UNDERGRADUATE(3, "本科"),
    /**
     * 硕士
     */
    MASTER(4, "硕士"),
    /**
     * 博士
     */
    DOCTOR(5, "博士");

    /**
     * 根据类型获取名称
     * @param type  类型
     * @return  名称
     */
    public static String getNameByType(int type) {
        for (EducationalLevelEnum value : EducationalLevelEnum.values()) {
            if (value.getType() == type) {
                return value.getDesc();
            }
        }
        return "";
    }
    /**
     * 类型
     */
    public final int type;
    /**
     * 描述
     */
    public final String desc;

}
