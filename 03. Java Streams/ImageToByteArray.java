import java.io.*;

public class ImageToByteArray {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.jpg");
            FileInputStream fis = new FileInputStream(inputFile);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            byte[] imageBytes = baos.toByteArray();
            fis.close();
            baos.close();

            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream("output.jpg");
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            bais.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}