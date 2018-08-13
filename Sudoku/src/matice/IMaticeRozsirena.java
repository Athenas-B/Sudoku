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
public interface IMaticeRozsirena<E> extends IMatice<E> {

    boolean existujeVRadku(IPozice pozice, int indexPrvku);

    boolean existujeVeCtverci(int indexRadku, int indeSloupce, int indexPrvku);

    boolean existujeVeSloupci(IPozice pozice, int indexPrvku);

    boolean jePolePrazdne(int indexRadku, int indexSloupce);

    List<Integer> moznostiPole(int indexRadku, int indeSloupce);

    List<IPozice> moznostiZnakuVRadku(IPozice pozice, int indexPrvku);

    List<IPozice> moznostiZnakuVeCtverci(int indexRadku, int indeSloupce, int indexPrvku);

    List<IPozice> moznostiZnakuVeSloupci(IPozice pozice, int indexPrvku);

    void nastav(int indexRadku, int indeSloupce, int indexPrvku);

    void smaz(int indexRadku, int indeSloupce);

    void smazCtverec(int indexRadku, int indeSloupce);

    void smazRadek(IPozice pozice);

    void smazRadekCtvercu(IPozice poziceCtverce);

    void smazSloupec(IPozice pozice);

    E vratHodotu(int indexRadku, int indeSloupce);

    int vratIndexPrvku(int indexRadku, int indeSloupce);

}
