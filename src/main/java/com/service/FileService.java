package com.service;

import com.entity.File;
import com.baomidou.mybatisplus.extension.service.IService;
import com.enums.FileTypeEnum;
import com.pojo.custom.FileUploadResult;
import com.pojo.custom.OperateResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zhoujianze
 * @description 针对表【file(文件表)】的数据库操作Service
 * @createDate 2024-11-26 18:00:31
 */
public interface FileService extends IService<File> {
    /**
     * 上传文件
     *
     * @param file       文件
     * @param fileTypeEnum 文件类型
     * @return 文件上传结果
     */
    FileUploadResult uploadFile(MultipartFile file, FileTypeEnum fileTypeEnum);

    /**
     * 插入文件
     *
     * @param fileName   文件名
     * @param type       类型
     * @param savePath   保存路径
     * @return 操作结果
     */
    OperateResult insertFile(String fileName, Integer type, String savePath);

    /**
     * 更新文件状态
     * @param fileId    文件ID
     * @return  是否成功
     */
    boolean updateFileStatus(String fileId);

    /**
     * 绑定成功
     * @param relationId    关联ID
     * @param fileId    文件ID
     * @return  是否成功
     */
    boolean bindSuccess(String relationId,String fileId);

}
