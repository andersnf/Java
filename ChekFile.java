/**************************************************************************
*                                                                         *
*     Program Filename:  ChekFile.java                                    *
*     Author          :  John B. Student                                  *
*     Date Written    :  November 13, 2014                                *
*     Purpose         :  To determine if sorted.dat is indeed sorted      *
*     Input from      :  sorted.dat                                       *
*     Output to       :  Screen                                           *
*                                                                         *
**************************************************************************/
import java.util.Scanner;
import java.io.*;

public class ChekFile
{
   public static void main(String[] args) throws IOException
   {
      Scanner InFile = new Scanner(new File("sorted.dat"));
      int     Current = 0, Previous = -1;
      int     Counter1 = 0, Counter2 = 0;

      while (InFile.hasNext())
      {
         Counter1++;      
         if (Previous > Current)
            Counter2++;
         // end if
         Previous = Current;
         Current = InFile.nextInt();
      }
      // end while

      System.out.println("The number of records in sorted.dat is " + Counter1);
      System.out.println("The number of records out of place is " + Counter2);

      InFile.close();
   }
   // end function main
}
// end class ChekFile
