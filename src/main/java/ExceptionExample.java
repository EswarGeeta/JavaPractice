import java.sql.SQLException;
import java.util.Optional;

public class ExceptionExample {

    public void exceptionThrowingMethod() {
        throw new NullPointerException();
    }

    public static void main(String[] args) {
        Optional<String> optionalString = Optional.of("sample");
        if(optionalString.isPresent())
            System.out.println(optionalString.get());
        try {
            throw new StackOverflowError();
        }
        catch(Error e){
            System.out.println("Coming here");
            e.printStackTrace();
        }
        finally {
            System.out.println("In final block");
        }
        System.out.println("I am here after final block");
    }
}
