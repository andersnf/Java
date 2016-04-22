/**************************************************************************
*                                                                         *
*     Program Filename:  TestNewMethods.java                              *
*     Author          :  John B. Student                                  *
*     Date Written    :  September 2, 2014                                *
*     Purpose         :  To test the 2 new methods in the Queue class     *
*     Input from      :  keyboard                                         *
*     Output to       :  screen                                           *
*                                                                         *
**************************************************************************/
import java.util.Scanner;

public class TestNewMethods
{
   public static void main(String[] args)
   {
      Queue<Integer> Q1 = new Queue<Integer>(), Q2 = new Queue<Integer>();
      Scanner        Keyboard = new Scanner(System.in);
      int            i, Length1, Length2;

      System.out.print("Enter the length of the first queue: ");
      Length1 = Keyboard.nextInt();
      System.out.print("Enter the length of the second queue: ");
      Length2 = Keyboard.nextInt();

      for (i = 1; i <= Length1; i++)
         Q1.Enqueue(i);
      // end for

      for (i = 1; i <= Length2; i++)
         Q2.Enqueue(i);
      // end for

      Q1.Equalize(Q2);
      Q1.SwitchEnds();
      Q2.SwitchEnds();

      System.out.println("The length of Q1 is " + Q1.LengthQueue() + '.');
      System.out.println("The length of Q2 is " + Q2.LengthQueue() + '.');

      while (!Q1.IsEmpty() || !Q2.IsEmpty())
      {
         if (!Q1.IsEmpty())
	 {
            i = Q1.Dequeue();
            System.out.print(i);
	 }
         else
            System.out.print("     ");
         // end if

         if (!Q2.IsEmpty())
	 {
            i = Q2.Dequeue();
            System.out.println("\t\t" + i);
	 }
         else
            System.out.println();
         // end if
      }
      // end while
   }
   // end function main
}
// end class TestNewMethods
