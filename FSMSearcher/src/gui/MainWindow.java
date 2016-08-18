package gui;

import engine.Target;
import engine.FiniteStateMachine;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

/**
 * @author Marcelo A. T. Gomes
 */
public class MainWindow extends javax.swing.JFrame {

    private String sourceFolder;
    private int resultsCounter;
    private FiniteStateMachine finiteStateMachine;
    private static Target target;
    static int filesCounter;
    static List<String> fileList;
    static String selectedLink;
    static int linkIndex;
   
    /**
     * @return the sourceFolder
     */
    public String getSourceFolder() {
        return sourceFolder;
    }

    /**
     * @param sourceFolder the sourceFolder to set
     */
    public void setSourceFolder(String sourceFolder) {
        this.sourceFolder = sourceFolder;
    }
    
    /**
     * @return the resultsFound
     */
    public int getResultsFound() {
        return resultsCounter;
    }

    /**
     * @param resultsFound the resultsFound to set
     */
    public void setResultsFound(int resultsFound) {
        this.resultsCounter = resultsFound;
    }
    
    /** Creates new form Find */
    public MainWindow() {
        initComponents();
        
        resultsCounter = 0;
        showButton.setVisible(false);
        
        // Getting home folder path
        sourceFolder = System.getProperty("user.home");
        sourceTextField.setText(sourceFolder);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chooser = new javax.swing.JFileChooser();
        resultWindow = new javax.swing.JFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        resultList = new javax.swing.JList();
        openFileButton = new javax.swing.JButton();
        labelSearchFor = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        matchCaseCheckBox = new javax.swing.JCheckBox();
        searchSubfoldersCheckBox = new javax.swing.JCheckBox();
        searchButton = new javax.swing.JButton();
        labelSearchIn = new javax.swing.JLabel();
        sourceTextField = new javax.swing.JTextField();
        changeButton = new javax.swing.JButton();
        labelResult = new javax.swing.JLabel();
        showButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTextField = new javax.swing.JTextArea();

        chooser.setDialogType(javax.swing.JFileChooser.CUSTOM_DIALOG);
        chooser.setApproveButtonText("Select");
        chooser.setApproveButtonToolTipText("Select");
        chooser.setDialogTitle("Folder for search");
        chooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        chooser.setDoubleBuffered(true);

        resultWindow.setMinimumSize(new java.awt.Dimension(1024, 480));

        resultList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        resultList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(resultList);

        openFileButton.setText("Open file");
        openFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout resultWindowLayout = new org.jdesktop.layout.GroupLayout(resultWindow.getContentPane());
        resultWindow.getContentPane().setLayout(resultWindowLayout);
        resultWindowLayout.setHorizontalGroup(
            resultWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
            .add(resultWindowLayout.createSequentialGroup()
                .add(431, 431, 431)
                .add(openFileButton)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        resultWindowLayout.setVerticalGroup(
            resultWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(resultWindowLayout.createSequentialGroup()
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 400, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(openFileButton)
                .add(0, 66, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Finite state machine searcher");
        setName("mainFrame"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        labelSearchFor.setText("Search for:");

        matchCaseCheckBox.setText("Match case");
        matchCaseCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        matchCaseCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));

        searchSubfoldersCheckBox.setSelected(true);
        searchSubfoldersCheckBox.setText("Search subfolders");
        searchSubfoldersCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        searchSubfoldersCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        labelSearchIn.setText("Search in:");

        changeButton.setText("Change");
        changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeButtonActionPerformed(evt);
            }
        });

        labelResult.setText("Result:");

        showButton.setText("Show");
        showButton.setDoubleBuffered(true);
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        resultTextField.setEditable(false);
        resultTextField.setColumns(20);
        resultTextField.setRows(4);
        resultTextField.setDoubleBuffered(true);
        jScrollPane1.setViewportView(resultTextField);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(labelSearchFor)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(searchTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                            .add(layout.createSequentialGroup()
                                .add(matchCaseCheckBox)
                                .add(14, 14, 14)
                                .add(searchSubfoldersCheckBox)
                                .add(24, 24, 24))))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(labelSearchIn)
                            .add(labelResult))
                        .add(10, 10, 10)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(sourceTextField)
                            .add(jScrollPane1))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(showButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(changeButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(searchButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelSearchFor)
                    .add(searchTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(searchButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(matchCaseCheckBox)
                    .add(searchSubfoldersCheckBox))
                .add(14, 14, 14)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelSearchIn)
                    .add(sourceTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(changeButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(labelResult)
                        .add(showButton))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 88, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeButtonActionPerformed
        
        chooser.setCurrentDirectory(new java.io.File(sourceFolder));
        
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) 
        {
            sourceFolder = chooser.getSelectedFile().toString();
            sourceTextField.setText(sourceFolder); 
        }
    }//GEN-LAST:event_changeButtonActionPerformed

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        
        DefaultListModel listModel = new DefaultListModel();
        resultList.setModel(listModel);
        
        fileList.stream().forEach((listaPagina) -> 
        {
            listModel.addElement(listaPagina);
            resultList.setModel(listModel);
        });
        
        this.resultWindow.setVisible(true);
    }//GEN-LAST:event_showButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        
        if(searchTextField.getText().isEmpty()) { return; }
            
        showButton.setVisible(false);
        fileList = new ArrayList<>();
        resultsCounter = 0;
        filesCounter = 0;
        target = new Target();
        target.setWord(searchTextField.getText());
        double startTime = System.currentTimeMillis();
        
        try {
            Files.walk(Paths.get(sourceFolder)).forEach((Path filePath) -> {
                
                if (Files.isRegularFile(filePath)) {
                    
                    target.setFilePath(filePath.toString());
                    target.setOccurrences(0);
                    
                    try {
                        
                        target = readFile(target);
                    } 
                    catch (IOException ex) {
                        
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    filesCounter++;
                    
                    if (target.getOccurrences()> 0)
                    {
                        resultsCounter += target.getOccurrences();
                        fileList.add(target.getOccurrences()+ " occurrences in " + target.getFilePath());
                    }
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        double endTime   = System.currentTimeMillis();
        double totalTime = endTime - startTime;
        this.resultTextField.setText("Found " + resultsCounter + " occurrences of \"" + target.getWord()+ "\".\nTotal of " + filesCounter + " documents searched in " + (totalTime/1000) + " seconds.");       
        
        if(resultsCounter > 0) {
        
            showButton.setVisible(true);
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void resultListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultListMouseClicked
        
        linkIndex = resultList.getSelectedIndex();
    }//GEN-LAST:event_resultListMouseClicked

    private void openFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileButtonActionPerformed
        // Recebe mensagem com o caminho selecionado no menu de exibição de resuotados
        selectedLink = this.fileList.get(linkIndex);

        // Seleciona apenas o caminho desejado e o insere em selectedLink
        for (int i = 0; i < selectedLink.length(); i++)
        {
            if (selectedLink.charAt(i) == 'C')
            {
                String aux = "";
                for (int j = i; j < selectedLink.length(); j++)
                {
                    aux += selectedLink.charAt(j);
                }
                selectedLink = aux;
                break;
            }
        }

        // Caso o arquivo exista na base de dados, abra-o com o programa padrão do windows
        try {
            File file = new File(selectedLink);
            if (file.exists())
            {
                if (Desktop.isDesktopSupported()) Desktop.getDesktop().open(file);
            }
            else
            {
                System.out.println("Broken link at: " + selectedLink);
            }
        }
        catch (IOException ert) {}
    }//GEN-LAST:event_openFileButtonActionPerformed
    
    private Target readFile(Target target) throws IOException {
        
        String line = null;
        if(matchCaseCheckBox.isSelected()) {
            
            finiteStateMachine = new FiniteStateMachine(target.getWord());
        
            try (BufferedReader file = new BufferedReader(new FileReader(new File(target.getFilePath())))) {
            
                while((line = file.readLine()) != null)
                {
                    target.setOccurrences(finiteStateMachine.run(line));
                }
            }
        }
        else {
            
            finiteStateMachine = new FiniteStateMachine(target.getWord().toLowerCase());
        
            try (BufferedReader file = new BufferedReader(new FileReader(new File(target.getFilePath())))) {
            
                while((line = file.readLine()) != null)
                {
                    target.setOccurrences(finiteStateMachine.run(line.toLowerCase()));
                }
            }
        }
        
        return target;
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels=javax.swing.UIManager.getInstalledLookAndFeels();
            for (int idx=0; idx<installedLookAndFeels.length; idx++)
                if ("Nimbus".equals(installedLookAndFeels[idx].getName())) {
                    javax.swing.UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
                    break;
                }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changeButton;
    private javax.swing.JFileChooser chooser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelResult;
    private javax.swing.JLabel labelSearchFor;
    private javax.swing.JLabel labelSearchIn;
    private javax.swing.JCheckBox matchCaseCheckBox;
    private javax.swing.JButton openFileButton;
    public javax.swing.JList resultList;
    private javax.swing.JTextArea resultTextField;
    private javax.swing.JFrame resultWindow;
    private javax.swing.JButton searchButton;
    private javax.swing.JCheckBox searchSubfoldersCheckBox;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JButton showButton;
    private javax.swing.JTextField sourceTextField;
    // End of variables declaration//GEN-END:variables
}