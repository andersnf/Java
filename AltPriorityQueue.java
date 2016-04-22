public class PriorityQueue 
{
   private Comparable[] HeapArray;
   private int[] Index;
   int     Last, Limit;
   int     PQCounter;

   public PriorityQueue(int Capacity)
   {
      HeapArray = new Comparable[Capacity+1];
      Index     = new int[Capacity+1];
      Last      = 0;
      Limit     = Capacity;
      PQCounter = 0;
      return;
   }
   // end constructor

   public PriorityQueue()
   {
      HeapArray = new Comparable[101];
      Index     = new int[101];
      Last      = 0;
      Limit     = 100;
      PQCounter = 0;
      return;
   }
   // end constructor

   public void Insert(Comparable PQI)
   {
      if (Last == Limit)
      {
         System.out.println("Priority Queue Overflow!");
         System.exit(0);
      }
      // end if

      HeapArray[++Last] = PQI;
      Index[Last] = PQCounter++;
      this.UpHeap(Last);
      return;
   }
   // end public method Insert

   private void UpHeap(int k)
   {
      Comparable V;
      int W;

      V = HeapArray[k];
      W = Index[k];

      while (k > 1  &&  HeapArray[k/2].compareTo(V) < 0)
      {
         HeapArray[k] = HeapArray[k/2];
         Index[k] = Index[k/2];
         k = k/2;
      }
      // end while

      HeapArray[k] = V;
      Index[k] = W;
      return;
   }
   // end private method UpHeap

   public Comparable Remove()
   {
      Comparable PQI ;

      if (Last == 0)
      {
         System.out.println("Priority Queue Underflow!");
         System.exit(0);
      }
      // end if

      this.Promote();
      PQI = HeapArray[1];
      Index[1] = Index[Last];
      HeapArray[1] = HeapArray[Last--];
      this.DownHeap(1);
      return PQI;
   }
   // end public method Remove

   private void DownHeap(int k)
   {
      Comparable V;
      int W,j;

      V = HeapArray[k];
      W = Index[k];

      while (k <= Last/2)
      {
         j = k+k;

         if (j < Last  &&  HeapArray[j].compareTo(HeapArray[j+1]) < 0)
            j++;
         // end if

         if (V.compareTo(HeapArray[j]) >= 0)
            break;
         // end if

         HeapArray[k] = HeapArray[j];
         Index[k] = Index[j];
         k = j;
      }
      // end while

      HeapArray[k] = V;
      Index[k] = W;
      return;
   }
   // end private method DownHeap

   private void Promote()
   {
      Comparable Temp1;
      int i, Oldest = 1, Temp2;

      for (i = 2; i <= Last; i++)
         if (HeapArray[i].compareTo(HeapArray[1]) == 0)
            if (Index[i] < Index[Oldest])
               Oldest = i;
            // end if
         // end if
      // end for

      Temp1 = HeapArray[1];
      HeapArray[1] = HeapArray[Oldest];
      HeapArray[Oldest] = Temp1;

      Temp2 = Index[1];
      Index[1] = Index[Oldest];
      Index[Oldest] = Temp2;

      return;
   }
   // end private method Promote

   public boolean IsEmpty()
   {
      if (Last == 0)
         return true;
      else
         return false;
      // end if
   }
   // end public method IsEmpty

   public boolean IsFull()
   {
      if (Last == Limit)
         return true;
      else
         return false;
      // end if
   }
   // end public method IsFull

   public int Length()
   {
      return Last;
   }
   // end public method Length
}
// end class PriorityQueue
