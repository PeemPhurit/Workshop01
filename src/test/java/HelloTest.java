import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloTest {

    @Test
    @DisplayName("ทำการทดสอบ ....")
    public void  case01() {
        Hello hello = new Hello();
        String name = "peem";
        String actualResult = hello.sawadee(name);
        assertEquals("Hello peem", actualResult);
    }
}