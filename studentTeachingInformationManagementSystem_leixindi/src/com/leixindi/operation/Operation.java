package com.leixindi.operation;

import com.leixindi.bean.*;
import com.leixindi.service.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ϵͳ�Ĳ�����
 */
public class Operation {
    /**
     * ϵͳ�������ͽ�������ķ���
     */
    public void showMainMenu() {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        // ���ô���Ĳ���Ϊ���Բ���
        jFrame.setLayout(null);
        // ʵ������ǩ����
        JLabel menuTestLabel = new JLabel("ѧ����ѧ��Ϣ����ϵͳ����");
        JButton adLoginButton = new JButton("����Ա��¼");
        JButton teaLoginButton = new JButton("��ʦ��¼");
        JButton stuLoginButton = new JButton("ѧ����¼");
        JButton exitSystemButton = new JButton("�˳�ϵͳ");
        // ���ø�����ڴ��������ʹ�С
        menuTestLabel.setBounds(70, 0, 200, 30);
        adLoginButton.setBounds(100, 40, 100, 30);
        teaLoginButton.setBounds(100, 80, 100, 30);
        stuLoginButton.setBounds(100, 120, 100, 30);
        exitSystemButton.setBounds(100, 160, 100, 30);
        // ��������ŵ�������
        jFrame.add(menuTestLabel);
        jFrame.add(adLoginButton);
        jFrame.add(teaLoginButton);
        jFrame.add(stuLoginButton);
        jFrame.add(exitSystemButton);
        // ���ô����С
        jFrame.setSize(320, 350);
        // ���ô�������
        jFrame.setLocation(500, 200);
        // �ô���ɼ�
        jFrame.setVisible(true);
        // Ϊ��������¼������ʹ������
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
        // Ϊ����Ա��¼��ť����¼������ʹ������
        adLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == adLoginButton) {
                    adminLogin();
                    jFrame.dispose();
                }
            }
        });
        // Ϊ��ʦ��¼��ť����¼������ʹ������
        teaLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == teaLoginButton) {
                    teacherLogin();
                    jFrame.dispose();
                }
            }
        });
        // Ϊѧ����¼��ť����¼������ʹ������
        stuLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == stuLoginButton) {
                    studentLogin();
                    jFrame.dispose();
                }
            }
        });
        // Ϊ�˳�ϵͳ��ť���ʱ������ʹ������
        exitSystemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
    }

    /**
     * ����Ա��¼��֤�ķ���
     */
    private void adminLogin() {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        // ���ô���Ĳ���Ϊ���Բ���
        jFrame.setLayout(null);
        // ʵ������ǩ����
        JLabel ad_uNameLabel = new JLabel("�û���");
        JLabel ad_pwdLabel = new JLabel("����");
        JTextField ad_uNameField = new JTextField();
        JPasswordField ad_pwdField = new JPasswordField();
        JLabel tipLabel = new JLabel("����Ա��¼����");
        JButton loginButton = new JButton("��¼");
        JButton backButton = new JButton("����");
        // ���ø�����ڴ��������ʹ�С
        ad_uNameLabel.setBounds(20, 40, 100, 30);
        ad_pwdLabel.setBounds(20, 80, 100, 30);
        ad_uNameField.setBounds(120, 40, 120, 30);
        ad_pwdField.setBounds(120, 80, 120, 30);
        tipLabel.setBounds(100, 0, 100, 30);
        loginButton.setBounds(90, 120, 120, 30);
        backButton.setBounds(90, 160, 120, 30);
        // ����������ڴ�����
        jFrame.add(ad_uNameLabel);
        jFrame.add(ad_uNameField);
        jFrame.add(ad_pwdLabel);
        jFrame.add(ad_pwdField);
        jFrame.add(tipLabel);
        jFrame.add(loginButton);
        jFrame.add(backButton);
        // ���ô���Ĵ�С������
        jFrame.setSize(320, 350);
        jFrame.setLocation(500, 200);
        //�ô���ɼ�
        jFrame.setVisible(true);
        // Ϊ����Ա��¼��ť����¼������ʹ������
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == loginButton) {
                    String ad_uName = ad_uNameField.getText();
                    String ad_pwd = new String(ad_pwdField.getPassword());
                    AdminService adminService = new AdminServiceImpl();
                    AdminInfo adminInfo = adminService.adminLogin(ad_uName, ad_pwd);
                    if (adminInfo.getAd_uName() != null) {
                        adminMenuTest(adminInfo.getAd_id());
                        jFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(loginButton, "�û������������");
                        ad_uNameField.setText("");
                        ad_pwdField.setText("");
                    }
                }
            }
        });
        // Ϊ���ذ�ť����¼������ʹ������
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    showMainMenu();
                    jFrame.dispose();
                }
            }
        });
        // Ϊ��������¼������ʹ������
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                showMainMenu();
            }
        });
    }

    /**
     * ��ʦ��¼��֤�ķ���
     */
    private void teacherLogin() {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        // �趨����Ĳ���Ϊ���Բ���
        jFrame.setLayout(null);
        JLabel tea_uNameLabel = new JLabel("�û���");
        JLabel tea_pwdLabel = new JLabel("����");
        JTextField tea_uNameField = new JTextField();
        JPasswordField tea_pwdField = new JPasswordField();
        JLabel tipLabel = new JLabel("��ʦ��¼����");
        JLabel promptLabel = new JLabel();
        JButton submitButton = new JButton("��¼");
        JButton backButton = new JButton("����");
        tea_uNameLabel.setBounds(20, 40, 100, 30);
        tea_pwdLabel.setBounds(20, 80, 100, 30);
        tea_uNameField.setBounds(120, 40, 120, 30);
        tea_pwdField.setBounds(120, 80, 120, 30);
        tipLabel.setBounds(100, 0, 100, 30);
        submitButton.setBounds(90, 120, 120, 30);
        backButton.setBounds(90, 160, 120, 30);
        jFrame.add(tea_uNameLabel);
        jFrame.add(tea_uNameField);
        jFrame.add(tea_pwdLabel);
        jFrame.add(tea_pwdField);
        jFrame.add(tipLabel);
        jFrame.add(submitButton);
        jFrame.add(promptLabel);
        jFrame.add(backButton);
        jFrame.setSize(320, 350);
        jFrame.setLocation(500, 200);
        jFrame.setVisible(true);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submitButton) {
                    String tea_uName = tea_uNameField.getText();
                    String tea_pwd = new String(tea_pwdField.getPassword());
                    TeacherService teacherService = new TeacherServiceImpl();
                    TeacherInfo teacherInfo = teacherService.queryTeaLogin(tea_uName, tea_pwd);
                    if (teacherInfo.getTea_uName() != null) {
                        if (teacherInfo.getTea_state().equals("����")) {
                            teaMenuTest(teacherInfo.getTea_id());
                            jFrame.dispose();
                        } else if (teacherInfo.getTea_state().equals("ͣ��")) {
                            JOptionPane.showMessageDialog(jFrame, "�����Ϣ״̬Ϊͣ��״̬��ֹͣ��¼");
                            tea_uNameField.setText("");
                            tea_pwdField.setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(jFrame, "�û������������");
                        tea_uNameField.setText("");
                        tea_pwdField.setText("");
                    }
                }
            }
        });
        // Ϊ��������¼������ʹ������
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                showMainMenu();
            }
        });
        // Ϊ���ذ�ť����¼������ʹ������
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    showMainMenu();
                    jFrame.dispose();
                }
            }
        });
    }

    /**
     * ѧ����¼��֤�ķ���
     */
    private void studentLogin() {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        jFrame.setLayout(null);
        JLabel stu_uNameLabel = new JLabel("�û���");
        JLabel stu_pwdLabel = new JLabel("����");
        JTextField stu_uNameField = new JTextField();
        JPasswordField stu_pwdField = new JPasswordField();
        JLabel tipLabel = new JLabel("ѧ����¼����");
        JButton submitButton = new JButton("��¼");
        JButton backButton = new JButton("����");
        stu_uNameLabel.setBounds(60, 40, 100, 30);
        stu_pwdLabel.setBounds(60, 80, 100, 30);
        stu_uNameField.setBounds(120, 40, 120, 30);
        stu_pwdField.setBounds(120, 80, 120, 30);
        tipLabel.setBounds(100, 0, 100, 30);
        submitButton.setBounds(90, 120, 120, 30);
        backButton.setBounds(90, 160, 120, 30);
        jFrame.add(stu_uNameLabel);
        jFrame.add(stu_uNameField);
        jFrame.add(stu_pwdLabel);
        jFrame.add(stu_pwdField);
        jFrame.add(tipLabel);
        jFrame.add(submitButton);
        jFrame.add(backButton);
        jFrame.setSize(320, 350);
        jFrame.setLocation(500, 200);
        jFrame.setVisible(true);
        // Ϊ��¼��ť����¼������ʹ������
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submitButton) {
                    String stu_uName = stu_uNameField.getText();
                    String stu_pwd = new String(stu_pwdField.getPassword());
                    StudentService StudentService = new StudentServiceImpl();
                    StudentInfo studentInfo = StudentService.queryStuLogin(stu_uName, stu_pwd);
                    if (studentInfo.getStu_uName() != null) {
                        if (studentInfo.getStu_state().equals("����")) {
                            stuMenuTest(studentInfo.getStu_id());
                            jFrame.dispose();
                        } else if (studentInfo.getStu_state().equals("ͣ��")) {
                            JOptionPane.showMessageDialog(jFrame, "�����Ϣ״̬Ϊͣ��״̬��ֹͣ��¼");
                            stu_uNameField.setText("");
                            stu_pwdField.setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(jFrame, "�û������������");
                        stu_uNameField.setText("");
                        stu_pwdField.setText("");
                    }
                }
            }
        });
        // Ϊ���ذ�ť����¼������ʹ������
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    showMainMenu();
                    jFrame.dispose();
                }
            }
        });
        // Ϊ��������¼������ʹ������
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                showMainMenu();
            }
        });
    }

    /**
     * ����Ա��¼������ҳ��ķ���
     *
     * @param ad_id ����Ա���
     */
    private void adminMenuTest(int ad_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        // ���ô��岼��Ϊ���Բ���
        jFrame.setLayout(null);
        // ʵ������ǩ����
        JLabel adMenuLabel = new JLabel("����Ա���ܽ���");
        JButton addInfoButton = new JButton("�����Ϣ����");
        JButton queryInfoButton = new JButton("��ѯ��Ϣ����");
        JButton updateInfoButton = new JButton("�޸���Ϣ����");
        JButton quitButton = new JButton("�˳���¼");
        // ���ø�������ڴ��������ʹ�С
        adMenuLabel.setBounds(100, 0, 200, 30);
        addInfoButton.setBounds(70, 40, 150, 30);
        queryInfoButton.setBounds(70, 80, 150, 30);
        updateInfoButton.setBounds(70, 120, 150, 30);
        quitButton.setBounds(70, 200, 150, 30);
        // ����������ڴ�����
        jFrame.add(adMenuLabel);
        jFrame.add(addInfoButton);
        jFrame.add(queryInfoButton);
        jFrame.add(updateInfoButton);
        jFrame.add(quitButton);
        // ���ô����С�����꣬��ʹ����ɼ�
        jFrame.setSize(320, 350);
        jFrame.setLocation(500, 200);
        jFrame.setVisible(true);
        // Ϊ�����Ϣ���ܰ�ť����¼������ʹ������
        addInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addInfoButton) {
                    addAdminInfoFunction(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ��ѯ��Ϣ���ܰ�ť����¼������ʹ������
        queryInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == queryInfoButton) {
                    queryAdminInfoFunction(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ�޸���Ϣ���ܰ�ť����¼������ʹ������
        updateInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == updateInfoButton) {
                    updateAdminInfoFunction(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ�˳���¼��ť����¼������ʹ������
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == quitButton) {
                    showMainMenu();
                    jFrame.dispose();
                }
            }
        });
        // Ϊ��������¼������ʹ������
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                showMainMenu();
            }
        });
    }

    /**
     * ����ԱȨ���������Ϣ������ҳ��ķ���
     *
     * @param ad_id ����Ա���
     */
    private void addAdminInfoFunction(int ad_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        // ���ô��岼��Ϊ���Բ���
        jFrame.setLayout(null);
        // ʵ������ǩ����
        JLabel addInfoLabel = new JLabel("�����Ϣ���ܽ���");
        JButton addStuInfoButton = new JButton("���ѧ����Ϣ");
        JButton addTeaInfoButton = new JButton("��ӽ�ʦ��Ϣ");
        JButton addCourseInfoButton = new JButton("��ӿγ���Ϣ");
        JButton backButton = new JButton("����");
        // ���ø�����ڴ��������ʹ�С
        addInfoLabel.setBounds(100, 0, 200, 30);
        addStuInfoButton.setBounds(70, 40, 150, 30);
        addTeaInfoButton.setBounds(70, 80, 150, 30);
        addCourseInfoButton.setBounds(70, 120, 150, 30);
        backButton.setBounds(70, 200, 150, 30);
        // ����������ڴ�����
        jFrame.add(addInfoLabel);
        jFrame.add(addStuInfoButton);
        jFrame.add(addTeaInfoButton);
        jFrame.add(addCourseInfoButton);
        jFrame.add(backButton);
        // ���ô����С�����겢ʹ����ɼ�
        jFrame.setSize(320, 350);
        jFrame.setLocation(500, 200);
        jFrame.setVisible(true);
        // Ϊ���ѧ����Ϣ��ť����¼������ʹ������
        addStuInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addStuInfoButton) {
                    try {
                        addStuInfo(ad_id);
                        jFrame.dispose();
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(jFrame, "û��רҵ��Ϣ�ļ�,�޷����ѧ����Ϣ");
                    }
                }
            }
        });
        // Ϊ��ӽ�ʦ��Ϣ��ť����¼������ʹ������
        addTeaInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addTeaInfoButton) {
                    try {
                        addTeaInfo(ad_id);
                        jFrame.dispose();
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(jFrame, "û��רҵ��Ϣ�ļ�,�޷���ӽ�ʦ��Ϣ");
                    }
                }
            }
        });
        // Ϊ��ӿγ���Ϣ��ť����¼������ʹ������
        addCourseInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addCourseInfoButton) {
                    try {
                        addCourseInfo(ad_id);
                        jFrame.dispose();
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(jFrame, "û��רҵ��Ϣ�ļ�,�޷���ӿγ���Ϣ");
                    }
                }
            }
        });
        // Ϊ���ذ�ť����¼������ʹ������
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    adminMenuTest(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ��������¼������ʹ������
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                adminMenuTest(ad_id);
            }
        });
    }

    /**
     * ����ԱȨ������ӽ�ʦ������Ϣ�ķ���
     *
     * @param ad_id ����Ա���
     */
    private void addTeaInfo(int ad_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        // ���ô��岼��Ϊ���Բ���
        jFrame.setLayout(null);
        // ʵ������ǩ����
        JLabel addTeaInfoLabel = new JLabel("��ӽ�ʦ������Ϣ");
        JLabel tea_uNameLabel = new JLabel("�û���");
        JLabel tea_pwdLabel = new JLabel("����");
        JLabel tea_comfirmPwdLabel = new JLabel("ȷ������");
        JLabel tea_nameLabel = new JLabel("����");
        JLabel tea_majorLabel = new JLabel("����רҵ");
        JTextField tea_uNameField = new JTextField();
        JPasswordField tea_pwdField = new JPasswordField();
        JPasswordField tea_confirmPwdField = new JPasswordField();
        JTextField tea_nameField = new JTextField();
        JComboBox tea_majorBox = new JComboBox(majorNameFile());
        JButton submitButton = new JButton("���");
        JButton backButton = new JButton("����");
        // ���õ�¼��ťΪ����
        submitButton.setEnabled(false);
        TeacherService teacherService = new TeacherServiceImpl();
        List<TeacherInfo> teacherInfoList = teacherService.queryTeaInfoList();
        DefaultTableModel teaInfoModel = new DefaultTableModel();
        teaInfoModel.setColumnIdentifiers(new Object[]{"��ʦ���", "��ʦ�û���", "��ʦ����", "��ʦ����",
                "��ʦרҵ", "��Ϣ����ʱ��", "��Ϣ����ʱ��", "��ʦ��Ϣ״̬"});
        if (teacherInfoList != null && !teacherInfoList.isEmpty()) {
            for (TeacherInfo teacherInfo : teacherInfoList) {
                Object[] rowData = {teacherInfo.getTea_id(), teacherInfo.getTea_uName(),
                        teacherInfo.getTea_pwd(), teacherInfo.getTea_name(),
                        teacherInfo.getTea_major(), teacherInfo.getTea_createDate(),
                        teacherInfo.getTea_updateDate(), teacherInfo.getTea_state()};
                teaInfoModel.addRow(rowData);
            }
        }
        JTable teaInfoTable = new JTable(teaInfoModel);
        JScrollPane teaJsc = new JScrollPane(teaInfoTable);
        teaInfoTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        // ����������ڴ�����
        jFrame.add(tea_uNameLabel);
        jFrame.add(tea_pwdLabel);
        jFrame.add(tea_nameLabel);
        jFrame.add(tea_majorLabel);
        jFrame.add(tea_uNameField);
        jFrame.add(tea_comfirmPwdLabel);
        jFrame.add(tea_confirmPwdField);
        jFrame.add(tea_pwdField);
        jFrame.add(tea_nameField);
        jFrame.add(tea_majorBox);
        jFrame.add(addTeaInfoLabel);
        jFrame.add(submitButton);
        jFrame.add(backButton);
        jFrame.add(teaJsc);
        // ���ø�����ڴ��������ʹ�С
        addTeaInfoLabel.setBounds(400, 0, 200, 30);
        tea_uNameLabel.setBounds(20, 40, 100, 30);
        tea_pwdLabel.setBounds(20, 80, 100, 30);
        tea_comfirmPwdLabel.setBounds(20, 120, 100, 30);
        tea_nameLabel.setBounds(20, 160, 100, 30);
        tea_majorLabel.setBounds(20, 200, 100, 30);
        tea_uNameField.setBounds(120, 40, 150, 30);
        tea_pwdField.setBounds(120, 80, 150, 30);
        tea_nameField.setBounds(120, 160, 150, 30);
        tea_confirmPwdField.setBounds(120, 120, 150, 30);
        tea_majorBox.setBounds(120, 200, 150, 30);
        submitButton.setBounds(100, 400, 150, 30);
        backButton.setBounds(700, 400, 150, 30);
        teaJsc.setBounds(300, 40, 600, 350);
        // ���ô����С�����겢ʹ����ɼ�
        jFrame.setSize(1000, 500);
        jFrame.setLocation(200, 100);
        jFrame.setVisible(true);

        tea_nameField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource() == tea_nameField) {
                    if (!String.valueOf(tea_pwdField.getPassword()).equals("") &&
                            !String.valueOf(tea_nameField.getText()).equals("") &&
                            !String.valueOf(tea_confirmPwdField.getPassword()).equals("") &&
                            !String.valueOf(tea_uNameField.getText()).equals("")) {
                        submitButton.setEnabled(true);
                    } else {
                        submitButton.setEnabled(false);
                    }
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == tea_nameField) {
                    if (!String.valueOf(tea_pwdField.getPassword()).equals("") &&
                            !String.valueOf(tea_nameField.getText()).equals("") &&
                            !String.valueOf(tea_confirmPwdField.getPassword()).equals("") &&
                            !String.valueOf(tea_uNameField.getText()).equals("")) {
                        submitButton.setEnabled(true);
                    } else {
                        submitButton.setEnabled(false);
                    }
                }
            }
        });
        // Ϊ��Ӱ�ť����¼������ʹ������
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submitButton) {
                    String tea_createDate = currentTime();
                    String tea_uName = tea_uNameField.getText();
                    String tea_pwd = new String(tea_pwdField.getPassword());
                    String tea_confirmPwd = new String(tea_confirmPwdField.getPassword());
                    String tea_name = tea_nameField.getText();
                    String tea_major = (String) tea_majorBox.getSelectedItem();
                    if (tea_confirmPwd.equals(tea_pwd)) {
                        TeacherInfo teacherInfo = new TeacherInfo();
                        teacherInfo.setTea_uName(tea_uName);
                        teacherInfo.setTea_pwd(tea_pwd);
                        teacherInfo.setTea_name(tea_name);
                        teacherInfo.setTea_major(tea_major);
                        teacherInfo.setAd_id(ad_id);
                        teacherInfo.setTea_createDate(tea_createDate);
                        teacherInfo.setTea_updateDate(tea_createDate);
                        TeacherService teacherService = new TeacherServiceImpl();
                        int rows = teacherService.addTeaInfo(teacherInfo);
                        if (rows == 1) {
                            JOptionPane.showMessageDialog(jFrame, "��ӽ�ʦ��Ϣ�ɹ�");
                            addTeaInfo(ad_id);
                            jFrame.dispose();
                        } else {
                            JOptionPane.showMessageDialog(jFrame, "�������");
                            tea_uNameField.setText("");
                            tea_pwdField.setText("");
                            tea_nameField.setText("");
                            tea_confirmPwdField.setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(jFrame, "�������벻һ�£�����������");
                        tea_uNameField.setText("");
                        tea_confirmPwdField.setText("");
                        tea_pwdField.setText("");
                        tea_nameField.setText("");
                    }
                }
            }
        });
        // Ϊ���ذ�ť����¼������ʹ������
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    addAdminInfoFunction(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ��������¼������ʹ������
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                addAdminInfoFunction(ad_id);
            }
        });
    }

    /**
     * ����ԱȨ�������ѧ����Ϣ�ķ���
     *
     * @param ad_id ����Ա���
     */
    private void addStuInfo(int ad_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        // Ϊ���岼��Ϊ���Բ���
        jFrame.setLayout(null);
        // ʵ������ǩ����
        JLabel addStuInfoLabel = new JLabel("���ѧ��������Ϣ");
        JLabel stu_uNameLabel = new JLabel("�û���");
        JLabel stu_pwdLabel = new JLabel("����");
        JLabel stu_comfirmPwdLabel = new JLabel("ȷ������");
        JLabel stu_nameLabel = new JLabel("����");
        JLabel stu_sexLabel = new JLabel("�Ա�");
        JLabel stu_ageLabel = new JLabel("����");
        JLabel stu_phoneLabel = new JLabel("�绰");
        JLabel stu_majorLabel = new JLabel("רҵ");
        JTextField stu_uNameField = new JTextField();
        JPasswordField stu_pwdField = new JPasswordField();
        JPasswordField stu_comfirmPwdField = new JPasswordField();
        JTextField stu_nameField = new JTextField();
        JTextField stu_majorField = new JTextField();
        JComboBox stu_majorBox = new JComboBox(majorNameFile());
        JTextField stu_sexField = new JTextField();
        String[] sex = {"��", "Ů"};
        JComboBox stu_sexBox = new JComboBox(sex);
        JTextField stu_ageField = new JTextField();
        JTextField stu_phoneField = new JTextField();
        JButton addButton = new JButton("���");
        JButton backButton = new JButton("������һ��");
        // ������Ӱ�ťΪ����
        addButton.setEnabled(false);
        // ��ѯѧ����Ϣ�б�
        StudentService studentService = new StudentServiceImpl();
        List<StudentInfo> studentInfoList = studentService.queryStuInfoList();
        // ����һ�������ģ�ͣ����������
        DefaultTableModel stuInfoModel = new DefaultTableModel();
        stuInfoModel.setColumnIdentifiers(new Object[]{"ѧ�����", "ѧ���û���", "ѧ������", "ѧ������", "ѧ���Ա�",
                "ѧ������", "ѧ���ֻ���", "ѧ��רҵ", "��Ϣ����ʱ��", "��Ϣ����ʱ��", "ѧ����Ϣ״̬"});
        for (StudentInfo studentInfo : studentInfoList) {
            Object[] rowData = {studentInfo.getStu_id(), studentInfo.getStu_uName(),
                    studentInfo.getStu_pwd(), studentInfo.getStu_name(), studentInfo.getStu_sex(),
                    studentInfo.getStu_age(), studentInfo.getStu_phone(), studentInfo.getStu_major(),
                    studentInfo.getStu_createDate(), studentInfo.getStu_updateDate(),
                    studentInfo.getStu_state()};
            stuInfoModel.addRow(rowData);
        }
        // ���ñ�񣬽������ģ�ͷ�������
        JTable stuInfoTable = new JTable(stuInfoModel);
        // Ϊ���Ĭ���Զ�������
        stuInfoTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        // ���ù����������������������
        JScrollPane stuJsc = new JScrollPane(stuInfoTable);
        // ����������ڴ�����
        jFrame.add(stu_uNameLabel);
        jFrame.add(stu_pwdLabel);
        jFrame.add(stu_nameLabel);
        jFrame.add(stu_sexLabel);
        jFrame.add(stu_ageLabel);
        jFrame.add(stu_phoneLabel);
        jFrame.add(stu_majorLabel);
        jFrame.add(stu_comfirmPwdLabel);
        jFrame.add(stu_comfirmPwdField);
        jFrame.add(stu_uNameField);
        jFrame.add(stu_pwdField);
        jFrame.add(stu_nameField);
        jFrame.add(stu_sexBox);
        jFrame.add(stu_ageField);
        jFrame.add(stu_phoneField);
        jFrame.add(stu_majorBox);
        jFrame.add(addStuInfoLabel);
        jFrame.add(addButton);
        jFrame.add(stuJsc);
        jFrame.add(backButton);
        // ���ø����������ʹ�С
        addStuInfoLabel.setBounds(400, 0, 200, 30);
        stu_uNameLabel.setBounds(20, 40, 100, 30);
        stu_pwdLabel.setBounds(20, 80, 100, 30);
        stu_comfirmPwdLabel.setBounds(20, 120, 100, 30);
        stu_nameLabel.setBounds(20, 160, 100, 30);
        stu_sexLabel.setBounds(20, 200, 100, 30);
        stu_ageLabel.setBounds(20, 240, 100, 30);
        stu_phoneLabel.setBounds(20, 280, 100, 30);
        stu_majorLabel.setBounds(20, 320, 100, 30);
        stu_uNameField.setBounds(120, 40, 150, 30);
        stu_pwdField.setBounds(120, 80, 150, 30);
        stu_comfirmPwdField.setBounds(120, 120, 150, 30);
        stu_nameField.setBounds(120, 160, 150, 30);
        stu_sexBox.setBounds(120, 200, 150, 30);
        stu_ageField.setBounds(120, 240, 150, 30);
        stu_phoneField.setBounds(120, 280, 150, 30);
        stu_majorBox.setBounds(120, 320, 150, 30);
        addButton.setBounds(100, 400, 150, 30);
        backButton.setBounds(700, 400, 150, 30);
        stuJsc.setBounds(300, 40, 600, 350);
        // ���ô��������ʹ�С����ʹ����ɼ�
        jFrame.setSize(1000, 500);
        jFrame.setLocation(200, 100);
        jFrame.setVisible(true);
        // Ϊѧ���ֻ������������¼������ʹ������
        stu_phoneField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource() == stu_phoneField) {
                    if (!String.valueOf(stu_pwdField.getPassword()).equals("") &&
                            !String.valueOf(stu_nameField.getText()).equals("") &&
                            !String.valueOf(stu_comfirmPwdField.getPassword()).equals("") &&
                            !String.valueOf(stu_uNameField.getText()).equals("") &&
                            !String.valueOf(stu_ageField.getText()).equals("") &&
                            !String.valueOf(stu_phoneField.getText()).equals("")) {
                        addButton.setEnabled(true);
                    } else {
                        addButton.setEnabled(false);
                    }
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == stu_phoneField) {
                    if (!String.valueOf(stu_pwdField.getPassword()).equals("") &&
                            !String.valueOf(stu_nameField.getText()).equals("") &&
                            !String.valueOf(stu_comfirmPwdField.getPassword()).equals("") &&
                            !String.valueOf(stu_uNameField.getText()).equals("") &&
                            !String.valueOf(stu_ageField.getText()).equals("") &&
                            !String.valueOf(stu_phoneField.getText()).equals("")) {
                        addButton.setEnabled(true);
                    } else {
                        addButton.setEnabled(false);
                    }
                }
            }
        });
        // Ϊ��Ӱ�ť����¼������ʹ������
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addButton) {
                    String stu_createDate = currentTime();
                    String stu_uName = stu_uNameField.getText();
                    String stu_pwd = new String(stu_pwdField.getPassword());
                    String stu_comfirmPwd = new String(stu_comfirmPwdField.getPassword());
                    String stu_name = stu_nameField.getText();
                    String stu_sex = (String) stu_sexBox.getSelectedItem();
                    String stu_phone = stu_phoneField.getText();
                    String stu_major = (String) stu_majorBox.getSelectedItem();
                    Pattern p = Pattern.compile("^[1][234578][0-9]{9}$");
                    Matcher m = p.matcher(stu_phone);
                    boolean b = m.matches();
                    int stu_age;
                    if (stu_comfirmPwd.equals(stu_pwd)) {
                        try {
                            stu_age = new Integer(stu_ageField.getText());
                            if (stu_age <= 0 || b == false) {
                                JOptionPane.showMessageDialog(jFrame, "������ֻ����������");
                                stu_ageField.setText("");
                                stu_phoneField.setText("");
                            } else {
                                StudentService studentService = new StudentServiceImpl();
                                StudentInfo studentInfo = new StudentInfo();
                                studentInfo.setStu_uName(stu_uName);
                                studentInfo.setStu_pwd(stu_pwd);
                                studentInfo.setStu_name(stu_name);
                                studentInfo.setStu_sex(stu_sex);
                                studentInfo.setStu_age(stu_age);
                                studentInfo.setStu_phone(stu_phone);
                                studentInfo.setStu_major(stu_major);
                                studentInfo.setAd_id(ad_id);
                                studentInfo.setStu_createDate(stu_createDate);
                                studentInfo.setStu_updateDate(stu_createDate);
                                int rows = studentService.addStuInfo(studentInfo);
                                if (rows == 1) {
                                    JOptionPane.showMessageDialog(jFrame, "���ѧ����Ϣ�ɹ�");
                                    addStuInfo(ad_id);
                                    jFrame.dispose();
                                } else {
                                    JOptionPane.showMessageDialog(jFrame, "���ʧ��");
                                    stu_uNameField.setText("");
                                    stu_pwdField.setText("");
                                    stu_ageField.setText("");
                                    stu_phoneField.setText("");
                                    stu_sexField.setText("");
                                    stu_nameField.setText("");
                                }
                            }
                        } catch (Exception e1) {
                            JOptionPane.showMessageDialog(jFrame, "�����������");
                            stu_ageField.setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(jFrame, "�������벻һ�£�����������");
                        stu_uNameField.setText("");
                        stu_pwdField.setText("");
                        stu_comfirmPwdField.setText("");
                        stu_ageField.setText("");
                        stu_phoneField.setText("");
                        stu_sexField.setText("");
                        stu_nameField.setText("");
                    }
                }
            }
        });
        // Ϊ���ذ�ť����¼������ʹ������
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    addAdminInfoFunction(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ��������¼������ʹ������
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                addAdminInfoFunction(ad_id);
            }
        });
    }

    /**
     * ����ԱȨ������ӿγ���Ϣ�ķ���
     *
     * @param ad_id ����Ա���
     */
    private void addCourseInfo(int ad_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        jFrame.setLayout(null);
        JLabel addCourseInfoLabel = new JLabel("��ӿγ���Ϣ");

        JLabel c_nameLabel = new JLabel("�γ�����");
        JLabel c_creditLabel = new JLabel("�γ�ѧ��");

        JComboBox c_nameBox = new JComboBox(courseNameFile());
        JComboBox c_creditBox = new JComboBox();
        for (int i = 1; i < 7; i++) {
            c_creditBox.addItem(i);
        }

        JButton submitButton = new JButton("���");
        JButton backButton = new JButton("����");

        addCourseInfoLabel.setBounds(400, 0, 200, 30);
        c_nameLabel.setBounds(20, 40, 100, 30);
        c_creditLabel.setBounds(20, 80, 100, 30);

        c_nameBox.setBounds(120, 40, 150, 30);
        c_creditBox.setBounds(120, 80, 150, 30);

        submitButton.setBounds(100, 400, 150, 30);
        backButton.setBounds(700, 400, 150, 30);

        jFrame.add(c_nameLabel);
        jFrame.add(c_creditLabel);
        jFrame.add(c_nameBox);
        jFrame.add(c_creditBox);
        jFrame.add(addCourseInfoLabel);
        jFrame.add(submitButton);
        jFrame.add(backButton);

        CourseService courseService = new CourseServiceImpl();
        List<CourseInfo> courseInfoList = courseService.queryCourInfoList();
        DefaultTableModel courseInfoModel = new DefaultTableModel();
        courseInfoModel.setColumnIdentifiers(new Object[]{"�γ̱��", "�γ�����", "�γ�ѧ��", "�γ̴���ʱ��",
                "�γ̸���ʱ��", "�γ�״̬"});
        if (courseInfoList != null && !courseInfoList.isEmpty()) {
            for (CourseInfo courseInfo : courseInfoList) {
                Object[] rowData = {courseInfo.getC_id(), courseInfo.getC_name(),
                        courseInfo.getC_credit(), courseInfo.getC_createDate(),
                        courseInfo.getC_updateDate(), courseInfo.getC_state()};
                courseInfoModel.addRow(rowData);
            }
        }
        JTable courseInfoTable = new JTable(courseInfoModel);
        JScrollPane courseJsc = new JScrollPane(courseInfoTable);
        jFrame.add(courseJsc);
        courseJsc.setBounds(300, 40, 600, 350);
        courseInfoTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        // Ϊ�������ô�С�����겢ʹ����ɼ�
        jFrame.setSize(1000, 500);
        jFrame.setLocation(200, 100);
        jFrame.setVisible(true);
        // Ϊ��Ӱ�ť����¼������ʹ������
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submitButton) {
                    String c_name = (String) c_nameBox.getSelectedItem();
                    int c_credit = 0;
                    try {
                        c_credit = (Integer) c_creditBox.getSelectedItem();
                        String c_createDate = currentTime();
                        CourseService courseService = new CourseServiceImpl();
                        CourseInfo courseInfo = new CourseInfo();
                        courseInfo.setC_name(c_name);
                        courseInfo.setC_credit(c_credit);
                        courseInfo.setAd_id(ad_id);
                        courseInfo.setC_createDate(c_createDate);
                        courseInfo.setC_updateDate(c_createDate);
                        int rows = courseService.addCourseInfo(courseInfo);
                        if (rows == 1) {
                            JOptionPane.showMessageDialog(jFrame, "��ӿγ���Ϣ�ɹ�");
                            addCourseInfo(ad_id);
                            jFrame.dispose();
                        } else {
                            JOptionPane.showMessageDialog(jFrame, "���ʧ��");
                            addCourseInfo(ad_id);
                            jFrame.dispose();
                        }
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(jFrame, "���ʧ��");
                        addCourseInfo(ad_id);
                        jFrame.dispose();
                    }
                }
            }
        });
        // Ϊ���ذ�ť����¼������ʹ������
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    addAdminInfoFunction(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ��������¼������ʹ������
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                addAdminInfoFunction(ad_id);
            }
        });
    }

    /**
     * ����ԱȨ�޲�ѯ��Ϣ������ҳ��ķ���
     *
     * @param ad_id ����Ա���
     */
    private void queryAdminInfoFunction(int ad_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        jFrame.setLayout(null);
        JLabel queryInfoLabel = new JLabel("��ѯ��Ϣ���ܽ���");
        JButton queryStuInfoButton = new JButton("��ѯѧ����Ϣ�б�");
        JButton queryTeaInfoButton = new JButton("��ѯ��ʦ��Ϣ�б�");
        JButton queryCourseInfoButton = new JButton("��ѯ�γ���Ϣ�б�");
        JButton backButton = new JButton("����");

        queryInfoLabel.setBounds(100, 0, 200, 30);
        queryStuInfoButton.setBounds(70, 40, 150, 30);
        queryTeaInfoButton.setBounds(70, 80, 150, 30);
        queryCourseInfoButton.setBounds(70, 120, 150, 30);

        backButton.setBounds(70, 200, 150, 30);

        jFrame.add(queryInfoLabel);
        jFrame.add(queryStuInfoButton);
        jFrame.add(queryTeaInfoButton);
        jFrame.add(queryCourseInfoButton);
        jFrame.add(backButton);

        jFrame.setSize(320, 350);
        jFrame.setLocation(500, 200);
        jFrame.setVisible(true);
        // Ϊ��ѯѧ����Ϣ��ť����¼������ʹ������
        queryStuInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == queryStuInfoButton) {
                    queryStudentInfo(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ��ѯ��ʦ��Ϣ��ť����¼������ʹ������
        queryTeaInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == queryTeaInfoButton) {
                    queryTeacherInfo(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ��ѯ�γ���Ϣ��ť����¼������ʹ������
        queryCourseInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == queryCourseInfoButton) {
                    queryCourseInfo(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ���ذ�ť����¼������ʹ������
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    adminMenuTest(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ��������¼������ʹ������
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                adminMenuTest(ad_id);
            }
        });

    }

    /**
     * ����ԱȨ���²鿴��ʦ��Ϣ�б�ķ���
     *
     * @param ad_id ����Ա���
     */
    private void queryTeacherInfo(int ad_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        jFrame.setLayout(null);
        JLabel teaInfoLabel = new JLabel("��ѯ��ʦ��Ϣ");
        JButton backButton = new JButton("����");

        TeacherService teacherService = new TeacherServiceImpl();
        List<TeacherInfo> teacherInfoList = teacherService.queryTeaInfoList();
        // ����һ�������ģ��
        DefaultTableModel teaInfoModel = new DefaultTableModel();
        // ���ñ������
        teaInfoModel.setColumnIdentifiers(new Object[]{"��ʦ���", "��ʦ�û���", "��ʦ����", "��ʦ����",
                "��ʦרҵ", "��Ϣ����ʱ��", "��Ϣ����ʱ��", "��ʦ��Ϣ״̬"});
        for (TeacherInfo teacherInfo : teacherInfoList) {
            Object[] rowData = {teacherInfo.getTea_id(), teacherInfo.getTea_uName(),
                    teacherInfo.getTea_pwd(), teacherInfo.getTea_name(),
                    teacherInfo.getTea_major(), teacherInfo.getTea_createDate(),
                    teacherInfo.getTea_updateDate(), teacherInfo.getTea_state()};
            teaInfoModel.addRow(rowData);
        }
        // ���ñ�񣬽������ģ�ͷ��뵽�����
        JTable teaInfoTable = new JTable(teaInfoModel);
        // Ϊ�������Ĭ�Ϲ�����
        teaInfoTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        // ���ù����������������������
        JScrollPane teaJsc = new JScrollPane(teaInfoTable);

        jFrame.add(teaInfoLabel);
        jFrame.add(teaJsc);
        jFrame.add(backButton);

        teaInfoLabel.setBounds(200, 0, 200, 30);
        teaJsc.setBounds(20, 40, 500, 300);
        backButton.setBounds(200, 380, 100, 30);

        jFrame.setSize(550, 500);
        jFrame.setLocation(400, 150);
        jFrame.setVisible(true);
        // Ϊ���ذ�ť����¼������ʹ������
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    queryAdminInfoFunction(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ��������¼������ʹ������
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                queryAdminInfoFunction(ad_id);
            }
        });
    }

    /**
     * ����ԱȨ���²鿴ѧ����Ϣ�б�ķ���
     *
     * @param ad_id ����Ա���
     */
    private void queryStudentInfo(int ad_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        jFrame.setLayout(null);
        JLabel stuInfoLabel = new JLabel("��ѯѧ����Ϣ");
        JButton backButton = new JButton("����");

        StudentService studentService = new StudentServiceImpl();
        List<StudentInfo> studentInfoList = studentService.queryStuInfoList();
        // ����һ�������ģ�ͣ����������
        DefaultTableModel stuModel = new DefaultTableModel();
        // ���ñ������
        stuModel.setColumnIdentifiers(new Object[]{"ѧ�����", "ѧ���û���", "ѧ������", "ѧ������", "ѧ���Ա�",
                "ѧ������", "ѧ���ֻ���", "ѧ��רҵ", "��Ϣ����ʱ��", "��Ϣ����ʱ��", "ѧ����Ϣ״̬"});
        for (StudentInfo studentInfo : studentInfoList) {
            Object[] rowData = {studentInfo.getStu_id(), studentInfo.getStu_uName(),
                    studentInfo.getStu_pwd(), studentInfo.getStu_name(), studentInfo.getStu_sex(),
                    studentInfo.getStu_age(), studentInfo.getStu_phone(), studentInfo.getStu_major(),
                    studentInfo.getStu_createDate(), studentInfo.getStu_updateDate(),
                    studentInfo.getStu_state()};
            stuModel.addRow(rowData);
        }
        // ���ñ�񣬽������ģ�ͷ��뵽�����
        JTable stuTable = new JTable(stuModel);
        // Ϊ���Ĭ���Զ�������
        stuTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        // ���ù����������������������
        JScrollPane stuJsc = new JScrollPane(stuTable);

        jFrame.add(stuInfoLabel);
        jFrame.add(stuJsc);
        jFrame.add(backButton);

        stuInfoLabel.setBounds(200, 0, 200, 30);
        stuJsc.setBounds(20, 40, 500, 300);
        backButton.setBounds(200, 380, 100, 30);

        jFrame.setSize(550, 500);
        jFrame.setLocation(400, 150);
        jFrame.setVisible(true);
        // Ϊ���ذ�ť����¼������ʹ������
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    queryAdminInfoFunction(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ��������¼������ʹ������
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                queryAdminInfoFunction(ad_id);
            }
        });
    }

    /**
     * ����ԱȨ���²�ѯ�γ̻�����Ϣ�ķ���
     *
     * @param ad_id ����Ա���
     */
    private void queryCourseInfo(int ad_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        jFrame.setLayout(null);

        JLabel courseInfoLabel = new JLabel("��ѯ�γ���Ϣ");
        JButton backButton = new JButton("����");

        CourseService courseService = new CourseServiceImpl();
        List<CourseInfo> courseInfoList = courseService.queryCourInfoList();
        // ����һ�������ģ��
        DefaultTableModel courseModel = new DefaultTableModel();
        // ��������
        courseModel.setColumnIdentifiers(new Object[]{"�γ̱��", "�γ�����", "�γ�ѧ��", "�γ̴���ʱ��",
                "�γ̸���ʱ��", "�γ�״̬"});
        for (CourseInfo courseInfo : courseInfoList) {
            Object[] rowData = {courseInfo.getC_id(), courseInfo.getC_name(), courseInfo.getC_credit(),
                    courseInfo.getC_createDate(), courseInfo.getC_updateDate(), courseInfo.getC_state()};
            courseModel.addRow(rowData);
        }
        // ���ñ�񣬽������ģ�ͷ�������
        JTable courseTable = new JTable(courseModel);
        // Ϊ�������Ĭ�Ϲ�����
        courseTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        // ���ù����������������������
        JScrollPane courseJsc = new JScrollPane(courseTable);

        jFrame.add(courseInfoLabel);
        jFrame.add(courseJsc);
        jFrame.add(backButton);

        courseInfoLabel.setBounds(200, 0, 200, 30);
        courseJsc.setBounds(20, 40, 500, 300);
        backButton.setBounds(200, 380, 100, 30);

        jFrame.setSize(550, 500);
        jFrame.setLocation(400, 150);
        jFrame.setVisible(true);
        // Ϊ���ذ�ť����¼������ʹ������
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    queryAdminInfoFunction(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ��������¼������ʹ������
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                queryAdminInfoFunction(ad_id);
            }
        });
    }

    /**
     * ����ԱȨ�����޸���Ϣ����ҳ��ķ���
     *
     * @param ad_id ����Ա���
     */
    private void updateAdminInfoFunction(int ad_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        jFrame.setLayout(null);
        JLabel updateInfoLabel = new JLabel("�޸���Ϣ���ܽ���");
        JButton updateCourseInfoButton = new JButton("�޸Ŀγ�ѧ��");
        JButton updateTeaStateButton = new JButton("�޸Ľ�ʦ��Ϣ״̬");
        JButton updateStuStateButton = new JButton("�޸�ѧ����Ϣ״̬");
        JButton updateCourseStateButton = new JButton("�޸Ŀγ���Ϣ״̬");
        JButton backButton = new JButton("����");

        updateInfoLabel.setBounds(100, 0, 200, 30);
        updateCourseInfoButton.setBounds(70, 40, 150, 30);
        updateTeaStateButton.setBounds(70, 80, 150, 30);
        updateStuStateButton.setBounds(70, 120, 150, 30);
        updateCourseStateButton.setBounds(70, 160, 150, 30);
        backButton.setBounds(70, 200, 150, 30);

        jFrame.add(updateInfoLabel);
        jFrame.add(updateCourseInfoButton);
        jFrame.add(updateTeaStateButton);
        jFrame.add(updateStuStateButton);
        jFrame.add(updateCourseStateButton);
        jFrame.add(backButton);

        jFrame.setSize(320, 350);
        jFrame.setLocation(500, 200);
        jFrame.setVisible(true);
        // Ϊ�޸Ŀγ���Ϣ��ť����¼������ʹ������
        updateCourseInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == updateCourseInfoButton) {
                    updateCourseInfo(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ�޸Ľ�ʦ״̬����¼������ʹ������
        updateTeaStateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == updateTeaStateButton) {
                    updateTeaStateInfo(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ�޸�ѧ��״̬����¼������ʹ������
        updateStuStateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == updateStuStateButton) {
                    updateStuStateInfo(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ�޸Ŀγ���Ϣ״̬��ť����¼������ʹ������
        updateCourseStateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == updateCourseStateButton) {
                    updateCourStateInfo(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ���ذ�ť����¼������ʹ������
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    adminMenuTest(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ��������¼������ʹ������
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                adminMenuTest(ad_id);
            }
        });
    }

    /**
     * ����ԱȨ�����޸Ŀγ�״̬�ķ���
     *
     * @param ad_id ����Ա���
     */
    private void updateCourStateInfo(int ad_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        jFrame.setLayout(null);

        JLabel updateCourseInfoLabel = new JLabel("�޸Ŀγ���Ϣ");

        JLabel c_idLabel = new JLabel("�γ̱��");

        JComboBox c_idBox = new JComboBox();

        JLabel c_stateLabel = new JLabel("�γ�״̬");
        String c_state[] = {"��ʹ��", "��ͣ��"};

        JComboBox c_stateBox = new JComboBox(c_state);

        jFrame.add(c_stateBox);
        jFrame.add(c_idBox);
        jFrame.add(c_idLabel);
        jFrame.add(c_stateLabel);

        jFrame.add(updateCourseInfoLabel);

        JButton submitButton = new JButton("�޸�");
        JButton backButton = new JButton("����");

        updateCourseInfoLabel.setBounds(300, 0, 200, 30);

        c_idLabel.setBounds(20, 40, 100, 30);
        c_stateLabel.setBounds(20, 80, 100, 30);
        c_idBox.setBounds(120, 40, 120, 30);
        c_stateBox.setBounds(120, 80, 120, 30);
        submitButton.setBounds(70, 160, 150, 30);
        backButton.setBounds(70, 200, 150, 30);

        jFrame.add(submitButton);
        jFrame.add(backButton);

        jFrame.setSize(800, 350);
        jFrame.setLocation(300, 200);
        jFrame.setVisible(true);

        DefaultTableModel courseModel = new DefaultTableModel();

        CourseService courseService = new CourseServiceImpl();
        List<CourseInfo> courseInfoList = courseService.queryCourInfoList();
        courseModel.setColumnIdentifiers(new Object[]{
                "�γ̱��", "�γ�����", "�γ�ѧ��", "�γ̴���ʱ��", "�γ̸���ʱ��", "�γ�״̬"});
        for (CourseInfo courseInfo : courseInfoList) {
            Object[] rowData = {courseInfo.getC_id(), courseInfo.getC_name(), courseInfo.getC_credit(),
                    courseInfo.getC_createDate(), courseInfo.getC_updateDate(), courseInfo.getC_state()};
            courseModel.addRow(rowData);
            c_idBox.addItem(courseInfo.getC_id());
        }
        JTable courseTable = new JTable(courseModel);
        JScrollPane courseJsc = new JScrollPane(courseTable);
        jFrame.add(courseJsc);

        courseJsc.setBounds(300, 40, 450, 240);
        courseTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        if (c_idBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(jFrame, "û�п��޸ĵ�����");
            updateAdminInfoFunction(ad_id);
            jFrame.dispose();
        }

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submitButton) {
                    int c_id = (Integer) c_idBox.getSelectedItem();
                    String c_state = (String) c_stateBox.getSelectedItem();
                    String c_updateDate = currentTime();
                    CourseInfo courseInfo = new CourseInfo();
                    courseInfo.setC_id(c_id);
                    courseInfo.setAd_id(ad_id);
                    courseInfo.setC_updateDate(c_updateDate);
                    courseInfo.setC_state(c_state);
                    int rows = courseService.updateCourStateInfo(courseInfo);
                    if (rows == 1) {
                        JOptionPane.showMessageDialog(jFrame, "�޸ĳɹ�");
                        updateCourStateInfo(ad_id);
                        jFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(jFrame, "�޸�ʧ��");
                        updateCourStateInfo(ad_id);
                        jFrame.dispose();
                    }
                }
            }
        });
        // Ϊ���ذ�ť����¼������ʹ������
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    updateAdminInfoFunction(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ��������¼������ʹ������
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                updateAdminInfoFunction(ad_id);
            }
        });
    }

    /**
     * ����ԱȨ�����޸Ŀγ�ѧ�ֵķ���
     *
     * @param ad_id ����Ա���
     */
    private void updateCourseInfo(int ad_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        jFrame.setLayout(null);

        JLabel updateCourseInfoLabel = new JLabel("�޸Ŀγ���Ϣ");

        JLabel c_idLabel = new JLabel("�γ̱��");

        JComboBox c_idBox = new JComboBox();

        JLabel c_creditLabel = new JLabel("�γ�ѧ��");

        JComboBox c_creditBox = new JComboBox();
        for (int i = 1; i < 7; i++) {
            c_creditBox.addItem(i);
        }

        jFrame.add(c_creditBox);
        jFrame.add(c_idBox);

        jFrame.add(c_idLabel);
        jFrame.add(c_creditLabel);

        jFrame.add(updateCourseInfoLabel);

        JButton submitButton = new JButton("�޸�");
        JButton backButton = new JButton("����");

        updateCourseInfoLabel.setBounds(300, 0, 200, 30);

        c_idLabel.setBounds(20, 40, 100, 30);
        c_creditLabel.setBounds(20, 80, 100, 30);

        c_idBox.setBounds(120, 40, 120, 30);
        c_creditBox.setBounds(120, 80, 120, 30);

        submitButton.setBounds(70, 160, 150, 30);
        backButton.setBounds(70, 200, 150, 30);

        jFrame.add(submitButton);
        jFrame.add(backButton);

        jFrame.setSize(800, 350);
        jFrame.setLocation(300, 200);
        jFrame.setVisible(true);

        DefaultTableModel courseModel = new DefaultTableModel();
        CourseService courseService = new CourseServiceImpl();
        List<CourseInfo> courseInfoList = courseService.queryCourInfoList();
        courseModel.setColumnIdentifiers(new Object[]{
                "�γ̱��", "�γ�����", "�γ�ѧ��", "�γ̴���ʱ��", "�γ̸���ʱ��", "�γ�״̬"});
        for (CourseInfo courseInfo : courseInfoList) {
            Object[] rowData = {courseInfo.getC_id(), courseInfo.getC_name(), courseInfo.getC_credit(),
                    courseInfo.getC_createDate(), courseInfo.getC_updateDate(), courseInfo.getC_state()};
            courseModel.addRow(rowData);
            c_idBox.addItem(courseInfo.getC_id());
        }

        JTable courseTable = new JTable(courseModel);
        JScrollPane courseJsc = new JScrollPane(courseTable);
        jFrame.add(courseJsc);

        courseJsc.setBounds(300, 40, 450, 240);
        courseTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        if (c_idBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(jFrame, "û�п��޸ĵ�����");
            updateAdminInfoFunction(ad_id);
            jFrame.dispose();
        }

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submitButton) {
                    int c_id = (Integer) c_idBox.getSelectedItem();
                    int c_credit = (Integer) c_creditBox.getSelectedItem();
                    String c_updateDate = currentTime();
                    CourseInfo courseInfo = new CourseInfo();
                    courseInfo.setC_credit(c_credit);
                    courseInfo.setC_id(c_id);
                    courseInfo.setAd_id(ad_id);
                    courseInfo.setC_updateDate(c_updateDate);
                    int rows = courseService.updateCourseInfo(courseInfo);
                    if (rows == 1) {
                        JOptionPane.showMessageDialog(jFrame, "�޸ĳɹ�");
                        updateCourseInfo(ad_id);
                        jFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(jFrame, "�޸�ʧ��");
                        updateCourseInfo(ad_id);
                        jFrame.dispose();
                    }
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    updateAdminInfoFunction(ad_id);
                    jFrame.dispose();
                }
            }
        });

        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                updateAdminInfoFunction(ad_id);
            }
        });
    }

    /**
     * ����ԱȨ�����޸�ѧ����Ϣ״̬�ķ���
     *
     * @param ad_id ����Ա���
     */
    private void updateStuStateInfo(int ad_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        // ���ô��岼��Ϊ���Բ���
        jFrame.setLayout(null);
        // ʵ������ǩ����
        JLabel updateTeaInfoLabel = new JLabel("�޸�ѧ����Ϣ״̬");
        JLabel stu_stateLabel = new JLabel("ѧ��״̬");
        JLabel stu_idLabel = new JLabel("ѧ�����");
        String state[] = {"����", "ͣ��"};
        JComboBox stu_stateBox = new JComboBox(state);
        JComboBox stu_idBox = new JComboBox();
        JButton submitButton = new JButton("�޸�");
        JButton backButton = new JButton("����");

        StudentService studentService = new StudentServiceImpl();
        List<StudentInfo> studentInfoList = studentService.queryStuInfoList();
        DefaultTableModel stuModel = new DefaultTableModel();
        // ��������
        stuModel.setColumnIdentifiers(new Object[]{"ѧ�����", "ѧ���û���", "ѧ������", "ѧ������",
                "ѧ���Ա�", "ѧ������", "ѧ���绰", "ѧ��רҵ", "��Ϣ����ʱ��", "��Ϣ����ʱ��", "ѧ����Ϣ״̬"});
        for (StudentInfo studentInfo : studentInfoList) {
            Object[] rowData = {studentInfo.getStu_id(), studentInfo.getStu_uName(), studentInfo.getStu_pwd(),
                    studentInfo.getStu_name(), studentInfo.getStu_sex(), studentInfo.getStu_age(),
                    studentInfo.getStu_phone(), studentInfo.getStu_major(), studentInfo.getStu_createDate(),
                    studentInfo.getStu_updateDate(), studentInfo.getStu_state()};
            stuModel.addRow(rowData);
            stu_idBox.addItem(studentInfo.getStu_id());
        }

        JTable stuTable = new JTable(stuModel);
        JScrollPane stuJsc = new JScrollPane(stuTable);
        stuTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        jFrame.add(updateTeaInfoLabel);
        jFrame.add(stu_stateLabel);
        jFrame.add(stu_stateBox);
        jFrame.add(stu_idBox);
        jFrame.add(stu_idLabel);
        jFrame.add(submitButton);
        jFrame.add(backButton);
        jFrame.add(stuJsc);

        updateTeaInfoLabel.setBounds(300, 0, 200, 30);
        stu_stateLabel.setBounds(20, 80, 100, 30);
        stu_idLabel.setBounds(20, 40, 100, 30);
        stu_stateBox.setBounds(120, 80, 120, 30);
        stu_idBox.setBounds(120, 40, 120, 30);
        submitButton.setBounds(70, 200, 150, 30);
        backButton.setBounds(70, 240, 150, 30);
        stuJsc.setBounds(300, 40, 450, 240);


        jFrame.setSize(800, 350);
        jFrame.setLocation(300, 200);
        jFrame.setVisible(true);

        if (stu_idBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(jFrame, "û�п��޸ĵ�����");
            updateAdminInfoFunction(ad_id);
            jFrame.dispose();
        }

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submitButton) {
                    int stu_id = (Integer) stu_idBox.getSelectedItem();
                    String stu_state = (String) stu_stateBox.getSelectedItem();
                    String stu_updateDate = currentTime();
                    StudentInfo studentInfo = new StudentInfo();
                    studentInfo.setStu_state(stu_state);
                    studentInfo.setStu_id(stu_id);
                    studentInfo.setAd_id(ad_id);
                    studentInfo.setStu_updateDate(stu_updateDate);
                    int rows = studentService.updateStuStateInfo(studentInfo);
                    if (rows == 1) {
                        JOptionPane.showMessageDialog(jFrame, "�޸ĳɹ�");
                        updateStuStateInfo(ad_id);
                        jFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(jFrame, "�޸�ʧ��");
                        updateStuStateInfo(ad_id);
                    }
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    updateAdminInfoFunction(ad_id);
                    jFrame.dispose();
                }
            }
        });

        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                updateAdminInfoFunction(ad_id);
            }
        });

    }

    /**
     * ����ԱȨ�����޸Ľ�ʦ��Ϣ״̬�ķ���
     *
     * @param ad_id ����Ա���
     */
    private void updateTeaStateInfo(int ad_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        jFrame.setLayout(null);
        JLabel updateTeaInfoLabel = new JLabel("�޸Ľ�ʦ��Ϣ״̬");

        JLabel tea_stateLabel = new JLabel("��ʦ״̬");
        JLabel tea_idLabel = new JLabel("��ʦ���");

        String state[] = {"����", "ͣ��"};
        JComboBox tea_stateBox = new JComboBox(state);
        JComboBox tea_idBox = new JComboBox();

        jFrame.add(updateTeaInfoLabel);
        jFrame.add(tea_stateLabel);
        jFrame.add(tea_stateBox);
        jFrame.add(tea_idBox);
        jFrame.add(tea_idLabel);

        JButton submitButton = new JButton("�޸�");
        JButton backButton = new JButton("����");

        updateTeaInfoLabel.setBounds(300, 0, 200, 30);
        tea_stateLabel.setBounds(20, 80, 100, 30);
        tea_idLabel.setBounds(20, 40, 100, 30);

        tea_stateBox.setBounds(120, 80, 120, 30);
        tea_idBox.setBounds(120, 40, 120, 30);

        submitButton.setBounds(70, 200, 150, 30);
        backButton.setBounds(70, 240, 150, 30);

        jFrame.add(submitButton);
        jFrame.add(backButton);

        jFrame.setSize(800, 350);
        jFrame.setLocation(300, 200);
        jFrame.setVisible(true);

        TeacherService teacherService = new TeacherServiceImpl();
        List<TeacherInfo> teacherInfoList = teacherService.queryTeaInfoList();
        DefaultTableModel teaModel = new DefaultTableModel();

        teaModel.setColumnIdentifiers(new Object[]{"��ʦ���", "��ʦ�û���", "��ʦ����", "��ʦ����", "��ʦרҵ",
                "��Ϣ����ʱ��", "��Ϣ����ʱ��", "��ʦ��Ϣ״̬"});
        for (TeacherInfo teacherInfo : teacherInfoList) {
            Object[] rowData = {teacherInfo.getTea_id(), teacherInfo.getTea_uName(),
                    teacherInfo.getTea_pwd(), teacherInfo.getTea_name(),
                    teacherInfo.getTea_major(), teacherInfo.getTea_createDate(),
                    teacherInfo.getTea_updateDate(), teacherInfo.getTea_state()};
            teaModel.addRow(rowData);
            tea_idBox.addItem(teacherInfo.getTea_id());
        }

        JTable teaTable = new JTable(teaModel);
        JScrollPane teaJsc = new JScrollPane(teaTable);
        jFrame.add(teaJsc);

        teaJsc.setBounds(300, 40, 450, 240);
        teaTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        if (tea_idBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(jFrame, "û�п��޸ĵ�����");
            updateAdminInfoFunction(ad_id);
            jFrame.dispose();
        }

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submitButton) {
                    int tea_id = (Integer) tea_idBox.getSelectedItem();
                    String tea_state = (String) tea_stateBox.getSelectedItem();
                    String tea_updateDate = currentTime();
                    TeacherInfo teacherInfo = new TeacherInfo();
                    teacherInfo.setTea_state(tea_state);
                    teacherInfo.setTea_updateDate(tea_updateDate);
                    teacherInfo.setAd_id(ad_id);
                    teacherInfo.setTea_id(tea_id);
                    int rows = teacherService.updateTeaStateInfo(teacherInfo);
                    if (rows == 1) {
                        JOptionPane.showMessageDialog(jFrame, "�޸ĳɹ�");
                        updateTeaStateInfo(ad_id);
                        jFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(jFrame, "�޸�ʧ��");
                        updateTeaStateInfo(ad_id);
                    }
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    updateAdminInfoFunction(ad_id);
                    jFrame.dispose();
                }
            }
        });

        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                updateAdminInfoFunction(ad_id);
            }
        });
    }

    /**
     * ��ʦ��¼������ҳ��ķ���
     *
     * @param tea_id ��ʦ���
     */
    private void teaMenuTest(int tea_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        jFrame.setLayout(null);
        JLabel TeaMenuLabel = new JLabel("��ʦ���ܽ���");
        JButton addInfoButton = new JButton("�����Ϣ����");
        JButton queryInfoButton = new JButton("��ѯ��Ϣ����");
        JButton updateInfoButton = new JButton("�޸���Ϣ����");
        JButton delInfoButton = new JButton("ɾ����Ϣ����");
        JButton quitButton = new JButton("�˳���¼");

        TeaMenuLabel.setBounds(100, 0, 200, 30);
        addInfoButton.setBounds(70, 40, 150, 30);
        queryInfoButton.setBounds(70, 80, 150, 30);
        updateInfoButton.setBounds(70, 120, 150, 30);
        delInfoButton.setBounds(70, 160, 150, 30);

        quitButton.setBounds(70, 200, 150, 30);

        jFrame.add(TeaMenuLabel);
        jFrame.add(addInfoButton);
        jFrame.add(queryInfoButton);
        jFrame.add(updateInfoButton);
        jFrame.add(delInfoButton);
        jFrame.add(quitButton);

        jFrame.setSize(320, 350);
        jFrame.setLocation(500, 200);
        jFrame.setVisible(true);

        addInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addInfoButton) {
                    addTeaInfoFunction(tea_id);
                    jFrame.dispose();
                }
            }
        });

        queryInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == queryInfoButton) {
                    queryTeaInfoFunction(tea_id);
                    jFrame.dispose();
                }
            }
        });

        updateInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == updateInfoButton) {
                    updateTeaInfoFunction(tea_id);
                    jFrame.dispose();
                }
            }
        });

        delInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == delInfoButton) {
                    delTeaInfoFunction(tea_id);
                    jFrame.dispose();
                }
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == quitButton) {
                    showMainMenu();
                    jFrame.dispose();
                }
            }
        });
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                showMainMenu();
            }
        });
    }

    /**
     * ��ʦȨ���������Ϣ����ҳ��ķ���
     *
     * @param tea_id ��ʦ��¼����
     */
    private void addTeaInfoFunction(int tea_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        jFrame.setLayout(null);
        JLabel TeaMenuLabel = new JLabel("�����Ϣ���ܽ���");
        JButton addStuResultInfoButton = new JButton("��ӳɼ���Ϣ");
        JButton backButton = new JButton("������һ��");

        TeaMenuLabel.setBounds(100, 0, 200, 30);
        addStuResultInfoButton.setBounds(70, 40, 150, 30);

        backButton.setBounds(70, 200, 150, 30);

        jFrame.add(TeaMenuLabel);
        jFrame.add(addStuResultInfoButton);
        jFrame.add(backButton);

        jFrame.setSize(320, 350);
        jFrame.setLocation(500, 200);
        jFrame.setVisible(true);

        TeacherService teacherService = new TeacherServiceImpl();
        TeacherInfo teacherInfo = teacherService.queryTeaInfo(tea_id);

        addStuResultInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addStuResultInfoButton) {
                    if (teacherInfo.getTea_state().equals("ͣ��")) {
                        JOptionPane.showMessageDialog(jFrame, "�Բ��������Ϣ״̬����ͣ��״̬���޷������ĳɼ���Ϣ");
                        teaMenuTest(tea_id);
                        jFrame.dispose();
                    }else {
                        addStudentResultInfo(tea_id);
                        jFrame.dispose();
                    }
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    teaMenuTest(tea_id);
                    jFrame.dispose();
                }
            }
        });
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                teaMenuTest(tea_id);
            }
        });
    }

    /**
     * ��ʦȨ������ӳɼ���Ϣ���ܵķ���
     *
     * @param tea_id ��ʦ���
     */
    private void addStudentResultInfo(int tea_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        jFrame.setLayout(null);
        JLabel addStuResInfoLabel = new JLabel("���ѧ���ɼ���Ϣ");

        JLabel stu_idLabel = new JLabel("ѧ�����");
        JLabel c_idLabel = new JLabel("�γ̱��");
        JLabel stu_resultLabel = new JLabel("ѧ���ɼ�");

        JComboBox stu_idBox = new JComboBox();
        JComboBox c_idBox = new JComboBox();
        JTextField stu_resultField = new JTextField();

        JButton submitButton = new JButton("���");
        JButton backButton = new JButton("����");

        addStuResInfoLabel.setBounds(400, 0, 200, 30);

        stu_idLabel.setBounds(20, 40, 100, 30);
        c_idLabel.setBounds(20, 80, 100, 30);
        stu_resultLabel.setBounds(20, 120, 100, 30);

        stu_idBox.setBounds(120, 40, 120, 30);
        c_idBox.setBounds(120, 80, 120, 30);
        stu_resultField.setBounds(120, 120, 120, 30);

        submitButton.setBounds(100, 400, 150, 30);
        backButton.setBounds(700, 400, 150, 30);

        StudentService studentService = new StudentServiceImpl();
        List<StudentInfo> studentInfoList = studentService.queryStuInfoList();
        DefaultTableModel stuInfoModel = new DefaultTableModel();
        stuInfoModel.setColumnIdentifiers(new Object[]{"ѧ�����", "ѧ������", "ѧ��רҵ", "��Ϣ����ʱ��",
                "��Ϣ����ʱ��", "ѧ����Ϣ״̬"});
        for (StudentInfo studentInfo : studentInfoList) {
            Object[] rowData = {studentInfo.getStu_id(), studentInfo.getStu_name(),
                    studentInfo.getStu_major(), studentInfo.getStu_createDate(), studentInfo.getStu_updateDate(),
                    studentInfo.getStu_state()};
            stuInfoModel.addRow(rowData);
            stu_idBox.addItem(studentInfo.getStu_id());
        }

        JTable stuInfoTable = new JTable(stuInfoModel);
        JScrollPane stuJsc = new JScrollPane(stuInfoTable);
        jFrame.add(stuJsc);
        jFrame.add(stu_idLabel);
        jFrame.add(c_idLabel);
        jFrame.add(stu_resultLabel);
        jFrame.add(stu_idBox);
        jFrame.add(c_idBox);
        jFrame.add(stu_resultField);
        jFrame.add(addStuResInfoLabel);
        jFrame.add(submitButton);
        jFrame.add(backButton);
        stuJsc.setBounds(440, 240, 460, 150);
        stuInfoTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        String c_state = "��ʹ��";
        CourseService courseService = new CourseServiceImpl();
        List<CourseInfo> courseInfoList = courseService.queryTeaCourInfoList(c_state);
        DefaultTableModel courseInfoModel = new DefaultTableModel();
        courseInfoModel.setColumnIdentifiers(new Object[]{
                "�γ̱��", "�γ�����", "�γ�ѧ��", "�γ̴���ʱ��", "�γ̸���ʱ��"});
        for (CourseInfo courseInfo : courseInfoList) {
            Object[] cRowData = {courseInfo.getC_id(), courseInfo.getC_name(), courseInfo.getC_credit(),
                    courseInfo.getC_createDate(), courseInfo.getC_updateDate()};
            courseInfoModel.addRow(cRowData);
            c_idBox.addItem(courseInfo.getC_id());
        }

        JTable courseTable = new JTable(courseInfoModel);
        JScrollPane courseJsc = new JScrollPane(courseTable);
        jFrame.add(courseJsc);
        courseJsc.setBounds(20, 240, 400, 150);
        courseTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        ResultCourseService resultCourseService = new ResultCourseServiceImpl();
        List<ResultCourseInfo> resultCourseInfoList = resultCourseService.queryStuResultInfoList(tea_id);
        DefaultTableModel stuResModel = new DefaultTableModel();
        stuResModel.setColumnIdentifiers(new Object[]{"�ɼ����", "ѧ������", "�γ�����", "���Գɼ�", "�ɼ�����ʱ��",
                "�ɼ�����ʱ��", "�γ����ڽ�ʦ����"});
        for (ResultCourseInfo resultCourseInfo : resultCourseInfoList) {
            Object[] resRowData = {resultCourseInfo.getSr_id(), resultCourseInfo.getStu_name(),
                    resultCourseInfo.getC_name(), resultCourseInfo.getSr_result(),
                    resultCourseInfo.getSr_createDate(), resultCourseInfo.getSr_updateDate(),
                    resultCourseInfo.getTea_name()};
            stuResModel.addRow(resRowData);
        }

        JTable stuResTable = new JTable(stuResModel);
        JScrollPane stuResJsc = new JScrollPane(stuResTable);
        jFrame.add(stuResJsc);
        stuResJsc.setBounds(300, 40, 600, 160);
        stuResTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        jFrame.setSize(1000, 500);
        jFrame.setLocation(200, 100);
        jFrame.setVisible(true);

        String sr_createDate = currentTime();



        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submitButton) {
                    int stu_id = 0;
                    int sr_result = 0;
                    int c_id = 0;
                    try {
                        stu_id = (Integer) stu_idBox.getSelectedItem();
                        c_id = (Integer) c_idBox.getSelectedItem();
                        sr_result = new Integer(stu_resultField.getText());
                        if (sr_result < 0) {
                            JOptionPane.showMessageDialog(jFrame, "���ʧ��");
                            addTeaInfoFunction(tea_id);
                            jFrame.dispose();
                        } else {
                            StudentResultService studentResultService = new StudentResultServiceImpl();
                            StudentResultInfo studentResultInfo = new StudentResultInfo();
                            studentResultInfo.setStu_id(stu_id);
                            studentResultInfo.setSr_result(sr_result);
                            studentResultInfo.setC_id(c_id);
                            studentResultInfo.setTea_id(tea_id);
                            studentResultInfo.setSr_createDate(sr_createDate);
                            studentResultInfo.setSr_updateDate(sr_createDate);
                            int rows = studentResultService.addStudentResultInfo(studentResultInfo);
                            if (rows == 1) {
                                JOptionPane.showMessageDialog(jFrame, "��ӳɼ���Ϣ�ɹ�");
                                addStudentResultInfo(tea_id);
                                jFrame.dispose();
                            } else {
                                JOptionPane.showMessageDialog(jFrame, "���ʧ��");
                                addStudentResultInfo(tea_id);
                                jFrame.dispose();
                            }
                        }
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(jFrame, "�޷����");
                        addStudentResultInfo(tea_id);
                        jFrame.dispose();
                    }
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    addTeaInfoFunction(tea_id);
                    jFrame.dispose();
                }
            }
        });

        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                addTeaInfoFunction(tea_id);
            }
        });

    }

    /**
     * ��ʦȨ���²�ѯ��Ϣ���ܵķ���
     *
     * @param tea_id ��ʦ��¼����
     */
    private void queryTeaInfoFunction(int tea_id) {
        Frame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        jFrame.setLayout(null);
        JLabel queryInfoLabel = new JLabel("��ѯ��Ϣ���ܽ���");
        JButton queryStuResultInfoButton = new JButton("��ѯ�ɼ���Ϣ");
        JButton queryTeaInfoButton = new JButton("��ѯ������Ϣ");
        JButton queryCourseInfoButton = new JButton("��ѯ�γ���Ϣ");
        JButton backButton = new JButton("������һ��");

        queryInfoLabel.setBounds(100, 0, 200, 30);
        queryStuResultInfoButton.setBounds(70, 40, 150, 30);
        queryTeaInfoButton.setBounds(70, 80, 150, 30);
        queryCourseInfoButton.setBounds(70, 120, 150, 30);

        backButton.setBounds(70, 200, 150, 30);

        jFrame.add(queryInfoLabel);
        jFrame.add(queryStuResultInfoButton);
        jFrame.add(queryTeaInfoButton);
        jFrame.add(queryCourseInfoButton);
        jFrame.add(backButton);

        jFrame.setSize(320, 350);
        jFrame.setLocation(500, 200);
        jFrame.setVisible(true);

        queryStuResultInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == queryStuResultInfoButton) {
                    queryTeaResultInfo(tea_id);
                    jFrame.dispose();
                }
            }
        });

        queryTeaInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == queryTeaInfoButton) {
                    queryTeaBasicInfo(tea_id);
                    jFrame.dispose();
                }
            }
        });

        queryCourseInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == queryCourseInfoButton) {
                    queryTeaCourseInfo(tea_id);
                    jFrame.dispose();
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    teaMenuTest(tea_id);
                    jFrame.dispose();
                }
            }
        });

        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                teaMenuTest(tea_id);
            }
        });
    }

    /**
     * ��ʦȨ���²�ѯ�ɼ���Ϣ�ķ���
     *
     * @param tea_id ��ʦ���
     */
    private void queryTeaResultInfo(int tea_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        jFrame.setLayout(null);
        JLabel queryLabel = new JLabel("��ѯ�ɼ���Ϣ");
        JButton backButton = new JButton("����");
        DefaultTableModel stuResModel = new DefaultTableModel();
        ResultCourseService resultCourseService = new ResultCourseServiceImpl();
        List<ResultCourseInfo> resultCourseInfoList = resultCourseService.queryStuResultInfoList(tea_id);
        stuResModel.setColumnIdentifiers(new Object[]{"�ɼ����", "ѧ������", "�γ�����", "���Գɼ�", "����ʱ��",
                "����ʱ��", "�γ����ڽ�ʦ����"});
        for (ResultCourseInfo resultCourseInfo : resultCourseInfoList) {
            Object[] rowData = {resultCourseInfo.getSr_id(), resultCourseInfo.getStu_name(),
                    resultCourseInfo.getC_name(), resultCourseInfo.getSr_result(), resultCourseInfo.getSr_createDate(),
                    resultCourseInfo.getSr_updateDate(), resultCourseInfo.getTea_name()};
            stuResModel.addRow(rowData);
        }
        JTable stuResTable = new JTable(stuResModel);
        stuResTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane stuResJsc = new JScrollPane(stuResTable);

        jFrame.add(queryLabel);
        jFrame.add(stuResJsc);
        jFrame.add(backButton);

        queryLabel.setBounds(200, 0, 200, 30);
        stuResJsc.setBounds(20, 40, 500, 300);
        backButton.setBounds(200, 380, 100, 30);


        jFrame.setSize(550, 500);
        jFrame.setLocation(400, 150);
        jFrame.setVisible(true);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    queryTeaInfoFunction(tea_id);
                    jFrame.dispose();
                }
            }
        });

        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                queryTeaInfoFunction(tea_id);
            }
        });
    }

    /**
     * ��ʦȨ���²�ѯ������Ϣ�ķ���
     *
     * @param tea_id ��ʦ���
     */
    private void queryTeaBasicInfo(int tea_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        jFrame.setLayout(null);
        JLabel queryLabel = new JLabel("��ѯ������Ϣ");
        JButton backButton = new JButton("����");

        TeacherService teacherService = new TeacherServiceImpl();
        TeacherInfo teacherInfo = teacherService.queryTeaInfo(tea_id);
        DefaultTableModel teaModel = new DefaultTableModel();
        teaModel.setColumnIdentifiers(new Object[]{"��ʦ���", "��ʦ�û���", "��ʦ����", "��ʦ����",
                "��ʦרҵ", "��Ϣ����ʱ��", "��Ϣ����ʱ��", "��ʦ��Ϣ״̬"});
        Object[] rowData = {teacherInfo.getTea_id(), teacherInfo.getTea_uName(),
                teacherInfo.getTea_pwd(), teacherInfo.getTea_name(),
                teacherInfo.getTea_major(), teacherInfo.getTea_createDate(),
                teacherInfo.getTea_updateDate(), teacherInfo.getTea_state()};
        teaModel.addRow(rowData);

        JTable teaTable = new JTable(teaModel);
        JScrollPane teaJsc = new JScrollPane(teaTable);
        teaTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jFrame.add(queryLabel);
        jFrame.add(teaJsc);
        jFrame.add(backButton);

        queryLabel.setBounds(180, 0, 200, 30);
        teaJsc.setBounds(20, 40, 450, 120);
        backButton.setBounds(150, 200, 150, 30);

        jFrame.setSize(500, 300);
        jFrame.setLocation(400, 200);
        jFrame.setVisible(true);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    queryTeaInfoFunction(tea_id);
                    jFrame.dispose();
                }
            }
        });

        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                queryTeaInfoFunction(tea_id);
            }
        });
    }

    /**
     * ��ʦȨ���²�ѯ�γ���Ϣ
     *
     * @param tea_id ��ʦ���
     */
    private void queryTeaCourseInfo(int tea_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        jFrame.setLayout(null);

        JLabel courseInfoLabel = new JLabel("��ѯ�γ���Ϣ");
        JButton backButton = new JButton("����");
        String c_state = "��ʹ��";
        CourseService courseService = new CourseServiceImpl();
        List<CourseInfo> courseInfoList = courseService.queryTeaCourInfoList(c_state);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"�γ̱��", "�γ�����", "�γ�ѧ��", "�γ̴���ʱ��",
                "�γ̸���ʱ��"});
        if (courseInfoList != null && !courseInfoList.isEmpty()) {
            for (CourseInfo courseInfo : courseInfoList) {
                Object[] rowData = {courseInfo.getC_id(), courseInfo.getC_name(),
                        courseInfo.getC_credit(), courseInfo.getC_createDate(),
                        courseInfo.getC_updateDate()};
                model.addRow(rowData);
            }
        }
        JTable table = new JTable(model);
        JScrollPane jsc = new JScrollPane(table);

        jFrame.add(courseInfoLabel);
        jFrame.add(jsc);
        jFrame.add(backButton);

        courseInfoLabel.setBounds(200, 0, 200, 30);
        jsc.setBounds(20, 40, 500, 300);
        backButton.setBounds(200, 380, 100, 30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        jFrame.setSize(550, 500);
        jFrame.setLocation(400, 150);
        jFrame.setVisible(true);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    queryTeaInfoFunction(tea_id);
                    jFrame.dispose();
                }
            }
        });

        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                queryTeaInfoFunction(tea_id);
            }
        });
    }

    /**
     * ��ʦȨ�����޸���Ϣ���ܵķ���
     *
     * @param tea_id ��ʦ���
     */
    private void updateTeaInfoFunction(int tea_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        jFrame.setLayout(null);
        JLabel updateInfoLabel = new JLabel("�޸���Ϣ���ܽ���");
        JButton updateStuResultInfoButton = new JButton("�޸ĳɼ���Ϣ");
        JButton updateTeaInfoButton = new JButton("�޸ĸ�����Ϣ");
        JButton backButton = new JButton("������һ��");

        updateInfoLabel.setBounds(100, 0, 200, 30);
        updateStuResultInfoButton.setBounds(70, 40, 150, 30);
        updateTeaInfoButton.setBounds(70, 80, 150, 30);

        backButton.setBounds(70, 200, 150, 30);

        jFrame.add(updateInfoLabel);
        jFrame.add(updateStuResultInfoButton);
        jFrame.add(updateTeaInfoButton);
        jFrame.add(backButton);

        jFrame.setSize(320, 350);
        jFrame.setLocation(500, 200);
        jFrame.setVisible(true);

        TeacherService teacherService = new TeacherServiceImpl();
        TeacherInfo teacherInfo = teacherService.queryTeaInfo(tea_id);

        updateStuResultInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == updateStuResultInfoButton) {
                    if (teacherInfo.getTea_state().equals("ͣ��")) {
                        JOptionPane.showMessageDialog(jFrame, "�Բ��������Ϣ״̬����ͣ��״̬���޷��޸���ĳɼ���Ϣ");
                    } else {
                        updateStudentResultInfo(tea_id);
                        jFrame.dispose();
                    }
                }
            }
        });
        updateTeaInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == updateTeaInfoButton) {
                    try {
                        if (teacherInfo.getTea_state().equals("ͣ��")) {
                            JOptionPane.showMessageDialog(jFrame, "�Բ��������Ϣ״̬����ͣ��״̬���޷��޸���ĳɼ���Ϣ");
                        } else {
                            updateTeaInfo(tea_id);
                            jFrame.dispose();
                        }
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(jFrame, "û��רҵ��Ϣ�ļ�,�޷��޸ı�����Ϣ");
                    }
                }
            }
        });
        // Ϊ���ذ�ť����¼������ʹ������
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    teaMenuTest(tea_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ��������¼������ʹ������
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                teaMenuTest(tea_id);
            }
        });
    }

    /**
     * ��ʦȨ�����޸ĳɼ���Ϣ�ķ���
     *
     * @param tea_id ��ʦ���
     */
    private void updateStudentResultInfo(int tea_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        jFrame.setLayout(null);

        JLabel updateStuResultInfoLabel = new JLabel("�޸ĳɼ���Ϣ");

        JLabel sr_idLabel = new JLabel("�ɼ����");

        JComboBox sr_idBox = new JComboBox();

        JLabel sr_resultLabel = new JLabel("���Գɼ�");

        JTextField sr_resultField = new JTextField();

        jFrame.add(sr_resultField);
        jFrame.add(sr_idBox);

        jFrame.add(sr_idLabel);
        jFrame.add(sr_resultLabel);

        jFrame.add(updateStuResultInfoLabel);

        JButton submitButton = new JButton("�޸�");
        JButton backButton = new JButton("����");


        updateStuResultInfoLabel.setBounds(300, 0, 200, 30);

        sr_idLabel.setBounds(20, 40, 100, 30);
        sr_resultLabel.setBounds(20, 80, 100, 30);

        sr_idBox.setBounds(120, 40, 120, 30);
        sr_resultField.setBounds(120, 80, 120, 30);

        submitButton.setBounds(70, 200, 150, 30);
        backButton.setBounds(70, 240, 150, 30);

        jFrame.add(submitButton);
        jFrame.add(backButton);

        jFrame.setSize(800, 350);
        jFrame.setLocation(300, 200);
        jFrame.setVisible(true);

        DefaultTableModel stuResModel = new DefaultTableModel();
        ResultCourseService resultCourseService = new ResultCourseServiceImpl();
        List<ResultCourseInfo> resultCourseInfoList = resultCourseService.queryStuResultInfoList(tea_id);
        stuResModel.setColumnIdentifiers(new Object[]{"�ɼ����", "ѧ������", "�γ�����", "���Գɼ�",
                "��Ϣ����ʱ��", "��Ϣ����ʱ��", "�γ����ڽ�ʦ����"});
        for (ResultCourseInfo resultCourseInfo : resultCourseInfoList) {
            Object[] rowData = {resultCourseInfo.getSr_id(), resultCourseInfo.getStu_name(),
                    resultCourseInfo.getC_name(), resultCourseInfo.getSr_result(), resultCourseInfo.getSr_createDate(),
                    resultCourseInfo.getSr_updateDate(), resultCourseInfo.getTea_name()};
            stuResModel.addRow(rowData);
            sr_idBox.addItem(resultCourseInfo.getSr_id());
        }

        JTable stuResultTable = new JTable(stuResModel);
        JScrollPane stuResultJsc = new JScrollPane(stuResultTable);
        jFrame.add(stuResultJsc);

        stuResultJsc.setBounds(300, 40, 450, 240);
        stuResultTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);


        if (sr_idBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(jFrame, "û�п��޸ĵ�����");
            updateStudentResultInfo(tea_id);
            jFrame.dispose();
        }

        // Ϊ�޸İ�ť����¼������ʹ������
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submitButton) {
                    int sr_id = (Integer) sr_idBox.getSelectedItem();
                    int sr_result = 0;
                    try {
                        sr_result = new Integer(sr_resultField.getText());
                        String sr_updateDate = currentTime();
                        if (sr_result < 0) {
                            JOptionPane.showMessageDialog(jFrame, "�ɼ��������,����������");
                            updateTeaInfoFunction(tea_id);
                            jFrame.dispose();
                        } else {
                            StudentResultService studentResultService = new StudentResultServiceImpl();
                            StudentResultInfo studentResultInfo = new StudentResultInfo();
                            studentResultInfo.setSr_id(sr_id);
                            studentResultInfo.setSr_result(sr_result);
                            studentResultInfo.setSr_updateDate(sr_updateDate);
                            int rows = studentResultService.updateStudentResultInfo(studentResultInfo);
                            if (rows == 1) {
                                JOptionPane.showMessageDialog(jFrame, "�޸ĳɹ�");
                                updateStudentResultInfo(tea_id);
                                jFrame.dispose();
                            } else {
                                JOptionPane.showMessageDialog(jFrame, "�޸�ʧ��");
                                updateStudentResultInfo(tea_id);
                                jFrame.dispose();
                            }
                        }
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(jFrame, "�ɼ��������,����������");
                        updateStudentResultInfo(tea_id);
                        jFrame.dispose();
                    }
                }
            }
        });
        // Ϊ���ذ�ť����¼������ʹ������
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    updateTeaInfoFunction(tea_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ���尴ť����¼������ʹ������
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                updateTeaInfoFunction(tea_id);
            }
        });
    }

    /**
     * ��ʦȨ�����޸ĸ�����Ϣ�ķ���
     *
     * @param tea_id ��ʦ���
     */
    private void updateTeaInfo(int tea_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        jFrame.setLayout(null);
        JLabel updateTeaInfoLabel = new JLabel("�޸ĸ�����Ϣ");

        JLabel tea_majorLabel = new JLabel("����רҵ");

        JComboBox tea_majorBox = new JComboBox(majorNameFile());

        jFrame.add(tea_majorBox);

        jFrame.add(tea_majorLabel);

        JButton submitButton = new JButton("�޸�");
        JButton backButton = new JButton("����");

        updateTeaInfoLabel.setBounds(320, 0, 200, 30);
        tea_majorLabel.setBounds(20, 40, 100, 30);

        tea_majorBox.setBounds(120, 40, 150, 30);

        submitButton.setBounds(70, 160, 150, 30);
        backButton.setBounds(70, 200, 150, 30);

        jFrame.add(updateTeaInfoLabel);

        jFrame.add(submitButton);
        jFrame.add(backButton);

        jFrame.setSize(800, 280);
        jFrame.setLocation(300, 200);
        jFrame.setVisible(true);

        TeacherService teacherService = new TeacherServiceImpl();
        TeacherInfo teacherInfo = teacherService.queryTeaInfo(tea_id);
        DefaultTableModel teaModel = new DefaultTableModel();
        teaModel.setColumnIdentifiers(new Object[]{"��ʦ���", "��ʦ�û���", "��ʦ����", "��ʦ����", "��ʦ����רҵ",
                "��Ϣ����ʱ��", "��Ϣ����ʱ��", "��ʦ��Ϣ״̬"});
        Object[] rowData = {teacherInfo.getTea_id(), teacherInfo.getTea_uName(), teacherInfo.getTea_pwd(),
                teacherInfo.getTea_name(), teacherInfo.getTea_major(), teacherInfo.getTea_createDate(),
                teacherInfo.getTea_updateDate(), teacherInfo.getTea_state()};
        teaModel.addRow(rowData);

        JTable teaTable = new JTable(teaModel);
        JScrollPane teaJsc = new JScrollPane(teaTable);
        jFrame.add(teaJsc);

        teaJsc.setBounds(300, 40, 450, 180);
        teaTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        // Ϊ�޸İ�ť����¼������ʹ������
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submitButton) {
                    String tea_major = (String) tea_majorBox.getSelectedItem();
                    String tea_updateDate = currentTime();
                    TeacherInfo teacherInfo = new TeacherInfo();
                    teacherInfo.setTea_id(tea_id);
                    teacherInfo.setTea_major(tea_major);
                    teacherInfo.setTea_updateDate(tea_updateDate);
                    int rows = teacherService.updateTeaInfo(teacherInfo);
                    if (rows == 1) {
                        JOptionPane.showMessageDialog(jFrame, "�޸ĳɹ�");
                        updateTeaInfo(tea_id);
                        jFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(jFrame, "�޸�ʧ��");
                        updateTeaInfo(tea_id);
                        jFrame.dispose();
                    }
                }
            }
        });
        // Ϊ���ذ�ť����¼������ʹ������
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    updateTeaInfoFunction(tea_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ��������¼������ʹ������
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                updateTeaInfoFunction(tea_id);
            }
        });
    }

    /**
     * ��ʦȨ����ɾ������ҳ��ķ���
     *
     * @param tea_id ��¼���ʦ�ı��
     */
    private void delTeaInfoFunction(int tea_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        jFrame.setLayout(null);
        JLabel updateInfoLabel = new JLabel("ɾ����Ϣ���ܽ���");
        JButton delStuResultInfoButton = new JButton("ɾ���ɼ���Ϣ");
        JButton backButton = new JButton("������һ��");

        updateInfoLabel.setBounds(100, 0, 200, 30);
        delStuResultInfoButton.setBounds(70, 40, 150, 30);
        backButton.setBounds(70, 200, 150, 30);

        jFrame.add(updateInfoLabel);
        jFrame.add(delStuResultInfoButton);
        jFrame.add(backButton);
        jFrame.setSize(320, 350);
        jFrame.setLocation(500, 200);
        jFrame.setVisible(true);

        TeacherService teacherService = new TeacherServiceImpl();
        TeacherInfo teacherInfo = teacherService.queryTeaInfo(tea_id);
        // Ϊɾ���ɼ���Ϣ��ť����¼������ʹ������
        delStuResultInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == delStuResultInfoButton) {
                    if (teacherInfo.getTea_state().equals("ͣ��")) {
                        JOptionPane.showMessageDialog(jFrame, "�Բ��������Ϣ״̬Ϊͣ��״̬���޷�ɾ���ɼ���Ϣ");
                    } else {
                        delStudentResultInfoFunction(tea_id);
                        jFrame.dispose();
                    }
                }
            }
        });
        // Ϊ���ذ�ť����¼������ʹ������
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    teaMenuTest(tea_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ���尴ť����¼������ʹ������
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                teaMenuTest(tea_id);
            }
        });
    }

    /**
     * ��ʦȨ����ɾ���ɼ���Ϣҳ��ķ���
     *
     * @param tea_id ��ʦ���
     */
    private void delStudentResultInfoFunction(int tea_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        // ���ô��岼��Ϊ���Բ���
        jFrame.setLayout(null);
        // ʵ������ǩ����
        JLabel delStuResultInfoLabel = new JLabel("ɾ���ɼ���Ϣ");
        JLabel sr_idLabel = new JLabel("�ɼ����");
        JComboBox sr_idBox = new JComboBox();
        JButton submitButton = new JButton("ɾ��");
        JButton backButton = new JButton("����");

        ResultCourseService resultCourseService = new ResultCourseServiceImpl();
        DefaultTableModel stuResModel = new DefaultTableModel();
        List<ResultCourseInfo> resultCourseInfoList = resultCourseService.queryStuResultInfoList(tea_id);
        stuResModel.setColumnIdentifiers(new Object[]{"�ɼ����", "ѧ������", "�γ�����", "���Գɼ�", "�ɼ�����ʱ��",
                "�ɼ�����ʱ��", "�γ����ڽ�ʦ����"});
        for (ResultCourseInfo resultCourseInfo : resultCourseInfoList) {
            Object[] rowData = {resultCourseInfo.getSr_id(), resultCourseInfo.getStu_name(),
                    resultCourseInfo.getC_name(), resultCourseInfo.getSr_result(), resultCourseInfo.getSr_createDate(),
                    resultCourseInfo.getSr_updateDate(), resultCourseInfo.getTea_name()};
            stuResModel.addRow(rowData);
            sr_idBox.addItem(resultCourseInfo.getSr_id());
        }

        JTable stuResTable = new JTable(stuResModel);
        JScrollPane stuResJsc = new JScrollPane(stuResTable);
        stuResTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        jFrame.add(sr_idLabel);
        jFrame.add(delStuResultInfoLabel);
        jFrame.add(sr_idBox);
        jFrame.add(submitButton);
        jFrame.add(backButton);
        jFrame.add(stuResJsc);
        // ���ø����������ʹ�С
        delStuResultInfoLabel.setBounds(300, 0, 200, 30);
        sr_idLabel.setBounds(20, 40, 100, 30);
        sr_idBox.setBounds(120, 40, 120, 30);
        submitButton.setBounds(70, 200, 150, 30);
        backButton.setBounds(70, 240, 150, 30);
        stuResJsc.setBounds(300, 40, 450, 240);
        // Ϊ�����������꣬��С��ʹ����ɼ�
        jFrame.setSize(800, 350);
        jFrame.setLocation(300, 200);
        jFrame.setVisible(true);

        if (sr_idBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(jFrame, "û�п�ɾ��������");
            delTeaInfoFunction(tea_id);
            jFrame.dispose();
        }
        // Ϊɾ����ť����¼������ʹ������
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submitButton) {
                    int sr_id = (Integer) sr_idBox.getSelectedItem();
                    StudentResultService studentResultService = new StudentResultServiceImpl();
                    int rows = studentResultService.delStudentResultInfo(sr_id, tea_id);
                    if (rows == 1) {
                        JOptionPane.showMessageDialog(jFrame, "ɾ���ɹ�");
                        delStudentResultInfoFunction(tea_id);
                        jFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(jFrame, "ɾ��ʧ��");
                        delStudentResultInfoFunction(tea_id);
                        jFrame.dispose();
                    }
                }
            }
        });
        // Ϊ���ذ�ť����¼������ʹ������
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    delTeaInfoFunction(tea_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ��������¼������ʹ������
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                delTeaInfoFunction(tea_id);
            }
        });
    }

    /**
     * ѧ����Ϣ����ҳ��ķ���
     *
     * @param stu_id ѧ�����
     */
    private void stuMenuTest(int stu_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        jFrame.setLayout(null);
        JLabel adMenuLabel = new JLabel("ѧ�����ܽ���");
        JButton queryInfoButton = new JButton("��ѯ��Ϣ����");
        JButton updateInfoButton = new JButton("�޸���Ϣ����");
        JButton quitButton = new JButton("�˳���¼");

        adMenuLabel.setBounds(100, 0, 200, 30);
        queryInfoButton.setBounds(70, 40, 150, 30);
        updateInfoButton.setBounds(70, 80, 150, 30);

        quitButton.setBounds(70, 200, 150, 30);

        jFrame.add(adMenuLabel);
        jFrame.add(queryInfoButton);
        jFrame.add(updateInfoButton);
        jFrame.add(quitButton);
        // Ϊ�����������꣬��С��ʹ����ɼ�
        jFrame.setSize(320, 350);
        jFrame.setLocation(500, 200);
        jFrame.setVisible(true);
        // Ϊ��ѯ��Ϣ��ť����¼������ʹ������
        queryInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == queryInfoButton) {
                    queryStuInfoFunction(stu_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ�޸���Ϣ��ť����¼������ʹ������
        updateInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == updateInfoButton) {
                    updateStuInfoFunction(stu_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ�˳���¼��ť����¼������ʹ������
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == quitButton) {
                    showMainMenu();
                    jFrame.dispose();
                }
            }
        });
        // Ϊ��������¼������ʹ������
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                showMainMenu();
            }
        });
    }

    /**
     * ѧ��Ȩ���²�ѯ��Ϣ���ܵķ���
     *
     * @param stu_id ѧ�����
     */
    private void queryStuInfoFunction(int stu_id) {
        Frame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        jFrame.setLayout(null);
        JLabel queryInfoLabel = new JLabel("��ѯ��Ϣ���ܽ���");
        JButton queryStuResultInfoButton = new JButton("��ѯ�ɼ���Ϣ");
        JButton queryTeaInfoButton = new JButton("��ѯ������Ϣ");
        JButton backButton = new JButton("������һ��");

        queryInfoLabel.setBounds(100, 0, 200, 30);
        queryStuResultInfoButton.setBounds(70, 40, 150, 30);
        queryTeaInfoButton.setBounds(70, 80, 150, 30);

        backButton.setBounds(70, 200, 150, 30);

        jFrame.add(queryInfoLabel);
        jFrame.add(queryStuResultInfoButton);
        jFrame.add(queryTeaInfoButton);
        jFrame.add(backButton);
        // Ϊ�����������꣬��С��ʹ����ɼ�
        jFrame.setSize(320, 350);
        jFrame.setLocation(500, 200);
        jFrame.setVisible(true);
        // Ϊ��ѯ�ɼ���Ϣ��ť����¼������ʹ������
        queryStuResultInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == queryStuResultInfoButton) {
                    queryStuResultInfo(stu_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ��ѯ������Ϣ��ť����¼������ʹ������
        queryTeaInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == queryTeaInfoButton) {
                    queryStuInfo(stu_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ���ذ�ť����¼������ʹ������
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    stuMenuTest(stu_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ��������¼������ʹ������
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                stuMenuTest(stu_id);
            }
        });
    }

    /**
     * ѧ��Ȩ���²�ѯ������Ϣ���ܵķ���
     *
     * @param stu_id ѧ�����
     */
    private void queryStuInfo(int stu_id) {
        JFrame jFrame = new JFrame("ѧ���ɼ���Ϣ����ϵͳ");
        jFrame.setLayout(null);
        JButton backButton = new JButton("����");
        JLabel queryLabel = new JLabel("��ѯ������Ϣ");

        StudentService studentService = new StudentServiceImpl();
        StudentInfo studentInfo = studentService.queryStuInfo(stu_id);
        DefaultTableModel stuModel = new DefaultTableModel();
        stuModel.setColumnIdentifiers(new Object[]{"ѧ�����", "ѧ���û���", "ѧ������", "ѧ������", "ѧ���Ա�",
                "ѧ������", "ѧ���ֻ���", "ѧ��רҵ", "��Ϣ����ʱ��", "��Ϣ����ʱ��", "ѧ����Ϣ״̬"});
        Object[] rowData = {studentInfo.getStu_id(), studentInfo.getStu_uName(),
                studentInfo.getStu_pwd(), studentInfo.getStu_name(), studentInfo.getStu_sex(),
                studentInfo.getStu_age(), studentInfo.getStu_phone(), studentInfo.getStu_major(),
                studentInfo.getStu_createDate(), studentInfo.getStu_updateDate(),
                studentInfo.getStu_state()};
        stuModel.addRow(rowData);
        JTable stuTable = new JTable(stuModel);
        JScrollPane stuJsc = new JScrollPane(stuTable);
        stuTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        jFrame.add(stuJsc);
        jFrame.add(backButton);
        jFrame.add(queryLabel);
        queryLabel.setBounds(180, 0, 200, 30);
        stuJsc.setBounds(20, 40, 450, 120);
        backButton.setBounds(150, 200, 150, 30);
        // Ϊ�����������꣬��С��ʹ����ɼ�
        jFrame.setSize(500, 300);
        jFrame.setLocation(400, 200);
        jFrame.setVisible(true);
        jFrame.add(stuJsc);
        // Ϊ���ذ�ť����¼������ʹ������
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    queryStuInfoFunction(stu_id);
                    jFrame.dispose();
                }
            }
        });
    }

    /**
     * ѧ��Ȩ���²�ѯ�ɼ����ܵķ���
     *
     * @param stu_id ѧ�����
     */
    private void queryStuResultInfo(int stu_id) {
        JFrame jFrame = new JFrame("ѧ���ɼ���Ϣ����ϵͳ");
        jFrame.setLayout(null);
        JButton backButton = new JButton("����");
        JLabel queryLabel = new JLabel("��ѯ�ɼ���Ϣ");
        ResultCourseService resultCourseService = new ResultCourseServiceImpl();
        List<ResultCourseInfo> resultCourseInfoList = resultCourseService.queryStudentResultInfoList(stu_id);
        DefaultTableModel stuResModel = new DefaultTableModel();
        stuResModel.setColumnIdentifiers(new Object[]{"�ɼ����", "ѧ������", "�γ�����", "���Գɼ�", "��Ϣ����ʱ��",
                "��Ϣ����ʱ��", "�γ����ڽ�ʦ����"});
        for (ResultCourseInfo resultCourseInfo : resultCourseInfoList) {
            Object[] rowData = {resultCourseInfo.getSr_id(),
                    resultCourseInfo.getStu_name(), resultCourseInfo.getC_name(), resultCourseInfo.getSr_result(),
                    resultCourseInfo.getSr_createDate(), resultCourseInfo.getSr_updateDate(),
                    resultCourseInfo.getTea_name()};
            stuResModel.addRow(rowData);
        }
        JTable stuResTable = new JTable(stuResModel);
        JScrollPane stuResJsc = new JScrollPane(stuResTable);
        stuResTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jFrame.add(stuResJsc);
        jFrame.add(backButton);
        jFrame.add(queryLabel);
        jFrame.add(stuResJsc);
        queryLabel.setBounds(180, 0, 200, 30);
        stuResJsc.setBounds(20, 40, 450, 120);
        backButton.setBounds(150, 200, 150, 30);
        // Ϊ�����������꣬��С��ʹ����ɼ�
        jFrame.setSize(500, 300);
        jFrame.setLocation(400, 200);
        jFrame.setVisible(true);
        // Ϊ���ذ�ť����¼������ʹ������
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    queryStuInfoFunction(stu_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ��������¼������ʹ������
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                queryStuInfoFunction(stu_id);
            }
        });
    }

    /**
     * ѧ��Ȩ�����޸���Ϣ���ܵķ���
     *
     * @param stu_id ѧ�����
     */
    private void updateStuInfoFunction(int stu_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        jFrame.setLayout(null);
        JLabel updateInfoLabel = new JLabel("�޸���Ϣ���ܽ���");
        JButton updateStuInfoButton = new JButton("�޸ĸ�����Ϣ");
        JButton backButton = new JButton("����");
        updateInfoLabel.setBounds(100, 0, 200, 30);
        updateStuInfoButton.setBounds(70, 40, 150, 30);
        backButton.setBounds(70, 200, 150, 30);
        jFrame.add(updateInfoLabel);
        jFrame.add(updateStuInfoButton);
        jFrame.add(backButton);
        jFrame.setSize(320, 350);
        jFrame.setLocation(500, 200);
        jFrame.setVisible(true);
        StudentService studentService = new StudentServiceImpl();
        StudentInfo studentInfo = studentService.queryStuInfo(stu_id);
        // Ϊ�޸ĸ�����Ϣ��ť����¼������ʹ������
        updateStuInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == updateStuInfoButton) {
                    try {
                        if (studentInfo.getStu_state().equals("ͣ��")) {
                            JOptionPane.showMessageDialog(jFrame, "�Բ��������Ϣ״̬Ϊͣ��״̬���޷��޸���ĸ�����Ϣ");
                        } else {
                            updateStuInfo(stu_id);
                            jFrame.dispose();
                        }
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(jFrame, "û��רҵ��Ϣ�ļ�,�޷��޸ı�����Ϣ");
                    }
                }
            }
        });
        // Ϊ���ذ�ť����¼������ʹ������
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    stuMenuTest(stu_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ��������¼������ʹ������
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                stuMenuTest(stu_id);
            }
        });
    }

    /**
     * ѧ��Ȩ�����޸ĸ�����Ϣ���ܵķ���
     *
     * @param stu_id ѧ�����
     */
    private void updateStuInfo(int stu_id) {
        JFrame jFrame = new JFrame("ѧ����ѧ��Ϣ����ϵͳ");
        // ���ô��岼��Ϊ���Բ���
        jFrame.setLayout(null);
        // ʵ������ǩ����
        JLabel queryStuInfoLabel = new JLabel("�޸ĸ�����Ϣ");
        JLabel stu_ageLabel = new JLabel("����");
        JLabel stu_phoneLabel = new JLabel("�ֻ���");
        JLabel stu_majorLabel = new JLabel("רҵ");
        JComboBox stu_majorBox = new JComboBox(majorNameFile());
        JTextField stu_ageField = new JTextField();
        JTextField stu_phoneField = new JTextField();
        JButton submitButton = new JButton("�޸�");
        JButton backButton = new JButton("����");

        StudentService studentService = new StudentServiceImpl();
        StudentInfo studentInfo = studentService.queryStuInfo(stu_id);
        DefaultTableModel stuModel = new DefaultTableModel();
        stuModel.setColumnIdentifiers(new Object[]{"ѧ�����", "ѧ���û���", "ѧ������", "ѧ������", "ѧ���Ա�",
                "ѧ������", "ѧ���ֻ���", "ѧ��רҵ", "��Ϣ����ʱ��", "��Ϣ����ʱ��", "ѧ����Ϣ״̬"});
        Object[] rowData = {studentInfo.getStu_id(), studentInfo.getStu_uName(),
                studentInfo.getStu_pwd(), studentInfo.getStu_name(), studentInfo.getStu_sex(),
                studentInfo.getStu_age(), studentInfo.getStu_phone(), studentInfo.getStu_major(),
                studentInfo.getStu_createDate(), studentInfo.getStu_updateDate(),
                studentInfo.getStu_state()};
        stuModel.addRow(rowData);

        JTable stuTable = new JTable(stuModel);
        stuTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane stuJsc = new JScrollPane(stuTable);

        jFrame.add(stuJsc);
        jFrame.add(stu_ageLabel);
        jFrame.add(stu_phoneLabel);
        jFrame.add(stu_majorLabel);
        jFrame.add(queryStuInfoLabel);
        jFrame.add(stu_ageField);
        jFrame.add(stu_phoneField);
        jFrame.add(stu_majorBox);
        jFrame.add(submitButton);
        jFrame.add(backButton);

        queryStuInfoLabel.setBounds(320, 0, 200, 30);
        stu_ageLabel.setBounds(20, 40, 100, 30);
        stu_phoneLabel.setBounds(20, 80, 100, 30);
        stu_majorLabel.setBounds(20, 120, 100, 30);
        stu_ageField.setBounds(120, 40, 150, 30);
        stu_phoneField.setBounds(120, 80, 150, 30);
        stu_majorBox.setBounds(120, 120, 150, 30);
        submitButton.setBounds(70, 160, 150, 30);
        backButton.setBounds(70, 200, 150, 30);
        stuJsc.setBounds(300, 40, 450, 180);

        // Ϊ�����������꣬��С��ʹ����ɼ�
        jFrame.setSize(800, 280);
        jFrame.setLocation(300, 200);
        jFrame.setVisible(true);
        // Ϊ�޸İ�ť����¼������ʹ������
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submitButton) {
                    int stu_age = 0;
                    String stu_phone = stu_phoneField.getText();
                    String stu_major = (String) stu_majorBox.getSelectedItem();
                    StudentService studentService = new StudentServiceImpl();
                    String stu_updateDate = currentTime();
                    Pattern p = Pattern.compile("^[1][234578][0-9]{9}$");
                    Matcher m = p.matcher(stu_phone);
                    boolean b = m.matches();
                    try {
                        stu_age = new Integer(stu_ageField.getText());
                        if (stu_age <= 0 || stu_age > 99 || b == false) {
                            JOptionPane.showMessageDialog(jFrame, "������ֻ����������");
                            stu_ageField.setText("");
                            stu_phoneField.setText("");
                        } else {
                            StudentInfo updateStudentInfo = new StudentInfo();
                            updateStudentInfo.setStu_id(stu_id);
                            updateStudentInfo.setStu_age(stu_age);
                            updateStudentInfo.setStu_phone(stu_phone);
                            updateStudentInfo.setStu_major(stu_major);
                            updateStudentInfo.setStu_updateDate(stu_updateDate);
                            int rows = studentService.updateStuInfo(updateStudentInfo);
                            if (rows == 1) {
                                JOptionPane.showMessageDialog(jFrame, "�޸ĸ�����Ϣ�ɹ�");
                                updateStuInfo(stu_id);
                                jFrame.dispose();
                            } else {
                                JOptionPane.showMessageDialog(jFrame, "�޸�ʧ��");
                                stu_ageField.setText("");
                                stu_phoneField.setText("");
                            }
                        }
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(jFrame, "�����������");
                        stu_ageField.setText("");
                    }
                }
            }
        });
        // Ϊ���ذ�ť����¼������ʹ������
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    updateStuInfoFunction(stu_id);
                    jFrame.dispose();
                }
            }
        });
        // Ϊ��������¼������ʹ������
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                updateStuInfoFunction(stu_id);
            }
        });
    }

    /**
     * ��ȡרҵ������Ϣ�ļ�
     *
     * @return רҵ��������
     */
    private String[] majorNameFile() {
        try {
            File file = new File("txt/majornameinfo.txt");
            InputStream inputStream = new FileInputStream(file);
            byte byteArray[] = new byte[(int) file.length()];
            inputStream.read(byteArray);
            String major = new String(byteArray);
            String majorArray[] = major.split("\n");
            return majorArray;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * ��ȡ�γ�������Ϣ�ļ�
     *
     * @return �γ���������
     */
    private String[] courseNameFile() {
        try {
            File file = new File("txt/coursenameinfo.txt");
            InputStream inputStream = new FileInputStream(file);
            byte byteArray[] = new byte[(int) file.length()];
            inputStream.read(byteArray);
            String courseName = new String(byteArray);
            String courseNameArray[] = courseName.split("\n");
            return courseNameArray;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * ��ȡ��ǰϵͳʱ��
     *
     * @return ��ǰϵͳʱ��
     */
    private String currentTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return simpleDateFormat.format(date);
    }
}