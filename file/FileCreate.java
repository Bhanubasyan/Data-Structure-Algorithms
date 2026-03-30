import java.io.*;
import java.io.IOException;

class FileCreate {
  public static void main(String[] args) {
    try {
      File obj = new File("C:\\Users\\Bhanu\\javaCode\\file\\FileWrite.java");

      if (obj.createNewFile()) {
        System.out.println("File created: " + obj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    try {
      FileWriter write = new FileWriter("C:\\Users\\Bhanu\\javaCode\\file\\FileWrite.java");
      write.write("import java.io.FileWriter;   // Import the FileWriter class\r\n" + //
          "import java.io.IOException;  // Import the IOException class\r\n" + //
          "\r\n" + //
          "public class WriteToFile {\r\n" + //
          "  public static void main(String[] args) {\r\n" + //
          "    try {\r\n" + //
          "      FileWriter myWriter = new FileWriter(\"filename.txt\");\r\n" + //
          "      myWriter.write(\"Files in Java might be tricky, but it is fun enough!\");\r\n" + //
          "      myWriter.close();  // must close manually\r\n" + //
          "      System.out.println(\"Successfully wrote to the file.\");\r\n" + //
          "    } catch (IOException e) {\r\n" + //
          "      System.out.println(\"An error occurred.\");\r\n" + //
          "      e.printStackTrace();\r\n" + //
          "    }\r\n" + //
          "  }\r\n" + //
          "}");
      write.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}