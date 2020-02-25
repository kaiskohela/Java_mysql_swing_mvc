package View;


import Controller.StudentDAO;
import Model.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class AddStudent extends JFrame {
    static AddStudent frame;
    private JPanel contentPane;

    ImageIcon img = new ImageIcon("C:\\Users\\kais\\IdeaProjects\\Students_Mangement\\imgs\\admin.png");
    ImageIcon img1 = new ImageIcon("C:\\Users\\kais\\IdeaProjects\\Students_Mangement\\imgs\\icon.png");
    private JTextField jTextFieldstudentId;
    private JTextField jTextFieldname;
    private JTextField jTextFieldemail;


    public static void main(String[] args) {
        ImageIcon img = new ImageIcon("C:\\Users\\kais\\IdeaProjects\\Students_Mangement\\imgs\\admin.png");

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    frame = new AddStudent();
                    frame.setTitle("Student Management");
                    frame.setVisible(true);
                    frame.setIconImage(img.getImage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //add student
    public AddStudent() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblAddStudent = new JLabel("Add Student ++");
        JLabel lblstudentId = new JLabel("StudentId : ");
        JLabel lblName = new JLabel("NAME : ");
        JLabel lblEmail = new JLabel("EMAIL : ");


        JButton btnAddStudent = new JButton("Add Student");
        btnAddStudent.setBackground(new Color(59, 89, 182));
        btnAddStudent.setForeground(Color.WHITE);
        btnAddStudent.setFocusPainted(false);
        btnAddStudent.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnAddStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int studentId = parseInt(jTextFieldstudentId.getText());
                String name = jTextFieldname.getText();
                String email = jTextFieldemail.getText();

                Student student = new Student(studentId, name, email);
                int status = StudentDAO.save(student);

                if (status > 0) {
                    JOptionPane.showMessageDialog(AddStudent.this, "Student added Successfully!!");
                    jTextFieldstudentId.setText("");
                    jTextFieldname.setText("");
                    jTextFieldemail.setText("");
                } else {
                    JOptionPane.showMessageDialog(AddStudent.this, "Sorry, Unable to add Student!!");

                }
            }

        });


        JButton btnEditStudent = new JButton("Edit Student");
        btnEditStudent.setBackground(new Color(182, 164, 0));
        btnEditStudent.setForeground(Color.WHITE);
        btnEditStudent.setFocusPainted(false);
        btnEditStudent.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnEditStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int studentId = parseInt(jTextFieldstudentId.getText());
                String name = jTextFieldname.getText();
                String email = jTextFieldemail.getText();

                Student student = new Student(studentId, name, email);
                int status = StudentDAO.update(student);

                if (status > 0) {
                    JOptionPane.showMessageDialog(AddStudent.this, "Student Updated Successfully!!");
                    jTextFieldstudentId.setText("");
                    jTextFieldname.setText("");
                    jTextFieldemail.setText("");
                } else {
                    JOptionPane.showMessageDialog(AddStudent.this, "Sorry, Unable to Update Student!!");

                }
            }

        });

        JButton btnDeleteStudent = new JButton("Delete Student");
        btnDeleteStudent.setBackground(new Color(182, 42, 25));
        btnDeleteStudent.setForeground(Color.WHITE);
        btnDeleteStudent.setFocusPainted(false);
        btnDeleteStudent.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnDeleteStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int studentId = parseInt(jTextFieldstudentId.getText());
                String name = jTextFieldname.getText();
                String email = jTextFieldemail.getText();

                Student student = new Student(studentId, name, email);
                int status = StudentDAO.delete(student);

                if (status > 0) {
                    JOptionPane.showMessageDialog(AddStudent.this, "Student deleted Successfully!!");
                    jTextFieldstudentId.setText("");
                    jTextFieldname.setText("");
                    jTextFieldemail.setText("");
                } else {
                    JOptionPane.showMessageDialog(AddStudent.this, "Sorry, Unable to delete Student!!");

                }
            }

        });

        JButton btnViewStudent = new JButton("View Students");
        btnViewStudent.setBackground(new Color(21, 171, 182));
        btnViewStudent.setForeground(Color.WHITE);
        btnViewStudent.setFocusPainted(false);
        btnViewStudent.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnViewStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewStudent frame = new ViewStudent();
                frame.setVisible(true);
                frame.setTitle("Students Table");
                frame.setIconImage(img1.getImage());
            }

        });


        jTextFieldstudentId = new JTextField();
        jTextFieldstudentId.setColumns(40);


        jTextFieldname = new JTextField();
        jTextFieldname.setColumns(20);

        jTextFieldemail = new JTextField();
        jTextFieldemail.setColumns(10);


        //section view student begins here :
        //view student end

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(150))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblstudentId)
                                                        .addComponent(lblName)
                                                        .addComponent(lblEmail))

                                                .addGap(30)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextFieldstudentId, GroupLayout.PREFERRED_SIZE, 50, Short.MAX_VALUE)
                                                        .addComponent(jTextFieldname, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                                        .addComponent(jTextFieldemail, GroupLayout.PREFERRED_SIZE, 50, Short.MAX_VALUE))
                                        )
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(btnAddStudent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnEditStudent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnDeleteStudent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnViewStudent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(150))
                                .addContainerGap(200, Short.MAX_VALUE))

        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblstudentId)
                                        .addComponent(jTextFieldstudentId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblName)
                                        .addComponent(jTextFieldname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(gl_contentPane.createParallelGroup()
                                        .addComponent(lblEmail)
                                        .addComponent(jTextFieldemail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAddStudent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnEditStudent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDeleteStudent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnViewStudent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)

                                )
                                .addContainerGap(50, Short.MAX_VALUE))

        );
        contentPane.setLayout(gl_contentPane);

    }


}

