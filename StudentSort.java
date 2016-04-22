/**************************************************************************
*                                                                         *
*     Program Filename:  StudentSort.java                                 *
*     Author          :  John B. Student                                  *
*     Date Written    :  September 16, 2014                               *
*     Purpose         :  Using a Priority Queue to sort Student Records   *
*     Input from      :  students.dat                                     *
*     Output to       :  sorted.dat                                       *
*                                                                         *
**************************************************************************/
import java.util.Scanner;
import java.io.*;

public class StudentSort
{
   public static void main(String[] args) throws IOException
   {
      PriorityQueue  P = new PriorityQueue();
      Scanner        InputFile = new Scanner(new File("students.dat"));
      PrintWriter    OutputFile = new PrintWriter("sorted.dat");
      StudentRecord  S;

      while(InputFile.hasNext())
      {
         S = new StudentRecord();
         S.ReadNextRecord(InputFile);
         P.Insert(S);
      }
      // end while

      while (!P.IsEmpty())
      {
         S = (StudentRecord) P.Remove();
         S.WriteRecord(OutputFile);
         System.out.println(S);
      }
      // end while
                              
      InputFile.close();
      OutputFile.close();
   }
   // end function main
}
// end class StudentSort
