package sectional.springsectional.aop;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;




@Slf4j
@Aspect
@RequiredArgsConstructor
public class AspectTransactionController {


    private final PlatformTransactionManager manager;

    @Around("args()")
    public void targetObject() {

    }


    @Around("execution(* sectional.springsectional.mvc.PostServiceImpl.*(..))")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {

        TransactionStatus tx = manager.getTransaction(new DefaultTransactionDefinition());

        //외부 트랜잭션
        try {

            //save result = true : commit
            //save result = false : rollBack
            log.info("트랜잭션 시작 = {}" ,joinPoint.getSignature());
            Object proceed = joinPoint.proceed();

            log.info("커밋 = {}" ,joinPoint.getSignature());
            this.manager.commit(tx);

            return proceed;

        } catch (RuntimeException e) {
            log.info("롤백 = {}" ,e.getMessage());
            this.manager.rollback(tx);
            throw e;
        }

    }
}
