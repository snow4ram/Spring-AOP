package sectional.springsectional.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallService {

    private final ApplicationContext applicationContext;

    public CallService(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void external() {
        log.info("외부 메소드 호출 ");
        CircularService callService = applicationContext.getBean(CircularService.class);
        callService.internal();
    }

    public void internal() {
        log.info("내부 메소드 호출");
    }
}
