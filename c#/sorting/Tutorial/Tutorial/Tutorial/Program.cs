using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tutorial
{
    class Program
    {

        // Complete the introTutorial function below.
        static int introTutorial(int V, int[] arr)
        {

            int lf = 0, ri = arr.Length-1;
            int mid = -1;
                
            while (lf <= ri)
            {
                mid = (ri - lf) / 2 + lf;
                if (arr[mid] == V)
                    break;

                else if (arr[mid] < V)
                {
                    lf = mid + 1;
                }

                else
                    ri = mid - 1;
            }

            return mid;
        }
        static void Main(string[] args)
        {
            Console.WriteLine(introTutorial(4, new int[] { 1, 4, 5, 7, 9, 12 }));
            Console.WriteLine(introTutorial(5, new int[] { 1, 4, 5}));
            Console.WriteLine(introTutorial(-10, new int[] { -10, 1, 4, 5, 10, 15, 30, 217}));
            Console.WriteLine(introTutorial(217, new int[] { -10, 1, 4, 5, 10, 15, 30, 217}));
            
        }
    }
}
