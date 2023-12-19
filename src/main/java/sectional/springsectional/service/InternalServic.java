package sectional.springsectional.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InternalServic {

    public void internal() {
        log.info("내부 메소드 호출");
    }
}
