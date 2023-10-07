package hexlet.code;

public abstract class BaseSchema {

    private boolean isNotAllowed;

    public void setNotAllowed(boolean notAllowed) {
        this.isNotAllowed = notAllowed;
    }

    public boolean isNotAllowed() {
        return this.isNotAllowed;
    }

    public BaseSchema required() {
        setNotAllowed(true);
        return this;
    }
// делает данные обязательными для заполнения. Иными словами добавляет в схему ограничение,
// которое не позволяет использовать null или пустую строку в качестве значения

    public abstract boolean isValid(Object obj);

}
