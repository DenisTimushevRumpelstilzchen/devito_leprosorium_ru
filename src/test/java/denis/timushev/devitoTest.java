package denis.timushev;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class devitoTest {

    Faker faker = new Faker();

    String Hello = faker.backToTheFuture().quote();
    String email = faker.internet().emailAddress();

    @BeforeAll

    static void setUp() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void searchLeproTest() {
        open("https://leprosorium.ru/login/");
        $(".b-login_navigation_devito").click();
        $("[id=js-devito_post_body]").setValue(Hello);
        $("[id=js-devito_email]").setValue(email);
        $("[id=js-devito_form_submit]").click();
    }
}
