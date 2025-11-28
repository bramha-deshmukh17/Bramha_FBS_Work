package Classwork.customException;

class InvalidUsernameException extends Exception {

    @Override
    public String toString() {
        return "Invalid Username!";
    }
}

class InvalidPasswordException extends Exception {

    @Override
    public String toString() {
        return "Incorrect Password!";
    }
}
