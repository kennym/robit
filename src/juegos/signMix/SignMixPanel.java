package juegos.signMix;

import java.util.ArrayList;
import java.awt.Image;
import javax.swing.*;

import lib.Picture;

/**
 *
 * @author Kenny Meyer <knny.myer@gmail.com>
 * @author Jorge Gimenez <jrg.gmnz@hotmail.com>
 *
 * TODO: El temporizador
 */
public class SignMixPanel extends javax.swing.JPanel {

    private Generator generador = new Generator();
    private ArrayList<String> numeros = new ArrayList<String>();
    
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
    public SignMixPanel() {
        initComponents();
        init();
        reset();
    }

    private void init() {
        robitPanel.add(caraFeliz);
        robitPanel.add(caraMuyFeliz);
        robitPanel.add(caraEnojada);
        robitPanel.add(caraTriste);
        robitPanel.add(caraMasTriste);
        caraFeliz.setVisible(false);
        caraEnojada.setVisible(false);
        caraTriste.setVisible(false);
        caraMasTriste.setVisible(false);
        caraMuyFeliz.setVisible(false);
    }

    private void llenarEspacios() {
        etiPrimer   .setText(this.numeros.get(0));
        etiSegundo  .setText(this.numeros.get(2));
        etiResultado.setText(this.numeros.get(3));
    }

    private void reset() {
        resetearNivel();
        // Generar nuevos numeros
        this.numeros = generador.generarProblema(this.nivel);
        // Reemplazar los controles de la ventana.
        vaciarSignos();
        llenarEspacios();
        // Ocultar los controles de los niveles superior a 1
        etiTercerNumero.setVisible(false);
        etiCuartoNumero.setVisible(false);
        txtSigno2      .setVisible(false);
        txtSigno3      .setVisible(false);
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
        if ( this.nivel == 2 ) {
            this.numeros = generador.generarProblema(2);

            etiTercerNumero.setVisible(true);
            txtSigno2      .setVisible(true);

            etiPrimer      .setText(this.numeros.get(0));
            txtSigno1      .setText("");
            etiSegundo     .setText(this.numeros.get(2));
            etiTercerNumero.setText(this.numeros.get(4));
            etiResultado   .setText(this.numeros.get(5));

            etiMensaje          .setText("correcto!!! pasaste al siguiente nivel");
         } else if( this.nivel == 3 ) {
             this.numeros = generador.generarProblema(3);

             etiCuartoNumero.setVisible(true);
             txtSigno3      .setVisible(true);

             etiPrimer      .setText(this.numeros.get(0));
             txtSigno1      .setText("");
             txtSigno2      .setText("");
             etiSegundo     .setText(this.numeros.get(2));
             etiTercerNumero.setText(this.numeros.get(4));
             etiCuartoNumero.setText(this.numeros.get(6));
             etiResultado   .setText(this.numeros.get(7));

             etiMensaje     .setText("correcto!!! pasaste al siguiente nivel");
         } else {
             etiMensaje .setText("Ganaste!!!!felicidades!!");
             mostrarRobitMuyFeliz();
         }
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
    private void vaciarSignos() {
        txtSigno1   .setText("");
        txtSigno2   .setText("");
        txtSigno3   .setText("");
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
        if (this.vecesIntentadas == 2){
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

    public void mostrarRobitFeliz() {
        this.caraEnojada.setVisible(false);
        this.caraTriste.setVisible(false);
        this.caraMasTriste.setVisible(false);
        this.caraFeliz.setVisible(true);
    }

    public void mostrarRobitMuyFeliz() {
        this.caraEnojada.setVisible(false);
        this.caraTriste.setVisible(false);
        this.caraMasTriste.setVisible(false);
        this.caraFeliz.setVisible(false);
        this.caraMuyFeliz.setVisible(true);
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
        jPanel1 = new javax.swing.JPanel();
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
        robitPanel = new javax.swing.JPanel();

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        etiMensaje.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        etiMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        jPanel3.add(btnOk);

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel3.add(btnReset);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        etiPrimer.setFont(new java.awt.Font("Aurulent Sans", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel4.add(etiPrimer, gridBagConstraints);

        txtSigno1.setColumns(1);
        jPanel4.add(txtSigno1, new java.awt.GridBagConstraints());

        etiSegundo.setFont(new java.awt.Font("Aurulent Sans", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel4.add(etiSegundo, gridBagConstraints);

        txtSigno2.setColumns(1);
        jPanel4.add(txtSigno2, new java.awt.GridBagConstraints());

        etiTercerNumero.setFont(new java.awt.Font("Aurulent Sans", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 10;
        jPanel4.add(etiTercerNumero, gridBagConstraints);

        txtSigno3.setColumns(1);
        jPanel4.add(txtSigno3, new java.awt.GridBagConstraints());

        etiCuartoNumero.setFont(new java.awt.Font("Aurulent Sans", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel4.add(etiCuartoNumero, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Aurulent Sans", 0, 18)); // NOI18N
        jLabel3.setText(" = ");
        jPanel4.add(jLabel3, new java.awt.GridBagConstraints());

        etiResultado.setFont(new java.awt.Font("Aurulent Sans", 0, 18)); // NOI18N
        jPanel4.add(etiResultado, new java.awt.GridBagConstraints());

        jPanel1.add(jPanel4);

        robitPanel.setBackground(new java.awt.Color(254, 254, 254));
        robitPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        robitPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(robitPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(robitPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
}//GEN-LAST:event_btnResetActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        /*
         * Cuando el jugador aprieta el botón OK, verificar que el resultado
         * sea correcto.
         */

        // El patrón
        String masOMenos = "^(\\+|\\-)"; // O "+" o "-"

        if ( nivel == 1 ) {
            if ( txtSigno1.getText().matches(masOMenos)) {
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
        } else if ( nivel == 2 ) {
            if ( txtSigno1.getText().matches(masOMenos) &&
                    txtSigno2.getText().matches(masOMenos)) {
                // Comparar el primer y segundo signo en la lista.
                if (( txtSigno1.getText().startsWith(
                        this.generador.obtenerSigno(this.numeros.get(1))) &&
                    ( txtSigno2.getText().startsWith(
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
        } else if ( nivel== 3 ) {
            if ( txtSigno1.getText().matches(masOMenos) &&
                    txtSigno2.getText().matches(masOMenos) &&
                    txtSigno3.getText().matches(masOMenos)) {
                // Comparar el primer, segundo y tercer signo en la lista.
                if (( txtSigno1.getText().startsWith(
                        this.generador.obtenerSigno(
                        this.numeros.get(1)))) &&
                    ( txtSigno2.getText().startsWith(
                        this.generador.obtenerSigno(
                        this.numeros.get(3)))) &&
                    ( txtSigno3.getText().startsWith(
                        this.generador.obtenerSigno(
                        this.numeros.get(5)))
                    )) {
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
}//GEN-LAST:event_btnOkActionPerformed


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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel robitPanel;
    private javax.swing.JTextField txtSigno1;
    private javax.swing.JTextField txtSigno2;
    private javax.swing.JTextField txtSigno3;
    // End of variables declaration//GEN-END:variables

}