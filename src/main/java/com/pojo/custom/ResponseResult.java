package com.pojo.custom;

import com.enums.HttpResultEnum;
import lombok.Data;
import lombok.experimental.Accessors;
import net.sf.json.JSONObject;

/**
 * description 响应返回结果类
 * @author 周建泽
 * @date 2023/10/21
 */
@Data
@Accessors(chain = true)
public class ResponseResult<T> {
    /**
     * 响应码
     */
    private HttpResultEnum httpResultEnum;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    public ResponseResult<T> setHttpResultEnum(HttpResultEnum httpResultEnum) {
        this.httpResultEnum = httpResultEnum;
        this.msg = httpResultEnum.getMsg();
        return this;
    }

    public ResponseResult() {
        this.httpResultEnum = HttpResultEnum.SUCCESS;
        this.msg = httpResultEnum.getMsg();
    }

    public ResponseResult(HttpResultEnum httpResultEnum) {
        this.httpResultEnum = httpResultEnum;
        this.msg = httpResultEnum.getMsg();
    }

    public JSONObject toJsonString(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",httpResultEnum.getCode());
        jsonObject.put("msg",msg);
        jsonObject.put("data",data);
        return jsonObject;
    }

    /**
     * 默认返回
     * @param httpResultEnum    返回码
     * @param msg   返回信息
     * @return  返回结果
     */
    public static ResponseResult<String> defaultBack(HttpResultEnum httpResultEnum,String msg){
        ResponseResult<String> responseResult = new ResponseResult<>();
        responseResult.setHttpResultEnum(httpResultEnum).setMsg(msg);
        return responseResult;
    }

}
