/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduly;

import java.util.List;
import matice.IMaticeRozsirena;
import matice.IPozice;
import matice.MaticeRozsirena;
import matice.Pozice;

/**
 *
 * @author Oldřich
 */
public class Resitel<E> implements IResitel<E> {

    IMaticeRozsirena<E> reseni;
    IMaticeRozsirena<E> uzivatelska;

    public Resitel(MaticeRozsirena<E> uzivatelska) {
        this.uzivatelska = uzivatelska;
        this.reseni = new MaticeRozsirena<>(uzivatelska);
    }

    @Override
    public void vyres() {
        int pokus=0;
        while (reseni.vratPocetPrazdnych() > 0 && pokus< 10000) {
            resPoPolich();
            resDleRadku();
            resDleSloupce();
            resDleCtvercu();
            pokus++;
        }
    }

    private void resDleCtvercu() {
        for (int indexRadku = 0; indexRadku < reseni.vratRozmer(); indexRadku += reseni.vratVELIKOST_CTVERCE()) {
            for (int indexSloupce = 0; indexSloupce < reseni.vratRozmer(); indexSloupce += reseni.vratVELIKOST_CTVERCE()) {
                IPozice pozice = new Pozice(indexRadku, indexSloupce);
                for (int indexPrvku = 0; indexPrvku < reseni.vratZNAKY().vratPocet(); indexPrvku++) {
                    List<IPozice> moznostiZnaku = reseni.moznostiZnakuVeCtverci(pozice, indexPrvku);
                    if (moznostiZnaku.size() == 1) {
                        reseni.nastav(moznostiZnaku.get(0), indexPrvku);
                    }
                }
            }
        }
    }

    private void resDleSloupce() {
        for (int indexSloupce = 0; indexSloupce < reseni.vratRozmer(); indexSloupce++) {
            for (int indexPrvku = 0; indexPrvku < reseni.vratZNAKY().vratPocet(); indexPrvku++) {
                List<IPozice> moznostiZnaku = reseni.moznostiZnakuVeSloupci(indexSloupce, indexPrvku);
                if (moznostiZnaku.size() == 1) {
                    reseni.nastav(moznostiZnaku.get(0), indexPrvku);
                }
            }
        }
    }

    private void resDleRadku() {
        for (int indexRadku = 0; indexRadku < reseni.vratRozmer(); indexRadku++) {
            for (int indexPrvku = 0; indexPrvku < reseni.vratZNAKY().vratPocet(); indexPrvku++) {
                List<IPozice> moznostiZnaku = reseni.moznostiZnakuVRadku(indexRadku, indexPrvku);
                if (moznostiZnaku.size() == 1) {
                    reseni.nastav(moznostiZnaku.get(0), indexPrvku);
                }
            }
        }
    }

    private void resPoPolich() {
        for (int indexRadku = 0; indexRadku < reseni.vratRozmer(); indexRadku++) {
            for (int indexSloupce = 0; indexSloupce < reseni.vratRozmer(); indexSloupce++) {
                IPozice pozice = new Pozice(indexRadku, indexSloupce);
                List<Integer> moznostiPole = reseni.moznostiPole(pozice);
                if (moznostiPole.size() == 1) {
                    reseni.nastav(pozice, moznostiPole.get(0));
                }
            }
        }
    }

    @Override
    public IMaticeRozsirena<E> getReseni() {
        return reseni;
    }

    @Override
    public IMaticeRozsirena<E> getUzivatelska() {
        return uzivatelska;
    }

    @Override
    public void setUzivatelska(IMaticeRozsirena<E> uzivatelska) {
        this.uzivatelska = uzivatelska;
    }

}
