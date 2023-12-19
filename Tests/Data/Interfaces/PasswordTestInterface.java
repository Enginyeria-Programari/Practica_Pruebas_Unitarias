package Data.Interfaces;

public interface PasswordTestInterface {
    void getPasswordTest();

    void nullPasswordTest();

    void passwordWithLessThanEightCharactersTest();

    void passwordWithEightCharactersTest();

    void passwordWithUpperCaseOnlyTest();

    void passwordWithLowerCaseOnlyTest();

    void passwordWithSpecialCharactersTest();

    void passwordWithSpaceTest();
}
