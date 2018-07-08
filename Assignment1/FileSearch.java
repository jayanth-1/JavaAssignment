import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FileSearch{

public void searchingFiles(String directoryName,String pattern){
  try{
        File directory = new File(directoryName);      // creating file class
        //get all the files from a directory
        File[] fList = directory.listFiles();
        
        for (File file : fList){
            if (file.isFile()){
              Pattern  expression = Pattern.compile(pattern);
              // Now create matcher object.
              Matcher match = expression.matcher(file.getName());   // matching file name with pattern
              if(match.matches()){                         // if matches
                                      
               System.out.println(file.getAbsolutePath()); // printing absolute path
             }
             }
             else if (file.isDirectory()){
                searchingFiles(file.getAbsolutePath(),pattern); // recursivley searching files directories & subdirectories
            }
        }
        

     } 

  catch(Exception e)
   {
     System.out.println("Check Regular expression it is not valid \n");
   }
}


public static void main(String[] args)
{

String directory_name = "/home/zemoso" ;                // home directory
FileSearch obj = new FileSearch();                     // creating object of First class  
while(true) {
 System.out.println("Enter regular expression \n ");    //Taking input from terminal i.e regular expression
 Scanner sc = new Scanner(System.in);  
 String pattern = sc.next();

 obj.searchingFiles(directory_name,pattern);
}


}

}


class TestFileSearch{

  public static void main(String[] args)
  {
    String directory_name = "/home/zemoso" ;  
    List<String> neg_testcase = Arrays.asList("*hello");
    List<String> pos_testcase = Arrays.asList("hello.*", "[a-z]", "[a-zA-Z0-9]");
    
    int i;
    FileSearch obj = new FileSearch();
    System.out.println("Running Positive test case \n\n");
    for(i=0;i<pos_testcase.size();i++)
    {
      System.out.println("test case " + i + " " + pos_testcase.get(i) + "\n");
      obj.searchingFiles(directory_name,pos_testcase.get(i));
      System.out.println("\n");

    }
    
    for(i=0;i<neg_testcase.size();i++)
    {
      System.out.println("test case " + i + " " + neg_testcase.get(i) + "\n");
      obj.searchingFiles(directory_name,neg_testcase.get(i));
    }

  }
}
