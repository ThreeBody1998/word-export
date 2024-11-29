package com.util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * description yml工具类
 * @Author 周建泽
 * @Date 2024-11-12 18:02
 */
@Component
@Getter
public class YmlUtil {
    /**
     * 服务器IP
     */
    @Value("${network.ip}")
    private String ip;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Value("${common.file-upload-path}")
    private String fileUploadPath;

    @Value("${common.file-get-prefix}")
    private String fileGetPrefix;

    @Value("${server.port}")
    private String port;

    /**
     * 根据模块名称获取文件上传路径
     * @param moduleName    模块名称
     * @return  文件上传路径
     */
    public String getFileUploadPathByModuleName(String moduleName){
        return fileUploadPath+"/"+moduleName;
    }

    /**
     * 获取文件的网络路径
     * @return  文件的网络路径
     */
    public String getNetWorkPath(){
        return ip+":"+port+ contextPath+"/"+fileGetPrefix;
    }

}
