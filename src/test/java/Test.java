import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Cucumber/features",
        glue = "steps",
        tags = "@1"
)
public class Test {

    @org.junit.Test
    public static void run(String[] args) {

    }
}
