/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import matice.IMaticeRozsirena;
import matice.MaticeRozsirena;
import moduly.Derovator;
import moduly.Generator;
import moduly.IGenerator;
import moduly.IResitel;
import moduly.Resitel;
import znaky.EZnaky;

/**
 *
 * @author Oldřich
 */
public class Sudoku<E> implements ISudoku<E> {

    private IMaticeRozsirena<E> reseni;
    private IMaticeRozsirena<E> zadani;
    private IMaticeRozsirena<E> uzivatel;

    private final E[] ZNAKY;
    private final E PRAZDNO;

    public Sudoku(E[] znaky, E prazdno) {
        this.PRAZDNO = prazdno;
        this.ZNAKY = znaky;
    }

    @Override
    public void generujNoveZadani(EObtiznost obtiznost) {
        if (reseni == null || reseni.vratPocetPrazdnych() != 0) {
            generujNoveReseni();
        }
        Derovator<E> derovator = new Derovator<>((MaticeRozsirena<E>) reseni);
        derovator.vytvorZadani(obtiznost.getOBTIZNOST());
        zadani = derovator.getZadani();
    }

    @Override
    public void generujNoveReseni() {
        IGenerator<E> generator = new Generator(ZNAKY, PRAZDNO);
        generator.generujNovou();
        reseni = generator.vratVysledek();
    }

    @Override
    public void vyresSudoku() {
        if (uzivatel == null) {
            throw new NullPointerException("Nebyla vlozena matice k reseni!");
        } else if (uzivatel.vratPocetPrazdnych() == 0) {
            reseni = new MaticeRozsirena<>((MaticeRozsirena<E>) zadani);
        } else {
            IResitel<E> resitel = new Resitel<>((MaticeRozsirena<E>) uzivatel);
            resitel.vyres();
            reseni=resitel.getReseni();
        }
    }

    private void vyresGenerovaneSudoku() {
    }

    @Override
    public IMaticeRozsirena<E> getZadani() {
        return zadani;
    }

    @Override
    public IMaticeRozsirena<E> getReseni() {
        return reseni;
    }

    @Override
    public E[] getZnaky() {
        return ZNAKY;
    }

    @Override
    public E getPrazdno() {
        return PRAZDNO;
    }

    @Override
    public IMaticeRozsirena<E> getUzivatel() {
        return uzivatel;
    }

    @Override
    public void setUzivatel(IMaticeRozsirena<E> uzivatel) {
        this.uzivatel = uzivatel;
    }

//    public static void main(String[] args) {
//        Sudoku<Character> s = new Sudoku<>(EZnaky.BEZNE.vratPole(), EZnaky.BEZNE.vratPrazdno());
//        s.generujNoveZadani(EObtiznost.TEZKE);
//        System.out.println(s.reseni);
//        System.out.println(s.zadani);
//        System.out.println(s.uzivatel);
//    }
}
