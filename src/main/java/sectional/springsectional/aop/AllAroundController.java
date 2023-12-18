package sectional.springsectional.aop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Aspect
@Slf4j
@RequiredArgsConstructor
public class AllAroundController {

    private final PlatformTransactionManager txManager;


    @Pointcut("execution(* sectional.springsectional.mvc.PostServiceImpl.*(..))")
    public void route() {

    }

    @Around("route()")
    public Object allAround(ProceedingJoinPoint joinPoint) throws Throwable {

        TransactionStatus transaction = txManager.getTransaction(new DefaultTransactionDefinition());

        try {

            log.info("[트랜잭션 시작] {}", joinPoint.getSignature());
            Object proceed = joinPoint.proceed();

            log.info("[트랜잭션 커밋] {}", joinPoint.getSignature());
            this.txManager.commit(transaction);

            return proceed;

        } catch (Exception e) {
            log.info("[트랜잭션 롤백] {}", joinPoint.getSignature());
            this.txManager.rollback(transaction);
            throw e;
        } finally {
            log.info("[리소스 반환] {}", joinPoint.getSignature());
        }

    }

    @Before("route()")
    public void doBefore(JoinPoint before) {
        log.info("[Before Running] {}", before.getSignature());
    }

    @AfterReturning("route()")
    public void doAfterReturn(JoinPoint afterReturn) {
        log.info("[AfterReturn Running] {}", afterReturn.getSignature());
    }

    @AfterThrowing("route()")
    public void doAfterThrowing(JoinPoint afterThrowing){
        log.info("[AfterThrowing Running] {}", afterThrowing.getSignature());
    }

    @After("route()")
    public void afters(JoinPoint afters) {
        log.info("[After] {}", afters.getSignature());
    }
}
