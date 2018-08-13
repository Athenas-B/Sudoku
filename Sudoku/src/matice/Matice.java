/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matice;

import znaky.IPoleZnaku;
import znaky.PoleZnaku;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Oldřich
 * @param <E>
 */
public class Matice<E> implements IMatice<E> {

    private List<List<E>> matice;
    private final IPoleZnaku<E> ZNAKY;
    private int pocetPrazdnych;
    private int pocetVyplnenych;
    private final int VELIKOST_CTVERCE;

    public Matice(Matice<E> puvodni) {
        this.ZNAKY = new PoleZnaku(puvodni.ZNAKY.vratPole(), puvodni.ZNAKY.vratPrazdno());
        this.matice = new ArrayList<>(this.ZNAKY.vratPocet());
        this.VELIKOST_CTVERCE = puvodni.VELIKOST_CTVERCE;
        this.pocetPrazdnych = puvodni.pocetPrazdnych;
        this.pocetVyplnenych = puvodni.pocetVyplnenych;

        for (int i = 0; i < this.ZNAKY.vratPocet(); i++) {
            matice.add(new ArrayList<>(Matice.this.ZNAKY.vratPocet()));
            for (int j = 0; j < this.ZNAKY.vratPocet(); j++) {
                matice.get(i).add(puvodni.matice.get(i).get(j));
            }
        }
    }

    public Matice(E[] znaky, E prazdno) {
        this.ZNAKY = new PoleZnaku(znaky, prazdno);
        this.matice = new ArrayList<>(this.ZNAKY.vratPocet());
        this.VELIKOST_CTVERCE = (int) Math.sqrt(this.ZNAKY.vratPocet());
        this.pocetPrazdnych = (int) Math.round(Math.pow(this.ZNAKY.vratPocet(), 2));
        this.pocetVyplnenych = 0;

        for (int i = 0; i < this.ZNAKY.vratPocet(); i++) {
            matice.add(new ArrayList<>(Matice.this.ZNAKY.vratPocet()));
            for (int j = 0; j < this.ZNAKY.vratPocet(); j++) {
                matice.get(i).add(prazdno);
            }
        }
    }

    @Override
    public void nastav(IPozice pozice, int indexPrvku) {
        if (jePolePrazdne(pozice)) {
            pocetPrazdnych--;
            pocetVyplnenych++;
        }
        matice.get(pozice.getIndexRadku()).set(pozice.getIndexSloupce(), ZNAKY.vratZIndexu(indexPrvku));
    }

    @Override
    public E vratHodotu(IPozice pozice) {
        return matice.get(pozice.getIndexRadku()).get(pozice.getIndexSloupce());
    }

    @Override
    public int vratIndexPrvku(IPozice pozice) {
        return ZNAKY.vratIndex(vratHodotu(pozice));
    }

    @Override
    public void smaz(IPozice pozice) {
        if (!jePolePrazdne(pozice)) {
            pocetPrazdnych++;
            pocetVyplnenych--;
        }
        matice.get(pozice.getIndexRadku()).set(pozice.getIndexSloupce(), ZNAKY.vratPrazdno());
    }

    @Override
    public void smaz() {
        for (int radek = 0; radek < matice.size(); radek++) {
            //matice.set(i, new ArrayList<>(Matice.this.ZNAKY.vratPocet()));
            for (int sloupec = 0; sloupec < matice.get(radek).size(); sloupec++) {
                matice.get(radek).set(sloupec, this.ZNAKY.vratPrazdno());
            }
        }
        pocetPrazdnych += pocetVyplnenych;
        pocetVyplnenych = 0;
    }

    @Override
    public void smazRadek(int indexRadku) {
        for (int indexSloupce = 0; indexSloupce < matice.get(indexRadku).size(); indexSloupce++) {
            if (!jePolePrazdne(new Pozice(indexRadku, indexSloupce))) {
                pocetPrazdnych++;
                pocetVyplnenych--;
            }
            matice.get(indexRadku).set(indexSloupce, ZNAKY.vratPrazdno());
        }
    }

    @Override
    public void smazSloupec(int indexSloupce) {
        for (int indexRadku = 0; indexRadku < matice.size(); indexRadku++) {
            if (!jePolePrazdne(new Pozice(indexRadku, indexSloupce))) {
                pocetPrazdnych++;
                pocetVyplnenych--;
            }
            matice.get(indexRadku).set(indexSloupce, ZNAKY.vratPrazdno());
        }
    }

    @Override
    public void smazCtverec(IPozice poziceCtverce) {
        IPozice zacatekCtverce = new Pozice((poziceCtverce.getIndexRadku() / (VELIKOST_CTVERCE)) * (VELIKOST_CTVERCE),
                (poziceCtverce.getIndexSloupce() / (VELIKOST_CTVERCE)) * (VELIKOST_CTVERCE));
        for (int indexRadku = zacatekCtverce.getIndexRadku(); indexRadku < zacatekCtverce.getIndexRadku() + VELIKOST_CTVERCE; indexRadku++) {
            for (int indexSloupce = zacatekCtverce.getIndexSloupce(); indexSloupce < zacatekCtverce.getIndexSloupce() + VELIKOST_CTVERCE; indexSloupce++) {
                if (!jePolePrazdne(new Pozice(indexRadku, indexSloupce))) {
                    pocetPrazdnych++;
                    pocetVyplnenych--;
                }
                matice.get(indexRadku).set(indexSloupce, this.ZNAKY.vratPrazdno());
            }
        }
    }

    @Override
    public void smazRadekCtvercu(int indexRadku) {
        for (int indexSloupce = 0; indexSloupce < vratRozmer(); indexSloupce += VELIKOST_CTVERCE) {
            smazCtverec(new Pozice(indexRadku, indexSloupce));
        }
    }

    @Override
    public boolean existujeVRadku(int indexRadku, int indexPrvku) {
        return matice.get(indexRadku).contains(ZNAKY.vratZIndexu(indexPrvku));
    }

    @Override
    public boolean existujeVeSloupci(int indexSloupce, int indexPrvku) {
        for (int radek = 0; radek < matice.size(); radek++) {
            if (matice.get(radek).get(indexSloupce) == ZNAKY.vratZIndexu(indexPrvku)) { //nebo compareTO --- je potřeba rozhraní?
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existujeVeCtverci(IPozice poziceCtverce, int indexPrvku) {
        IPozice zacatekCtverce = new Pozice((poziceCtverce.getIndexRadku() / (VELIKOST_CTVERCE)) * (VELIKOST_CTVERCE),
                (poziceCtverce.getIndexSloupce() / (VELIKOST_CTVERCE)) * (VELIKOST_CTVERCE));
        for (int indexRadku = zacatekCtverce.getIndexRadku(); indexRadku < zacatekCtverce.getIndexRadku() + VELIKOST_CTVERCE; indexRadku++) {
            for (int indexSloupce = zacatekCtverce.getIndexSloupce(); indexSloupce < zacatekCtverce.getIndexSloupce() + VELIKOST_CTVERCE; indexSloupce++) {
                if (matice.get(indexRadku).get(indexSloupce) == ZNAKY.vratZIndexu(indexPrvku)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<IPozice> moznostiZnakuVRadku(int indexRadku, int indexPrvku) {
        List<IPozice> moznosti = new ArrayList<>();
        if (existujeVRadku(indexRadku, indexPrvku)) {
            return moznosti;
        }
        for (int indexSloupce = 0; indexSloupce < matice.get(indexRadku).size(); indexSloupce++) {
            Pozice mozna = new Pozice(indexRadku, indexSloupce);
            if (!existujeVeSloupci(indexRadku, indexPrvku) && !existujeVeCtverci(mozna, indexPrvku)) {
                moznosti.add(mozna);
            }
        }
        return moznosti;
    }

    @Override
    public List<IPozice> moznostiZnakuVeSloupci(int indexSloupce, int indexPrvku) {
        List<IPozice> moznosti = new ArrayList<>();
        if (existujeVeSloupci(indexSloupce, indexPrvku)) {
            return moznosti;
        }
        for (int indexRadku = 0; indexRadku < matice.size(); indexRadku++) {
            Pozice mozna = new Pozice(indexRadku, indexSloupce);
            if (!existujeVRadku(indexRadku, indexPrvku) && !existujeVeCtverci(mozna, indexPrvku)) {
                moznosti.add(mozna);
            }
        }
        return moznosti;
    }

    @Override
    public List<IPozice> moznostiZnakuVeCtverci(IPozice poziceCtverce, int indexPrvku) {
        List<IPozice> moznosti = new ArrayList<>();
        if (existujeVeCtverci(poziceCtverce, indexPrvku)) {
            return moznosti;
        }
        IPozice zacatekCtverce = new Pozice((poziceCtverce.getIndexRadku() / (VELIKOST_CTVERCE)) * (VELIKOST_CTVERCE),
                (poziceCtverce.getIndexSloupce() / (VELIKOST_CTVERCE)) * (VELIKOST_CTVERCE));
        for (int indexRadku = zacatekCtverce.getIndexRadku(); indexRadku < zacatekCtverce.getIndexRadku() + VELIKOST_CTVERCE; indexRadku++) {
            for (int indexSloupce = zacatekCtverce.getIndexSloupce(); indexSloupce < zacatekCtverce.getIndexSloupce() + VELIKOST_CTVERCE; indexSloupce++) {
                if (!existujeVRadku(indexRadku, indexPrvku) && !existujeVeSloupci(indexSloupce, indexPrvku)) {
                    moznosti.add(new Pozice(indexRadku, indexSloupce));
                }
            }
        }
        return moznosti;
    }

    @Override
    public List<Integer> moznostiPole(IPozice pozice) {
        List<Integer> moznosti = new ArrayList<>();
        for (int mozna = 0; mozna < ZNAKY.vratPocet(); mozna++) {
            if (!existujeVRadku(pozice.getIndexRadku(), mozna) && !existujeVeSloupci(pozice.getIndexSloupce(), mozna) && !existujeVeCtverci(pozice, mozna)) {
                moznosti.add(mozna);
            }
        }
        return moznosti;
    }

    @Override
    public boolean jePolePrazdne(IPozice pozice) {
        return matice.get(pozice.getIndexRadku()).get(pozice.getIndexSloupce()) == ZNAKY.vratPrazdno();
    }

    @Override
    public List<List<E>> vratMatici() {
        return matice;
    }

    @Override
    public int vratPocetPrazdnych() {
        return pocetPrazdnych;
    }

    @Override
    public int vratPocetVyplnenych() {
        return pocetVyplnenych;
    }

    @Override
    public int vratRozmer() {
        return ZNAKY.vratPocet();
    }

    @Override
    public int vratVELIKOST_CTVERCE() {
        return VELIKOST_CTVERCE;
    }

    @Override
    public String toString() {
        String vrat = "Matice{" + "ZNAKY=" + ZNAKY + ", pocetPrazdnych=" + pocetPrazdnych + ", pocetVyplnenych=" + pocetVyplnenych + ", VELIKOST_CTVERCE=" + VELIKOST_CTVERCE + "}" + System.getProperty("line.separator");
        vrat += "Obsah:" + System.getProperty("line.separator");
        for (int iRadek = 0; iRadek < matice.size(); iRadek++) {
            if (iRadek % VELIKOST_CTVERCE == 0) {
                vrat += "-------------------------" + System.getProperty("line.separator");
            }
            for (int iSloupec = 0; iSloupec < matice.get(iRadek).size(); iSloupec++) {
                if (iSloupec % VELIKOST_CTVERCE == 0) {
                    vrat += "| ";
                }
                vrat += matice.get(iRadek).get(iSloupec).toString() + " ";
            }
            vrat += "| " + System.getProperty("line.separator");
        }
        vrat += "-------------------------" + System.getProperty("line.separator");
        return vrat;
    }

    @Override
    public IPoleZnaku<E> vratZNAKY() {
        return ZNAKY;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.matice);
        hash = 71 * hash + Objects.hashCode(this.ZNAKY);
        hash = 71 * hash + this.pocetPrazdnych;
        hash = 71 * hash + this.pocetVyplnenych;
        hash = 71 * hash + this.VELIKOST_CTVERCE;
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
        final Matice<?> other = (Matice<?>) obj;
        if (!Objects.equals(this.matice, other.matice)) {
            return false;
        }
        if (!Objects.equals(this.ZNAKY, other.ZNAKY)) {
            return false;
        }
        if (this.pocetPrazdnych != other.pocetPrazdnych) {
            return false;
        }
        if (this.pocetVyplnenych != other.pocetVyplnenych) {
            return false;
        }
        if (this.VELIKOST_CTVERCE != other.VELIKOST_CTVERCE) {
            return false;
        }
        return true;
    }
}
