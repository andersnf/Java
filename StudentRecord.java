import java.io.*;
import java.util.Scanner;

public class StudentRecord implements Comparable<StudentRecord>
{
   private class CourseRecord
   {
      String SequenceCode;
      char   Grade;
   }
   // end class CourseRecord

   private String         SSNumber;
   private String         LastName;
   private String         FirstName;
   private char           MidInitial;
   private int            NumberOfCourses;
   private CourseRecord[] CourseArray;

   public StudentRecord()
   {
      SSNumber = "";
      LastName = "";
      FirstName = "";
      MidInitial = ' ';
      NumberOfCourses = 0;
      CourseArray = new CourseRecord[50];
      for (int i = 0; i < 50; i++)
         CourseArray[i] = new CourseRecord();
      // end for
   }
   // end constructor

   public int compareTo(StudentRecord S)
   {
      return NumberOfCourses - S.NumberOfCourses;
   }
   // end public method compareTo

   public void ReadNextRecord(Scanner InFile)
   {
      String CurrentRecord;

      CurrentRecord = InFile.nextLine();
      SSNumber = CurrentRecord.substring(0, 9);
      LastName = CurrentRecord.substring(9, 24);
      FirstName = CurrentRecord.substring(24, 34);
      MidInitial = CurrentRecord.charAt(34);
      NumberOfCourses = Integer.parseInt(CurrentRecord.substring(35, 37));
      for (int i = 0; i < NumberOfCourses; i++)
      {
         CourseArray[i].SequenceCode = CurrentRecord.substring(37+7*i, 43+7*i);
         CourseArray[i].Grade = CurrentRecord.charAt(43+7*i);
      }
      // end for
   }
   // end public method ReadNextRecord

   public void WriteRecord(PrintWriter OutFile)
   {
      OutFile.print(SSNumber);
      OutFile.print(LastName);
      OutFile.print(FirstName);
      OutFile.print(MidInitial);
      OutFile.print(NumberOfCourses/10);
      OutFile.print(NumberOfCourses%10);
      for (int i = 0; i < NumberOfCourses; i++)
      {
         OutFile.print(CourseArray[i].SequenceCode);
         OutFile.print(CourseArray[i].Grade);
      }
      // end for
      OutFile.println();
   }
   // end public method WriteRecord

   public String toString()
   {
      String Result = "";

      Result += SSNumber;
      Result += LastName;
      Result += FirstName;
      Result += MidInitial;
      Result += NumberOfCourses/10;
      Result += NumberOfCourses%10;
      for (int i = 0; i < NumberOfCourses; i++)
      {
         Result += CourseArray[i].SequenceCode;
         Result += CourseArray[i].Grade;
      }
      // end for

      return Result;
   }
   // end public method toString
}
// end class StudentRecord
