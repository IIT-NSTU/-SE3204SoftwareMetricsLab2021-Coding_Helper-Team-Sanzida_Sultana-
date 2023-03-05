import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedHashMap;

public class JavaFileCount {
    public static int count;

    public static void FileCount() throws IOException {
        Path folderToWalk = Paths.get("D:\\Coding_Helper");
        Files.walkFileTree(folderToWalk, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path f, BasicFileAttributes attr) throws IOException {
                        if (f.getFileName().toString().endsWith(".java")) {
                              count++;


                        }

                        return FileVisitResult.CONTINUE;
                    }

                }
        );
        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
     JavaFileCount.FileCount();

    }

}