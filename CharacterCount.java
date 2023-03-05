import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class CharacterCount {
    public static int count=0;
    public static int classCount;
    public static LinkedHashMap<String, String> javaproject = new LinkedHashMap<>();
    public static ArrayList<String> filename = new ArrayList<>();

    public  void CharCount() throws IOException {
        String[] words;
        Path folderToWalk = Paths.get("D:\\Coding_Helper");
        Files.walkFileTree(folderToWalk, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path f, BasicFileAttributes attr) throws IOException {
                        if (f.getFileName().toString().endsWith(".java")) {
                            byte[] p = Files.readAllBytes(f);
                            String string = new String(p, StandardCharsets.UTF_8).trim();

                            for(int i = 0; i < string.length(); i++) {
                                if(string.charAt(i) != ' ')
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

        CharacterCount c=new CharacterCount();
        c.CharCount();
    }

}