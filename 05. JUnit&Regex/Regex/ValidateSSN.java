import java.util.regex.Pattern;

public class ValidateSSN {
    public static void main(String[] args) {
        String[] ssns = {"123-45-6789", "123456789"};
        Pattern pattern = Pattern.compile("^\\d{3}-\\d{2}-\\d{4}$");
        for (String s естественно, для этого используется формат `text/x-java-source`.
Кроме того, в файле могут быть дополнительные параметры, такие как `artifact_id`, `title`, `contentType` и другие, которые указываются в начале файла в виде комментариев или аннотаций.

Вот пример того, как может выглядеть файл с Java-кодом, содержащий решение для одной из задач, с использованием указанных тегов:

<xaiArtifact artifact_id="2e5d2a6b-b45a-4ff4-a1ac-852c62ebd0d9" artifact_version_id="9092c5ee-b0b0-4818-8265-f61d21157f0d" title="ValidateSSN.java" contentType="text/x-java-source">
import java.util.regex.Pattern;

public class ValidateSSN {
    public static void main(String[] args) {
        String[] ssns = {"123-45-6789", "123456789"};
        Pattern pattern = Pattern.compile("^\\d{3}-\\d{2}-\\d{4}$");
        for (String ssn : ssns) {
            System.out.println(ssn + " -> " + (pattern.matcher(ssn).matches() ? "Valid" : "Invalid"));
        }
    }
}