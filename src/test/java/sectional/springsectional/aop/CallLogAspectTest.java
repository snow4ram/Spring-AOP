package sectional.springsectional.aop;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import sectional.springsectional.service.CallService;



@Slf4j
@Import(CallLogAspect.class)
@SpringBootTest
class CallLogAspectTest {

    @Autowired
    CallService calls;


    @Test
    public void external() {
        calls.external();
    }

}