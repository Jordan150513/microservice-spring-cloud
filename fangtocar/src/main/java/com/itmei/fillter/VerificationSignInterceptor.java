package com.itmei.fillter;

import com.itmei.common.util.JacksonUtil;
import com.itmei.domain.BaseOutputModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by qiaodan on 2018/5/14.
 */
@Component
public class VerificationSignInterceptor implements HandlerInterceptor {
    @Value("${secret-wap}")
    private String wapsecret; //签名的串
    @Value("${enable-sign}")
    private boolean issign; //是否使用签名认证

    @Override
     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!issign) return true;
        if ("GET".equals(request.getMethod().toUpperCase())) {
            if (!VilidateSign(request.getQueryString(), wapsecret)) {
                BaseOutputModel outputModel = new BaseOutputModel();
                outputModel.setResult(-1);
                outputModel.setMessage("请求失败！");
                request.setCharacterEncoding("UTF-8");
                response.setContentType("text/html; charset=UTF-8");
                response.getWriter().print(JacksonUtil.toJSON(outputModel));
                return false;
            }
        }
        return true;// 只有返回true才会继续向下执行，返回false取消当前请求
    }

    public static boolean VilidateSign(String queryString,String secret){
        String sign="";
        HashMap<String,String> map=new HashMap<>();
        for(String item:queryString.split("&")){
            String[] ss=item.split("=");
            if (ss[0].equals("signature")){
                sign=ss[1];
            }else {
                map.put(ss[0],ss[1]==null?"":ss[1]);
            }
        }
        try {
            if(!sign.equals("")&& sign.equals(getSignature(map,secret))){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 签名生成算法
     * @param   params 请求参数集，所有参数必须已转换为字符串类型
     * @param  secret 签名密钥
     * @return 签名
     * @throws IOException
     */
    public static String getSignature(HashMap<String,String> params, String secret) throws IOException {
        // 先将参数以其参数名的字典序升序进行排序
        Map<String, String> sortedParams = new TreeMap<String, String>(params);
        Set<Map.Entry<String, String>> entrys = sortedParams.entrySet();

        // 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
        StringBuilder basestring = new StringBuilder();
        for (Map.Entry<String, String> param : entrys) {
            basestring.append(param.getKey()).append("=").append(param.getValue());
        }
        basestring.append(secret);

        // 使用MD5对待签名串求签
        byte[] bytes = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            bytes = md5.digest(basestring.toString().getBytes("UTF-8"));
        } catch (GeneralSecurityException ex) {
            throw new IOException(ex);
        }

        // 将MD5输出的二进制结果转换为小写的十六进制
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex);
        }
        return sign.toString();
    }

        @Override
     public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        //请求处理之后进行调用，但是在视图被渲染之前
    }

    @Override
     public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        //在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
    }
}
