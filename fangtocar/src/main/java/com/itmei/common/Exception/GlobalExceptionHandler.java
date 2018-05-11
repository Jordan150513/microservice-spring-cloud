package com.itmei.common.Exception;

import com.itmei.common.util.Configration;
import com.itmei.service.MailService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.rmi.ServerException;
import java.util.Map;

/**
 * Created by qiaodan on 2018/5/11.
 */
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
    private org.slf4j.Logger logger = LoggerFactory.getLogger("GlobalExceptionHandler");
//    @Autowired
//    private ExceptionCache exceptionCache;

    @Autowired
    private MailService mailService;

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public ErrorInfo<String> errorInfoHandler(HttpServletRequest request, BaseException e) throws Exception{
        logger.error("---BaseException Handler---Host {} invokes url {} ERROR: {}", request.getRemoteHost(), request.getRequestURL(), e.getMessage());

        ErrorInfo<String> errorInfo = new ErrorInfo<String>();
        errorInfo.setMessage(e.getMessage());
        errorInfo.setCode(Configration.ERROR);
        errorInfo.setData(getParams(request));
        errorInfo.setUrl(request.getRequestURI());
        mailService.sendAttachmentsMail();
//        exceptionCache.addExceptionToList(errorInfo);
        return errorInfo;
    }

    private String getParams(HttpServletRequest request) throws ServerException,IOException {
        Map<String,String[]> params = request.getParameterMap();
        String queryString ="";
        for (String key : params.keySet()){
            String[] values = params.get(key);
            for (int i=0;i<values.length;i++){
                String value = values[i];
                queryString+=key+"="+value+"&";
            }
        }
        //去掉最后一个空格
        if(queryString.length()>0)
            queryString = queryString.substring(0,queryString.length()-1);
        return queryString;
    }

}
