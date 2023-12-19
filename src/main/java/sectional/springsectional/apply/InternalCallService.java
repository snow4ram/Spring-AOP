package sectional.springsectional.apply;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;


@Slf4j
@Service
public class InternalCallService {

    private final InternalCallService calls;

    public InternalCallService(@Lazy InternalCallService calls) {
        this.calls = calls;
    }

    public void external() {
        log.info("외부 트랜잭션 호출");
        printTx();
        calls.internal(); //false
    }


    @Transactional
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
