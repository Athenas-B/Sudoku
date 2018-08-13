/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Oldřich
 */
public enum EObtiznost {

    SNADNE(1),
    STREDNI(2),
    TEZKE(3);

    public final int OBTIZNOST;

    private EObtiznost(int obtiznost) {
        this.OBTIZNOST = obtiznost;
    }

    public int getOBTIZNOST() {
        return OBTIZNOST;
    }

}
