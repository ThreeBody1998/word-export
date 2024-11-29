package com.pojo.vo;

import com.entity.Resume;
import com.enums.PoliticalEnum;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @Author 周建泽
 * @Date 2024-11-13 17:01
 */
@Data
public class ResumeVO {
    /**
     * 姓名
     */
    private String name;
    /**
     * 出生年月
     */
    private String birthDay;
    /**
     * 民族
     */
    private String nation;
    /**
     * 政治面貌
     */
    private String political;
    /**
     * 电话
     */
    private String phone;
    /**
     * 毕业院校
     */
    private String graduationSchool;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 学历
     */
    private Integer educationalLevel;
    /**
     * 头像地址
     */
    private String profilePictureUrl;
    /**
     * 住址
     */
    private String address;
    /**
     * 求职意向
     */
    private String jobIntention;
    /**
     * 教育背景
     */
    private String educationalBackground;
    /**
     * 实习经历
     */
    private String internshipExperience;
    /**
     * 校内实践
     */
    private String campusPractice;
    /**
     * 技能证书
     */
    private String skillsCertificate;
    /**
     * 自我评价
     */
    private String selfEvaluation;

    public ResumeVO(Resume resume) {
        BeanUtils.copyProperties(resume, this);
        this.political = PoliticalEnum.getNameByType(resume.getPoliticalStatus());
    }

    public ResumeVO() {
    }

}
