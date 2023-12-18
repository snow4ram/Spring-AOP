package sectional.springsectional.annotation;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Component
public class MemberServiceImpl implements MemberService{
    @Override
    @MethodAop("test value")
    public String hello(String param) {

        log.info(param);

        return "ok";
    }


    public String internal(String param) {

        log.info(param);

        return "internal";
    }


}
