package com.enums;

import lombok.Getter;

/**
 * @Author 周建泽
 * @Date 2024-11-13 17:07
 */
@Getter
public enum PoliticalEnum {
    /**
     * 群众
     */
    PEOPLE(0, "群众"),
    /**
     * 党员
     */
    PARTY_MEMBER(1, "党员"),
    /**
     * 团员
     */
    LEAGUE_MEMBER(2, "团员"),
    /**
     * 其他
     */
    OTHER(3, "其他");
    /**
     * 类型
     */
    private final int type;
    /**
     * 名称
     */
    private final String name;

    PoliticalEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    /**
     * 根据类型获取名称
     * @param type  类型
     * @return  名称
     */
    public static String getNameByType(int type) {
        for (PoliticalEnum value : PoliticalEnum.values()) {
            if (value.getType() == type) {
                return value.getName();
            }
        }
        return "";
    }
}
