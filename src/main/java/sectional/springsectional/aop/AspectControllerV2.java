package sectional.springsectional.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class AspectControllerV2 {

    @Pointcut("execution(* sectional.springsectional.mvc.PostServiceImpl.*(..))")
    private void doFilter(){}

    @Pointcut("execution(* *..*PostServiceImpl.*(..))")
    private void doService(){}

//    @Around("doFilter()")
//    public Object doLong(ProceedingJoinPoint joinPoint) {
//        Signature signature = joinPoint.getSignature();
//
//        log.info("타겟 메소드 결과 값 = {}" ,signature);
//        return signature;
//    }

    @Around("doFilter() && doService()")
    public Object doTx(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            log.info("트랜잭션 시작 = {}" ,joinPoint.getSignature());
            Object proceed = joinPoint.proceed();
            log.info("트랜잭션 Commit = {}" ,joinPoint.getSignature());
            return proceed;
        } catch (Exception e) {
            log.info("트랜잭션 RollBack = {}" ,joinPoint.getSignature());
            throw e;
        }finally {
            log.info("자원 반납 = {}" ,joinPoint.getSignature());
        }
    }

}
