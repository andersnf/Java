/**************************************************************************
*                                                                         *
*     Program Filename:  Student5.java                                    *
*     Author          :  John B. Student                                  *
*     Date Written    :  November 20, 2014                                *
*     Purpose         :  To build and profile a binary search tree        *
*     Input from      :  Keyboard and a file to be named at the keyboard  *
*     Output to       :  Screen                                           *
*                                                                         *
**************************************************************************/
import java.util.Scanner;
import java.io.*;

public class Student5
{
public static class TreeNode
{
   TreeNode LeftLink;
   int      Content;
   TreeNode RightLink;
}
// end class TreeNode

public static void main(String[] args) throws IOException
{
   TreeNode T = null;
   int      H, i;

   T = BuildSearchTree();

   H = Height(T);
   System.out.println("The number of nodes on the tree is " + NodeCount(T));
   System.out.println("The height of the tree is " + H);
   for (i = 0; i <= H; i++)
      System.out.println("The number of nodes on level " + i + " is " + CountLevel(T,i));
   // end for
}
// end main method

/*********************************************************************
*                                                                    *
*     Method Name     :  Height                                      *
*     Purpose         :  To return the height of a BST               *
*     Called by       :  Main Method                                 *
*     Methods Called  :  None                                        *
*                                                                    *
*********************************************************************/
public static int Height(TreeNode T)
{
   if (T == null)
      return -1;
   // end if

   int LeftHeight = -1, RightHeight = -1;

   if (T.LeftLink != null)
      LeftHeight = Height(T.LeftLink);
   // end if

   if (T.RightLink != null)
      RightHeight = Height(T.RightLink);
   // end if

   if (LeftHeight > RightHeight)
      return LeftHeight + 1;
   else
      return RightHeight + 1;
   // end if
}
// end method Height

/*********************************************************************
*                                                                    *
*     Method Name     :  NodeCount                                   *
*     Purpose         :  To return the number of nodes on a BST      *
*     Called by       :  Main Method                                 *
*     Methods Called  :  None                                        *
*                                                                    *
*********************************************************************/
public static int NodeCount(TreeNode T)
{
   if (T == null)
      return 0;
   // end if

   return (NodeCount(T.LeftLink) + NodeCount(T.RightLink) + 1);
}
// end method NodeCount

/*********************************************************************
*                                                                    *
*     Method Name     :  CountLevel                                  *
*     Purpose         :  To return the number of nodes on level N    *
*     Called by       :  Main Method                                 *
*     Methods Called  :  None                                        *
*                                                                    *
*********************************************************************/
public static int CountLevel(TreeNode T, int N)
{
   if (T == null)
      return 0;
   // end if

   if (N == 0)
      return 1;
   else
      return CountLevel(T.LeftLink, N-1) + CountLevel(T.RightLink, N-1);
   // end if
}
// end method CountLevel

/*********************************************************************
*                                                                    *
*     Method Name     :  BuildSearchTree                             *
*     Purpose         :  To build a binary search tree               *
*     Called by       :  Main Method                                 *
*     Methods Called  :  None                                        *
*                                                                    *
*********************************************************************/
public static TreeNode BuildSearchTree() throws IOException
{
   TreeNode  T = null;

   // I left out a few things here for you to do!!

   return T;
}
// end method BuildSearchTree

}
// end class Student5
