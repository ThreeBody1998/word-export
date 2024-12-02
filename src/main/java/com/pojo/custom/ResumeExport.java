package com.pojo.custom;

import com.deepoove.poi.data.PictureRenderData;
import com.entity.Resume;
import com.enums.PoliticalEnum;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.File;

/**
 * @Author 周建泽
 * @Date 2024-11-13 17:01
 */
@Data
public class ResumeExport {
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
    private PictureRenderData profilePictureUrl;
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

    /**
     * 默认图片宽度
     */
    private static final int DEFAULT_PHOTO_WIDTH = 100;
    /**
     * 默认图片高度
     */
    private static final int DEFAULT_PHOTO_HEIGHT = 160;

    public ResumeExport(Resume resume, String profilePictureUrl) {
        BeanUtils.copyProperties(resume, this);
        this.political = PoliticalEnum.getNameByType(resume.getPoliticalStatus());
        this.profilePictureUrl= new PictureRenderData(DEFAULT_PHOTO_WIDTH, DEFAULT_PHOTO_HEIGHT,new File(profilePictureUrl));
    }

}
