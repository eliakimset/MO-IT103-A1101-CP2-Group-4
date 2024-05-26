package motorphemployee;

import java.io.*;

public class EmployeeData {
   
    public static void main(String [] args){
    
    String path = "/Users/set/Downloads/Employee Data.csv";
    String line = "";
    
    try {
    BufferedReader br = new BufferedReader(new FileReader(path));
    
    
    while((line = br.readLine()) != null) {
        System.out.println(line);
    
    }
   } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}