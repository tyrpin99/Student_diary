package com.company;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import javax.swing.DefaultListModel;

public class GUI implements ListSelectionListener, ActionListener, TableModelListener {
    private JFrame frame = new JFrame();
    private JFrame studentsFrame = new JFrame();
    private JFrame emptyClassesFrame = new JFrame();
    private JPanel mainPanel = new JPanel();
    private JTable studentsTable = new JTable();
    private JLabel label1 = new JLabel("Groups");
    private JLabel label2 = new JLabel("Students");
    private JLabel label3 = new JLabel("Type");
    private JButton bAdStudent = new JButton("Add Student");
    private JButton bAddPoints = new JButton("Add Points");
    private JButton bGetStudent = new JButton("Get Student");
    // private JButton bChangeC = new JButton("Change Condition");
    private JButton bRemoveP = new JButton("RemovePoints");
    private JButton bSearch = new JButton("Search");
    private JButton bSearchP = new JButton("Search Partial");
    private JButton bCountC = new JButton("CountByCondition");

    private JButton bSortN = new JButton("Sort by Name");
    private JButton bSortP = new JButton("Sort by Points");
    private JButton bMax = new JButton("Max");
    private JButton bShow = new JButton("SHOW");

    private JButton bAddClass = new JButton("Add Class");
    private JButton bRemoveC = new JButton("Remove Class");
    private JButton bFindC = new JButton("Find empty Class");
    private JButton bSumm2 = new JButton("Class summary");

    private JTextField tName = new JTextField("Name");
    private JTextField tSurrname = new JTextField("Surrname");
    private JComboBox sCondition = new JComboBox();
    private JTextField tYear = new JTextField("Year");
    private JTextField tPoints = new JTextField("Points");

    private JTextField tGName = new JTextField("Name");
    private JTextField tGCap = new JTextField("Capacity");
    private JTable table = new JTable();
    private Student selectedStudent;

    JList gList = new JList();

    // Class class1 = new Class( "dwsadsa",20);

    // tabela studentow
    // private JTable students = new JTable();
    ArrayList<String> columns = new ArrayList<String>();
    ArrayList<Student> list = new ArrayList<Student>();
    // Map<String,Class> groups = new TreeMap<String, Class>();
    // Class class1 = new Class("First",20);
    ClassContainer groups = new ClassContainer();
    // ArrayList<Class> list2 = new ArrayList<String>(TreeMap);
    /*
     * public void convertMapToList() {
     * 
     * for (Class singleClass : groups.values()
     * ) {
     * ArrayList<Class> classList
     * = new ArrayList<Class>(groups.values());
     * 
     * }
     * 
     * }
     * 
     */

    // DefaultListModel listModel = new DefaultListModel(value );

    /*
     * ArrayList<String> keyList
     * = new ArrayList<String>(groups.keySet());
     * 
     * ArrayList<Class> valueList
     * = new ArrayList<Class>(groups.values());
     * System.out.println(
     * "List of keys of the given Map : " + keyList);
     * 
     * // printing the valueList
     * System.out.println(
     * "List of values of the given Map : "
     * + valueList);
     * 
     */
    // }

    // private JList groupList = new TreeMap<>(groups);

    public ArrayList<String[]> change(ArrayList<Student> list) {

        ArrayList<String[]> values = new ArrayList<String[]>();
        int index = 1;

        for (int i = 0; i < list.size(); i++) {

            values.add(new String[] { String.valueOf(index), list.get(i).name, list.get(i).surrname,
                    String.valueOf(list.get(i).studentCondition), String.valueOf(list.get(i).year),
                    String.valueOf(list.get(i).points) });
            index++;

        }
        return values;
    }

    TableModel tableModel = new DefaultTableModel(change(list).toArray(new Object[][] {}), columns.toArray());
    /*
     * public ArrayList<String> change2(Map<String,Class> groups) {
     * 
     * ArrayList<String> classList = new ArrayList<String>();
     * for (int i = 0; i < groups.size(); i++) {
     * 
     * classList.add(String.valueOf(groups.get(i).groupName));
     * 
     * }
     * 
     * return classList;
     * }
     * 
     */
    // DefaultListModel listModel = new DefaultListModel(change2(groups).toArray(new
    // Object[] {}));
    // DefaultTableModel tableModel;
    DefaultListModel model;

    // JTable students = new JTable(tableModel);

    // JScrollPane sp = new JScrollPane(students);
    /*
     * public Map<String,Class> change2(TreeMap<String,Class> groups)
     * {
     * TreeMap<String,Class> empty = new TreeMap<String,Class>();
     * for (Class group : groups.values()) {
     * // empty.put(new TreeMap<String,Class>());
     * System.out.println(group.groupName)+" Filling : "+(group.studentList.size()/(
     * double)group.studentMax)*100+"%" );
     * }
     * 
     * }
     * 
     * return empty;
     * }
     */
    // JPanel

    public GUI() {

        model = new DefaultListModel();
        gList = new JList(model);

        // ArrayList<Class> classList = new ArrayList<Class>(groups.values());

        // gList = new JList(classList);
        // protected void initDetail(int selectedRow) {
        // selectedStudent = list.get(selectedRow);
        // }

        initComponents();

        columns.add("Index"); 
        columns.add("Name");
        columns.add("Surrname");
        columns.add("Condition");
        columns.add("Birth");
        columns.add("Points");

    }

    public void initComponents() {
        bAdStudent.addActionListener(this);
        bGetStudent.addActionListener(this);
        bRemoveC.addActionListener(this);
        bRemoveP.addActionListener(this);
        bShow.addActionListener(this);
        bSearch.addActionListener(this);
        bSearchP.addActionListener(this);
        bAddPoints.addActionListener(this);
        bAddClass.addActionListener(this);
        bSumm2.addActionListener(this);
        bFindC.addActionListener(this);
        bMax.addActionListener(this);
        bSortN.addActionListener(this);
        bSortP.addActionListener(this);
        bCountC.addActionListener(this);

        gList.setVisibleRowCount(1);
        gList.setSelectionBackground(Color.BLUE);
        gList.setSelectionForeground(Color.GREEN);
        gList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollList = new JScrollPane(gList);
        /*
         * String name = (String) gList.getSelectedValue();
         * Class klasa1 = groups.getGroupB(name);
         * JPanel panelTable = new JPanel();
         * panelTable.setLayout(new BorderLayout());
         * TableModel tableModel= new DefaultTableModel(klasa1.studentList.toArray(new
         * Object[][]{}),columns.toArray());
         * JTable table = new JTable(tableModel);
         * panelTable.add(table.getTableHeader());
         * panelTable.add(new JScrollPane(table));
         * // this.getContentPane().add(panelTable,BorderLayout.CENTER);
         */

        // groupList.add()
        sCondition.setModel(new DefaultComboBoxModel<>(StudentCondition.values()));

        // mainPanel.add();
        JFrame frame = new JFrame("Electrionic Dictionary");

        frame.setBounds(300, 300, 500, 500);
        frame.setDefaultCloseOperation(3);
        frame.add(mainPanel);

        GroupLayout layout = new GroupLayout(mainPanel);
        mainPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(
                        layout.createParallelGroup().addComponent(bAdStudent, 20, 100, 100)
                                .addComponent(bAddPoints, 20, 100, 100)
                                .addComponent(bCountC, 20, 100, 100).addComponent(bMax, 20, 100, 100)
                                .addGroup(
                                        layout.createParallelGroup().addComponent(bAddClass, 20, 100, 100)
                                                .addComponent(bRemoveC, 20, 100, 100).addComponent(bFindC, 20, 100, 100)
                                                .addComponent(bSumm2, 20, 100, 100)))
                .addGroup(
                        layout.createParallelGroup().addComponent(bGetStudent, 20, 100, 100)
                                .addComponent(bRemoveP, 20, 100, 100)
                                .addComponent(bSortN, 20, 100, 100).addComponent(tGName, 20, 100, 100)
                                .addComponent(tGCap, 20, 100, 100)
                                .addComponent(label1, 20, 100, 100).addComponent(label2, 20, 100, 100))
                .addGroup(
                        layout.createParallelGroup().addComponent(bSearch, 20, 100, 100)
                                .addComponent(bSearchP, 20, 100, 100)
                                .addComponent(bSortP, 20, 100, 100).addComponent(bShow, 20, 100, 100)
                                .addComponent(scrollList, 20, 100, 100))
                .addGroup(
                        layout.createParallelGroup().addComponent(tName, 20, 100, 100)
                                .addComponent(tSurrname, 20, 100, 100).addComponent(tYear, 20, 100, 100)
                                .addComponent(sCondition, 20, 100, 100).addComponent(tPoints, 20, 100, 100)
                                .addComponent(label3, 30, 50, 70))

        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(
                        layout.createParallelGroup().addComponent(label2, 15, 20, 25).addComponent(label3, 20, 20, 25))

                .addGroup(
                        layout.createParallelGroup().addComponent(bAdStudent, 15, 20, 30)
                                .addComponent(bGetStudent, 15, 20, 30)
                                .addComponent(bSearch, 15, 20, 30).addComponent(tName, 15, 20, 25))
                .addGroup(
                        layout.createParallelGroup().addComponent(bAddPoints, 15, 20, 30)
                                .addComponent(bRemoveP, 15, 20, 30)
                                .addComponent(bSearchP, 15, 20, 30).addComponent(tSurrname, 15, 20, 25))
                .addGroup(
                        layout.createParallelGroup().addComponent(bCountC, 15, 20, 30).addComponent(bSortN, 15, 20, 30)
                                .addComponent(bSortP, 15, 20, 30).addComponent(sCondition, 15, 30, 35))
                .addGroup(
                        layout.createParallelGroup().addComponent(bMax, 15, 20, 30)
                                .addComponent(tYear, 15, 20, 25).addComponent(bShow, 15, 20, 30))
                .addGroup(
                        layout.createParallelGroup().addComponent(tPoints, 15, 20, 25).addComponent(label1, 15, 20, 25))

                // .addGap(10,20,100)
                .addGroup(
                        layout.createParallelGroup()

                                .addComponent(bAddClass, 15, 20, 30)

                                .addComponent(tGName, 15, 20, 25)
                                .addComponent(scrollList, 20, 25, 30)
                // .addComponent(sp,30,100,100)

                )
                .addGroup(
                        layout.createParallelGroup()
                                .addComponent(bRemoveC, 15, 20, 30)
                                .addComponent(tGCap, 15, 20, 25))

                .addComponent(bFindC, 15, 20, 30)
                .addComponent(bSumm2, 15, 20, 30)

        );

        frame.setVisible(true);
        // pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == bAdStudent) {
            Student student = new Student(tName.getText(), tSurrname.getText(),
                    (StudentCondition) sCondition.getSelectedItem(), Integer.parseInt(tYear.getText()),
                    Double.parseDouble(tPoints.getText()));

            String name = (String) gList.getSelectedValue();
            Class klasa = groups.getGroupB(name);

            if (klasa.studentList.size() + 1 == klasa.studentMax) {
                JOptionPane.showMessageDialog(null, "Class is full!", "Adding student",
                        JOptionPane.INFORMATION_MESSAGE);

            } else {
                klasa.addStudent(student);
                JOptionPane.showMessageDialog(null, "Succesful!", "Adding student", JOptionPane.INFORMATION_MESSAGE);

            }

        } else if (source == bGetStudent) {
            // table.addMouseListener(new MouseAdapter() {
            // public void mouseClicked(MouseEvent e){
            // initComponents(table.getSelectedRow());
            // }
            // });
            // Student student = (Student)
            // Student(table.convertRowIndexToModel(table.getSelectedRow()));

        } else if (source == bAddPoints) {
            String name = (String) gList.getSelectedValue();
            Class klasa2 = groups.getGroupB(name);
            // klasa2.addPoints(Student student,tPoints.getText());

        } else if (source == bRemoveP) {
            String points = tPoints.getText();

        } else if (source == bSearch) {
            String search = tSurrname.getText();
            String name = (String) gList.getSelectedValue();
            Class klasa2 = groups.getGroupB(name);
            Student student = klasa2.searchSurr(search);
            // 1 . jak tu odwolac sie do studenta ktory został znaleziony zebym mogl go
            // podswietlic w tabeli?
            if (student != null) { 
                DefaultTableModel model = (DefaultTableModel) studentsTable.getModel();
                int rowsNum = model.getRowCount();
                for (int i = 0; i < rowsNum; i++) {
                    String rowName = (String) model.getValueAt(i,1);
                    String rowSurname = (String) model.getValueAt(i,2);
                     if (student.name == rowName && student.surrname == rowSurname) {
                        studentsTable.addRowSelectionInterval(i, i);
                        studentsTable.setBackground(Color.white);
                        studentsTable.setForeground(Color.BLUE);
                    }

                }
            } 

        } else if (source == bSearchP) {
            String search = tSurrname.getText();
            String name = (String) gList.getSelectedValue();
            Class klasa2 = groups.getGroupB(name);
            klasa2.searchPartial(search);

        } else if (source == bFindC) {

            JPanel epmtyP = new JPanel();
            ArrayList<Class> emptyClasses = groups.findEmpty();
            String[] emptyClassesNames = new String[emptyClasses.size()];
            Iterator<Class> classIterator = emptyClasses.iterator();
            int nextIndex = 0;
            while(classIterator.hasNext()){
                emptyClassesNames[nextIndex++] = classIterator.next().groupName;
             }

            // }
            JList listE = new JList<>(emptyClassesNames);
            // JLabel empty = new JLabel();
            epmtyP.add(listE);
            emptyClassesFrame.add(epmtyP);
            emptyClassesFrame.pack();
            emptyClassesFrame.setVisible(true);

            // 2. Jak tu zrobic zeby wyswietlalo mi nazwe klasy a nie instacje

        } else if (source == bAddClass) {
            Class class1 = new Class(tGName.getText(), Integer.parseInt(tGCap.getText()));
            groups.addClass(class1.groupName, class1);
            model.addElement(class1.groupName);
            JOptionPane.showMessageDialog(null, "Succesful!", "Adding class", JOptionPane.INFORMATION_MESSAGE);

        } else if (source == bRemoveC) {
            String name = (String) gList.getSelectedValue();
            groups.removeClass(name);
            model.removeElement(name);
            JOptionPane.showMessageDialog(null, "Succesful!", "Adding class", JOptionPane.INFORMATION_MESSAGE);

        } else if (source == bShow) {
            studentsFrame = new JFrame();
            JPanel showPanel = new JPanel();
            // showPanel.setLayout(new BorderLayout());
            String name = (String) gList.getSelectedValue();
            Class class1 = groups.getGroupB(name);

            TableModel tableModel = new DefaultTableModel(change(class1.studentList).toArray(new Object[][] {}),
                    columns.toArray());
            
            studentsTable.setModel(tableModel);
            // table.setName("Student table");
            studentsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            showPanel.add(studentsTable.getTableHeader());
            showPanel.add(new JScrollPane(studentsTable));

            studentsFrame.add(showPanel);
            studentsFrame.pack();
            studentsFrame.setVisible(true);

        } else if (source == bSumm2) {
            JFrame frameClassSummary = new JFrame();
            JPanel summaryPanel = new JPanel();
            ;

            JLabel groupName = new JLabel("Group Name");
            JLabel capacity = new JLabel("Capacity");
            GridLayout classSummaryGrid = new GridLayout(0,2);

            summaryPanel.setLayout(classSummaryGrid);
            summaryPanel.add(groupName);
            summaryPanel.add(capacity);
            
            
            // 3. jak tutaj dostac sie do wartosci group name i capcity ?
            // Mozna to grid layout zastapic tez tabelka tak jak miales w innym przypadku
            for(Class singleClass: groups.getAllGroups().values()){
                summaryPanel.add(new JLabel(singleClass.groupName));
                summaryPanel.add(new JLabel(String.valueOf(singleClass.studentMax)));
            };

            frameClassSummary.add(summaryPanel);
            frameClassSummary.pack();
            frameClassSummary.setVisible(true);
        } else if (source == bSortP) {
            String name = (String) gList.getSelectedValue();
            Class class1 = groups.getGroupB(name);
            class1.sortByPoints();

        } else if (source == bSortN) {
            String name = (String) gList.getSelectedValue();
            Class class1 = groups.getGroupB(name);
            class1.sortByName();

        } else if (source == bMax) {
            String name = (String) gList.getSelectedValue();
            Class class1 = groups.getGroupB(name);
            class1.max();

        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

    @Override
    public void tableChanged(TableModelEvent e) {

    }
}
