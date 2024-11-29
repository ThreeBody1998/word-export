package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.config.DataConfig;
import com.entity.Resume;
import com.pojo.custom.OperateResult;
import com.pojo.vo.ResumeVO;
import com.service.ResumeService;
import com.mapper.ResumeMapper;
import com.util.TimeUtil;
import org.springframework.stereotype.Service;

/**
* @author zhoujianze
* @description 针对表【resume(简历表)】的数据库操作Service实现
* @createDate 2024-11-29 16:39:20
*/
@Service
public class ResumeServiceImpl extends ServiceImpl<ResumeMapper, Resume>
    implements ResumeService{

    @Override
    public OperateResult add(Resume resume) {
        OperateResult operateResult = new OperateResult();
        resume.setIsDelete(DataConfig.DB_NOT_DELETE);
        resume.setCreateTime(TimeUtil.getCurrentTime());
        resume.setCreateUser("test");
        return operateResult.setResult(save(resume));
    }

    @Override
    public ResumeVO getVOById(String id) {
        Resume resume = getById(id);
        return new ResumeVO(resume);
    }
}




