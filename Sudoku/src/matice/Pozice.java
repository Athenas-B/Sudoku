/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matice;

/**
 *
 * @author Oldřich
 */
public class Pozice implements IPozice {

    private int indexRadku = 0;
    private int indexSloupce = 0;
//    private final int DELKA_RADKU;
//    private final int DELKA_SLOUPCE;

    public Pozice(int indexRadku, int indexSloupce) {
        if (indexRadku >= 0 && indexSloupce >= 0) {
            this.indexRadku = indexRadku;
            this.indexSloupce = indexSloupce;
        }
    }

    @Override
    public int getIndexRadku() {
        return indexRadku;
    }

    @Override
    public int getIndexSloupce() {
        return indexSloupce;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.indexRadku;
        hash = 29 * hash + this.indexSloupce;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pozice other = (Pozice) obj;
        if (this.indexRadku != other.indexRadku) {
            return false;
        }
        if (this.indexSloupce != other.indexSloupce) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pozice{" + "indexRadku=" + indexRadku + ", indexSloupce=" + indexSloupce + '}';
    }

}
