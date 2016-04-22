/**************************************************************************
*                                                                         *
*     Program Filename:  Student3.java                                    *
*     Author          :  John B. Student                                  *
*     Date Written    :  October 17, 2014                                 *
*     Purpose         :  To construct Calling Circles                     *
*     Input from      :  keyboard and a file named at keyboard            *
*     Output to       :  screen                                           *
*                                                                         *
**************************************************************************/
import java.util.Scanner;
import java.io.*;

public class Student3
{

public static void main(String[] args) throws IOException
{
   String[] People = new String[25];
   int[][]  A = new int[25][25];
   int      NumberOfNames;
   Scanner  InputFile = null;
   String   FileName = null;

   FileName = PromptUserForNameOfInputFile;
   NumberOfNames = ReadTheFile(FileName, InputFile, People);
   BuildAdjacencyMatrix(A, FileName, InputFile, People);
   BuildConnectivityMatrix(A, NumberOfNames);
   PrintTheCallingCircles(A, People, NumberOfNames);   
   
  
}
// end method main