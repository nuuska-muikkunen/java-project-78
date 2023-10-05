import hexlet.code.StringSchema;
import hexlet.code.Validator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    public void nullRestrictionsTest() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        assertThat(schema.isValid("")).isTrue();
        assertThat(schema.isValid(null)).isTrue();
        schema.required();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid("")).isFalse();
    }

    @Test
    public void stingsRestrictionsTest() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        schema.required();
//        assertThat(schema.isValid("5")).isFalse();
        schema.set(5);
        assertThat(schema.isValid("what does the fox say")).isTrue();
        assertThat(schema.isValid("hexlet")).isTrue();
        assertThat(schema.contains("wh").isValid("what does the fox say")).isTrue();
        assertThat(schema.contains("what").isValid("what does the fox say")).isTrue();
        assertThat(schema.contains("whatthe").isValid("what does the fox say")).isFalse();
        assertThat(schema.isValid("what does the fox say")).isFalse();
    }
}