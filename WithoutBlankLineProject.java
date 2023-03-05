import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.LinkedHashMap;


    public class WithoutBlankLineProject {
        public static int count=0;

        public  void fileRead() throws IOException {
            Path folderToWalk = Paths.get("D:\\Coding_Helper\\");
            Files.walkFileTree(folderToWalk, new SimpleFileVisitor<Path>() {
                        @Override
                        public FileVisitResult visitFile(Path f, BasicFileAttributes attr) throws IOException {
                            if (f.getFileName().toString().endsWith(".java")) {


                                String filepath=f.getParent().toString().trim() + "\\" + f.getFileName()+"\\";

                                File file=new File(filepath);
                                FileReader fr = new FileReader(file);
                                BufferedReader br = new BufferedReader(fr);
                                br.readLine();
                                LineNumberReader ln = new LineNumberReader(br);

                                while (ln.readLine()!=null)
                                {
                                    count++;
                                }




                            }

                            return FileVisitResult.CONTINUE;
                        }

                    }
            );
            System.out.println("No. of lines = " + count);

        }

        public static void main(String[] args) throws IOException {

            WithoutBlankLineProject blank=new WithoutBlankLineProject();
            blank.fileRead();

        }

    }



