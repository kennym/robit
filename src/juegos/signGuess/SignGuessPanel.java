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
package juegos.signGuess;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;

import lib.Picture;
import lib.Sonido;

/**
 * La interfaz gráfica del juego.
 *
 * @author Kenny Meyer <knny.myer@gmail.com>
 * @author Jorge Gimenez <jrg.gmnz@hotmail.com>
 *
 */
public class SignGuessPanel extends javax.swing.JPanel {

    private Generator generador = new Generator();
    private ArrayList<String> numeros = new ArrayList<String>();

    JLabel instrucciones = new Picture("data/robit/signMix/instrucciones.png").getJLabel();
    JLabel caraFeliz = new Picture("data/robit/signMix/feliz.png").getJLabel();
    JLabel caraMuyFeliz = new Picture("data/robit/signMix/muyFeliz.png").getJLabel();
    JLabel caraEnojada = new Picture("data/robit/signMix/enojado.png").getJLabel();
    JLabel caraTriste = new Picture("data/robit/signMix/triste.png").getJLabel();
    JLabel caraMasTriste = new Picture("data/robit/signMix/mastriste.png").getJLabel();
    /**
     * El nivel del juego
     *
     * De acuerdo al nivel se mostrarán más etiquetas y entradas de texto.
     */
    private int nivel = 1;
    private int vecesIntentadas = 0;

    /** Creates new form SignMixFrame */
    public SignGuessPanel() {
        initComponents();
        init();
    }

    private void init() {
        robitPanel.add(caraFeliz);
        robitPanel.add(caraMuyFeliz);
        robitPanel.add(caraEnojada);
        robitPanel.add(caraTriste);
        robitPanel.add(caraMasTriste);
        robitPanel.add(instrucciones);
        caraFeliz.setVisible(false);
        caraEnojada.setVisible(false);
        caraTriste.setVisible(false);
        caraMasTriste.setVisible(false);
        caraMuyFeliz.setVisible(false);
        instrucciones.setVisible(false);
        reset();
    }

    /**
     * Vaciar todos los signos en la interfaz gráfica.
     *
     * En vez de escribir:

    txtSigno1   .setText("");
    txtSigno2   .setText("");
    txtSigno3   .setText("");
     *
     * Solo llamar a este método, que se encarge de eso.
     */
    private void _vaciarSignos() {
        txtSigno1.setText("");
        txtSigno2.setText("");
        txtSigno3.setText("");
    }

    private void _llenarEspacios() {
        etiPrimer.setText(this.numeros.get(0));
        etiSegundo.setText(this.numeros.get(2));
        etiResultado.setText(this.numeros.get(3));
    }

    private void reset() {
        resetearNivel();
        // Generar nuevos numeros
        this.numeros = generador.generarProblema(this.nivel);
        // Reemplazar los controles de la ventana.
        _vaciarSignos();
        _llenarEspacios();
        // Ocultar los controles de los niveles superior a 1
        etiTercerNumero.setVisible(false);
        etiCuartoNumero.setVisible(false);
        txtSigno2.setVisible(false);
        txtSigno3.setVisible(false);
        btnOk.setVisible(true);
        resetearMalasVeces();
        mostrarInstrucciones();
        mostrarMensaje("");
    }

    /**
     * Subir de nivel.
     * 
     * Incrementar el nivel, y desplegar los nuevos controles de acuerdo al nivel.
     */
    public void subirNivel() {
        incrementarNivel();
        mostrarRobitFeliz();
        resetearMalasVeces();
        if (this.nivel == 2) {
            this.numeros = generador.generarProblema(2);

            etiTercerNumero.setVisible(true);
            txtSigno2.setVisible(true);

            etiPrimer.setText(this.numeros.get(0));
            txtSigno1.setText("");
            etiSegundo.setText(this.numeros.get(2));
            etiTercerNumero.setText(this.numeros.get(4));
            etiResultado.setText(this.numeros.get(5));

            mostrarMensaje("Correcto! Subiste al nivel 2.");
        } else if (this.nivel == 3) {
            this.numeros = generador.generarProblema(3);

            etiCuartoNumero.setVisible(true);
            txtSigno3.setVisible(true);

            etiPrimer.setText(this.numeros.get(0));
            txtSigno1.setText("");
            txtSigno2.setText("");
            etiSegundo.setText(this.numeros.get(2));
            etiTercerNumero.setText(this.numeros.get(4));
            etiCuartoNumero.setText(this.numeros.get(6));
            etiResultado.setText(this.numeros.get(7));

            mostrarMensaje("Correcto! Subiste al nivel 3.");
        } else {
            mostrarMensaje("Sos un MASTER. Felicidades!");
            mostrarRobitMuyFeliz();
            btnOk.setVisible(false);
            Sonido.reproducirSonidoStartGame();
        }
    }

    public void incrementarNivel() {
        this.nivel++;
    }

    public void resetearNivel() {
        this.nivel = 1;
    }

    public void aumentarMalasVeces() {
        this.vecesIntentadas++;
        this.caraFeliz.setVisible(false);
        this.caraTriste.setVisible(false);
        this.caraMasTriste.setVisible(false);
        if (this.vecesIntentadas == 2) {
            this.caraMasTriste.setVisible(true);
        } else if (this.vecesIntentadas > 2) {
            this.caraEnojada.setVisible(true);
        } else {
            this.caraTriste.setVisible(true);
        }
    }

    public void resetearMalasVeces() {
        this.vecesIntentadas = 0;
    }

    private void mostrarInstrucciones() {
        this.caraEnojada.setVisible(false);
        this.caraTriste.setVisible(false);
        this.caraMasTriste.setVisible(false);
        this.caraMuyFeliz.setVisible(false);
        this.caraFeliz.setVisible(false);
        this.instrucciones.setVisible(true);
    }

    public void mostrarRobitFeliz() {
        this.caraEnojada.setVisible(false);
        this.caraTriste.setVisible(false);
        this.caraMasTriste.setVisible(false);
        this.instrucciones.setVisible(false);
        this.caraMuyFeliz.setVisible(false);
        this.caraFeliz.setVisible(true);
    }

    public void mostrarRobitMuyFeliz() {
        this.caraEnojada.setVisible(false);
        this.caraTriste.setVisible(false);
        this.caraMasTriste.setVisible(false);
        this.caraFeliz.setVisible(false);
        this.instrucciones.setVisible(false);
        this.caraMuyFeliz.setVisible(true);
    }

    public void mostrarMensaje(String mensaje) {
        this.etiMensaje.setText(mensaje);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        etiMensaje = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnOk = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        robitPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        etiPrimer = new javax.swing.JLabel();
        txtSigno1 = new javax.swing.JTextField();
        etiSegundo = new javax.swing.JLabel();
        txtSigno2 = new javax.swing.JTextField();
        etiTercerNumero = new javax.swing.JLabel();
        txtSigno3 = new javax.swing.JTextField();
        etiCuartoNumero = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        etiResultado = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(400, 305));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        etiMensaje.setFont(new java.awt.Font("SansSerif", 0, 24));
        etiMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 5, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnOk.setText("OK");
        btnOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnOkMouseReleased(evt);
            }
        });
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        jPanel3.add(btnOk);

        btnReset.setText("Reset");
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnResetMouseReleased(evt);
            }
        });
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel3.add(btnReset);

        robitPanel.setBackground(new java.awt.Color(254, 254, 254));
        robitPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        robitPanel.setLayout(new java.awt.CardLayout());

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        etiPrimer.setFont(new java.awt.Font("Aurulent Sans", 0, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel4.add(etiPrimer, gridBagConstraints);

        txtSigno1.setColumns(2);
        txtSigno1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSigno1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSigno1KeyReleased(evt);
            }
        });
        jPanel4.add(txtSigno1, new java.awt.GridBagConstraints());

        etiSegundo.setFont(new java.awt.Font("Aurulent Sans", 0, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel4.add(etiSegundo, gridBagConstraints);

        txtSigno2.setColumns(2);
        txtSigno2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSigno2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSigno2KeyReleased(evt);
            }
        });
        jPanel4.add(txtSigno2, new java.awt.GridBagConstraints());

        etiTercerNumero.setFont(new java.awt.Font("Aurulent Sans", 0, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 10;
        jPanel4.add(etiTercerNumero, gridBagConstraints);

        txtSigno3.setColumns(2);
        txtSigno3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSigno3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSigno3KeyReleased(evt);
            }
        });
        jPanel4.add(txtSigno3, new java.awt.GridBagConstraints());

        etiCuartoNumero.setFont(new java.awt.Font("Aurulent Sans", 0, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel4.add(etiCuartoNumero, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Aurulent Sans", 0, 24));
        jLabel3.setText(" = ");
        jPanel4.add(jLabel3, new java.awt.GridBagConstraints());

        etiResultado.setFont(new java.awt.Font("Aurulent Sans", 0, 24));
        jPanel4.add(etiResultado, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(robitPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(robitPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
}//GEN-LAST:event_btnResetActionPerformed

    private void btnOk() {
        /*
         * Cuando el jugador aprieta el botón OK, verificar que el resultado
         * sea correcto.
         */

        Sonido.reproducirSonidoPress2();

        // El patrón
        String masOMenos = "^(\\+|\\-)"; // O "+" o "-"

        if (nivel == 1) {
            if (txtSigno1.getText().matches(masOMenos)) {
                // Comparar el primer signo en la lista.
                if (txtSigno1.getText().startsWith(this.generador.obtenerSigno(this.numeros.get(1)))) {
                    // El signo está correcto ...
                    etiMensaje.setText("Correcto! Sos un master!");
                    // y subir de nivel...
                    subirNivel();
                } else {
                    etiMensaje.setText("No está correcto. Intentá de nuevo.");
                    aumentarMalasVeces();
                }
            } else {
                etiMensaje.setText("Ingrese el signo + ó - !");
            }
        } else if (nivel == 2) {
            if (txtSigno1.getText().matches(masOMenos)
                    && txtSigno2.getText().matches(masOMenos)) {
                // Comparar el primer y segundo signo en la lista.
                if ((txtSigno1.getText().startsWith(
                        this.generador.obtenerSigno(this.numeros.get(1)))
                        && (txtSigno2.getText().startsWith(
                        this.generador.obtenerSigno(this.numeros.get(3)))))) {
                    // El signo está correcto ...
                    etiMensaje.setText("Correcto! Sos un master!");
                    // y subir de nivel...
                    subirNivel();

                } else {
                    etiMensaje.setText("No está correcto. Intentá de nuevo.");
                    aumentarMalasVeces();
                }
            } else {
                etiMensaje.setText("Ingrese el signo + ó - !");
            }
        } else if (nivel == 3) {
            if (txtSigno1.getText().matches(masOMenos)
                    && txtSigno2.getText().matches(masOMenos)
                    && txtSigno3.getText().matches(masOMenos)) {
                // Comparar el primer, segundo y tercer signo en la lista.
                if ((txtSigno1.getText().startsWith(
                        this.generador.obtenerSigno(
                        this.numeros.get(1))))
                        && (txtSigno2.getText().startsWith(
                        this.generador.obtenerSigno(
                        this.numeros.get(3))))
                        && (txtSigno3.getText().startsWith(
                        this.generador.obtenerSigno(
                        this.numeros.get(5))))) {
                    // Los signos se ha puestos correctamente
                    etiMensaje.setText("Correcto! Sos un master!");
                    // y subir de nivel...
                    subirNivel();

                } else {
                    etiMensaje.setText("No está correcto. Intentá de nuevo.");
                    aumentarMalasVeces();
                }
            } else {
                etiMensaje.setText("Ingrese el signo + ó - !");
            }
        }
    }
    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        btnOk();
}//GEN-LAST:event_btnOkActionPerformed

    private void btnOkMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkMouseReleased
        Sonido.reproducirSonidoPress2();
    }//GEN-LAST:event_btnOkMouseReleased

    private void btnResetMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseReleased
        Sonido.reproducirSonidoStartGame();
    }//GEN-LAST:event_btnResetMouseReleased

    private void txtSigno1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSigno1KeyReleased
        int length = txtSigno1.getText().length();
        if (length > 1) {
            mostrarMensaje("Ingresa solo un signo!");
            txtSigno1.setBackground(Color.red);
        } else {
            mostrarMensaje("");
            txtSigno1.setBackground(Color.WHITE);
        }

        if (evt.getKeyCode() == 10) { // Enter
            btnOk();
        }
    }//GEN-LAST:event_txtSigno1KeyReleased

    private void txtSigno2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSigno2KeyReleased
        int length = txtSigno2.getText().length();
        if (length > 1) {
            mostrarMensaje("Ingresa solo un signo!");
            txtSigno2.setBackground(Color.red);
        } else {
            mostrarMensaje("");
            txtSigno2.setBackground(Color.WHITE);
        }

        if (evt.getKeyCode() == 10) { // Enter
            btnOk();
        }
    }//GEN-LAST:event_txtSigno2KeyReleased

    private void txtSigno3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSigno3KeyReleased
        int length = txtSigno3.getText().length();
        if (length > 1) {
            mostrarMensaje("Ingresa solo un signo!");
            txtSigno3.setBackground(Color.red);
        } else {
            mostrarMensaje("");
            txtSigno3.setBackground(Color.WHITE);
        }

        if (evt.getKeyCode() == 10) { // Enter
            btnOk();
        }
    }//GEN-LAST:event_txtSigno3KeyReleased

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
    }//GEN-LAST:event_formKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel etiCuartoNumero;
    private javax.swing.JLabel etiMensaje;
    private javax.swing.JLabel etiPrimer;
    private javax.swing.JLabel etiResultado;
    private javax.swing.JLabel etiSegundo;
    private javax.swing.JLabel etiTercerNumero;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel robitPanel;
    private javax.swing.JTextField txtSigno1;
    private javax.swing.JTextField txtSigno2;
    private javax.swing.JTextField txtSigno3;
    // End of variables declaration//GEN-END:variables
}
