import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class CodeWithoutBlankLine {
    public static int length;
    public static int classCount;
    public static LinkedHashMap<String, String> javaproject = new LinkedHashMap<>();
    public static ArrayList<String> filename = new ArrayList<>();

    public  void fileRead() throws IOException {
        Path folderToWalk = Paths.get("D:\\Coding_Helper");
        Files.walkFileTree(folderToWalk, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path f, BasicFileAttributes attr) throws IOException {

                            length +=attr.size();
                            byte[] p = Files.readAllBytes(f);
                            String s = new String(p, StandardCharsets.UTF_8).trim();
                            String dir = f.getParent().toString().substring(f.getParent().toString().lastIndexOf(File.separator) + 1);
                            filename.add(f.getParent().toString().trim() + "\\" + f.getFileName());
                            String fileNamewithPackage = dir + "$" + f.getFileName().toString(); //packagename$filename.java
                            //   System.out.println("name="+f.getFileName());
                            javaproject.put(fileNamewithPackage, s);



                        return FileVisitResult.CONTINUE;
                    }

                }
        );
        System.out.println(length);
    }

    public static void main(String[] args) throws IOException {
        CodeWithoutBlankLine size=new CodeWithoutBlankLine();
        size.fileRead();

    }

}