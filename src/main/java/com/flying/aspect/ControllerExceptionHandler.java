package com.flying.aspect;

import com.flying.constant.HSHttpCodeEnum;
import com.flying.entity.HSResult;
import com.flying.exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler({ MyException.class })
    @ResponseBody
    public HSResult handleNoAuthException(MyException e) {
        LOGGER.error("handle handleNoAuthException, ex={}", e.getMessage(), e);
        HSResult hsResult = HSResult.build(HSHttpCodeEnum.CODE_401.getValue(),e.getMessage());
        return hsResult;
    }
}
