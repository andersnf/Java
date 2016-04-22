/**************************************************************************
*                                                                         *
*     Program Filename:  Student4.java                                    *
*     Author          :  John B. Student                                  *
*     Date Written    :  November 9, 2014                                 *
*     Purpose         :  To find the MST for Louie's Airline              *
*     Input from      :  Keyboard and file to be named at the keyboard    *
*     Output to       :  Screen                                           *
*                                                                         *
**************************************************************************/
import java.util.Scanner;
import java.io.*;

public class Student4
{
public static void main(String[] args) throws IOException
{
   Scanner   Keyboard = new Scanner(System.in);
   Scanner   InputFile;
   String[]  Cities = new String[50];
   int       i, N;

   System.out.println("Please enter the name of the input file:");
   System.out.print("(include path if not in the current folder)");
   InputFile = new Scanner(new File(Keyboard.nextLine()));

   N = InputFile.nextInt();

   for (i = 0; i < N; i++)
      Cities[i] = InputFile.next();
   // end for

   BuildMinimalSpanningTree(N, Cities, InputFile);
}
// end main method
