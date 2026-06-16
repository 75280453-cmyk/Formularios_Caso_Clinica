/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package clinica.liquidacion;

/**
 *
 * @author joest
 */
public class WINliquidacion extends javax.swing.JFrame {

    private javax.swing.JLabel lblMedico, lblConsultas, lblLabs, lblTele;
    private javax.swing.JTextField txtMedico, txtConsultas, txtLabs, txtTele;
    private javax.swing.JComboBox<String> cmbComision;
    private javax.swing.JButton btnCalcular, btnLimpiar;
    private javax.swing.JTextArea txtResultado;
    
    public WINliquidacion() {
        initComponents();
        initMiFormulario();
    }
private void initMiFormulario() {
        setTitle("Liquidación de Turno Médico");
        setSize(450, 480);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        javax.swing.JLabel lblTitulo = new javax.swing.JLabel("LIQUIDACIÓN DE TURNO MÉDICO");
        lblTitulo.setBounds(100, 10, 280, 25);
        lblTitulo.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 13));

        lblMedico = new javax.swing.JLabel("Nombre del médico:");
        lblMedico.setBounds(20, 50, 170, 25);

        txtMedico = new javax.swing.JTextField();
        txtMedico.setBounds(200, 50, 210, 25);

        lblConsultas = new javax.swing.JLabel("N° consultas (S/150 c/u):");
        lblConsultas.setBounds(20, 90, 175, 25);

        txtConsultas = new javax.swing.JTextField();
        txtConsultas.setBounds(200, 90, 210, 25);

        lblLabs = new javax.swing.JLabel("N° laboratorios (S/120 c/u):");
        lblLabs.setBounds(20, 130, 175, 25);

        txtLabs = new javax.swing.JTextField();
        txtLabs.setBounds(200, 130, 210, 25);

        lblTele = new javax.swing.JLabel("N° telemedicinas (S/60 c/u):");
        lblTele.setBounds(20, 170, 175, 25);

        txtTele = new javax.swing.JTextField();
        txtTele.setBounds(200, 170, 210, 25);

        javax.swing.JLabel lblComision = new javax.swing.JLabel("Tipo de comisión:");
        lblComision.setBounds(20, 210, 175, 25);

        cmbComision = new javax.swing.JComboBox<>(new String[]{
            "Estándar (20%)",
            "Especialista (35%)"
        });
        cmbComision.setBounds(200, 210, 210, 25);

        btnCalcular = new javax.swing.JButton("Calcular");
        btnCalcular.setBounds(80, 255, 120, 30);

        btnLimpiar = new javax.swing.JButton("Limpiar");
        btnLimpiar.setBounds(240, 255, 120, 30);

        txtResultado = new javax.swing.JTextArea();
        txtResultado.setEditable(false);
        txtResultado.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));
        javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(txtResultado);
        scroll.setBounds(20, 295, 395, 155);

        getContentPane().add(lblTitulo);
        getContentPane().add(lblMedico);    getContentPane().add(txtMedico);
        getContentPane().add(lblConsultas); getContentPane().add(txtConsultas);
        getContentPane().add(lblLabs);      getContentPane().add(txtLabs);
        getContentPane().add(lblTele);      getContentPane().add(txtTele);
        getContentPane().add(lblComision);  getContentPane().add(cmbComision);
        getContentPane().add(btnCalcular);  getContentPane().add(btnLimpiar);
        getContentPane().add(scroll);

        btnCalcular.addActionListener(e -> calcular());
        btnLimpiar.addActionListener(e -> limpiar());
    }

    private void calcular() {
        try {
            String medico = txtMedico.getText().trim();
            int consultas = Integer.parseInt(txtConsultas.getText().trim());
            int labs      = Integer.parseInt(txtLabs.getText().trim());
            int tele      = Integer.parseInt(txtTele.getText().trim());

            if (medico.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el nombre del médico.");
                return;
            }

            ComisionPolicy politica;
            if (cmbComision.getSelectedIndex() == 0) {
                politica = new ComisionEstandar();
            } else {
                politica = new ComisionEspecialista();
            }

            TurnoMedico turno = new TurnoMedico(medico, consultas, labs, tele);

            CalculadoraLiquidacion calculadora = new CalculadoraLiquidacion();
            DetalleLiquidacion detalle = calculadora.calcular(turno, politica);

            txtResultado.setText(
                "Médico          : " + detalle.getNombreMedico()                              + "\n" +
                "Comisión        : " + detalle.getPoliticaNombre()                            + "\n" +
                "------------------------------\n"                                             +
                "Consultas       : S/ " + String.format("%.2f", detalle.getTotalConsultas())  + "\n" +
                "Laboratorios    : S/ " + String.format("%.2f", detalle.getTotalLabs())       + "\n" +
                "Telemedicinas   : S/ " + String.format("%.2f", detalle.getTotalTele())       + "\n" +
                "------------------------------\n"                                             +
                "Total recaudado : S/ " + String.format("%.2f", detalle.getTotalRecaudado())  + "\n" +
                "Comisión médico : S/ " + String.format("%.2f", detalle.getComision())        + "\n" +
                "==============================\n"                                             +
                "INGRESO NETO    : S/ " + String.format("%.2f", detalle.getIngresoNeto())
            );

        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos.");
        }
    }

    private void limpiar() {
        txtMedico.setText("");
        txtConsultas.setText("");
        txtLabs.setText("");
        txtTele.setText("");
        cmbComision.setSelectedIndex(0);
        txtResultado.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WINliquidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WINliquidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WINliquidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WINliquidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WINliquidacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
