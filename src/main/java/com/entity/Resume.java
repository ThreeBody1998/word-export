package com.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 简历表
 * @TableName resume
 */
@TableName(value ="resume")
@Data
public class Resume implements Serializable {
    /**
     * 主键
     */
    @TableId
    private String uuid;

    /**
     * 姓名
     */
    private String name;

    /**
     * 出生年月
     */
    private String birthDay;

    /**
     *  民族
     */
    private String nation;

    /**
     * 政治面貌
     */
    private Integer politicalStatus;

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

    /**
     * 假删除的标志
     */
    private Integer isDelete;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 更新人
     */
    private String updateUser;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Resume other = (Resume) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getBirthDay() == null ? other.getBirthDay() == null : this.getBirthDay().equals(other.getBirthDay()))
            && (this.getNation() == null ? other.getNation() == null : this.getNation().equals(other.getNation()))
            && (this.getPoliticalStatus() == null ? other.getPoliticalStatus() == null : this.getPoliticalStatus().equals(other.getPoliticalStatus()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getGraduationSchool() == null ? other.getGraduationSchool() == null : this.getGraduationSchool().equals(other.getGraduationSchool()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getEducationalLevel() == null ? other.getEducationalLevel() == null : this.getEducationalLevel().equals(other.getEducationalLevel()))
            && (this.getProfilePictureUrl() == null ? other.getProfilePictureUrl() == null : this.getProfilePictureUrl().equals(other.getProfilePictureUrl()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getJobIntention() == null ? other.getJobIntention() == null : this.getJobIntention().equals(other.getJobIntention()))
            && (this.getEducationalBackground() == null ? other.getEducationalBackground() == null : this.getEducationalBackground().equals(other.getEducationalBackground()))
            && (this.getInternshipExperience() == null ? other.getInternshipExperience() == null : this.getInternshipExperience().equals(other.getInternshipExperience()))
            && (this.getCampusPractice() == null ? other.getCampusPractice() == null : this.getCampusPractice().equals(other.getCampusPractice()))
            && (this.getSkillsCertificate() == null ? other.getSkillsCertificate() == null : this.getSkillsCertificate().equals(other.getSkillsCertificate()))
            && (this.getSelfEvaluation() == null ? other.getSelfEvaluation() == null : this.getSelfEvaluation().equals(other.getSelfEvaluation()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getBirthDay() == null) ? 0 : getBirthDay().hashCode());
        result = prime * result + ((getNation() == null) ? 0 : getNation().hashCode());
        result = prime * result + ((getPoliticalStatus() == null) ? 0 : getPoliticalStatus().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getGraduationSchool() == null) ? 0 : getGraduationSchool().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getEducationalLevel() == null) ? 0 : getEducationalLevel().hashCode());
        result = prime * result + ((getProfilePictureUrl() == null) ? 0 : getProfilePictureUrl().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getJobIntention() == null) ? 0 : getJobIntention().hashCode());
        result = prime * result + ((getEducationalBackground() == null) ? 0 : getEducationalBackground().hashCode());
        result = prime * result + ((getInternshipExperience() == null) ? 0 : getInternshipExperience().hashCode());
        result = prime * result + ((getCampusPractice() == null) ? 0 : getCampusPractice().hashCode());
        result = prime * result + ((getSkillsCertificate() == null) ? 0 : getSkillsCertificate().hashCode());
        result = prime * result + ((getSelfEvaluation() == null) ? 0 : getSelfEvaluation().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uuid=").append(uuid);
        sb.append(", name=").append(name);
        sb.append(", birthDay=").append(birthDay);
        sb.append(", nation=").append(nation);
        sb.append(", politicalStatus=").append(politicalStatus);
        sb.append(", phone=").append(phone);
        sb.append(", graduationSchool=").append(graduationSchool);
        sb.append(", email=").append(email);
        sb.append(", educationalLevel=").append(educationalLevel);
        sb.append(", profilePictureUrl=").append(profilePictureUrl);
        sb.append(", address=").append(address);
        sb.append(", jobIntention=").append(jobIntention);
        sb.append(", educationalBackground=").append(educationalBackground);
        sb.append(", internshipExperience=").append(internshipExperience);
        sb.append(", campusPractice=").append(campusPractice);
        sb.append(", skillsCertificate=").append(skillsCertificate);
        sb.append(", selfEvaluation=").append(selfEvaluation);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}