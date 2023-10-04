package hexlet.code;

public class StringSchema {
    //constraints
    private int length;
    private String string;
    private boolean isNotAllowed = false;

    public boolean isValid(String str) {
        return true;
    }

    public StringSchema required() {
        this.isNotAllowed = true;
        return this;
    } //— делает данные обязательными для заполнения. Иными словами добавляет в схему ограничение,
      // которое не позволяет использовать null или пустую строку в качестве значения

    public StringSchema min(int length1) {
        this.length = length1;
        return this;
    } //— добавляет в схему ограничение минимальной длины для строки.
      // Строка должна быть равна или длиннее указанного числа

    public StringSchema contains(String str) {
        this.string = str;
        return this;
    } //— добавляет в схему ограничение по содержимому строки. Строка должна содержать определённую подстроку
}
