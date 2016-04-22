/**************************************************************************
*                                                                         *
*     Program Filename:  reverse2.java                                    *
*     Purpose         :  To demonstrate the Stack Interface               *
*     Input from      :  keyboard                                         *
*     Output to       :  Screen                                           *
*                                                                         *
**************************************************************************/
import java.util.Scanner;

public class reverse2
{
   public static void main(String[] args)
   {
      Stack2<Character>  S = new Stack2<Character>();
      char      SI;
      int       i;
      String    InputString;
      Scanner   Keyboard = new Scanner(System.in);

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
// end class reverse2


