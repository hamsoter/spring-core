package hamsoter.core.singleton;

public class StatefulService {

    // private int price; // 상태를 유지하는 필드 (권장 x)

    public int order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        return price;
    }
/*
    public int getPrice() {
        // return price;
    }
*/

}
