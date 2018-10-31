using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InsertionSort1
{
    class Program
    {
        // Complete the insertionSort1 function below.
        static void insertionSort1(int n, int[] arr)
        {
            int target = arr[n-1];
            bool flag = true;
            for (int i = n-1; i > 0; i--)
            {
                if (target < arr[i - 1])
                {
                    arr[i] = arr[i-1];
                    for(int j=0; j<n; j++) 
                    {
                        Console.Write(String.Format(j == 0 ? "{0}" : " {0}", arr[j]));
                    }
                    Console.WriteLine("");
                }
                else
                {
                    arr[i] = target;
                    for (int j = 0; j < n; j++)
                    {
                        Console.Write(String.Format(j == 0 ? "{0}" : " {0}", arr[j]));
                    }
                    break;
                }
            }

            if (flag)
            {
                arr[0] = target;
                for (int j = 0; j < n; j++)
                {
                    Console.Write(String.Format(j == 0 ? "{0}" : " {0}", arr[j]));
                }
            }

        }

        static void Main(string[] args)
        {
            //insertionSort1(5, new int[] { 1, 2, 4, 5, 3 });
            //insertionSort1(5, new int[] { 2, 4, 6, 8, 3 });
            insertionSort1(10, new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 10, 1});

        }
    }
}
