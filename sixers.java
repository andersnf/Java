/**************************************************************************
*                                                                         *
*     Program Filename:  sixers.java                                      *
*     Author          :  John B. Student                                  *
*     Date Written    :  November 6, 2014                                 *
*     Purpose         :  To test for connectivity among 6-letter words    *
*     Input from      :  sixers.dat                                       *
*     Output to       :  screen                                           *
*                                                                         *
**************************************************************************/
import java.util.Scanner;
import java.io.*;

public class sixers
{
public static void main(String[] args) throws IOException
{
   int         i=0, j, k, FootPrint=0, Temp;
   Scanner     InFile = new Scanner(new File("sixers.dat"));
   String[]    WordArray = new String[15222];
   int[]       CheckPad = new int[15222];       

   while (InFile.hasNext())
      WordArray[i++] = InFile.next();
   // end while

   for (i = 0; i < 15222; i++)
      CheckPad[i] = -1-i;
   // end for

   for (i = 0; i < 15222; i++)
      for (j = i+1; j < 15222; j++)
         if (WordsAreAdjacent(WordArray[i], WordArray[j]) && CheckPad[i] != CheckPad[j])
            if (CheckPad[i] < 0 && CheckPad[j] < 0)
               CheckPad[i] = CheckPad[j] = FootPrint++;
            else if (CheckPad[i] < 0)
               CheckPad[i] = CheckPad[j];
            else if (CheckPad[j] < 0)
               CheckPad[j] = CheckPad[i];
            else
            {
               Temp = CheckPad[i];
               for (k = 0; k < 15222; k++)
                  if (CheckPad[k] == Temp)
                     CheckPad[k] = CheckPad[j];
                  // end if
               // end for
            }
            // end if
         // end if
      // end for
   // end for

   CheckTwoWords(CheckPad, WordArray);

   InFile.close();
}
// end main method

/**************************************************************************
*                                                                         *
*     Function Name   :  WordsAreAdjacent                                 *
*     Purpose         :  To determine if two words are adjacent           *
*     Called by       :  Main                                             *
*     Functions Called:  None                                             *
*                                                                         *
**************************************************************************/

public static boolean WordsAreAdjacent(String X, String Y)
{
   int i, Counter=0;

   for (i = 0; i < 6; i++)
      if (X.charAt(i) == Y.charAt(i))
         Counter++;
      // end if
   // end for

   if (Counter == 5)
      return true;
   else
      return false;
   // end if
}
// end method WordsAreAdjacent

/**************************************************************************
*                                                                         *
*     Function Name   :  CheckTwoWords                                    *
*     Purpose         :  To determine if two words are connected          *
*     Called by       :  Main                                             *
*     Functions Called:  Index                                            *
*                                                                         *
**************************************************************************/

public static void CheckTwoWords(int[] CheckPad, String[] WordArray)
{
   Scanner Keyboard = new Scanner(System.in);
   String First, Second;

   System.out.print("Please enter a six-letter word: ");
   First = Keyboard.nextLine().toUpperCase();
   System.out.print("Please enter another six-letter word: ");
   Second = Keyboard.nextLine().toUpperCase();

   if (CheckPad[Index(First, WordArray)] == CheckPad[Index(Second, WordArray)])
      System.out.println("These two words are connected.");
   else
      System.out.println("These two words are not connected.");
   // end if

   return;
}
// end method CheckTwoWords

/**************************************************************************
*                                                                         *
*     Function Name   :  Index                                            *
*     Purpose         :  To return the position of a word in WordArray    *
*     Called by       :  CheckTwoWords                                    *
*     Functions Called:  None                                             *
*                                                                         *
**************************************************************************/

public static int Index(String S, String[] WordArray)
{
   for (int i = 0; i < 15222; i++)
      if (S.equals(WordArray[i]))
         return i;
      // end if
   // end for

   return -1;
}
// end method Index

}
// end class sixers
