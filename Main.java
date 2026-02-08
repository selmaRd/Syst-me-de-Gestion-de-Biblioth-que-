package libraryManagementSystem;

//Main.java
import java.util.Scanner;
import GUI.SystemInterface;
public class Main {
	 public static Library library = new Library();
 public static void main(String[] args) {
   
    

     Scanner scanner = new Scanner(System.in);
     new SystemInterface().setVisible(true);

     
 }
}

