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
public enum EZnaky {

    BEZNE,
    HEXA;

    public final Character PRAZDNO = Character.MIN_VALUE;
    public final Character[] ZNAKY_BEZNE = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public final Character[] ZNAKY_HEXA = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public Character[] vratPole() {
        switch (this) {
            case BEZNE:
                return ZNAKY_BEZNE;
            case HEXA:
                return ZNAKY_HEXA;
            default:
                return null;
        }

    }

    public Character vratPrazdno() {
        return PRAZDNO;
    }

}
