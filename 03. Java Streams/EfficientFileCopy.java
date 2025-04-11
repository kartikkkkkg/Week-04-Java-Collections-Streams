import java.io.*;

public class EfficientFileCopy {
    public static void main(String[] args) {
        try {
            long startTime = System.nanoTime();
            copyWithBufferedStreams("source.txt", "dest_buffered.txt");
            long bufferedTime = System.nanoTime() - startTime;
            System.out.println("Buffered Streams Time: " + bufferedTime + " ns");

            startTime = System.nanoTime();
            copyWithNormalStreams("source.txt", "dest_normal.txt");
            long normalTime = System.nanoTime() - startTime;
            System.out.println("Normal Streams Time: " + normalTime + " ns");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyWithBufferedStreams(String src, String dest) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        }
    }

    private static void copyWithNormalStreams(String src, String dest) throws IOException {
        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}