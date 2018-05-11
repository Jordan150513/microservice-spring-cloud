package com.itmei.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;

/**
 * Created by qiaodan on 2018/5/11.
 */
public class JacksonUtil {
    private static final Logger logger = LoggerFactory.getLogger(JacksonUtil.class);
    private static final ObjectMapper objectMapper  = new ObjectMapper();
    static{
        /***默认非空不输出*/
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }
    /**
     * 将java对象转换Json字符串
     */
    public static <T> String toJSON(T obj) {
        String jsonStr;
        try {
            jsonStr = objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            logger.error("Java 转 JSON 出错！", e);
            throw new RuntimeException(e);
        }
        return jsonStr;
    }
    /**
     * 将 JSON 字符串转为 Java 对象
     */
    public static <T> T fromJSON(String json, Class<T> type) {
        T obj;
        try {
            obj = objectMapper.readValue(json, type);

        } catch (Exception e) {
            logger.error("JSON 转 Java 出错！", e);
            throw new RuntimeException(e);
        }
        return obj;
    }

    /**
     * json转换List
     * @param json json字符串
     * @param collectionClass List.class
     * @param elementClasses List实体如：User.class
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T readJSON(String json,Class<?> collectionClass,Class<?>... elementClasses) throws Exception{
        JavaType javaType = getCollectionType(collectionClass,elementClasses);
        return objectMapper.readValue(json,javaType);
    }

    /**
     * 获取泛型的Collection Type
     * @param collectionClass 泛型的Collection
     * @param elementClasses 元素类
     * @return JavaType Java类型
     */
    public static JavaType getCollectionType(Class<?> collectionClass,Class<?>...elementClasses){
        return objectMapper.getTypeFactory().constructParametricType(collectionClass,elementClasses);
    }
}
