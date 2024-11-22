package modulo_jdbc.db;

public class DbIntegrityConstraintViolationException extends RuntimeException{

    public DbIntegrityConstraintViolationException(String message) {
        super(message);
    }
}
