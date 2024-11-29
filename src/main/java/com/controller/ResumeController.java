package com.controller;

import com.entity.Resume;
import com.enums.FileTypeEnum;
import com.enums.HttpResultEnum;
import com.pojo.custom.FileUploadResult;
import com.pojo.custom.OperateResult;
import com.pojo.custom.ResponseResult;
import com.pojo.dto.ResumeDTO;
import com.pojo.vo.ResumeVO;
import com.service.FileService;
import com.service.ResumeService;
import com.util.WordTemplateUtil;
import com.util.YmlUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.File;

/**
 * 简历
 *
 * @Author 周建泽
 * @Date 2024-11-12 17:18
 */
@RestController
@RequestMapping("/resume")
@AllArgsConstructor
@Slf4j
public class ResumeController {

    private ResumeService resumeService;

    private FileService fileService;

    private YmlUtil ymlUtil;
    /**
     * 文件名
     */
    private static final String FILE_NAME = "resume.docx";


    /**
     * 导出简历
     *
     * @param id 用户ID
     * @return 流结果或者错误信息
     */
    @GetMapping("/export/{id}")
    public ResponseResult<String> exportResume(@Validated @PathVariable @NotBlank(message = "用户ID不能为空") String id, HttpServletResponse response) {
        //获取数据并转化为导出需要的VO
        ResumeVO resumeVO = resumeService.getVOById(id);
        if (resumeVO == null) {
            return new ResponseResult<String>().setHttpResultEnum(HttpResultEnum.PARAM_IS_ERROR);
        }
        //准备模版文件
        String fireUrl = ymlUtil.getFileUploadPathByModuleName(FileTypeEnum.RESUME.getModuleName()) + File.separator+FILE_NAME;
        //导出
        WordTemplateUtil.generateWordByBean(fireUrl,"个人简历",response,resumeVO);
        return new ResponseResult<String>().setData("导出成功");
    }

    /**
     * 新增简历
     *
     * @param resumeDTO 简历DTO
     * @return 添加结果
     */
    @PostMapping
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult<String> addResume(@Valid ResumeDTO resumeDTO) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        Resume resume = resumeDTO.translate2Entity();
        OperateResult insertResult = resumeService.add(resume);
        if (!insertResult.getResult()) {
            return responseResult.setHttpResultEnum(HttpResultEnum.INSERT_FAIL);
        }
        return responseResult;
    }

    /**
     * 上传文件
     *
     * @param multipartFile 文件对象
     * @return 文件信息
     */
    @PostMapping("/uploadFile")
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult<FileUploadResult> uploadFile(MultipartFile multipartFile) {
        if(multipartFile==null || multipartFile.isEmpty()){
            return new ResponseResult<>(HttpResultEnum.PARAM_IS_NULL);
        }
        FileUploadResult fileUploadResult = fileService.uploadFile(multipartFile, FileTypeEnum.RESUME);
        if (!fileUploadResult.isResult()) {
            return new ResponseResult<FileUploadResult>().setHttpResultEnum(HttpResultEnum.SERVER_ERROR);
        }
        return new ResponseResult<FileUploadResult>().setData(fileUploadResult);
    }

}
