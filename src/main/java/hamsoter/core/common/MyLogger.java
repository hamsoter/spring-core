package hamsoter.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {

    private String uuid;
    private String requestURL;

    // 나중에 별도로 들어옴
    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "][" + requestURL + "]" +message);
    }

    // 빈 호출과 동시에 고유 uuid 생성
    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create: " + this);


    }

    // 고객 요청이 서버에서 빠져나갈 때
    @PreDestroy
    public void close() {
        System.out.println("");
        System.out.println("[" + uuid + "] request scope bean close: " + this);

    }
}
