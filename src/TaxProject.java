import java.awt.event.*;
import javax.imageio.IIOException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * Created by JFormDesigner on Tue Jul 27 10:34:48 PDT 2021
 */



/**
 * @author unknown
 */
public class TaxProject extends JFrame {

 public static ArrayList<Employee> list1 = new ArrayList<Employee>();

 public TaxProject() {
  initComponents();
 }

 private void btnaddActionPerformed(ActionEvent e) {
  // TODO add your code here

  String num = txtnumb.getText();
  String name =txttempname.getText();
  String income = txtincome.getText();
  String status = "";
  String member = "";

  if (rbosingle.isSelected()) {
   status = "Single";
  }

  if (rbomarried.isSelected()) {
   status = "Married";
  }

  if (chkunion.isSelected()) {
   member = "Yes";

  } else {
   member = "No";
  }

  list1.add(new Employee(num, name, income, status, member));
  WriteFile();

  String[][] array = new String[list1.size()][5];

  for (int i = 0; i < list1.size(); ++i) {

   array[i][0] = list1.get(i).getEmpNum();
   array[i][1] = list1.get(i).getEmpName();
   array[i][2] = list1.get(i).getMonthlyIncome();
   array[i][3] = list1.get(i).getStatus();
   array[i][4] = list1.get(i).getMember();
  }

  String columns[] = {"Emp Number", "Emp Name", "Income", "Status", "Member Type"};

  DefaultTableModel model = new DefaultTableModel(array, columns);

  jdata.setModel(model);
 }

 private void btneditActionPerformed(ActionEvent e) {
  // TODO add your code here

  DefaultTableModel model = (DefaultTableModel) jdata.getModel();
  int index1 = jdata.getSelectedRow();
  String oldValue = model.getValueAt(index1, 0).toString();

  for (int i = 0; i < list1.size(); ++i){

   if (oldValue.equals(list1.get(i).getEmpNum())){
    list1.remove(i);
   }
  }

  String num = txtnumb.getText();
  String name =txttempname.getText();
  String income = txtincome.getText();
  String status = "";
  String member = "";

  if (rbosingle.isSelected()) {
   status = "Single";
  }

  if (rbomarried.isSelected()) {
   status = "Married";
  }

  if (chkunion.isSelected()) {
   member = "Yes";

  } else {
   member = "No";
  }

  list1.add(new Employee(num, name, income, status, member));
  WriteFile();

  String[][] array = new String[list1.size()][5];

  for (int i = 0; i < list1.size(); ++i) {

   array[i][0] = list1.get(i).getEmpNum();
   array[i][1] = list1.get(i).getEmpName();
   array[i][2] = list1.get(i).getMonthlyIncome();
   array[i][3] = list1.get(i).getStatus();
   array[i][4] = list1.get(i).getMember();
  }

  String columns[] = {"Emp Number", "Emp Name", "Income", "Status", "Member Type"};

  DefaultTableModel model2 = new DefaultTableModel(array, columns);

  jdata.setModel(model2);
 }

 private void jdataMouseClicked(MouseEvent e) {
  // TODO add your code here

  DefaultTableModel model = (DefaultTableModel) jdata.getModel();

  int index1 = jdata.getSelectedRow();

  txtnumb.setText(model.getValueAt(index1,0).toString());
  txttempname.setText(model.getValueAt(index1,1).toString());
  txtincome.setText(model.getValueAt(index1,2).toString());
  String status = model.getValueAt(index1, 3).toString();
  String member = model.getValueAt(index1, 4).toString();

  if (status.equals("Single")) {
   rbosingle.setSelected(true);
  }

  if (status.equals("Married")) {
   rbomarried.setSelected(true);
  }

  if (member.equals("Yes")) {
   chkunion.setSelected(true);
  } else {
   chkunion.setSelected(false);
  }

  double tax;
  double taxAfter=0;
  DecimalFormat dec = new DecimalFormat("#.##");

  txtpretax.setText(txtincome.getText());

  if (rbosingle.isSelected()) {
   tax = Double.parseDouble(txtincome.getText()) * 0.15;
   txttax.setText(dec.format(tax));
   taxAfter = Double.parseDouble(txtincome.getText()) - tax;
   txtposttax.setText(dec.format(taxAfter));

  }

  if (rbomarried.isSelected()) {
   tax = Double.parseDouble(txtincome.getText()) * 0.10;
   txttax.setText(dec.format(tax));
   taxAfter = Double.parseDouble(txtincome.getText()) - tax;
   txtposttax.setText(dec.format(taxAfter));

  }

  if (chkunion.isSelected()) {
   taxAfter = taxAfter - 100;
   txtposttax.setText(dec.format(taxAfter));

  }

 }

 private void btndeleteActionPerformed(ActionEvent e) {
  // TODO add your code here

  DefaultTableModel model = (DefaultTableModel) jdata.getModel();
  int index1 = jdata.getSelectedRow();
  String oldValue = model.getValueAt(index1, 0).toString();

  for (int i = 0; i < list1.size(); ++i){

   if (oldValue.equals(list1.get(i).getEmpNum())){
    list1.remove(i);
   }
  }

  WriteFile();

  String[][] array = new String[list1.size()][5];

  for (int i = 0; i < list1.size(); ++i) {

   array[i][0] = list1.get(i).getEmpNum();
   array[i][1] = list1.get(i).getEmpName();
   array[i][2] = list1.get(i).getMonthlyIncome();
   array[i][3] = list1.get(i).getStatus();
   array[i][4] = list1.get(i).getMember();
  }

  String columns[] = {"Emp Number", "Emp Name", "Income", "Status", "Member Type"};

  DefaultTableModel model2 = new DefaultTableModel(array, columns);

  jdata.setModel(model2);
 }

 private void initComponents() {
  // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
  // Generated using JFormDesigner Evaluation license - unknown
  label1 = new JLabel();
  txtnumb = new JTextField();
  label2 = new JLabel();
  txttempname = new JTextField();
  label3 = new JLabel();
  txtincome = new JTextField();
  rbosingle = new JRadioButton();
  rbomarried = new JRadioButton();
  chkunion = new JCheckBox();
  panel1 = new JPanel();
  label4 = new JLabel();
  txtpretax = new JTextField();
  label5 = new JLabel();
  txttax = new JTextField();
  label6 = new JLabel();
  txtposttax = new JTextField();
  scrollPane1 = new JScrollPane();
  jdata = new JTable();
  btnadd = new JButton();
  btnedit = new JButton();
  btndelete = new JButton();

  //======== this ========
  var contentPane = getContentPane();
  contentPane.setLayout(new MigLayout(
      "hidemode 3",
      // columns
      "[fill]" +
      "[fill]",
      // rows
      "[]" +
      "[]" +
      "[]" +
      "[]" +
      "[]" +
      "[]" +
      "[]"));

  //---- label1 ----
  label1.setText("enter the employee number");
  contentPane.add(label1, "cell 0 0");

  //---- txtnumb ----
  txtnumb.setColumns(20);
  contentPane.add(txtnumb, "cell 1 0");

  //---- label2 ----
  label2.setText("Enter the employee name");
  contentPane.add(label2, "cell 0 1");

  //---- txttempname ----
  txttempname.setColumns(20);
  contentPane.add(txttempname, "cell 1 1");

  //---- label3 ----
  label3.setText("Enter the monthly income");
  contentPane.add(label3, "cell 0 2");

  //---- txtincome ----
  txtincome.setColumns(20);
  contentPane.add(txtincome, "cell 1 2");

  //---- rbosingle ----
  rbosingle.setText("Single");
  contentPane.add(rbosingle, "cell 1 3");

  //---- rbomarried ----
  rbomarried.setText("Married");
  contentPane.add(rbomarried, "cell 1 3");

  //---- chkunion ----
  chkunion.setText("Union member");
  contentPane.add(chkunion, "cell 1 4");

  //======== panel1 ========
  {
      panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.
      swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e",javax.swing.border
      .TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dialo\u0067"
      ,java.awt.Font.BOLD,12),java.awt.Color.red),panel1. getBorder
      ()));panel1. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java
      .beans.PropertyChangeEvent e){if("borde\u0072".equals(e.getPropertyName()))throw new RuntimeException
      ();}});
      panel1.setLayout(new MigLayout(
          "hidemode 3",
          // columns
          "[fill]",
          // rows
          "[]" +
          "[]" +
          "[]" +
          "[]" +
          "[]" +
          "[]"));

      //---- label4 ----
      label4.setText("The income");
      panel1.add(label4, "cell 0 0");

      //---- txtpretax ----
      txtpretax.setColumns(20);
      panel1.add(txtpretax, "cell 0 1");

      //---- label5 ----
      label5.setText("Total Tax");
      panel1.add(label5, "cell 0 2");
      panel1.add(txttax, "cell 0 3");

      //---- label6 ----
      label6.setText("Income after tax");
      panel1.add(label6, "cell 0 4");
      panel1.add(txtposttax, "cell 0 5");
  }
  contentPane.add(panel1, "cell 0 5");

  //======== scrollPane1 ========
  {
      scrollPane1.setViewportView(jdata);
  }
  contentPane.add(scrollPane1, "cell 1 5");

  //---- btnadd ----
  btnadd.setText("Add");
  contentPane.add(btnadd, "cell 1 6");

  //---- btnedit ----
  btnedit.setText("Edit");
  contentPane.add(btnedit, "cell 1 6");

  //---- btndelete ----
  btndelete.setText("Delete");
  contentPane.add(btndelete, "cell 1 6");
  pack();
  setLocationRelativeTo(getOwner());

  //---- buttonGroup1 ----
  var buttonGroup1 = new ButtonGroup();
  buttonGroup1.add(rbosingle);
  buttonGroup1.add(rbomarried);
  // JFormDesigner - End of component initialization  //GEN-END:initComponents
 }

 // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
 // Generated using JFormDesigner Evaluation license - unknown
 private JLabel label1;
 private JTextField txtnumb;
 private JLabel label2;
 private JTextField txttempname;
 private JLabel label3;
 private JTextField txtincome;
 private JRadioButton rbosingle;
 private JRadioButton rbomarried;
 private JCheckBox chkunion;
 private JPanel panel1;
 private JLabel label4;
 private JTextField txtpretax;
 private JLabel label5;
 private JTextField txttax;
 private JLabel label6;
 private JTextField txtposttax;
 private JScrollPane scrollPane1;
 private JTable jdata;
 private JButton btnadd;
 private JButton btnedit;
 private JButton btndelete;
 // JFormDesigner - End of variables declaration  //GEN-END:variables

 public static void main(String[] args) {

  TaxProject form1 = new TaxProject();
  form1.setVisible(true);
  form1.ReadFile();

 }

 public void ReadFile() {

  String path = "empfile.txt";
  File myFile = new File(path);
  String input[];

  if (myFile.length()!=0) {
   try {
    Scanner myReader = new Scanner(myFile);

    while (myReader.hasNextLine()) {
     String data = myReader.nextLine();
     input = data.split("\\s+");
     String num = input[0];
     String name = input[1];
     String income = input[2];
     String status = input[3];
     String member = input[4];

     list1.add(new Employee(num, name, income, status, member));

    }

    myReader.close();

   } catch (FileNotFoundException ex) {

    System.out.println("File not found");
   }
  }

  String[][] array = new String[list1.size()][5];

  for (int i = 0; i < list1.size(); ++i) {

   array[i][0] = list1.get(i).getEmpNum();
   array[i][1] = list1.get(i).getEmpName();
   array[i][2] = list1.get(i).getMonthlyIncome();
   array[i][3] = list1.get(i).getStatus();
   array[i][4] = list1.get(i).getMember();
  }

  String columns[] = {"Emp Number", "Emp Name", "Income", "Status", "Member Type"};

  DefaultTableModel model = new DefaultTableModel(array, columns);

  jdata.setModel(model);
 }

 public void WriteFile() {

  String path = "empfile.txt";
  File myFile = new File(path);
  String input;

  try {

   FileWriter myWriter = new FileWriter(myFile);

   for (int j = 0; j < list1.size(); ++j){

    input = list1.get(j).getEmpNum() + " " + list1.get(j).getEmpName() + " " + list1.get(j).getMonthlyIncome() + " " + list1.get(j).getStatus() + " " + list1.get(j).getMember() + "\n";
    myWriter.write(input);
   }

   myWriter.close();
  } catch (IOException ex) {

   System.out.println("File Writing Error");
  }
 }


}