/******************************  Sichtbarkeit.java  ********************/
package de.uos.rt.exercise._5;

/**
 * Hier geht es um die Sichtbarkeit von Variablen
 */

public class Sichtbarkeit {

    static int a;

    public static void main(String argv[]) {

        int a = 6;
        int [] c = {38, 12, 2, 6};

        /*** Stelle 1 ***/

        initialize();

        /*** Stelle 3 ***/

        for (int b = 0; b < 1; b++) {

            /*** Stelle 4 ***/
            a /= 3;
            c[b+1] -= c[b+2];
        }

        /*** Stelle 5 ***/

        int b = method1(a + c[a-2]);

        /*** Stelle 7 ***/

        for (a = 3; a < 5; a += 2) {

            b = 2;
            c[a] -= c[b];

            /*** Stelle 8***/
        }

        /*** Stelle 9 ***/

        b = 7 + method2(++a, c);

        /*** Stelle 11 ***/

        a = method1(method2(method1(a), c));

        /*** Stelle 15 ***/
        System.out.println(a);
        System.out.println(b);
        for(int i = 0; i < c.length; i++) {
        	System.out.println(c[i]);
        }
    }

    static void initialize() {

        int b = 4;

        a = 3;

        /*** Stelle 2 ***/
    }

    static int method1(int b) {

        /*** Stelle 6, 12  bzw. 14 ***/
        
        return a;
    }

    static int method2(int a, int[] c) {

        a++;
        c[0] /= 2;
        c = new int[4];
        
        /*** Stelle 10 bzw. 13 ***/

        return a;
    }
}

