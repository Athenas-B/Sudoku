/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku;

import matice.IMaticeRozsirena;

/**
 *
 * @author Oldřich
 */
public interface ISudoku<E> {

    void generujNoveReseni();

    void generujNoveZadani(EObtiznost obtiznost);

    E getPrazdno();

    IMaticeRozsirena<E> getReseni();

    IMaticeRozsirena<E> getUzivatel();

    IMaticeRozsirena<E> getZadani();

    E[] getZnaky();

    void setUzivatel(IMaticeRozsirena<E> uzivatel);

    void vyresSudoku();
    
}
