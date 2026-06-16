package clinica.cobro;

public class WINcobro extends javax.swing.JFrame {

    private javax.swing.JLabel lblNombre, lblAtencion, lblCobertura;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JComboBox<String> cmbAtencion, cmbCobertura;
    private javax.swing.JButton btnCalcular, btnLimpiar;
    private javax.swing.JTextArea txtResultado;
    
    public WINcobro() {
        initComponents();
        initMiFormulario(); 
    }
     private void initMiFormulario() {
        setTitle("Cobro de Atención Clínica");
        setSize(450, 420);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        javax.swing.JLabel lblTitulo = new javax.swing.JLabel("COBRO DE ATENCIÓN");
        lblTitulo.setBounds(140, 10, 200, 25);
        lblTitulo.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));

        lblNombre = new javax.swing.JLabel("Nombre del paciente:");
        lblNombre.setBounds(20, 50, 160, 25);

        txtNombre = new javax.swing.JTextField();
        txtNombre.setBounds(190, 50, 220, 25);

        lblAtencion = new javax.swing.JLabel("Tipo de atención:");
        lblAtencion.setBounds(20, 90, 160, 25);

        cmbAtencion = new javax.swing.JComboBox<>(new String[]{
            "Consulta General - S/80",
            "Consulta Especialidad - S/150",
            "Laboratorio - S/120",
            "Telemedicina - S/60"
        });
        cmbAtencion.setBounds(190, 90, 220, 25);

        lblCobertura = new javax.swing.JLabel("Tipo de cobertura:");
        lblCobertura.setBounds(20, 130, 160, 25);

        cmbCobertura = new javax.swing.JComboBox<>(new String[]{
            "Particular (100%)",
            "Asegurado (copago 30%)",
            "Convenio Corporativo (copago 20%)"
        });
        cmbCobertura.setBounds(190, 130, 220, 25);

        btnCalcular = new javax.swing.JButton("Calcular");
        btnCalcular.setBounds(80, 175, 120, 30);

        btnLimpiar = new javax.swing.JButton("Limpiar");
        btnLimpiar.setBounds(240, 175, 120, 30);

        javax.swing.JLabel lblResultado = new javax.swing.JLabel("Resultado:");
        lblResultado.setBounds(20, 215, 100, 25);

        txtResultado = new javax.swing.JTextArea();
        txtResultado.setEditable(false);
        txtResultado.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));
        javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(txtResultado);
        scroll.setBounds(20, 240, 395, 140);

        // 4. Agregas todo al contenedor
        getContentPane().add(lblTitulo);
        getContentPane().add(lblNombre);
        getContentPane().add(txtNombre);
        getContentPane().add(lblAtencion);
        getContentPane().add(cmbAtencion);
        getContentPane().add(lblCobertura);
        getContentPane().add(cmbCobertura);
        getContentPane().add(btnCalcular);
        getContentPane().add(btnLimpiar);
        getContentPane().add(lblResultado);
        getContentPane().add(scroll);

        // 5. Acciones de los botones
        btnCalcular.addActionListener(e -> calcular());
        btnLimpiar.addActionListener(e -> limpiar());
    }

    // 6. Lógica de cálculo usando tus clases SOLID
    private void calcular() {
        String nombre = txtNombre.getText().trim();
        if (nombre.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el nombre del paciente.");
            return;
        }

        double costoBase;
        switch (cmbAtencion.getSelectedIndex()) {
            case 0:  costoBase = 80;  break;
            case 1:  costoBase = 150; break;
            case 2:  costoBase = 120; break;
            default: costoBase = 60;  break;
        }

        CoberturaPolicy politica;
        switch (cmbCobertura.getSelectedIndex()) {
            case 0:  politica = new CoberturaParticular();  break;
            case 1:  politica = new CoberturaAseguradora(); break;
            default: politica = new CoberturaConvenio();    break;
        }

        ServicioClinico servicio = new ServicioClinico(
            "P001", nombre,
            (String) cmbAtencion.getSelectedItem(),
            costoBase
        );

        CalculadoraCobro calculadora = new CalculadoraCobro();
        DetalleCobro detalle = calculadora.calcular(servicio, politica);

        txtResultado.setText(
            "Paciente    : " + detalle.getNombrePaciente()          + "\n" +
            "Atención    : " + detalle.getTipoAtencion()            + "\n" +
            "Cobertura   : " + detalle.getPoliticaNombre()          + "\n" +
            "------------------------\n"                             +
            "Costo base  : S/ " + String.format("%.2f", detalle.getCostoBase())  + "\n" +
            "IGV (18%)   : S/ " + String.format("%.2f", detalle.getIgv())        + "\n" +
            "Copago      : S/ " + String.format("%.2f", detalle.getCopago())     + "\n" +
            "========================\n"                             +
            "TOTAL A PAGAR: S/ " + String.format("%.2f", detalle.getTotalFinal())
        );
    }

    private void limpiar() {
        txtNombre.setText("");
        cmbAtencion.setSelectedIndex(0);
        cmbCobertura.setSelectedIndex(0);
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
            java.util.logging.Logger.getLogger(WINcobro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WINcobro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WINcobro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WINcobro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WINcobro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
