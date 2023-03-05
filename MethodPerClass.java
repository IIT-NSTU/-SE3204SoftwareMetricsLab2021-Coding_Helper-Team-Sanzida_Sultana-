import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MethodPerClass {
    public static int Methodcount;
    public static int ClassCount;
    public  void MethodPerClass() throws IOException {
        Path folderToWalk = Paths.get("D:\\Coding_Helper");

        Files.walkFileTree(folderToWalk, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path f, BasicFileAttributes attr) throws IOException {
                        if (f.getFileName().toString().endsWith(".java")) {

                            byte[] p = Files.readAllBytes(f);
                            String fileContent = new String(p, StandardCharsets.UTF_8).trim();
                            Scanner scan = new Scanner(fileContent);
                            String file = scan.useDelimiter("\\Z").next().trim();


                            String pattern = "(public|void|protected|private|static|final|public static|private static|protected static|public final|private final|protective final)+\\s*(\\<.*\\>)*\\s*[a-zA-Z]*\\s*\\b([_$a-zA-Z1-9]+)\\b\\s*\\(.*\\)\\s*[^;].*?$";
                            Matcher methodMatcher = Pattern.compile(pattern, Pattern.MULTILINE).matcher(file);
                            while (methodMatcher.find()) {

                                Methodcount++;
                            }

                            String s = new String(p, StandardCharsets.UTF_8).trim();
                            Pattern classpattern = Pattern.compile("class\\s+([a-zA-Z]+).*");
                            Matcher classMatcher = classpattern.matcher(s);
                            while (classMatcher.find()) {
                                String className = classMatcher.group(1);
                                ClassCount++;
                            }

                        }

                        return FileVisitResult.CONTINUE;
                    }

                }
        );

        double methodPerClass=100*ClassCount/(double)(Methodcount);
        System.out.println( methodPerClass+"%");

    }
    public static void main(String[] args) throws IOException {

        MethodPerClass c=new MethodPerClass();
         c.MethodPerClass();
    }




}