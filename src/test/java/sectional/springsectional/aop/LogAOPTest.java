package sectional.springsectional.aop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sectional.springsectional.mvc.Post;
import sectional.springsectional.mvc.PostRepository;
import sectional.springsectional.mvc.PostServiceImpl;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class LogAOPTest {

    @Autowired
    PostServiceImpl service;

    @Autowired
    PostRepository repository;

    @Test
    public void save() {
        service.save(new Post("author A" , "test A"));
    }


    @AfterEach
    public void delete() {
        repository.deleteAll();
    }

}