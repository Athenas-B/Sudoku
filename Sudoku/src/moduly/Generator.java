/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduly;

import java.util.List;
import matice.IMaticeRozsirena;
import matice.MaticeRozsirena;
import static moduly.Funkce.*;

/**
 *
 * @author Oldřich
 */
public class Generator<E> implements IGenerator<E> {

    IMaticeRozsirena<E> matice;

    public Generator(E[] znaky, E prazdno) {
        this.matice = new MaticeRozsirena<>(znaky, prazdno);
        generuj();
    }

    @Override
    public IMaticeRozsirena<E> vratVysledek() {
        return matice;
    }

    @Override
    public void generujNovou() {
        generuj();
    }

    private void generuj() {
        for (int indexRadku = 0; indexRadku < matice.vratRozmer(); indexRadku++) {
            try {
                generujRadek(indexRadku);
            } catch (ChybaGenerovani ex) {
                //smaž řádek čtverců
                //System.out.println(ex);
                matice.smazRadekCtvercu(indexRadku);
                int radkuSpatne = indexRadku % matice.vratVELIKOST_CTVERCE();
                //System.out.println("///  " + radkuSpatne + "   ///");
                indexRadku -= (radkuSpatne + 1);
                //continue;
            }
        }
    }

    private void generujRadek(int indexRadku) throws ChybaGenerovani {
        int pokusy = 0;
        int limitPokusu = faktorial(matice.vratRozmer() / 2);
        for (int indexSloupce = 0; indexSloupce < matice.vratRozmer(); indexSloupce++) {
            List<Integer> moznosti = matice.moznostiPole(indexRadku, indexSloupce);
            if (moznosti.isEmpty()) {
                pokusy++;
                if (pokusy > limitPokusu) {
                    throw new ChybaGenerovani("radek nelze vytvorit - slepa moznost");
                }
                matice.smazRadek(indexRadku);
                indexSloupce = -1;
                continue;
            }
            int indexZnaku = generujIndexZnaku(moznosti);
            matice.nastav(indexRadku, indexSloupce, indexZnaku);
        }
    }

    private int generujIndexZnaku(List<Integer> moznosti) {
        int index = generujCislo(0, moznosti.size() - 1);
        return moznosti.get(index);
    }

//    public static void main(String[] args) {
//        Generator<Character> g = new Generator<>(znaky.EZnaky.BEZNE.vratPole(), znaky.EZnaky.BEZNE.vratPrazdno());
//        System.out.println(g.matice);
//
//    }
}
