package com.service;

import com.entity.Resume;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pojo.custom.OperateResult;
import com.pojo.custom.ResumeExport;

/**
 * @author zhoujianze
 * @description 针对表【resume(简历表)】的数据库操作Service
 * @createDate 2024-11-29 16:39:20
 */
public interface ResumeService extends IService<Resume> {
    /**
     * 添加简历
     *
     * @param resume 简历
     * @return 操作结果
     */
    OperateResult add(Resume resume);


    /**
     * 根据ID获取简历VO
     *
     * @param id ID
     * @return 简历VO
     */
    ResumeExport getResumeExportById(String id);

}
