package com.aq.common.aop;


import com.aq.common.beans.ResultBean;
import com.aq.common.exception.CheckException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class ControllerAOP {
  private static final Logger logger = LoggerFactory.getLogger(ControllerAOP.class);

  public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
    long startTime = System.currentTimeMillis();

    ResultBean<?> result;

    try {
      result = (ResultBean<?>) pjp.proceed();
      logger.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
    } catch (Throwable e) {
      result = handlerException(pjp, e);
    }

    return result;
  }

  private ResultBean<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
    ResultBean<?> result = new ResultBean();

    // 已知异常
    if (e instanceof CheckException) {
      result.setMsg(e.getLocalizedMessage());
      result.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
    } else {
      logger.error(pjp.getSignature() + " error ", e);
      result.setMsg(e.toString());
      result.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
     // 未知异常是应该重点关注的，这里可以做其他操作，如通知邮件，单独写到某个文件等等。
    }
    return result;
  }
}