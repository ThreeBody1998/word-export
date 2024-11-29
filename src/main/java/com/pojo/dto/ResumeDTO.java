package com.pojo.dto;

import com.config.DataConfig;
import com.entity.Resume;
import com.util.TimeUtil;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * @Author 周建泽
 * @Date 2024-11-26 16:52
 */
@Data
public class ResumeDTO {
    /**
     * 姓名
     */
    @Valid
    @NotBlank(message = "姓名不能为空")
    private String name;
    /**
     * 出生年月
     */
    @Valid
    @NotBlank(message = "出生年月不能为空")
    private String brothDay;
    /**
     * 民族
     */
    @Valid
    @NotBlank(message = "民族不能为空")
    private String nation;
    /**
     * 政治面貌
     */
    @Valid
    @NotBlank(message = "政治面貌不能为空")
    private String political;
    /**
     * 电话
     */
    @Valid
    @NotBlank(message = "电话不能为空")
    private String phone;
    /**
     * 毕业院校
     */
    @Valid
    @NotBlank(message = "毕业院校不能为空")
    private String graduationSchool;
    /**
     * 邮箱
     */
    @Valid
    @NotBlank(message = "邮箱不能为空")
    private String email;
    /**
     * 学历
     */
    @Valid
    @NotBlank(message = "学历不能为空")
    private Integer educationalLevel;
    /**
     * 头像地址
     */
    @Valid
    @NotBlank(message = "头像地址不能为空")
    private String profilePictureUrl;
    /**
     * 住址
     */
    @Valid
    @NotBlank(message = "住址不能为空")
    private String address;
    /**
     * 求职意向
     */
    @Valid
    @NotBlank(message = "求职意向不能为空")
    private String jobIntention;
    /**
     * 教育背景
     */
    @Valid
    @NotBlank(message = "教育背景不能为空")
    private String educationalBackground;
    /**
     * 实习经历
     */
    @Valid
    @NotBlank(message = "实习经历不能为空")
    private String internshipExperience;
    /**
     * 校内实践
     */
    @Valid
    @NotBlank(message = "校内实践不能为空")
    private String campusPractice;
    /**
     * 技能证书
     */
    @Valid
    @NotBlank(message = "技能证书不能为空")
    private String skillsCertificate;
    /**
     * 自我评价
     */
    @Valid
    @NotBlank(message = "自我评价不能为空")
    private String selfEvaluation;

    /**
     * 将DTO转换为实体
     *
     * @return 数据库实体
     */
    public Resume translate2Entity() {
        Resume resume = new Resume();
        BeanUtils.copyProperties(this, resume);
        resume.setUuid(UUID.randomUUID().toString());
        resume.setIsDelete(DataConfig.DB_NOT_DELETE);
        resume.setCreateTime(TimeUtil.getCurrentTime());
        resume.setCreateUser("test");
        return resume;
    }
}
