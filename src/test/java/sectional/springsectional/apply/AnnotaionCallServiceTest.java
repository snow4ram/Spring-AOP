package sectional.springsectional.apply;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
class AnnotaionCallServiceTest {



    @Autowired
    AnnotationCallService callService;

    @Test
    public void run() {

        callService.external();
    }

}