/**************************************************************************
*                                                                         *
*     Program Filename:  fivers2.java                                     *
*     Author          :  John B. Student                                  *
*     Date Written    :  October 28, 2014                                 *
*     Purpose         :  To create a graph of 5-letter words              *
*     Input from      :  fivers.dat                                       *
*     Output to       :  screen                                           *
*                                                                         *
**************************************************************************/
import java.util.Scanner;
import java.io.*;

public class fivers2
{

public static class ListNode
{
   int       Vertex;
   ListNode  Link;
}
// end class ListNode

static int UnSeen = -1;
static int id = 0;

public static void main(String[] args) throws IOException
{
   Scanner     InFile = new Scanner(new File("fivers.dat"));
   String[]    WordArray = new String[8550];
   ListNode[]  AdjacencyList = new ListNode[8550];

   ReadAllTheWords(InFile, WordArray);
   BuildAdjacencyList(WordArray, AdjacencyList);
   QuestionOne(AdjacencyList);
   QuestionTwo(AdjacencyList, WordArray);
   BFSearch(WordArray, AdjacencyList);
}
// end main method

/**************************************************************************
*                                                                         *
*     Method Name     :  ReadAllTheWords                                  *
*     Purpose         :  Read all 5-letter words into an array            *
*     Called by       :  Main                                             *
*     Methods Called  :  None                                             *
*                                                                         *
**************************************************************************/

public static void ReadAllTheWords(Scanner InFile, String[] WordArray) throws IOException
{
   int i = 0;

   while (InFile.hasNext())
      WordArray[i++] = InFile.next();
   // end while
   InFile.close();
}
// end method ReadAllTheWords

/**************************************************************************
*                                                                         *
*     Method Name     :  BuildAdjacencyList                               *
*     Purpose         :  Build adjacency list for an 8550-node graph      *
*     Called by       :  Main                                             *
*     Methods Called  :  Insert, WordsAreAdjacent                         *
*                                                                         *
**************************************************************************/

public static void BuildAdjacencyList(String[] WordArray, ListNode[] AdjacencyList)
{
   int i, j;

   for (i = 0; i < 8550; i++)
      AdjacencyList[i] = null;
   // end for
      
   for (i = 0; i < 8550; i++)
      for (j = i+1; j < 8550; j++)
         if (WordsAreAdjacent(WordArray[i], WordArray[j]))
         {
            Insert(AdjacencyList, i, j);
            Insert(AdjacencyList, j, i);
         }
         // end if
      // end for
   // end for
}
// end method BuildAdjacencyList

/**************************************************************************
*                                                                         *
*     Method Name     :  WordsAreAdjacent                                 *
*     Purpose         :  To determine if two words are adjacent           *
*     Called by       :  BuildAdjacencyList                               *
*     Methods Called  :  None                                             *
*                                                                         *
**************************************************************************/

public static boolean WordsAreAdjacent(String X, String Y)
{
   int i, Counter=0;

   for (i = 0; i < 5; i++)
      if (X.charAt(i) == Y.charAt(i))
         Counter++;
      // end if
   // end for

   if (Counter == 4)
      return true;
   else
      return false;
   // end if
}
// end method WordsAreAdjacent

/**************************************************************************
*                                                                         *
*     Method Name     :  Insert                                           *
*     Purpose         :  To insert a ListNode to a List                   *
*     Called by       :  BuildAdjacencyList                               *
*     Methods Called  :  None                                             *
*                                                                         *
**************************************************************************/

public static void Insert(ListNode[] L, int i, int j)
{
   ListNode Temp;

   Temp        = new ListNode();
   Temp.Link   = L[i];
   Temp.Vertex = j;
   L[i]        = Temp;
   
   return;
}
// end method Insert

/**************************************************************************
*                                                                         *
*     Method Name     :  BFSearch                                         *
*     Purpose         :  To traverse the nodes of a graph                 *
*     Called by       :  Main                                             *
*     Methods Called  :  Visit, QuestionThree, QuestionFour, QuestionFive *
*                                                                         *
**************************************************************************/

public static void BFSearch(String[] WordArray, ListNode[] AdjacencyList)
{
   int i;
   int[] Val = new int[8550];

   for (i = 0; i < 8550; i++)
      Val[i] = UnSeen;
   // end for

   for (i = 0; i < 8550; i++)
      if (Val[i] == UnSeen)
         Visit(AdjacencyList, Val, i);
      // end if
   // end for

   QuestionThree(WordArray, Val);
   QuestionFour(Val);
   QuestionFive(Val);
}
// end method BFSearch

/**************************************************************************
*                                                                         *
*     Method Name     :  Visit                                            *
*     Purpose         :  To visit the nodes of a connected component      *
*     Called by       :  BFSearch                                         *
*     Methods Called  :  None                                             *
*                                                                         *
**************************************************************************/

public static void Visit(ListNode[] AdjacencyList, int[] Val, int i)
{
   ListNode t;
   Queue<Integer> Q = new Queue<Integer>();

   Q.MakeEmpty();
   Q.Enqueue(i);

   while (!Q.IsEmpty())
   {
      i = Q.Dequeue();
      Val[i] = id;

      t = AdjacencyList[i];
      while (t != null)
      {
         if (Val[t.Vertex] == UnSeen)
         {
            Q.Enqueue(t.Vertex);
            Val[t.Vertex] = -2;
         }
         // end if
         t = t.Link;
      }
      // end while
   }
   // end while

   id++;
   return;
}
// end method Visit

/**************************************************************************
*                                                                         *
*     Function Name   :  QuestionOne                                      *
*     Purpose         :  To answer the first homework question            *
*     Called by       :  Main                                             *
*     Functions Called:  None                                             *
*                                                                         *
**************************************************************************/

public static void QuestionOne(ListNode[] AdjacencyList)
{
   int Counter=0, i;

   for (i = 0; i < 8550; i++)
      if (AdjacencyList[i] == null)
         Counter++;
      // end if
   // end for

   System.out.println("The number of isolated 5-letter words: " + Counter);
   return;
}
// end method QuestionOne

/**************************************************************************
*                                                                         *
*     Function Name   :  QuestionTwo                                      *
*     Purpose         :  To answer the second homework question           *
*     Called by       :  Main                                             *
*     Functions Called:  None                                             *
*                                                                         *
**************************************************************************/

public static void QuestionTwo(ListNode[] AdjacencyList, String[] WordArray)
{
   ListNode t;
   int i, Counter=0;

   for (i = 0; i < 8550; i++)
      if (WordArray[i].equals("APPLE"))
         break;
      // end if
   // end for

   t = AdjacencyList[i];
   while (t != null)
   {
      Counter++;
      t = t.Link;
   }
   // end while

   System.out.println("The number of 5-letter words adjacent to APPLE: " + Counter);
   return;
}
// end method QuestionTwo

/**************************************************************************
*                                                                         *
*     Function Name   :  QuestionThree                                    *
*     Purpose         :  To answer the third homework question            *
*     Called by       :  BFSearch                                         *
*     Functions Called:  None                                             *
*                                                                         *
**************************************************************************/

public static void QuestionThree(String[] WordArray, int[] Val)
{
   int i, j, Counter=0;

   for (i = 0; i < 8550; i++)
      if (WordArray[i].equals("APPLE"))
         break;
      // end if
   // end for

   for (j = 0; j < 8550; j++)
      if (Val[i] == Val[j])
         Counter++;
      // end if
   // end for


   System.out.println("The number of 5-letter words connected to APPLE: " + Counter);
   return;
}
// end method QuestionThree

/**************************************************************************
*                                                                         *
*     Function Name   :  QuestionFour                                     *
*     Purpose         :  To answer the fourth homework question           *
*     Called by       :  BFSearch                                         *
*     Functions Called:  None                                             *
*                                                                         *
**************************************************************************/

public static void QuestionFour(int[] Val)
{
   int i, Max = -1;

   for (i = 0; i < 8550; i++)
      if (Max < Val[i])
         Max = Val[i];
      // end if
   // end for

   System.out.println("The number of connected components is: " + (Max+1));
   return;
}
// end method QuestionFour

/**************************************************************************
*                                                                         *
*     Function Name   :  QuestionFive                                     *
*     Purpose         :  To answer the fifth homework question            *
*     Called by       :  BFSearch                                         *
*     Functions Called:  None                                             *
*                                                                         *
**************************************************************************/

public static void QuestionFive(int[] Val)
{
   int i, Max = -1;
   int[] Components = new int[909];

   for (i = 0; i < 8550; i++)
      Components[Val[i]]++;
   // end for

   for (i = 0; i < 909; i++)
      if (Max < Components[i])
         Max = Components[i];
      // end if
   // end for

   System.out.println("The size of the largest component is: " + Max);
   return;
}
// end method QuestionFive

}
// end class fivers2
