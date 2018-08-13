/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matice;

import java.util.List;
import znaky.IPoleZnaku;

/**
 *
 * @author Oldřich
 */
public interface IMatice<E> {

    boolean existujeVRadku(int indexRadku, int indexPrvku);

    boolean existujeVeCtverci(IPozice poziceCtverce, int indexPrvku);

    boolean existujeVeSloupci(int indexSloupce, int indexPrvku);

    boolean jePolePrazdne(IPozice pozice);

    List<Integer> moznostiPole(IPozice pozice);

    List<IPozice> moznostiZnakuVRadku(int indexRadku, int indexPrvku);

    List<IPozice> moznostiZnakuVeCtverci(IPozice poziceCtverce, int indexPrvku);

    List<IPozice> moznostiZnakuVeSloupci(int indexSloupce, int indexPrvku);

    IPoleZnaku<E> vratZNAKY();

    void nastav(IPozice pozice, int indexPrvku);

    void smaz(IPozice pozice);

    void smaz();

    void smazCtverec(IPozice poziceCtverce);

    void smazRadek(int indexRadku);

    void smazRadekCtvercu(int indexRadku);

    void smazSloupec(int indexSloupce);

    E vratHodotu(IPozice pozice);

    int vratIndexPrvku(IPozice pozice);

    List<List<E>> vratMatici();

    int vratPocetPrazdnych();

    int vratPocetVyplnenych();

    int vratRozmer();

    int vratVELIKOST_CTVERCE();
}
