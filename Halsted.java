import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.*;

public class Halsted {
    public static String REGEX = "^[A-za-z_$]{1,}[A-za-z0-9_$]{0,}(.java)$";
    public static String NAMING = "[=(.\s]*[A-za-z_$]{1,}[A-za-z0-9_$]{0,}[=\s;)]*$";

    static String []opers={"=", "+=" ,"-=", "*=", "/=" ,"%=", "&=" ,"^=" ,"|=" ,"<<=" ,">>=", ">>>=" ,"?" ,":" ,"||" ,"&&", "|" ,"^" ,"&" 	,"==" ,"!=", "<" ,">" ,"<=" ,">=" ,"<<" ,">>" ,">>>" ,"+" ,"-" 	,"*" ,"/" ,"%", "~", "!"};

    static List<String> operators= Arrays.asList(opers);
    static int operatorsCount=0;
    static int operandCount=0;
    static List<String> operatorList;
    public static int[] listFilesForFolder(final File folder) throws FileNotFoundException {
        operatorList = new ArrayList<>();
        List<String> operandList= new ArrayList<>();
        int []counts= new int[4];

        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                if(fileEntry.getName().matches(REGEX)){
                    File f= new File(fileEntry.getPath());
                    Scanner collect=new Scanner(f);
                    while(collect.hasNext()){

                        String str=collect.next();
                        for(String oprs: operators){
                            // System.out.println(str);
                            if(str.contains(oprs)){
                                operatorList.add(oprs);

                                operatorsCount+=1;
                            }
                        }

                    }
                }

            }
        }
        counts[0]=new HashSet<String>(operatorList).size();
        counts[1]=0;
        counts[2]=operatorsCount;
        counts[3]=operandCount;
        return counts;
    }


}

class Main{
    public static void main(String[] args) throws FileNotFoundException {

        final File folder = new File("D:\\Coding_Helper\\");
        //listFilesForFolder(folder);
        int arr[]=Halsted.listFilesForFolder(folder);
        System.out.println("Unique Operators: "+arr[0]);
        System.out.println("Total Operators: "+arr[2]);
        System.out.println(arr[1]);

    }
}
