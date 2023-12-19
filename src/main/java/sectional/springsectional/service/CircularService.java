package sectional.springsectional.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CircularService {


    private CircularService service;


    @Autowired
    public void setService(@Lazy CircularService service) {
        this.service = service;
    }


    public void external() {
        log.info("외부 메소드 호출 ");
        service.internal();
    }

    public void internal() {
        log.info("내부 메소드 호출");
    }
}
