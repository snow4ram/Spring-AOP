package sectional.springsectional.aop;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
@Slf4j
@RequiredArgsConstructor
public class CallLogAspect {


    @Before("execution(* sectional.springsectional.service..*.*(..))")
    public void doCall(JoinPoint joinPoint) {


        log.info("signature = {}" , joinPoint.getSignature());

    }
}
