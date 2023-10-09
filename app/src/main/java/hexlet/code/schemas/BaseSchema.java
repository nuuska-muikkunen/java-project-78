package hexlet.code.schemas;

public abstract class BaseSchema<T> {

    private boolean isNotAllowed = false;
    private boolean isActiveStringRestriction = false;

    public boolean isActiveStringRestriction() {
        return isActiveStringRestriction;
    }

    public void setActiveStringRestriction(boolean activeStringRestriction) {
        isActiveStringRestriction = activeStringRestriction;
    }

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

    public BaseSchema contains(String str) {
        setActiveStringRestriction(true);
        return this;
    }

    public abstract boolean isValid(T obj);

}
