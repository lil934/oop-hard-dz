public class UserValidator {
    public static boolean validateEmail(String email, long id) {
        if (email == null || !email.contains("@")) {
            throw new InvalidUserParamsException(id, "Email некорректен");
        }
        return true;
    }

    public static boolean validateFullName(String fullName, long id) {
        if (fullName.isEmpty()) {
            throw new InvalidUserParamsException(id, "fullName пустой");
        }
        return true;
    }
}