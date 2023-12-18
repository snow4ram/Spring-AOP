package sectional.springsectional.annotation;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import sectional.springsectional.mvc.Post;
import sectional.springsectional.mvc.PostService;
import sectional.springsectional.mvc.PostServiceImpl;

import java.lang.reflect.Method;


@Slf4j

public class MemberServiceImplTest {


    AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();


    Method save;

    Method hello;
    @Nested
    class test1 {

        @BeforeEach
        @DisplayName("PostServiceImpl 에 있는 save 메소드 경로 찾기 ")
        public void findPostMethod() throws NoSuchMethodException {

            save = PostServiceImpl.class.getMethod("save", Post.class);

            log.info("save = {}", save);
        }


        @Test
        @DisplayName("PostServiceImpl 에 있는 save 메소드 와  AspectJ 로 지정한 경로가 맞는지 확인")
        public void init1() {
            pointcut.setExpression("execution(public void sectional.springsectional.mvc.PostServiceImpl.save(sectional.springsectional.mvc.Post))");

            Assertions.assertThat(pointcut.matches(save, PostServiceImpl.class)).isTrue();

        }
    }


    @Nested
    class test2 {

        @BeforeEach
        @DisplayName("Member 서비스 에 있는 hello 메소드 경로 찾기 ")
        public void findHelloMethodRoot() throws NoSuchMethodException {

            hello = MemberServiceImpl.class.getMethod("hello", String.class);

            log.info("hello = {}" , hello);
        }

        @Test
        @DisplayName("Member 서비스로 찾은 경로와 AspectJ 로 지정한 경로가 맞는지 확인 ")
        public void helloMethodRoot() {
            pointcut.setExpression("execution(String sectional.springsectional.annotation.MemberServiceImpl.hello(String))");

            Assertions.assertThat(pointcut.matches(hello, MemberServiceImpl.class)).isTrue();
        }
    }
}