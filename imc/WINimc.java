package clinica.imc;


public class WINimc extends javax.swing.JFrame {

    private javax.swing.JLabel lblNombre, lblPeso, lblTalla, lblEdad, lblSexo;
    private javax.swing.JTextField txtNombre, txtPeso, txtTalla, txtEdad;
    private javax.swing.JComboBox<String> cmbSexo, cmbTipoPaciente;
    private javax.swing.JButton btnCalcular, btnLimpiar;
    private javax.swing.JTextArea txtResultado;
    
    public WINimc() {
        initComponents();
        initMiFormulario();
    }
    private void initMiFormulario() {
        setTitle("Calculadora de IMC - Triaje");
        setSize(450, 480);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        javax.swing.JLabel lblTitulo = new javax.swing.JLabel("CÁLCULO DE IMC Y PESO IDEAL");
        lblTitulo.setBounds(100, 10, 280, 25);
        lblTitulo.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 13));

        lblNombre = new javax.swing.JLabel("Nombre del paciente:");
        lblNombre.setBounds(20, 50, 160, 25);

        txtNombre = new javax.swing.JTextField();
        txtNombre.setBounds(200, 50, 210, 25);

        lblPeso = new javax.swing.JLabel("Peso (kg):");
        lblPeso.setBounds(20, 90, 160, 25);

        txtPeso = new javax.swing.JTextField();
        txtPeso.setBounds(200, 90, 210, 25);

        lblTalla = new javax.swing.JLabel("Talla (m)  ej: 1.70:");
        lblTalla.setBounds(20, 130, 160, 25);

        txtTalla = new javax.swing.JTextField();
        txtTalla.setBounds(200, 130, 210, 25);

        lblEdad = new javax.swing.JLabel("Edad:");
        lblEdad.setBounds(20, 170, 160, 25);

        txtEdad = new javax.swing.JTextField();
        txtEdad.setBounds(200, 170, 210, 25);

        lblSexo = new javax.swing.JLabel("Sexo:");
        lblSexo.setBounds(20, 210, 160, 25);

        cmbSexo = new javax.swing.JComboBox<>(new String[]{
            "Masculino", "Femenino"
        });
        cmbSexo.setBounds(200, 210, 210, 25);

        javax.swing.JLabel lblTipo = new javax.swing.JLabel("Tipo de paciente:");
        lblTipo.setBounds(20, 250, 160, 25);

        cmbTipoPaciente = new javax.swing.JComboBox<>(new String[]{
            "Adulto", "Adulto Mayor"
        });
        cmbTipoPaciente.setBounds(200, 250, 210, 25);

        btnCalcular = new javax.swing.JButton("Calcular IMC");
        btnCalcular.setBounds(80, 295, 130, 30);

        btnLimpiar = new javax.swing.JButton("Limpiar");
        btnLimpiar.setBounds(230, 295, 130, 30);

        txtResultado = new javax.swing.JTextArea();
        txtResultado.setEditable(false);
        txtResultado.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));
        javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(txtResultado);
        scroll.setBounds(20, 335, 395, 110);

        getContentPane().add(lblTitulo);
        getContentPane().add(lblNombre);   getContentPane().add(txtNombre);
        getContentPane().add(lblPeso);     getContentPane().add(txtPeso);
        getContentPane().add(lblTalla);    getContentPane().add(txtTalla);
        getContentPane().add(lblEdad);     getContentPane().add(txtEdad);
        getContentPane().add(lblSexo);     getContentPane().add(cmbSexo);
        getContentPane().add(lblTipo);     getContentPane().add(cmbTipoPaciente);
        getContentPane().add(btnCalcular); getContentPane().add(btnLimpiar);
        getContentPane().add(scroll);

        btnCalcular.addActionListener(e -> calcular());
        btnLimpiar.addActionListener(e -> limpiar());
    }

    private void calcular() {
        try {
            String nombre = txtNombre.getText().trim();
            double peso   = Double.parseDouble(txtPeso.getText().trim());
            double talla  = Double.parseDouble(txtTalla.getText().trim());
            int edad      = Integer.parseInt(txtEdad.getText().trim());

            if (nombre.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el nombre del paciente.");
                return;
            }
            if (talla <= 0 || peso <= 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Peso y talla deben ser mayores a 0.");
                return;
            }

            Paciente paciente = new Paciente(
                nombre, edad,
                (String) cmbSexo.getSelectedItem(),
                peso, talla
            );

            ClasificacionIMCPolicy politica;
            if (cmbTipoPaciente.getSelectedIndex() == 0) {
                politica = new ClasificacionAdulto();
            } else {
                politica = new ClasificacionAdultoMayor();
            }

            CalculadoraIMC calculadora = new CalculadoraIMC();
            ResultadoIMC resultado = calculadora.calcular(paciente, politica);

            String estadoPeso = resultado.getDiferencia() > 0
                ? "Exceso: "  + String.format("%.2f", resultado.getDiferencia()) + " kg"
                : "Déficit: " + String.format("%.2f", Math.abs(resultado.getDiferencia())) + " kg";

            txtResultado.setText(
                "Paciente      : " + resultado.getNombrePaciente()                        + "\n" +
                "Edad / Sexo   : " + edad + " años / " + cmbSexo.getSelectedItem()        + "\n" +
                "-----------------------------\n"                                           +
                "IMC           : " + String.format("%.2f", resultado.getImc())             + "\n" +
                "Clasificación : " + resultado.getClasificacion()                          + "\n" +
                "Peso ideal    : " + String.format("%.2f", resultado.getPesoIdeal()) + " kg\n" +
                "Estado        : " + estadoPeso
            );

        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos.");
        }
    }

    private void limpiar() {
        txtNombre.setText("");
        txtPeso.setText("");
        txtTalla.setText("");
        txtEdad.setText("");
        cmbSexo.setSelectedIndex(0);
        cmbTipoPaciente.setSelectedIndex(0);
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
            java.util.logging.Logger.getLogger(WINimc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WINimc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WINimc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WINimc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WINimc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
