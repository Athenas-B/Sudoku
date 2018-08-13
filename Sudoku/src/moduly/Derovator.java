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
import static moduly.Funkce.generujCislo;

/**
 *
 * @author Oldřich
 */
public class Derovator<E> implements IDerovator<E> {

    IMaticeRozsirena<E> original;
    IMaticeRozsirena<E> zadani;

    public Derovator(MaticeRozsirena<E> original) {
        this.original = original;
        zadani = new MaticeRozsirena<>(original);
    }

    @Override
    public void vytvorZadani(int obtiznost) {
        switch (obtiznost) {
            case 1:
                vytvorDiryNahodne();
                break;
            case 2:
                vytvorZadani(1);
                break;
            case 3:
                vytvorZadani(2);
                vytvorDiryKdeToJde();
                vytvorDiryPoRadkach();
                vytvorDiryPoSloupcich();
                vytvorDiryPoCtvercich();
                break;
            default:
        }
    }

    private void vytvorDiryNahodne() {
        int der = 0;
        int pokusu = 100;
        while (pokusu > 0) {
            int indexRadku = generujCislo(0, zadani.vratRozmer() - 1);
            int indexSloupce = generujCislo(0, zadani.vratRozmer() - 1);
            IPozice pozice = new Pozice(indexRadku, indexSloupce);
            if (zadani.jePolePrazdne(pozice)) {
                continue;
            }
            zadani.smaz(pozice);
            List<Integer> moznosti = zadani.moznostiPole(pozice);
            if (moznosti.isEmpty() || moznosti.size() != 1 || moznosti.get(0) != original.vratIndexPrvku(pozice)) {
                zadani.nastav(pozice, original.vratIndexPrvku(pozice));
            } else {
                der++;
            }
            pokusu--;
        }
    }

    private void vytvorDiryKdeToJde() {
        for (int indexRadku = 0; indexRadku < zadani.vratRozmer(); indexRadku++) {
            for (int indexSloupce = 0; indexSloupce < zadani.vratRozmer(); indexSloupce++) {
                IPozice pozice = new Pozice(indexRadku, indexSloupce);
                if (zadani.jePolePrazdne(pozice)) {
                    continue;
                }
                zadani.smaz(pozice);
                List<Integer> moznosti = zadani.moznostiPole(pozice);
                if (moznosti.isEmpty() || moznosti.size() != 1 || moznosti.get(0) != original.vratIndexPrvku(pozice)) {
                    zadani.nastav(pozice, original.vratIndexPrvku(pozice));
                }
            }
        }
    }

    private void vytvorDiryPoRadkach() {
        for (int indexRadku = 0; indexRadku < zadani.vratRozmer(); indexRadku++) {
            for (int indexSloupce = 0; indexSloupce < zadani.vratRozmer(); indexSloupce++) {
                IPozice pozice = new Pozice(indexRadku, indexSloupce);
                if (zadani.jePolePrazdne(pozice)) {
                    continue;
                }
                int indexPrvku = zadani.vratIndexPrvku(pozice);
                zadani.smaz(pozice);

                List<IPozice> moznosti = zadani.moznostiZnakuVRadku(pozice, indexPrvku);

                if (moznosti.isEmpty() || moznosti.size() != 1 || moznosti.get(0) != pozice) {
                    zadani.nastav(pozice, original.vratIndexPrvku(pozice));
                }

            }
        }
    }

    private void vytvorDiryPoSloupcich() {
        for (int indexRadku = 0; indexRadku < zadani.vratRozmer(); indexRadku++) {
            for (int indexSloupce = 0; indexSloupce < zadani.vratRozmer(); indexSloupce++) {
                IPozice pozice = new Pozice(indexRadku, indexSloupce);
                if (zadani.jePolePrazdne(pozice)) {
                    continue;
                }
                int indexPrvku = zadani.vratIndexPrvku(pozice);
                zadani.smaz(pozice);

                List<IPozice> moznosti = zadani.moznostiZnakuVeSloupci(pozice, indexPrvku);

                if (moznosti.isEmpty() || moznosti.size() != 1 || moznosti.get(0) != pozice) {
                    zadani.nastav(pozice, original.vratIndexPrvku(pozice));
                }

            }
        }
    }

    private void vytvorDiryPoCtvercich() {
        for (int indexRadku = 0; indexRadku < zadani.vratRozmer(); indexRadku++) {
            for (int indexSloupce = 0; indexSloupce < zadani.vratRozmer(); indexSloupce++) {
                IPozice pozice = new Pozice(indexRadku, indexSloupce);
                if (zadani.jePolePrazdne(pozice)) {
                    continue;
                }
                int indexPrvku = zadani.vratIndexPrvku(pozice);
                zadani.smaz(pozice);

                List<IPozice> moznosti = zadani.moznostiZnakuVeCtverci(pozice, indexPrvku);

                if (moznosti.isEmpty() || moznosti.size() != 1 || moznosti.get(0) != pozice) {
                    zadani.nastav(pozice, original.vratIndexPrvku(pozice));
                }

            }
        }
    }

    @Override
    public IMaticeRozsirena<E> getOriginal() {
        return original;
    }

    @Override
    public IMaticeRozsirena<E> getZadani() {
        return zadani;
    }

    @Override
    public void setOriginal(IMaticeRozsirena<E> original) {
        this.original = original;
    }

}
