/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package znaky;

/**
 *
 * @author Oldřich
 */
public interface IPoleZnaku<E> {

    int vratIndex(E prvek);

    int vratPocet();

    E[] vratPole();

    E vratPrazdno();

    E vratZIndexu(int index);
    
}
