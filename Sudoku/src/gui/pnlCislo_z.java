/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;

/**
 *
 * @author Oldřich
 */
public class pnlCislo_z extends javax.swing.JPanel {

    /**
     * Creates new form pnlCislo
     */
    private boolean stale = false;
    private char znak = '0';
    private Font font;
    private Font boldFont;
    private int velikost;

    public pnlCislo_z() {
        initComponents();
        lblZnak.setText(znak + "");
        this.font = lblZnak.getFont();
        this.boldFont = new Font(font.getFontName(), Font.BOLD, font.getSize());
        this.velikost = this.getWidth();
    }

    public char getZnak() {
        return znak;
    }

    public void setZnak(char znak) {
        this.znak = znak;
        lblZnak.setText(znak + "");
    }

    public boolean isStale() {
        return stale;
    }

    public void setStale(boolean stale) {
        this.stale = stale;
        if (stale) {
            lblZnak.setFont(boldFont);
            setBackground(Color.lightGray);
        } else {
            lblZnak.setFont(font);
            setBackground(Color.white);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblZnak = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(20, 20));
        addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                formAncestorResized(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        lblZnak.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblZnak.setText("0");
        lblZnak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblZnakMouseClicked(evt);
            }
        });
        add(lblZnak, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void lblZnakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblZnakMouseClicked
        if (stale) {
            return;
        }
        pnlVstup vstup = new pnlVstup();
        int dialog = JOptionPane.showConfirmDialog(this, vstup, "Vyber hodnoty pole", JOptionPane.OK_CANCEL_OPTION);
        if (dialog == JOptionPane.OK_OPTION) {
            if (vstup.getHodnota() == '0') {
                setZnak(Character.MIN_VALUE);
            } else {
                setZnak(vstup.getHodnota());
            }
        }
    }//GEN-LAST:event_lblZnakMouseClicked

    private void formAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorResized
        int zmenaP = (int) (this.getHeight() * 0.6);
        this.font = new Font(font.getFontName(), Font.PLAIN, zmenaP);
        this.boldFont = new Font(font.getFontName(), Font.BOLD, zmenaP);
        if (stale) {
            lblZnak.setFont(boldFont);
        } else {
            lblZnak.setFont(font);
        }
    }//GEN-LAST:event_formAncestorResized


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblZnak;
    // End of variables declaration//GEN-END:variables
}
