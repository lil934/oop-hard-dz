public class InvalidUserParamsException extends RuntimeException {
    public InvalidUserParamsException(long id, String message) {
        super("Ошибка пользователя с ID " + id + ": " + message);
    }
}