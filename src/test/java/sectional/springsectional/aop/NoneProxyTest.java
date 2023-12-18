package sectional.springsectional.aop;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

import sectional.springsectional.service.CallService;
import sectional.springsectional.service.CircularService;

@Slf4j
@Import(CallLogAspect.class)
@SpringBootTest
public class NoneProxyTest {

    @Autowired
    CircularService circular;


    @Test
    public void external() {

        circular.external();


    }


}
