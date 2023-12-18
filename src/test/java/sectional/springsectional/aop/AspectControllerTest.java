package sectional.springsectional.aop;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sectional.springsectional.mvc.Post;
import sectional.springsectional.mvc.PostService;

@Slf4j
@Import(AspectTransactionController.class)
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AspectControllerTest {

    @Autowired
    PostService service;

    @Test
    void doFilter() {

        log.info("isAopProxy, postService={}", AopUtils.isAopProxy(service));

    }

    @Test
    void posts() {
        service.save(new Post("user A" , "title A"));
    }
}
