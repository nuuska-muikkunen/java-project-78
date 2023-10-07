package hexlet.code;

public abstract class BaseSchema<T> {

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

    public abstract boolean isValid(T obj);

}
