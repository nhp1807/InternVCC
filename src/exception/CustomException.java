package exception;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String str) {
        // calling the constructor of parent Exception
        super(str);
    }
}

public class CustomException {
    // method to check the age
    static void validate(int age) throws InvalidAgeException {
        if (age < 18) {
            // throw an object of user defined exception
            throw new InvalidAgeException("Too young!");
        } else {
            System.out.println("Valid!");
        }
    }

    // main method
    public static void main(String args[]) {
        try {
            // calling the method
            validate(17);
        } catch (InvalidAgeException ex) {
            System.out.println("Caught the exception");

            // printing the message from InvalidAgeException object
            System.out.println("Exception occured: " + ex);
        }

        System.out.println("...");
    }
}
