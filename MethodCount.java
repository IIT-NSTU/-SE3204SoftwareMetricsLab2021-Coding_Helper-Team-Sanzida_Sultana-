import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class MethodCount {
        public static int count;
        public  void TotalMethod() throws IOException {
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

            MethodCount c=new MethodCount();
            c.TotalMethod();
        }

    }

