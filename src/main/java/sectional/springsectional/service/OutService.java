package sectional.springsectional.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OutService {

    private final InternalServic internalServic;

    public void external() {
        log.info("외부 메서드 호출");
        internalServic.internal();
    }
}
