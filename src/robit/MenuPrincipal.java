/*
 *  ROBIT - El robot simpático e inteligente
 *  Copyright (C) 2010  Kenny Meyer <knny.myer@gmail.com>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  --
 *
 *  Este programa es software libre: usted puede redistribuirlo y/o modificarlo
 *  conforme a los términos de la Licencia Pública General de GNU publicada por
 *  la Fundación para el Software Libre, ya sea la versión 3 de esta Licencia o (a
 *  su elección) cualquier versión posterior.
 *
 *  Este programa se distribuye con el deseo de que le resulte útil, pero SIN
 *  GARANTÍAS DE NINGÚN TIPO; ni siquiera con las garantías implícitas de
 *  COMERCIABILIDAD o APTITUD PARA UN PROPÓSITO DETERMINADO.  Para más información,
 *  consulte la Licencia Pública General de GNU.
 *
 *  Junto con este programa, se debería incluir una copia de la Licencia Pública General de GNU.
 *  De no ser así, ingrese en <http://www.gnu.org/licenses/>.
 */
package robit;

import lib.Picture;
import lib.Sonido;
import juegos.bitFlip.GamePanel;
import juegos.signGuess.SignGuessPanel;

import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Esta clase muestra el Menú principal.  Es recomendable, sino necesario, que
 * el usuario primero hace una instancia de este objeto.
 *
 * @author Kenny Meyer <knny.myer@gmail.com>
 */
public class MenuPrincipal extends javax.swing.JFrame {
    String archivoRobitFeliz    = "data/robit/feliz.png";
    String archivoRobitTriste   = "data/robit/triste.png";
    String archivoRobitBitFlip  = "data/robit/bitFlip.png";
    String archivoRobitSignMix  = "data/robit/signGuess.png";
    String archivoRobitAcercaDe = "data/robit/acercaDe.png";

    JPanel subPanel             = new JPanel();

    JLabel robitBienvenidos     = new Picture(archivoRobitFeliz)   .getJLabel();
    JLabel robitTristeLabel     = new Picture(archivoRobitTriste)  .getJLabel();
    JLabel robitBitFlipLabel    = new Picture(archivoRobitBitFlip) .getJLabel();
    JLabel robitSignMixLabel    = new Picture(archivoRobitSignMix) .getJLabel();
    JLabel robitAcercaDe        = new Picture(archivoRobitAcercaDe).getJLabel();

    // Instancias de nuestros juegos.
    GamePanel bitFlip           = new GamePanel();
    SignGuessPanel signMix      = new SignGuessPanel();

    /**
     * El inicializador (...y el TERMINATOR?)
     */
    public MenuPrincipal() {
        initComponents();
        init();
    }

    /**
     * Arreglar los elementos en la ventana.
     */
    public void init() {
        // Añadir los labeles de las imagenes al subpanel
        this.subPanel.add(this.robitBienvenidos);
        this.subPanel.add(this.robitTristeLabel);
        this.subPanel.add(this.robitBitFlipLabel);
        this.subPanel.add(this.robitSignMixLabel);
        this.subPanel.add(this.robitAcercaDe);
        this.subPanel.setBackground(java.awt.Color.WHITE);

        this.robitBienvenidos.setVisible(true);
        this.robitTristeLabel.setVisible(false);
        this.robitBitFlipLabel.setVisible(false);
        this.robitSignMixLabel.setVisible(false);
        this.robitAcercaDe.setVisible(false);

        panelPrincipal.add(this.subPanel);
        panelPrincipal.add(bitFlip);
        // Añadir bitFlip al panel
        bitFlip.setVisible(false);
        // Añadir signMix al panel
        panelPrincipal.add(signMix);
        signMix.setVisible(false);
        pack();
    }
    
    public void ocultarControles() {
        if (this.bitFlip.isVisible()) {
            bitFlip.setVisible(false);
        }

        if (this.signMix.isVisible()) {
            signMix.setVisible(false);
        }
    }

    public void mostrarSubPanel() {
        this.subPanel.setVisible(true);
    }

    public void ocultarSubPanel() {
        this.subPanel.setVisible(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        panelPrincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnBitFlip = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnCreditos = new javax.swing.JButton();
        btnSignGuess = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ROBIT");

        panelPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelPrincipal.setMaximumSize(new java.awt.Dimension(0, 0));
        panelPrincipal.setLayout(new java.awt.CardLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnBitFlip.setText("BitFlip");
        btnBitFlip.setMaximumSize(new java.awt.Dimension(100, 100));
        btnBitFlip.setMinimumSize(new java.awt.Dimension(100, 100));
        btnBitFlip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBitFlipMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBitFlipMouseEntered(evt);
            }
        });
        btnBitFlip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBitFlipActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
        });
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnCreditos.setText("Acerca De");
        btnCreditos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCreditosMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCreditosMouseEntered(evt);
            }
        });
        btnCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreditosActionPerformed(evt);
            }
        });

        btnSignGuess.setText("SignGuess");
        btnSignGuess.setMaximumSize(new java.awt.Dimension(100, 100));
        btnSignGuess.setMinimumSize(new java.awt.Dimension(100, 100));
        btnSignGuess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSignGuessMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSignGuessMouseEntered(evt);
            }
        });
        btnSignGuess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignGuessActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSignGuess, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(btnBitFlip, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(btnCreditos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(btnBitFlip, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSignGuess, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addComponent(btnCreditos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("ROBIT v1.0");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBitFlipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBitFlipActionPerformed
        // Llamar al cuadro del juego BitFlip.
        // Reemplazar el contenido del panel principal.
        this.subPanel.setVisible(false);
        ocultarControles();
        this.bitFlip.setVisible(true);
        pack();
    }//GEN-LAST:event_btnBitFlipActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // Salir de ROBIT :'-(
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditosActionPerformed
        DialogoCreditos creditos = new DialogoCreditos(this, false);
        creditos.setVisible(true);
    }//GEN-LAST:event_btnCreditosActionPerformed

    private void btnBitFlipMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBitFlipMouseEntered
        mostrarSubPanel();
        this.robitBienvenidos.setVisible(false);
        this.robitBitFlipLabel.setVisible(true);
        this.validate();
        Sonido.reproducirSonidoHover();
    }//GEN-LAST:event_btnBitFlipMouseEntered

    private void btnBitFlipMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBitFlipMouseExited
        ocultarSubPanel();
        this.robitBitFlipLabel.setVisible(false);
        this.robitBienvenidos.setVisible(true);
        this.validate();
    }//GEN-LAST:event_btnBitFlipMouseExited

    private void btnSignGuessMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSignGuessMouseExited
        ocultarSubPanel();
        this.robitSignMixLabel.setVisible(false);
        this.robitBienvenidos.setVisible(true);
        this.validate();
    }//GEN-LAST:event_btnSignGuessMouseExited

    private void btnSignGuessMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSignGuessMouseEntered
        mostrarSubPanel();
        this.robitBienvenidos.setVisible(false);
        this.robitSignMixLabel.setVisible(true);
        this.validate();
        Sonido.reproducirSonidoHover();
    }//GEN-LAST:event_btnSignGuessMouseEntered

    private void btnSignGuessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignGuessActionPerformed
        // Llamar al panel del juego SignMix.
        // Reemplazar el contenido del panel principal.
        this.subPanel.setVisible(false);
        ocultarControles();
        this.signMix.setVisible(true);
        pack();
    }//GEN-LAST:event_btnSignGuessActionPerformed

    private void btnCreditosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreditosMouseEntered
        mostrarSubPanel();
        this.robitBienvenidos.setVisible(false);
        this.robitAcercaDe.setVisible(true);
        Sonido.reproducirSonidoHover();
    }//GEN-LAST:event_btnCreditosMouseEntered

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        mostrarSubPanel();
        this.robitBienvenidos.setVisible(false);
        this.robitTristeLabel.setVisible(true);
        Sonido.reproducirSonidoHover();
    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        ocultarSubPanel();
        this.robitTristeLabel.setVisible(false);
        this.robitBienvenidos.setVisible(true);
        Sonido.reproducirSonidoHover();
    }//GEN-LAST:event_btnSalirMouseExited

    private void btnCreditosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreditosMouseExited
        ocultarSubPanel();
        this.robitAcercaDe.setVisible(false);
        this.robitBienvenidos.setVisible(true);
        Sonido.reproducirSonidoHover();
    }//GEN-LAST:event_btnCreditosMouseExited

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBitFlip;
    private javax.swing.JButton btnCreditos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSignGuess;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables

}