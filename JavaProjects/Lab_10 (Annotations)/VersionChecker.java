import java.lang.reflect.Method;

public class VersionChecker {
    public static void main(String[] args) {
        Method[] methods = Software.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Version.class)) {
                Version annotation = method.getAnnotation(Version.class);
                System.out.println("Method: " + method.getName() + ", Version: " + annotation.version_number() + ", Author: " + annotation.author_name());
            }
        }
    }
}
