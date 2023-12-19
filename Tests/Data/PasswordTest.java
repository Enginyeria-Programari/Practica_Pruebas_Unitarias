package Data;

import Data.Interfaces.PasswordTestInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PasswordTest implements PasswordTestInterface {

    Password password;

    @BeforeEach
    public void setUp() {
        String correctPassword = "StrongPass123";
        password = new Password(correctPassword);
    }

    @Test
    @Override
    public void getPasswordTest() {
        String correctPassword = "StrongPass123";
        assertEquals(correctPassword, password.getPassword());
    }

    @Test
    @Override
    public void nullPasswordTest() {
        assertThrows(NullPointerException.class, () -> new Password(null));
    }

    @Test
    @Override
    public void passwordWithLessThanEightCharactersTest() {
        assertThrows(IllegalArgumentException.class, () -> new Password("Pass123"));
    }

    @Test
    @Override
    public void passwordWithEightCharactersTest() {
        // Passwords with exactly eight characters are considered valid in this example
        String validEightCharacterPassword = "Pass1234";
        assertEquals(validEightCharacterPassword, new Password(validEightCharacterPassword).getPassword());

        // Passwords with less than eight characters are invalid
        assertThrows(IllegalArgumentException.class, () -> new Password("Pass123"));
    }

    @Test
    @Override
    public void passwordWithLowerCaseOnlyTest() {
        // Passwords with lowercase characters only are considered valid
        String validLowerCasePassword = "strongpassword";
        assertEquals(validLowerCasePassword, new Password(validLowerCasePassword).getPassword());
    }

    @Test
    @Override
    public void passwordWithUpperCaseOnlyTest() {
        // Passwords with uppercase characters only are considered valid
        String validUpperCasePassword = "STRONGPASSWORD";
        assertEquals(validUpperCasePassword, new Password(validUpperCasePassword).getPassword());
    }


    @Test
    @Override
    public void passwordWithSpecialCharactersTest() {
        // Passwords with special characters are considered valid
        String validSpecialCharacterPassword = "Pass@123";
        assertEquals(validSpecialCharacterPassword, new Password(validSpecialCharacterPassword).getPassword());

        // Passwords without special characters are invalid
        assertThrows(IllegalArgumentException.class, () -> new Password("Pass123"));
    }

    @Test
    @Override
    public void passwordWithSpaceTest() {
        // Passwords with spaces are considered valid
        String validSpacePassword = "Pass 123";
        assertEquals(validSpacePassword, new Password(validSpacePassword).getPassword());

        // Passwords without spaces are invalid
        assertThrows(IllegalArgumentException.class, () -> new Password("Pass123"));
    }
}