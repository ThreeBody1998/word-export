package com.controller;

import com.util.YmlUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Author 周建泽
 * @Date 2024-11-28 09:49
 */
@RestController
@RequestMapping("/file")
@AllArgsConstructor
@Slf4j
public class FileController {

    private YmlUtil ymlUtil;

    /**
     * 下载文件
     *
     * @param moduleName 模块名称
     * @param fileName   文件名称
     */
    @GetMapping("/{moduleName}/{fileName}")
    public void downloadFile(@PathVariable String moduleName, @PathVariable String fileName, HttpServletResponse response) throws IOException {
        // 获取文件路径
        File file = new File(ymlUtil.getFileUploadPathByModuleName(moduleName) + File.separator + fileName);
        if (!file.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
            log.error("文件未找到: {}", file.getAbsolutePath());
            return;
        }
        // 设置响应头
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        // 设置响应内容类型
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        // 读取文件并写入响应输出流
        try (FileInputStream fis = new FileInputStream(file);
             OutputStream os = response.getOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (FileNotFoundException e) {
            log.error("文件未找到");
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("File Not Found: " + e.getMessage());
        }
    }
}
