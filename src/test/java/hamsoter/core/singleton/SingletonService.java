package hamsoter.core.singleton;

public class SingletonService {
    // 자기 자신 선언
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자를 private로 하여 신규 생성을 막음
    private SingletonService() {}

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }


}
