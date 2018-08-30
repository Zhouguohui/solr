package com.zgh.springboot.common;



import com.github.pagehelper.Page;
import lombok.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Data
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode
public class RestResult<T> implements Serializable {

    /**
     * 接口调用状态
     */
    private boolean success;
    /**
     * 状态码
     */
    private String code;
    /**
     * 额外消息
     */
    private String message;
    /**
     * 数据
     */
    private Object data;

    /**
     * 调用接口失败
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> Fail(String msg) {
        return RestResult.Fail("000", msg);
    }

    public static <T> RestResult<T> Fail(String code, String msg) {
        return Fail(code, msg, new Object());
    }

    public static <T> RestResult<T> Fail(String code, String msg, Object data) {
        RestResult<T> tResultOK = new RestResult<>();
        tResultOK.setSuccess(false);
        tResultOK.setCode(code);
        tResultOK.setMessage(msg);
        tResultOK.setData(data);
        return tResultOK;
    }

    /**
     * SUCCESS
     *
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> Success(String message, Object data) {
        RestResult<T> tResultOK = new RestResult<>();
        tResultOK.setSuccess(true);
        tResultOK.setCode("200");
        tResultOK.setMessage(message);
        if (Objects.nonNull(data))
            tResultOK.setData(data);

        return tResultOK;
    }

    public static <T> RestResult<T> Success(Object data) {
        return RestResult.Success("200", data);
    }

    public static <T> RestResult<T> Success(String message) {
        return RestResult.Success(message, new Object());
    }

    public static <T> RestResult<T> buildPaging(Object data) {

        Map<String, Object> resultData = new HashMap<>();
        Page page = (Page) data;
        PageResult<T> tNashPaging = new PageResult<>();
        tNashPaging.setPageNum(page.getPageNum());
        tNashPaging.setPageSize(page.getPageSize());
        tNashPaging.setTotal(page.getTotal());
        tNashPaging.setHasMore(page.getPageNum() * page.getPageSize() < page.getTotal());
        resultData.put("list", data);
        resultData.put("page", tNashPaging);

        return RestResult.Success(resultData);
    }

    /**
     * NashResult
     * 如果 T对象是通过分页插件查询的数据
     *
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> RestResult build(T obj) {
        if (obj instanceof Page) {
            return RestResult.buildPaging(obj);
        } else {
            return RestResult.Success(obj);
        }
    }



}