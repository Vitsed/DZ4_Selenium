package stepDef;

import io.cucumber.java.Before;

public class Hook {
    @Before
    public void before() {
        System.out.println("hello world\n");
    }
}
