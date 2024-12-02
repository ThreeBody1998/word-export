package com.util;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.util.PoitlIOUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * description word模版工具类
 *
 * @Author 周建泽
 * @Date 2024-11-13 17:25
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WordTemplateUtil {

    /**
     * 通过bean生成word
     *
     * @param filePath 文件路径
     * @param fileName 文件名
     * @param response 响应
     * @param obj      数据
     */
    public static void generateWordByBean(String filePath, String fileName, HttpServletResponse response, Object obj) {
        //设置响应头
        setResponse(response, fileName);
        //将对象转化为Map
        Map<String, Object> map = translate2Map(obj);
        //输出文件
        try {
            XWPFTemplate template = XWPFTemplate.compile(filePath).render(map);
            OutputStream out = response.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(out);
            template.write(bos);
            bos.flush();
            out.flush();
            PoitlIOUtils.closeQuietlyMulti(bos, out);
            template.close();
        } catch (IOException e) {
            log.error("IO异常{}", e.getMessage());
        }
    }

    /**
     * 设置响应头(网路响应)
     *
     * @param response 响应
     * @param fileName 文件名
     */
    public static void setResponse(HttpServletResponse response, String fileName) {
        response.reset();
        // 告知浏览器不缓存 响应编码 用给定的名称和值添加一个响应头
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache-control", "no-cache");
        response.setHeader("expires", "0");
        response.setCharacterEncoding("UTF-8");
        response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
    }

    /**
     * 将VO转化为以字段名称作为key,值为value的Map
     *
     * @param obj 对象
     * @return Map
     */
    private static Map<String, Object> translate2Map(Object obj) {
        //转化为Map
        HashMap<String, Object> map = new HashMap<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            try {
                ReflectionUtils.makeAccessible(field);
                map.put(field.getName(), field.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
