package sectional.springsectional.transactionalservice;


import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import sectional.springsectional.service.CircularService;


@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @Autowired
    PlatformTransactionManager manager;


    @Autowired
    Box box;

    @Test
    public void externalExecution() {
        box.external();
    }

    @Test
    public void internalExecution() {
        box.internal();

    }


    @Test
    public void readOnlyExecution() {

        box.readOnlyTx();

    }


    public static class Box {

        public void external() {
            log.info("외부 메소드 호출 ");
            print();
        }

        @Transactional
        public void internal() {
            log.info("내부 메소드 호출");
            print();
            printRead();
        }

        @Transactional(readOnly = true)
        public void readOnlyTx() {
            log.info("읽기 전용 메소드 호출 ");
            printRead();
        }


        public void print() {
            boolean active = TransactionSynchronizationManager.isActualTransactionActive();

            log.info("트랜잭션이 활성화 되어있는가? ={}" ,active);
        }

        public void printRead() {
            boolean readOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
            log.info("읽기 전용인가? ={} " , readOnly);
        }

    }

    @TestConfiguration
    public static class TestBox  {

        @Bean
        public Box box() {
            return new Box();
        }

    }
}
