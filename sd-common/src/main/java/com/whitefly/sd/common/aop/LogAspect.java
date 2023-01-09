package com.whitefly.sd.common.aop;

import com.alibaba.fastjson.JSON;
import com.whitefly.sd.common.log.OperationLog;
import com.whitefly.sd.common.web.SdAbstractController;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 所有web接口都日志保留
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution (* com.whitefly.sd.*.controller.*.*(..))")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        try {
            Object target = joinPoint.getTarget();
            if (target instanceof SdAbstractController) {
                //打印方法名和参数
                Object[] args = joinPoint.getArgs();
                List<String> collect = Arrays.stream(args).filter(ags -> !(ags instanceof ServletRequest || ags instanceof ServletResponse)).map(JSON::toJSONString).collect(Collectors.toList());
                Signature signature = joinPoint.getSignature();
                String classPath = signature.getDeclaringTypeName();
                String methodName = signature.getName();

                log.info("{}|{}|{}  , {}", classPath, methodName, "user", collect);

                OperationLog.info(classPath, methodName, "user", collect.toString());
            }
        } catch (Exception e) {
            log.error("LogAspect error ", e);
        }


    }
}
