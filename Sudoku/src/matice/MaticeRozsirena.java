/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matice;

import java.util.List;

/**
 *
 * @author Oldřich
 */
public class MaticeRozsirena<E> extends Matice<E> implements IMaticeRozsirena<E> {

    public MaticeRozsirena(E[] znaky, E prazdno) {
        super(znaky, prazdno);
    }

    public MaticeRozsirena(Matice<E> puvodni) {
        super(puvodni);
    }

    @Override
    public void nastav(int indexRadku, int indeSloupce, int indexPrvku) {
        nastav(new Pozice(indexRadku, indeSloupce), indexPrvku);
    }

    @Override
    public E vratHodotu(int indexRadku, int indeSloupce) {
        return vratHodotu(new Pozice(indexRadku, indeSloupce));
    }

    @Override
    public int vratIndexPrvku(int indexRadku, int indeSloupce) {
        return vratIndexPrvku(new Pozice(indexRadku, indeSloupce));
    }

    @Override
    public void smaz(int indexRadku, int indeSloupce) {
        smaz(new Pozice(indexRadku, indeSloupce));
    }

    @Override
    public void smazRadek(IPozice pozice) {
        smazRadek(pozice.getIndexRadku());
    }

    @Override
    public void smazSloupec(IPozice pozice) {
        smazSloupec(pozice.getIndexSloupce());
    }

    @Override
    public void smazCtverec(int indexRadku, int indeSloupce) {
        smazCtverec(new Pozice(indexRadku, indeSloupce));

    }

    @Override
    public boolean existujeVRadku(IPozice pozice, int indexPrvku) {
        return existujeVRadku(pozice.getIndexRadku(), indexPrvku);
    }

    @Override
    public boolean existujeVeSloupci(IPozice pozice, int indexPrvku) {
        return existujeVeSloupci(pozice.getIndexSloupce(), indexPrvku);
    }

    @Override
    public boolean existujeVeCtverci(int indexRadku, int indeSloupce, int indexPrvku) {
        return existujeVeCtverci(new Pozice(indexRadku, indeSloupce), indexPrvku);
    }

    @Override
    public List<IPozice> moznostiZnakuVRadku(IPozice pozice, int indexPrvku) {
        return moznostiZnakuVRadku(pozice.getIndexRadku(), indexPrvku);
    }

    @Override
    public List<IPozice> moznostiZnakuVeSloupci(IPozice pozice, int indexPrvku) {
        return moznostiZnakuVeSloupci(pozice.getIndexSloupce(), indexPrvku);
    }

    @Override
    public List<IPozice> moznostiZnakuVeCtverci(int indexRadku, int indeSloupce, int indexPrvku) {
        return moznostiZnakuVeCtverci(new Pozice(indexRadku, indeSloupce), indexPrvku);
    }

    @Override
    public List<Integer> moznostiPole(int indexRadku, int indeSloupce) {
        return moznostiPole(new Pozice(indexRadku, indeSloupce));
    }

    @Override
    public boolean jePolePrazdne(int indexRadku, int indexSloupce) {
        return jePolePrazdne(new Pozice(indexRadku, indexSloupce));
    }

    @Override
    public void smazRadekCtvercu(IPozice poziceCtverce) {
        smazRadekCtvercu(poziceCtverce.getIndexRadku());
    }

}
