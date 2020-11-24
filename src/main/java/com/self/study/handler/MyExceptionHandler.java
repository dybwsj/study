package com.self.study.handler;

import com.self.study.common.ResultVO;
import com.self.study.exception.MyException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: duyubo
 * @date: 2020年11月19日, 0019 13:53
 * @description:
 */

@ControllerAdvice
@ResponseBody
public class MyExceptionHandler {

    @ExceptionHandler(value = BindException.class)
    public ResultVO bindExceptionHandler(Exception e) {
        StringBuilder sb = new StringBuilder("参数错误：[");
        List<ObjectError> list = ((BindException) e).getAllErrors();
        for (ObjectError item : list) {
            sb.append(item.getDefaultMessage()).append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(']');

        String msg = sb.toString();
        return ResultVO.fail(msg);
    }

    @ExceptionHandler(value = MyException.class)
    public ResultVO myExceptionHandler(Exception e) {
        return ResultVO.fail(e.getMessage());
    }

}
