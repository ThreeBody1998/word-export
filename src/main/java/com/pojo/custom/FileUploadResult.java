package com.pojo.custom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * description 文件上传结果
 * @Author 周建泽
 * @Date 2024-11-26 17:52
 */
@AllArgsConstructor
@Data
//链式调用
@Accessors(chain = true)
public class FileUploadResult {
    /**
     * 文件名
     */
    private String fileName;
    /**
     * 文件ID
     */
    private String fileId;
    /**
     * 文件路径
     */
    private String filePath;
    /**
     * 操作结果
     */
    private boolean result;

    public FileUploadResult(){
        result = true;
    }
}
