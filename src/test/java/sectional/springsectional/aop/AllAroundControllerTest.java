package sectional.springsectional.aop;

import lombok.extern.slf4j.Slf4j;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
class AllAroundControllerTest {


    @Autowired
    PostService postService;


    @Test
    public void allAround() {
        postService.save(new Post("user A" , "title"));

    }


    @Test
    public void ex() {


        postService.save(null);
    }
}