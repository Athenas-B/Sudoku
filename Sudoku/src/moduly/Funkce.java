/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduly;

/**
 *
 * @author Oldřich
 */
public class Funkce {

    public static int generujCislo(int od, int po) {
        int cislo = (int) (Math.random() * (po - od + 1) + od);
        return cislo;
    }

    public static int faktorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }
}
