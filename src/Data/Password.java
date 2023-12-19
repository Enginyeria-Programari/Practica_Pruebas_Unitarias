package Data;

public class Password {
    private final String password;

    public Password(String password) {
        if (password == null) throw new NullPointerException("Password cannot be null");
        checkPassword(password);

        this.password = password;
    }

    private void checkPassword(String password) {
        // Add your password validation logic here
        // For example, you might want to check for minimum length or specific character requirements
        if (password.length() < 8) throw new IllegalArgumentException("Password must be at least 8 characters long");
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password that = (Password) o;
        return password.equals(that.password);
    }

    @Override
    public int hashCode() {
        return password.hashCode();
    }

    @Override
    public String toString() {
        return "Password{" + "password='" + password + '\'' + '}';
    }
}
