import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InterfaceCount {
    public static int count;
    public  void TotalClass() throws IOException {
        Path folderToWalk = Paths.get("D:\\Coding_Helper");
        Files.walkFileTree(folderToWalk, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path f, BasicFileAttributes attr) throws IOException {
                        if (f.getFileName().toString().endsWith(".java")) {
                            byte[] p = Files.readAllBytes(f);
                            String s = new String(p, StandardCharsets.UTF_8).trim();
                            Pattern classpattern = Pattern.compile("interface\\s+([a-zA-Z]+).*");
                            Matcher classMatcher = classpattern.matcher(s);
                            while (classMatcher.find()) {
                                String className = classMatcher.group(1);
                                count++;
                            }


                        }

                        return FileVisitResult.CONTINUE;
                    }

                }
        );
        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        InterfaceCount c=new InterfaceCount();
        c.TotalClass();
    }

}