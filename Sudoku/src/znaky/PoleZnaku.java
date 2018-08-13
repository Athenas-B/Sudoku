/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package znaky;

import java.util.Arrays;

/**
 *
 * @author Oldřich
 */
public class PoleZnaku<E> implements IPoleZnaku<E> {

    public final E[] POLE;
    public final E PRAZDNE_POLICKO;

    public PoleZnaku(E[] POLE, E PRAZDNE_POLICKO) {
        this.POLE = POLE;
        this.PRAZDNE_POLICKO = PRAZDNE_POLICKO;
    }

    @Override
    public int vratPocet() {
        return POLE.length;
    }

    @Override
    public E[] vratPole() {
        return POLE;
    }

    @Override
    public E vratZIndexu(int index) {
        return POLE[index];
    }

    @Override
    public int vratIndex(E prvek) {
        for (int i = 0; i < vratPocet(); i++) {
            if (prvek == POLE[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E vratPrazdno() {
        return PRAZDNE_POLICKO;
    }

    @Override
    public String toString() {
        return "PoleZnaku{" + "POLE=" + Arrays.toString(POLE) + ", PRAZDNE_POLICKO=" + PRAZDNE_POLICKO + '}';
    }

}
