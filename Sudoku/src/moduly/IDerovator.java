/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduly;

import matice.IMaticeRozsirena;

/**
 *
 * @author Oldřich
 */
public interface IDerovator<E> {

    IMaticeRozsirena<E> getOriginal();

    IMaticeRozsirena<E> getZadani();

    void setOriginal(IMaticeRozsirena<E> original);

    void vytvorZadani(int obtiznost);

}
