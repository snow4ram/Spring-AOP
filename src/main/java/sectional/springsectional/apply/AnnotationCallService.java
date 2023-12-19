package sectional.springsectional.apply;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
@Service
@RequiredArgsConstructor
public class AnnotationCallService {


    private final ApplicationContext applicationContext;


    @Transactional
    public void external() {
        log.info("외부 트랜잭션 호출");
        AnnotationCallService result = applicationContext.getBean(AnnotationCallService.class);

        result.internal();
    }

    public void internal() {
        log.info("내부 트랜잭션 호출");
        printTx(); //ture
        //internalParents();
    }

    public void printTx() {
        boolean active = TransactionSynchronizationManager.isSynchronizationActive();

        log.info("트랜잭션이 활성화 되어있는가? ={}" ,active);
    }
}
