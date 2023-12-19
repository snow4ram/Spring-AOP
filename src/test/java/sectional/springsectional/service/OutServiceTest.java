package sectional.springsectional.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import sectional.springsectional.aop.CallLogAspect;

import static org.junit.jupiter.api.Assertions.*;


@Import(CallLogAspect.class)
@Slf4j
@SpringBootTest
class OutServiceTest {
//    @Autowired
//    OutService out;

    OutService out = new OutService(new InternalServic());

    @Test
    public void out() {
        out.external();
    }

}