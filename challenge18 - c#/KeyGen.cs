using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


//
//  KeyGen
//  Implemented by the one and only Sammynator!
//
namespace DeggCryptor
{
    class KeyGen
    {
        public static string generateKey()
        {
            // Init the four seed values. 1111 and multiples of it.
            int h1 = 1111;
            int h2 = 2222;
            int h3 = 3333;
            int h4 = 4444;

            // Init variables.
            int a = h1;
            int b = h2;
            int c = h3;
            int d = h4;
            int x = 0;
            int y = 0;

            // 1'000 iterations.
            for (int i = 1; i <= 1000; i++)
            {
                // If c is greater than d, double c and d.
                if (c > d)
                {
                    c *= 2;
                    d *= 2;
                }

                // Calculate new values.
                // a: Take sum of a and b, and c and d. Then, multiply the two values.
                a = (a + b) * (c + d);
                // b: multiply with 3. Using two additions instead of multiplying -> performance booooost!
                b = b + b + b;
                // b = b + b;
                // c, d: Swap c and d 
                c = c + d;
                d = c - d;
                c = c - d;

                // Take last four digits (modulo 10'000),
                a %= 10000;
                b %= 10000;
                c %= 10000;
                d %= 10000;
            }
            // Password: a,b,c and d with "X" in between
            string password = a + "X" + b + "X" + c + "X" + d;
            return password;
        }

    }
}
