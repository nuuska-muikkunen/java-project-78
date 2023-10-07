import hexlet.code.StringSchema;
import hexlet.code.NumberSchema;
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
        assertThat(schema.isValid(5)).isFalse();
        assertThat(schema.isValid("what does the fox say")).isTrue();
        assertThat(schema.isValid("hexlet")).isTrue();
        assertThat(schema.contains("wh").isValid("what does the fox say")).isTrue();
        assertThat(schema.contains("what").isValid("what does the fox say")).isTrue();
        assertThat(schema.contains("whatthe").isValid("what does the fox say")).isFalse();
        assertThat(schema.isValid("what does the fox say")).isFalse();

        StringSchema schema1 = v.string();
        assertThat(schema1.set(10).isValid("what does the fox say")).isTrue();
        assertThat(schema1.set(30).isValid("what does the fox say")).isFalse();
    }

    @Test
    public void numbersRestrictionsTest() {
        Validator v =   new Validator();
        NumberSchema schema = v.number();
        schema.required();
        // Пока не вызван метод required(), null считается валидным
        schema.isValid(null); // true
        schema.positive().isValid(null); // true
        schema.required();
        schema.isValid(null); // false
        schema.isValid("5"); // false
        schema.isValid(10); // true
// Потому что ранее мы вызвали метод positive()
        schema.isValid(-10); // false
//  Ноль — не положительное число
        schema.isValid(0); // false
        schema.range(5, 10);
        schema.isValid(5); // true
        schema.isValid(10); // true
        schema.isValid(4); // false
        schema.isValid(11); // false
    }
}
