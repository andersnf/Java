/**************************************************************************
*                                                                         *
*     Program Filename:  graph.java                                       *
*     Author          :  John B. Student                                  *
*     Date Written    :  September 25, 2014                               *
*     Purpose         :  To solve today's Graph Theory Problem            *
*     Input from      :  graph.dat                                        *
*     Output to       :  Screen                                           *
*                                                                         *
**************************************************************************/
import java.util.Scanner;
import java.io.*;

public class graph
{

public static void main(String[] args) throws IOException
{
   int[][]   A = new int[10][10], C = new int[10][10], Sum = new int[10][10];
   int[]     Nodes = new int[10];
   int       i, j;
   Scanner   InputFile = new Scanner(new File("graph.dat"));

   for (i = 0; i < 10; i++)
      Nodes[i] = InputFile.nextInt();
   // end for

   for (i = 0; i < 10; i++)
      for (j = 0; j < 10; j++)
         if (Prime(Nodes[i]+Nodes[j]))
            A[i][j] = 1;
         else
            A[i][j] = 0;
         // end if
      // end for
   // end for

   MatrixPrint(A, 10);

   for (i = 0; i < 10; i++)
      for (j = 0; j < 10; j++)
      {
         Sum[i][j] = A[i][j];
         C[i][j] = A[i][j];
      }
      // end for
   // end for

   for (i = 1; i < 10; i++)
   {
      MatrixProduct(C, A, 10);
      MatrixSum(Sum, C, 10);
   }
   // end for

   for (i = 0; i < 10; i++)
      for (j = 0; j < 10; j++)
         if (Sum[i][j] != 0)
            C[i][j] = 1;
         else
            C[i][j] = 0;
         // end if
      // end for
   // end for

   System.out.println();
   MatrixPrint(C, 10);
}
// end function main

/**************************************************************************
*                                                                         *
*     Function Name   :  MatrixPrint                                      *
*     Purpose         :  To print a Matrix                                *
*     Called by       :  Main                                             *
*     Functions Called:  None                                             *
*                                                                         *
**************************************************************************/

public static void MatrixPrint(int[][] a, int size)
{
   int i, j;

   for (i = 0; i < size; i++)
   {
      for (j = 0; j < size; j++)
         System.out.format("%3d", a[i][j]);
      // end for

      System.out.println();
   }
   // end for

   return;
}
// end public method MatrixPrint

/**************************************************************************
*                                                                         *
*     Function Name   :  MatrixProduct                                    *
*     Purpose         :  To multiply two square matrices                  *
*     Called by       :  Main                                             *
*     Functions Called:  None                                             *
*                                                                         *
**************************************************************************/

public static void MatrixProduct(int[][] a, int[][] b, int size)
{
   int[][] product = new int[size][size];
   int i, j, k;

   for (i = 0; i < size; i++)
      for (j = 0; j < size; j++)
      {
         product[i][j] = 0;

         for (k = 0; k < size; k++)
            product[i][j] = product[i][j] + a[i][k]*b[k][j];
         // end for
      }
      // end for
   // end for

   for (i = 0; i < size; i++)
      for (j = 0; j < size; j++)
         a[i][j] = product[i][j];
      // end for
   // end for

   return;
}
// end public method MatrixProduct

/**************************************************************************
*                                                                         *
*     Function Name   :  MatrixSum                                        *
*     Purpose         :  To add two square matrices                       *
*     Called by       :  Main                                             *
*     Functions Called:  None                                             *
*                                                                         *
**************************************************************************/

public static void MatrixSum(int[][] a, int[][] b, int size)
{
   int  i, j;

   for (i = 0; i < size; i++)
      for (j = 0; j < size; j++)
         a[i][j] = a[i][j] + b[i][j];
      // end for
   // end for

   return;
}
// end public method MatrixSum

/**************************************************************************
*                                                                         *
*     Function Name   :  Prime                                            *
*     Purpose         :  To determine if an integer parameter is prime    *
*     Called by       :  Main                                             *
*     Functions Called:  None                                             *
*                                                                         *
**************************************************************************/

public static boolean Prime(int X)
{
   int j, Limit;

   if (X == 1 || X == 2 || X == 3)
      return true;
   // end if

   if (X%2 == 0)
      return false;
   // end if

   Limit = (int) Math.sqrt(X);

   for (j = 3; j <= Limit; j = j+2)
      if (X%j == 0)
         return false;
      // end if
   // end for

   return true;
}
// end public method Prime

}
// end class graph
