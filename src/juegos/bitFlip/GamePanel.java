package juegos.bitFlip;

import javax.swing.JFrame;

/**
 *
 * @author Kenny Meyer <knny.myer@gmail.com>
 */
public class GamePanel extends javax.swing.JPanel {
    private Generator generador = Generator.getInstance();

    /** Creates new form GamePanel */
    public GamePanel() {
        initComponents();
        if (generador.getStep() == 0) {
            mostrarEstadoInicial();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        canvas1 = new GameCanvas();
        btnReset = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnSi = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        btnNo = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setMaximumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(400, 500));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setMaximumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));
        jPanel1.add(canvas1);

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        btnSi.setText("Si");
        btnSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiActionPerformed(evt);
            }
        });
        jPanel2.add(btnSi);

        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        jPanel2.add(btnOk);

        btnNo.setText("No");
        btnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoActionPerformed(evt);
            }
        });
        jPanel2.add(btnNo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(btnReset, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void mostrarEstadoInicial() {
        btnSi   .setVisible(false);
        btnNo   .setVisible(false);
        btnReset.setEnabled(false);
        btnOk   .setVisible(true);
    }

    public void terminarEstadoInicial() {
        btnSi   .setVisible(true);
        btnNo   .setVisible(true);
        btnReset.setEnabled(true);
        btnOk   .setVisible(false);
        canvas1 .setEstadoIncio(false);
    }

    private void desactivarBotones() {
        btnSi   .setEnabled(false);
        btnNo   .setEnabled(false);
        btnReset.setText("Jugar nuevamente!");
    }

    private void activarBotones() {
        btnSi   .setEnabled(true);
        btnNo   .setEnabled(true);
        btnReset.setText("Reset");
    }

    private void btnSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiActionPerformed
        generador.yes();
        // Step must be 7 to stop, otherwise the pow(2, 7) won't be shown.
        if (generador.getStep() > 6) {
            desactivarBotones();
        }
        canvas1.repaint();
}//GEN-LAST:event_btnSiActionPerformed

    private void btnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoActionPerformed
        generador.no();
        if (generador.getStep() > 6) {
            desactivarBotones();
        }
        canvas1.repaint();
}//GEN-LAST:event_btnNoActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        generador.reset();
        activarBotones();
        canvas1.resetearEstado();
        mostrarEstadoInicial();
        canvas1.repaint();
}//GEN-LAST:event_btnResetActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        terminarEstadoInicial();
        canvas1.repaint();
    }//GEN-LAST:event_btnOkActionPerformed

    public static void main(String args[]) {
        JFrame frame = new JFrame();
        GamePanel gamePanel = new GamePanel();
        
        frame.add(gamePanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNo;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSi;
    private GameCanvas canvas1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
