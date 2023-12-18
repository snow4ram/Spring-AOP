package sectional.springsectional.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Slf4j
public class AspectControllerV1 {


    @Around("execution(* sectional.springsectional.mvc.PostServiceImpl.*(..))")
    public Object doLong(ProceedingJoinPoint joinPoint) throws Throwable {

        Object target = joinPoint.getTarget();

        log.info("Target Method = {}" , target.getClass());

        Signature signature = joinPoint.getSignature();


        log.info("서명 = {}" , signature);

        return target;
    }

}
