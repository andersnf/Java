/**************************************************************************
*                                                                         *
*     Program Filename:  queuedemo.java                                   *
*     Author          :  John B. Student                                  *
*     Date Written    :  August 26, 2014                                  *
*     Purpose         :  To demonstrate the Queue Interface               *
*     Input from      :  numbers.dat                                      *
*     Output to       :  louie.dat                                        *
*                                                                         *
**************************************************************************/
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.*;

public class queuedemo
{
   public static void main(String[] args) throws IOException
   {
      Queue<Integer> Q1 = new Queue<Integer>(), Q2 = new Queue<Integer>();
      Scanner        InputFile = new Scanner(new File("numbers.dat"));
      PrintWriter    OutputFile = new PrintWriter("louie.dat");
      int            QI;

      while(InputFile.hasNext())
      {
         QI = InputFile.nextInt();
         if (QI >= 0)
            Q1.Enqueue(QI);
         else
            Q2.Enqueue(QI);
         // end if
      }
      // end while

      while (!Q1.IsEmpty() || !Q2.IsEmpty())
      {
         if (!Q1.IsEmpty())
	 {
            QI = Q1.Dequeue();
            OutputFile.print(QI);
	 }
         else
            OutputFile.print("     ");
         // end if

         if (!Q2.IsEmpty())
	 {
            QI = Q2.Dequeue();
            OutputFile.println("\t\t" + QI);
	 }
         else
            OutputFile.println();
         // end if
      }
      // end while

      InputFile.close();
      OutputFile.close();
   }
   // end function main
}
// end class queuedemo
