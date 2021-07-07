import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "avitosteps",
        tags = "@1"
)
public class Test {

    @org.junit.Test
    public static void run(String[] args) {
        System.out.println("All tests complete");
    }
}
