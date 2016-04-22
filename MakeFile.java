/**************************************************************************
*                                                                         *
*     Program Filename:  MakeFile.java                                    *
*     Author          :  John B. Student                                  *
*     Date Written    :  November 13, 2014                                *
*     Purpose         :  To create a large unsorted file                  *
*     Input from      :  none                                             *
*     Output to       :  unsorted.dat                                     *
*                                                                         *
**************************************************************************/
import java.io.*;

public class MakeFile
{
   public static void main(String[] args) throws IOException
   {
      PrintWriter OutFile = new PrintWriter(new File("unsorted.dat"));
      int Number;

      for (int i = 1; i <= 1000000; i++)
      {
         Number = (int) (Math.random()*1000000);
         OutFile.println(Number);
      }
      // end for

      OutFile.close();
   }
   // end function main
}
// end class MakeFile
