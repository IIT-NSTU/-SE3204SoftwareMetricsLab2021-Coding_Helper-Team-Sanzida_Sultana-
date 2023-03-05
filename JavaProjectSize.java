import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class JavaProjectSize {
    public static double  length=0;
    public  void ProjectSize() throws IOException {
        Path folderToWalk = Paths.get("D:\\Coding_Helper");
        Files.walkFileTree(folderToWalk, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path f, BasicFileAttributes attr) throws IOException {


String path=f.getParent().toString().trim() + "\\" + f.getFileName();

                        File file=new File(path);
                        if (file.isFile())
                            length += file.length();


                        return FileVisitResult.CONTINUE;
                    }

                }
        );
        System.out.println(length);
    }

    public static void main(String[] args) throws IOException {
      JavaProjectSize s=new JavaProjectSize();
      s.ProjectSize();

    }
}
