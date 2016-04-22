/**************************************************************************
*                                                                         *
*     Program Filename:  reverse1.java                                    *
*     Author          :  John B. Student                                  *
*     Date Written    :  August 21, 2014                                  *
*     Purpose         :  To demonstrate the Stack Interface               *
*     Input from      :  keyboard                                         *
*     Output to       :  Screen                                           *
*                                                                         *
**************************************************************************/
import java.util.Scanner;

public class reverse1
{
   public static void main(String[] args)
   {
      Stack   S = new Stack();
      char    SI;
      int     i;
      String  InputString;
      Scanner Keyboard = new Scanner(System.in);

      System.out.print("Please enter a character string: ");
      InputString = Keyboard.nextLine();

      S.MakeEmpty();

      for (i = 0; i < InputString.length(); i++)
      {
         SI = InputString.charAt(i);
         S.PushStack(SI);
      }
      // end for

      while(!S.IsEmpty())
      {
         SI = S.PopStack();
         System.out.print(SI);
      }
      // end while
   }
   // end function main
}
// end class reverse1


