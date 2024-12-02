package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.config.DataConfig;
import com.entity.File;
import com.enums.FileStatusEnum;
import com.enums.FileTypeEnum;
import com.pojo.custom.FileUploadResult;
import com.pojo.custom.OperateResult;
import com.service.FileService;
import com.mapper.FileMapper;
import com.util.FileUtil;
import com.util.TimeUtil;
import com.util.YmlUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;
import java.util.UUID;

/**
 * @author zhoujianze
 * @description 针对表【file(文件表)】的数据库操作Service实现
 * @createDate 2024-11-26 18:00:31
 */
@Service
@Slf4j
@AllArgsConstructor
public class FileServiceImpl extends ServiceImpl<FileMapper, File>
        implements FileService {

    private YmlUtil ymlUtil;

    @Override
    public FileUploadResult uploadFile(MultipartFile file, FileTypeEnum fileTypeEnum) {
        FileUploadResult fileUploadResult = new FileUploadResult();
        if (file == null) {
            return fileUploadResult;
        }
        //文件存储至本地
        String fileName = file.getOriginalFilename();
        String suffix = Objects.requireNonNull(fileName).substring(fileName.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        String fileSaveName = uuid + suffix;
        String fileUploadPath = ymlUtil.getFileUploadPathByModuleName(fileTypeEnum.getModuleName());
        OperateResult operateResult = FileUtil.saveFile(file, fileSaveName, fileUploadPath);
        if (!operateResult.getResult()) {
            return fileUploadResult;
        }
        //数据库插入
        OperateResult insertResult = insertFile(fileName, fileTypeEnum.getType(), "/" + fileTypeEnum.getModuleName() + "/" + fileSaveName);
        if (!insertResult.getResult()) {
            return fileUploadResult.setResult(false);
        } else {
            fileUploadResult.setFileId(insertResult.getMessage());
        }
        fileUploadResult.setResult(operateResult.getResult());
        //返回参数设置
        if (operateResult.getResult()) {
            fileUploadResult.setFileName(fileName);
            fileUploadResult.setFilePath(ymlUtil.getNetWorkPath() + "/" + fileTypeEnum.getModuleName() + "/" + fileSaveName);
        }

        return fileUploadResult;
    }

    @Override
    public OperateResult insertFile(String fileName, Integer type, String savePath) {
        OperateResult operateResult = new OperateResult();
        String uuid = UUID.randomUUID().toString();
        File file = new File();
        file.setUuid(uuid);
        file.setIsDelete(DataConfig.DB_NOT_DELETE);
        file.setFileName(fileName);
        file.setStatus(FileStatusEnum.UPLOAD_SUCCESS.getStatus());
        file.setType(type);
        file.setSavePath(savePath);
        file.setCreateTime(TimeUtil.getCurrentTime());
        file.setCreateUser("test");
        if (!save(file)) {
            log.error("插入数据库失败");
            return operateResult.setResult(false).setMessage("插入数据库失败");
        }
        return operateResult.setMessage(uuid);
    }

    @Override
    public String getFilePathByRelationIdAndType(String relationId, Integer type) {
        File file = lambdaQuery().eq(File::getRelationId, relationId).eq(File::getType, type).eq(File::getIsDelete,DataConfig.DB_NOT_DELETE).one();
        if (file != null) {
            return file.getSavePath();
        }
        return null;
    }
}




