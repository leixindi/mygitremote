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
 * 系统的操作类
 */
public class Operation {
    /**
     * 系统的启动和交互界面的方法
     */
    public void showMainMenu() {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        // 设置窗体的布局为绝对布局
        jFrame.setLayout(null);
        // 实例化标签对象
        JLabel menuTestLabel = new JLabel("学生教学信息管理系统界面");
        JButton adLoginButton = new JButton("管理员登录");
        JButton teaLoginButton = new JButton("教师登录");
        JButton stuLoginButton = new JButton("学生登录");
        JButton exitSystemButton = new JButton("退出系统");
        // 设置各组件在窗体的坐标和大小
        menuTestLabel.setBounds(70, 0, 200, 30);
        adLoginButton.setBounds(100, 40, 100, 30);
        teaLoginButton.setBounds(100, 80, 100, 30);
        stuLoginButton.setBounds(100, 120, 100, 30);
        exitSystemButton.setBounds(100, 160, 100, 30);
        // 将各组件放到窗体中
        jFrame.add(menuTestLabel);
        jFrame.add(adLoginButton);
        jFrame.add(teaLoginButton);
        jFrame.add(stuLoginButton);
        jFrame.add(exitSystemButton);
        // 设置窗体大小
        jFrame.setSize(320, 350);
        // 设置窗体坐标
        jFrame.setLocation(500, 200);
        // 让窗体可见
        jFrame.setVisible(true);
        // 为窗体添加事件监听和处理操作
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
        // 为管理员登录按钮添加事件监听和处理操作
        adLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == adLoginButton) {
                    adminLogin();
                    jFrame.dispose();
                }
            }
        });
        // 为教师登录按钮添加事件监听和处理操作
        teaLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == teaLoginButton) {
                    teacherLogin();
                    jFrame.dispose();
                }
            }
        });
        // 为学生登录按钮添加事件监听和处理操作
        stuLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == stuLoginButton) {
                    studentLogin();
                    jFrame.dispose();
                }
            }
        });
        // 为退出系统按钮添加时间监听和处理操作
        exitSystemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
    }

    /**
     * 管理员登录验证的方法
     */
    private void adminLogin() {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        // 设置窗体的布局为绝对布局
        jFrame.setLayout(null);
        // 实例化标签对象
        JLabel ad_uNameLabel = new JLabel("用户名");
        JLabel ad_pwdLabel = new JLabel("密码");
        JTextField ad_uNameField = new JTextField();
        JPasswordField ad_pwdField = new JPasswordField();
        JLabel tipLabel = new JLabel("管理员登录界面");
        JButton loginButton = new JButton("登录");
        JButton backButton = new JButton("返回");
        // 设置各组件在窗体的坐标和大小
        ad_uNameLabel.setBounds(20, 40, 100, 30);
        ad_pwdLabel.setBounds(20, 80, 100, 30);
        ad_uNameField.setBounds(120, 40, 120, 30);
        ad_pwdField.setBounds(120, 80, 120, 30);
        tipLabel.setBounds(100, 0, 100, 30);
        loginButton.setBounds(90, 120, 120, 30);
        backButton.setBounds(90, 160, 120, 30);
        // 将各组件放在窗体中
        jFrame.add(ad_uNameLabel);
        jFrame.add(ad_uNameField);
        jFrame.add(ad_pwdLabel);
        jFrame.add(ad_pwdField);
        jFrame.add(tipLabel);
        jFrame.add(loginButton);
        jFrame.add(backButton);
        // 设置窗体的大小和坐标
        jFrame.setSize(320, 350);
        jFrame.setLocation(500, 200);
        //让窗体可见
        jFrame.setVisible(true);
        // 为管理员登录按钮添加事件监听和处理操作
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
                        JOptionPane.showMessageDialog(loginButton, "用户名或密码错误");
                        ad_uNameField.setText("");
                        ad_pwdField.setText("");
                    }
                }
            }
        });
        // 为返回按钮添加事件监听和处理操作
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    showMainMenu();
                    jFrame.dispose();
                }
            }
        });
        // 为窗体添加事件监听和处理操作
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                showMainMenu();
            }
        });
    }

    /**
     * 教师登录验证的方法
     */
    private void teacherLogin() {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        // 设定窗体的布局为绝对布局
        jFrame.setLayout(null);
        JLabel tea_uNameLabel = new JLabel("用户名");
        JLabel tea_pwdLabel = new JLabel("密码");
        JTextField tea_uNameField = new JTextField();
        JPasswordField tea_pwdField = new JPasswordField();
        JLabel tipLabel = new JLabel("教师登录界面");
        JLabel promptLabel = new JLabel();
        JButton submitButton = new JButton("登录");
        JButton backButton = new JButton("返回");
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
                        if (teacherInfo.getTea_state().equals("正常")) {
                            teaMenuTest(teacherInfo.getTea_id());
                            jFrame.dispose();
                        } else if (teacherInfo.getTea_state().equals("停用")) {
                            JOptionPane.showMessageDialog(jFrame, "你的信息状态为停用状态，停止登录");
                            tea_uNameField.setText("");
                            tea_pwdField.setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(jFrame, "用户名或密码错误");
                        tea_uNameField.setText("");
                        tea_pwdField.setText("");
                    }
                }
            }
        });
        // 为窗体添加事件监听和处理操作
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                showMainMenu();
            }
        });
        // 为返回按钮添加事件监听和处理操作
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
     * 学生登录验证的方法
     */
    private void studentLogin() {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        jFrame.setLayout(null);
        JLabel stu_uNameLabel = new JLabel("用户名");
        JLabel stu_pwdLabel = new JLabel("密码");
        JTextField stu_uNameField = new JTextField();
        JPasswordField stu_pwdField = new JPasswordField();
        JLabel tipLabel = new JLabel("学生登录界面");
        JButton submitButton = new JButton("登录");
        JButton backButton = new JButton("返回");
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
        // 为登录按钮添加事件监听和处理操作
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submitButton) {
                    String stu_uName = stu_uNameField.getText();
                    String stu_pwd = new String(stu_pwdField.getPassword());
                    StudentService StudentService = new StudentServiceImpl();
                    StudentInfo studentInfo = StudentService.queryStuLogin(stu_uName, stu_pwd);
                    if (studentInfo.getStu_uName() != null) {
                        if (studentInfo.getStu_state().equals("正常")) {
                            stuMenuTest(studentInfo.getStu_id());
                            jFrame.dispose();
                        } else if (studentInfo.getStu_state().equals("停用")) {
                            JOptionPane.showMessageDialog(jFrame, "你的信息状态为停用状态，停止登录");
                            stu_uNameField.setText("");
                            stu_pwdField.setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(jFrame, "用户名或密码错误");
                        stu_uNameField.setText("");
                        stu_pwdField.setText("");
                    }
                }
            }
        });
        // 为返回按钮添加事件监听和处理操作
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    showMainMenu();
                    jFrame.dispose();
                }
            }
        });
        // 为窗体添加事件监听和处理操作
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                showMainMenu();
            }
        });
    }

    /**
     * 管理员登录后功能主页面的方法
     *
     * @param ad_id 管理员编号
     */
    private void adminMenuTest(int ad_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        // 设置窗体布局为绝对布局
        jFrame.setLayout(null);
        // 实例化标签对象
        JLabel adMenuLabel = new JLabel("管理员功能界面");
        JButton addInfoButton = new JButton("添加信息功能");
        JButton queryInfoButton = new JButton("查询信息功能");
        JButton updateInfoButton = new JButton("修改信息功能");
        JButton quitButton = new JButton("退出登录");
        // 设置各组件的在窗体的坐标和大小
        adMenuLabel.setBounds(100, 0, 200, 30);
        addInfoButton.setBounds(70, 40, 150, 30);
        queryInfoButton.setBounds(70, 80, 150, 30);
        updateInfoButton.setBounds(70, 120, 150, 30);
        quitButton.setBounds(70, 200, 150, 30);
        // 将各组件放在窗体中
        jFrame.add(adMenuLabel);
        jFrame.add(addInfoButton);
        jFrame.add(queryInfoButton);
        jFrame.add(updateInfoButton);
        jFrame.add(quitButton);
        // 设置窗体大小和坐标，并使窗体可见
        jFrame.setSize(320, 350);
        jFrame.setLocation(500, 200);
        jFrame.setVisible(true);
        // 为添加信息功能按钮添加事件监听和处理操作
        addInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addInfoButton) {
                    addAdminInfoFunction(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // 为查询信息功能按钮添加事件监听和处理操作
        queryInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == queryInfoButton) {
                    queryAdminInfoFunction(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // 为修改信息功能按钮添加事件监听和处理操作
        updateInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == updateInfoButton) {
                    updateAdminInfoFunction(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // 为退出登录按钮添加事件监听和处理操作
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == quitButton) {
                    showMainMenu();
                    jFrame.dispose();
                }
            }
        });
        // 为窗体添加事件监听和处理操作
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                showMainMenu();
            }
        });
    }

    /**
     * 管理员权限下添加信息功能主页面的方法
     *
     * @param ad_id 管理员编号
     */
    private void addAdminInfoFunction(int ad_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        // 设置窗体布局为绝对布局
        jFrame.setLayout(null);
        // 实例化标签对象
        JLabel addInfoLabel = new JLabel("添加信息功能界面");
        JButton addStuInfoButton = new JButton("添加学生信息");
        JButton addTeaInfoButton = new JButton("添加教师信息");
        JButton addCourseInfoButton = new JButton("添加课程信息");
        JButton backButton = new JButton("返回");
        // 设置各组件在窗体的坐标和大小
        addInfoLabel.setBounds(100, 0, 200, 30);
        addStuInfoButton.setBounds(70, 40, 150, 30);
        addTeaInfoButton.setBounds(70, 80, 150, 30);
        addCourseInfoButton.setBounds(70, 120, 150, 30);
        backButton.setBounds(70, 200, 150, 30);
        // 将各组件放在窗体中
        jFrame.add(addInfoLabel);
        jFrame.add(addStuInfoButton);
        jFrame.add(addTeaInfoButton);
        jFrame.add(addCourseInfoButton);
        jFrame.add(backButton);
        // 设置窗体大小和坐标并使窗体可见
        jFrame.setSize(320, 350);
        jFrame.setLocation(500, 200);
        jFrame.setVisible(true);
        // 为添加学生信息按钮添加事件监听和处理操作
        addStuInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addStuInfoButton) {
                    try {
                        addStuInfo(ad_id);
                        jFrame.dispose();
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(jFrame, "没有专业信息文件,无法添加学生信息");
                    }
                }
            }
        });
        // 为添加教师信息按钮添加事件监听和处理操作
        addTeaInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addTeaInfoButton) {
                    try {
                        addTeaInfo(ad_id);
                        jFrame.dispose();
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(jFrame, "没有专业信息文件,无法添加教师信息");
                    }
                }
            }
        });
        // 为添加课程信息按钮添加事件监听和处理操作
        addCourseInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addCourseInfoButton) {
                    try {
                        addCourseInfo(ad_id);
                        jFrame.dispose();
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(jFrame, "没有专业信息文件,无法添加课程信息");
                    }
                }
            }
        });
        // 为返回按钮添加事件监听和处理操作
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    adminMenuTest(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // 为窗体添加事件监听和处理操作
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                adminMenuTest(ad_id);
            }
        });
    }

    /**
     * 管理员权限下添加教师基本信息的方法
     *
     * @param ad_id 管理员编号
     */
    private void addTeaInfo(int ad_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        // 设置窗体布局为绝对布局
        jFrame.setLayout(null);
        // 实例化标签对象
        JLabel addTeaInfoLabel = new JLabel("添加教师基本信息");
        JLabel tea_uNameLabel = new JLabel("用户名");
        JLabel tea_pwdLabel = new JLabel("密码");
        JLabel tea_comfirmPwdLabel = new JLabel("确认密码");
        JLabel tea_nameLabel = new JLabel("姓名");
        JLabel tea_majorLabel = new JLabel("所授专业");
        JTextField tea_uNameField = new JTextField();
        JPasswordField tea_pwdField = new JPasswordField();
        JPasswordField tea_confirmPwdField = new JPasswordField();
        JTextField tea_nameField = new JTextField();
        JComboBox tea_majorBox = new JComboBox(majorNameFile());
        JButton submitButton = new JButton("添加");
        JButton backButton = new JButton("返回");
        // 设置登录按钮为禁用
        submitButton.setEnabled(false);
        TeacherService teacherService = new TeacherServiceImpl();
        List<TeacherInfo> teacherInfoList = teacherService.queryTeaInfoList();
        DefaultTableModel teaInfoModel = new DefaultTableModel();
        teaInfoModel.setColumnIdentifiers(new Object[]{"教师编号", "教师用户名", "教师密码", "教师姓名",
                "教师专业", "信息创建时间", "信息更新时间", "教师信息状态"});
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
        // 将各组件放在窗体中
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
        // 设置各组件在窗体的坐标和大小
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
        // 设置窗体大小和坐标并使窗体可见
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
        // 为添加按钮添加事件监听和处理操作
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
                            JOptionPane.showMessageDialog(jFrame, "添加教师信息成功");
                            addTeaInfo(ad_id);
                            jFrame.dispose();
                        } else {
                            JOptionPane.showMessageDialog(jFrame, "输入错误");
                            tea_uNameField.setText("");
                            tea_pwdField.setText("");
                            tea_nameField.setText("");
                            tea_confirmPwdField.setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(jFrame, "两次密码不一致，请重新输入");
                        tea_uNameField.setText("");
                        tea_confirmPwdField.setText("");
                        tea_pwdField.setText("");
                        tea_nameField.setText("");
                    }
                }
            }
        });
        // 为返回按钮添加事件监听和处理操作
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    addAdminInfoFunction(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // 为窗体添加事件监听和处理操作
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                addAdminInfoFunction(ad_id);
            }
        });
    }

    /**
     * 管理员权限下添加学生信息的方法
     *
     * @param ad_id 管理员编号
     */
    private void addStuInfo(int ad_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        // 为窗体布局为绝对布局
        jFrame.setLayout(null);
        // 实例化标签对象
        JLabel addStuInfoLabel = new JLabel("添加学生基本信息");
        JLabel stu_uNameLabel = new JLabel("用户名");
        JLabel stu_pwdLabel = new JLabel("密码");
        JLabel stu_comfirmPwdLabel = new JLabel("确认密码");
        JLabel stu_nameLabel = new JLabel("姓名");
        JLabel stu_sexLabel = new JLabel("性别");
        JLabel stu_ageLabel = new JLabel("年龄");
        JLabel stu_phoneLabel = new JLabel("电话");
        JLabel stu_majorLabel = new JLabel("专业");
        JTextField stu_uNameField = new JTextField();
        JPasswordField stu_pwdField = new JPasswordField();
        JPasswordField stu_comfirmPwdField = new JPasswordField();
        JTextField stu_nameField = new JTextField();
        JTextField stu_majorField = new JTextField();
        JComboBox stu_majorBox = new JComboBox(majorNameFile());
        JTextField stu_sexField = new JTextField();
        String[] sex = {"男", "女"};
        JComboBox stu_sexBox = new JComboBox(sex);
        JTextField stu_ageField = new JTextField();
        JTextField stu_phoneField = new JTextField();
        JButton addButton = new JButton("添加");
        JButton backButton = new JButton("返回上一级");
        // 设置添加按钮为禁用
        addButton.setEnabled(false);
        // 查询学生信息列表
        StudentService studentService = new StudentServiceImpl();
        List<StudentInfo> studentInfoList = studentService.queryStuInfoList();
        // 设置一个表控制模型，并添加数据
        DefaultTableModel stuInfoModel = new DefaultTableModel();
        stuInfoModel.setColumnIdentifiers(new Object[]{"学生编号", "学生用户名", "学生密码", "学生姓名", "学生性别",
                "学生年龄", "学生手机号", "学生专业", "信息创建时间", "信息更新时间", "学生信息状态"});
        for (StudentInfo studentInfo : studentInfoList) {
            Object[] rowData = {studentInfo.getStu_id(), studentInfo.getStu_uName(),
                    studentInfo.getStu_pwd(), studentInfo.getStu_name(), studentInfo.getStu_sex(),
                    studentInfo.getStu_age(), studentInfo.getStu_phone(), studentInfo.getStu_major(),
                    studentInfo.getStu_createDate(), studentInfo.getStu_updateDate(),
                    studentInfo.getStu_state()};
            stuInfoModel.addRow(rowData);
        }
        // 设置表格，将表控制模型放入表格中
        JTable stuInfoTable = new JTable(stuInfoModel);
        // 为表格默认自动滚动条
        stuInfoTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        // 设置滚动条组件，将表格放入其中
        JScrollPane stuJsc = new JScrollPane(stuInfoTable);
        // 将各组件放在窗体中
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
        // 设置各组件的坐标和大小
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
        // 设置窗体的坐标和大小，并使窗体可见
        jFrame.setSize(1000, 500);
        jFrame.setLocation(200, 100);
        jFrame.setVisible(true);
        // 为学生手机号输入框添加事件监听和处理操作
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
        // 为添加按钮添加事件监听和处理操作
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
                                JOptionPane.showMessageDialog(jFrame, "年龄或手机号输入错误");
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
                                    JOptionPane.showMessageDialog(jFrame, "添加学生信息成功");
                                    addStuInfo(ad_id);
                                    jFrame.dispose();
                                } else {
                                    JOptionPane.showMessageDialog(jFrame, "添加失败");
                                    stu_uNameField.setText("");
                                    stu_pwdField.setText("");
                                    stu_ageField.setText("");
                                    stu_phoneField.setText("");
                                    stu_sexField.setText("");
                                    stu_nameField.setText("");
                                }
                            }
                        } catch (Exception e1) {
                            JOptionPane.showMessageDialog(jFrame, "年龄输入错误");
                            stu_ageField.setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(jFrame, "密码输入不一致，请重新输入");
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
        // 为返回按钮添加事件监听和处理操作
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    addAdminInfoFunction(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // 为窗体添加事件监听和处理操作
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                addAdminInfoFunction(ad_id);
            }
        });
    }

    /**
     * 管理员权限下添加课程信息的方法
     *
     * @param ad_id 管理员编号
     */
    private void addCourseInfo(int ad_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        jFrame.setLayout(null);
        JLabel addCourseInfoLabel = new JLabel("添加课程信息");

        JLabel c_nameLabel = new JLabel("课程名称");
        JLabel c_creditLabel = new JLabel("课程学分");

        JComboBox c_nameBox = new JComboBox(courseNameFile());
        JComboBox c_creditBox = new JComboBox();
        for (int i = 1; i < 7; i++) {
            c_creditBox.addItem(i);
        }

        JButton submitButton = new JButton("添加");
        JButton backButton = new JButton("返回");

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
        courseInfoModel.setColumnIdentifiers(new Object[]{"课程编号", "课程名称", "课程学分", "课程创建时间",
                "课程更新时间", "课程状态"});
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
        // 为窗体设置大小和坐标并使窗体可见
        jFrame.setSize(1000, 500);
        jFrame.setLocation(200, 100);
        jFrame.setVisible(true);
        // 为添加按钮添加事件监听和处理操作
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
                            JOptionPane.showMessageDialog(jFrame, "添加课程信息成功");
                            addCourseInfo(ad_id);
                            jFrame.dispose();
                        } else {
                            JOptionPane.showMessageDialog(jFrame, "添加失败");
                            addCourseInfo(ad_id);
                            jFrame.dispose();
                        }
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(jFrame, "添加失败");
                        addCourseInfo(ad_id);
                        jFrame.dispose();
                    }
                }
            }
        });
        // 为返回按钮添加事件监听和处理操作
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    addAdminInfoFunction(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // 为窗体添加事件监听和处理操作
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                addAdminInfoFunction(ad_id);
            }
        });
    }

    /**
     * 管理员权限查询信息功能主页面的方法
     *
     * @param ad_id 管理员编号
     */
    private void queryAdminInfoFunction(int ad_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        jFrame.setLayout(null);
        JLabel queryInfoLabel = new JLabel("查询信息功能界面");
        JButton queryStuInfoButton = new JButton("查询学生信息列表");
        JButton queryTeaInfoButton = new JButton("查询教师信息列表");
        JButton queryCourseInfoButton = new JButton("查询课程信息列表");
        JButton backButton = new JButton("返回");

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
        // 为查询学生信息按钮添加事件监听和处理操作
        queryStuInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == queryStuInfoButton) {
                    queryStudentInfo(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // 为查询教师信息按钮添加事件监听和处理操作
        queryTeaInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == queryTeaInfoButton) {
                    queryTeacherInfo(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // 为查询课程信息按钮添加事件监听和处理操作
        queryCourseInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == queryCourseInfoButton) {
                    queryCourseInfo(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // 为返回按钮添加事件监听和处理操作
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    adminMenuTest(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // 为窗体添加事件监听和处理操作
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                adminMenuTest(ad_id);
            }
        });

    }

    /**
     * 管理员权限下查看教师信息列表的方法
     *
     * @param ad_id 管理员编号
     */
    private void queryTeacherInfo(int ad_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        jFrame.setLayout(null);
        JLabel teaInfoLabel = new JLabel("查询教师信息");
        JButton backButton = new JButton("返回");

        TeacherService teacherService = new TeacherServiceImpl();
        List<TeacherInfo> teacherInfoList = teacherService.queryTeaInfoList();
        // 设置一个表控制模型
        DefaultTableModel teaInfoModel = new DefaultTableModel();
        // 设置表的列名
        teaInfoModel.setColumnIdentifiers(new Object[]{"教师编号", "教师用户名", "教师密码", "教师姓名",
                "教师专业", "信息创建时间", "信息更新时间", "教师信息状态"});
        for (TeacherInfo teacherInfo : teacherInfoList) {
            Object[] rowData = {teacherInfo.getTea_id(), teacherInfo.getTea_uName(),
                    teacherInfo.getTea_pwd(), teacherInfo.getTea_name(),
                    teacherInfo.getTea_major(), teacherInfo.getTea_createDate(),
                    teacherInfo.getTea_updateDate(), teacherInfo.getTea_state()};
            teaInfoModel.addRow(rowData);
        }
        // 设置表格，将表控制模型放入到表格中
        JTable teaInfoTable = new JTable(teaInfoModel);
        // 为表格设置默认滚动条
        teaInfoTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        // 设置滚动条组件，将表格放入其中
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
        // 为返回按钮添加事件监听和处理操作
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    queryAdminInfoFunction(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // 为窗体添加事件监听和处理操作
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                queryAdminInfoFunction(ad_id);
            }
        });
    }

    /**
     * 管理员权限下查看学生信息列表的方法
     *
     * @param ad_id 管理员编号
     */
    private void queryStudentInfo(int ad_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        jFrame.setLayout(null);
        JLabel stuInfoLabel = new JLabel("查询学生信息");
        JButton backButton = new JButton("返回");

        StudentService studentService = new StudentServiceImpl();
        List<StudentInfo> studentInfoList = studentService.queryStuInfoList();
        // 设置一个表控制模型，并添加数据
        DefaultTableModel stuModel = new DefaultTableModel();
        // 设置表的列名
        stuModel.setColumnIdentifiers(new Object[]{"学生编号", "学生用户名", "学生密码", "学生姓名", "学生性别",
                "学生年龄", "学生手机号", "学生专业", "信息创建时间", "信息更新时间", "学生信息状态"});
        for (StudentInfo studentInfo : studentInfoList) {
            Object[] rowData = {studentInfo.getStu_id(), studentInfo.getStu_uName(),
                    studentInfo.getStu_pwd(), studentInfo.getStu_name(), studentInfo.getStu_sex(),
                    studentInfo.getStu_age(), studentInfo.getStu_phone(), studentInfo.getStu_major(),
                    studentInfo.getStu_createDate(), studentInfo.getStu_updateDate(),
                    studentInfo.getStu_state()};
            stuModel.addRow(rowData);
        }
        // 设置表格，将表控制模型放入到表格中
        JTable stuTable = new JTable(stuModel);
        // 为表格默认自动滚动条
        stuTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        // 设置滚动条组件，将表格放入其中
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
        // 为返回按钮添加事件监听和处理操作
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    queryAdminInfoFunction(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // 为窗体添加事件监听和处理操作
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                queryAdminInfoFunction(ad_id);
            }
        });
    }

    /**
     * 管理员权限下查询课程基本信息的方法
     *
     * @param ad_id 管理员编号
     */
    private void queryCourseInfo(int ad_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        jFrame.setLayout(null);

        JLabel courseInfoLabel = new JLabel("查询课程信息");
        JButton backButton = new JButton("返回");

        CourseService courseService = new CourseServiceImpl();
        List<CourseInfo> courseInfoList = courseService.queryCourInfoList();
        // 设置一个表控制模型
        DefaultTableModel courseModel = new DefaultTableModel();
        // 设置列名
        courseModel.setColumnIdentifiers(new Object[]{"课程编号", "课程名称", "课程学分", "课程创建时间",
                "课程更新时间", "课程状态"});
        for (CourseInfo courseInfo : courseInfoList) {
            Object[] rowData = {courseInfo.getC_id(), courseInfo.getC_name(), courseInfo.getC_credit(),
                    courseInfo.getC_createDate(), courseInfo.getC_updateDate(), courseInfo.getC_state()};
            courseModel.addRow(rowData);
        }
        // 设置表格，将表控制模型放入其中
        JTable courseTable = new JTable(courseModel);
        // 为表格设置默认滚动条
        courseTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        // 设置滚动条组件，将表格放入其中
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
        // 为返回按钮添加事件监听和处理操作
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    queryAdminInfoFunction(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // 为窗体添加事件监听和处理操作
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                queryAdminInfoFunction(ad_id);
            }
        });
    }

    /**
     * 管理员权限下修改信息功能页面的方法
     *
     * @param ad_id 管理员编号
     */
    private void updateAdminInfoFunction(int ad_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        jFrame.setLayout(null);
        JLabel updateInfoLabel = new JLabel("修改信息功能界面");
        JButton updateCourseInfoButton = new JButton("修改课程学分");
        JButton updateTeaStateButton = new JButton("修改教师信息状态");
        JButton updateStuStateButton = new JButton("修改学生信息状态");
        JButton updateCourseStateButton = new JButton("修改课程信息状态");
        JButton backButton = new JButton("返回");

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
        // 为修改课程信息按钮添加事件监听和处理操作
        updateCourseInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == updateCourseInfoButton) {
                    updateCourseInfo(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // 为修改教师状态添加事件监听和处理操作
        updateTeaStateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == updateTeaStateButton) {
                    updateTeaStateInfo(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // 为修改学生状态添加事件监听和处理操作
        updateStuStateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == updateStuStateButton) {
                    updateStuStateInfo(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // 为修改课程信息状态按钮添加事件监听和处理操作
        updateCourseStateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == updateCourseStateButton) {
                    updateCourStateInfo(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // 为返回按钮添加事件监听和处理操作
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    adminMenuTest(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // 为窗体添加事件监听和处理操作
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                adminMenuTest(ad_id);
            }
        });
    }

    /**
     * 管理员权限下修改课程状态的方法
     *
     * @param ad_id 管理员编号
     */
    private void updateCourStateInfo(int ad_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        jFrame.setLayout(null);

        JLabel updateCourseInfoLabel = new JLabel("修改课程信息");

        JLabel c_idLabel = new JLabel("课程编号");

        JComboBox c_idBox = new JComboBox();

        JLabel c_stateLabel = new JLabel("课程状态");
        String c_state[] = {"可使用", "已停用"};

        JComboBox c_stateBox = new JComboBox(c_state);

        jFrame.add(c_stateBox);
        jFrame.add(c_idBox);
        jFrame.add(c_idLabel);
        jFrame.add(c_stateLabel);

        jFrame.add(updateCourseInfoLabel);

        JButton submitButton = new JButton("修改");
        JButton backButton = new JButton("返回");

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
                "课程编号", "课程名称", "课程学分", "课程创建时间", "课程更新时间", "课程状态"});
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
            JOptionPane.showMessageDialog(jFrame, "没有可修改的数据");
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
                        JOptionPane.showMessageDialog(jFrame, "修改成功");
                        updateCourStateInfo(ad_id);
                        jFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(jFrame, "修改失败");
                        updateCourStateInfo(ad_id);
                        jFrame.dispose();
                    }
                }
            }
        });
        // 为返回按钮添加事件监听和处理操作
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    updateAdminInfoFunction(ad_id);
                    jFrame.dispose();
                }
            }
        });
        // 为窗体添加事件监听和处理操作
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                updateAdminInfoFunction(ad_id);
            }
        });
    }

    /**
     * 管理员权限下修改课程学分的方法
     *
     * @param ad_id 管理员编号
     */
    private void updateCourseInfo(int ad_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        jFrame.setLayout(null);

        JLabel updateCourseInfoLabel = new JLabel("修改课程信息");

        JLabel c_idLabel = new JLabel("课程编号");

        JComboBox c_idBox = new JComboBox();

        JLabel c_creditLabel = new JLabel("课程学分");

        JComboBox c_creditBox = new JComboBox();
        for (int i = 1; i < 7; i++) {
            c_creditBox.addItem(i);
        }

        jFrame.add(c_creditBox);
        jFrame.add(c_idBox);

        jFrame.add(c_idLabel);
        jFrame.add(c_creditLabel);

        jFrame.add(updateCourseInfoLabel);

        JButton submitButton = new JButton("修改");
        JButton backButton = new JButton("返回");

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
                "课程编号", "课程名称", "课程学分", "课程创建时间", "课程更新时间", "课程状态"});
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
            JOptionPane.showMessageDialog(jFrame, "没有可修改的数据");
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
                        JOptionPane.showMessageDialog(jFrame, "修改成功");
                        updateCourseInfo(ad_id);
                        jFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(jFrame, "修改失败");
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
     * 管理员权限下修改学生信息状态的方法
     *
     * @param ad_id 管理员编号
     */
    private void updateStuStateInfo(int ad_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        // 设置窗体布局为绝对布局
        jFrame.setLayout(null);
        // 实例化标签对象
        JLabel updateTeaInfoLabel = new JLabel("修改学生信息状态");
        JLabel stu_stateLabel = new JLabel("学生状态");
        JLabel stu_idLabel = new JLabel("学生编号");
        String state[] = {"正常", "停用"};
        JComboBox stu_stateBox = new JComboBox(state);
        JComboBox stu_idBox = new JComboBox();
        JButton submitButton = new JButton("修改");
        JButton backButton = new JButton("返回");

        StudentService studentService = new StudentServiceImpl();
        List<StudentInfo> studentInfoList = studentService.queryStuInfoList();
        DefaultTableModel stuModel = new DefaultTableModel();
        // 设置列名
        stuModel.setColumnIdentifiers(new Object[]{"学生编号", "学生用户名", "学生密码", "学生姓名",
                "学生性别", "学生年龄", "学生电话", "学生专业", "信息创建时间", "信息更新时间", "学生信息状态"});
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
            JOptionPane.showMessageDialog(jFrame, "没有可修改的数据");
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
                        JOptionPane.showMessageDialog(jFrame, "修改成功");
                        updateStuStateInfo(ad_id);
                        jFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(jFrame, "修改失败");
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
     * 管理员权限下修改教师信息状态的方法
     *
     * @param ad_id 管理员编号
     */
    private void updateTeaStateInfo(int ad_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        jFrame.setLayout(null);
        JLabel updateTeaInfoLabel = new JLabel("修改教师信息状态");

        JLabel tea_stateLabel = new JLabel("教师状态");
        JLabel tea_idLabel = new JLabel("教师编号");

        String state[] = {"正常", "停用"};
        JComboBox tea_stateBox = new JComboBox(state);
        JComboBox tea_idBox = new JComboBox();

        jFrame.add(updateTeaInfoLabel);
        jFrame.add(tea_stateLabel);
        jFrame.add(tea_stateBox);
        jFrame.add(tea_idBox);
        jFrame.add(tea_idLabel);

        JButton submitButton = new JButton("修改");
        JButton backButton = new JButton("返回");

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

        teaModel.setColumnIdentifiers(new Object[]{"教师编号", "教师用户名", "教师密码", "教师姓名", "教师专业",
                "信息创建时间", "信息更新时间", "教师信息状态"});
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
            JOptionPane.showMessageDialog(jFrame, "没有可修改的数据");
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
                        JOptionPane.showMessageDialog(jFrame, "修改成功");
                        updateTeaStateInfo(ad_id);
                        jFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(jFrame, "修改失败");
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
     * 教师登录后功能主页面的方法
     *
     * @param tea_id 教师编号
     */
    private void teaMenuTest(int tea_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        jFrame.setLayout(null);
        JLabel TeaMenuLabel = new JLabel("教师功能界面");
        JButton addInfoButton = new JButton("添加信息功能");
        JButton queryInfoButton = new JButton("查询信息功能");
        JButton updateInfoButton = new JButton("修改信息功能");
        JButton delInfoButton = new JButton("删除信息功能");
        JButton quitButton = new JButton("退出登录");

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
     * 教师权限下添加信息功能页面的方法
     *
     * @param tea_id 教师登录后编号
     */
    private void addTeaInfoFunction(int tea_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        jFrame.setLayout(null);
        JLabel TeaMenuLabel = new JLabel("添加信息功能界面");
        JButton addStuResultInfoButton = new JButton("添加成绩信息");
        JButton backButton = new JButton("返回上一级");

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
                    if (teacherInfo.getTea_state().equals("停用")) {
                        JOptionPane.showMessageDialog(jFrame, "对不起，你的信息状态处于停用状态，无法添加你的成绩信息");
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
     * 教师权限下添加成绩信息功能的方法
     *
     * @param tea_id 教师编号
     */
    private void addStudentResultInfo(int tea_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        jFrame.setLayout(null);
        JLabel addStuResInfoLabel = new JLabel("添加学生成绩信息");

        JLabel stu_idLabel = new JLabel("学生编号");
        JLabel c_idLabel = new JLabel("课程编号");
        JLabel stu_resultLabel = new JLabel("学生成绩");

        JComboBox stu_idBox = new JComboBox();
        JComboBox c_idBox = new JComboBox();
        JTextField stu_resultField = new JTextField();

        JButton submitButton = new JButton("添加");
        JButton backButton = new JButton("返回");

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
        stuInfoModel.setColumnIdentifiers(new Object[]{"学生编号", "学生姓名", "学生专业", "信息创建时间",
                "信息更新时间", "学生信息状态"});
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

        String c_state = "可使用";
        CourseService courseService = new CourseServiceImpl();
        List<CourseInfo> courseInfoList = courseService.queryTeaCourInfoList(c_state);
        DefaultTableModel courseInfoModel = new DefaultTableModel();
        courseInfoModel.setColumnIdentifiers(new Object[]{
                "课程编号", "课程名称", "课程学分", "课程创建时间", "课程更新时间"});
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
        stuResModel.setColumnIdentifiers(new Object[]{"成绩编号", "学生姓名", "课程名称", "考试成绩", "成绩创建时间",
                "成绩更新时间", "课程所授教师姓名"});
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
                            JOptionPane.showMessageDialog(jFrame, "添加失败");
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
                                JOptionPane.showMessageDialog(jFrame, "添加成绩信息成功");
                                addStudentResultInfo(tea_id);
                                jFrame.dispose();
                            } else {
                                JOptionPane.showMessageDialog(jFrame, "添加失败");
                                addStudentResultInfo(tea_id);
                                jFrame.dispose();
                            }
                        }
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(jFrame, "无法添加");
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
     * 教师权限下查询信息功能的方法
     *
     * @param tea_id 教师登录后编号
     */
    private void queryTeaInfoFunction(int tea_id) {
        Frame jFrame = new JFrame("学生教学信息管理系统");
        jFrame.setLayout(null);
        JLabel queryInfoLabel = new JLabel("查询信息功能界面");
        JButton queryStuResultInfoButton = new JButton("查询成绩信息");
        JButton queryTeaInfoButton = new JButton("查询个人信息");
        JButton queryCourseInfoButton = new JButton("查询课程信息");
        JButton backButton = new JButton("返回上一级");

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
     * 教师权限下查询成绩信息的方法
     *
     * @param tea_id 教师编号
     */
    private void queryTeaResultInfo(int tea_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        jFrame.setLayout(null);
        JLabel queryLabel = new JLabel("查询成绩信息");
        JButton backButton = new JButton("返回");
        DefaultTableModel stuResModel = new DefaultTableModel();
        ResultCourseService resultCourseService = new ResultCourseServiceImpl();
        List<ResultCourseInfo> resultCourseInfoList = resultCourseService.queryStuResultInfoList(tea_id);
        stuResModel.setColumnIdentifiers(new Object[]{"成绩编号", "学生姓名", "课程名称", "考试成绩", "创建时间",
                "更新时间", "课程所授教师姓名"});
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
     * 教师权限下查询本人信息的方法
     *
     * @param tea_id 教师编号
     */
    private void queryTeaBasicInfo(int tea_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        jFrame.setLayout(null);
        JLabel queryLabel = new JLabel("查询个人信息");
        JButton backButton = new JButton("返回");

        TeacherService teacherService = new TeacherServiceImpl();
        TeacherInfo teacherInfo = teacherService.queryTeaInfo(tea_id);
        DefaultTableModel teaModel = new DefaultTableModel();
        teaModel.setColumnIdentifiers(new Object[]{"教师编号", "教师用户名", "教师密码", "教师姓名",
                "教师专业", "信息创建时间", "信息更新时间", "教师信息状态"});
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
     * 教师权限下查询课程信息
     *
     * @param tea_id 教师编号
     */
    private void queryTeaCourseInfo(int tea_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        jFrame.setLayout(null);

        JLabel courseInfoLabel = new JLabel("查询课程信息");
        JButton backButton = new JButton("返回");
        String c_state = "可使用";
        CourseService courseService = new CourseServiceImpl();
        List<CourseInfo> courseInfoList = courseService.queryTeaCourInfoList(c_state);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"课程编号", "课程名称", "课程学分", "课程创建时间",
                "课程更新时间"});
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
     * 教师权限下修改信息功能的方法
     *
     * @param tea_id 教师编号
     */
    private void updateTeaInfoFunction(int tea_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        jFrame.setLayout(null);
        JLabel updateInfoLabel = new JLabel("修改信息功能界面");
        JButton updateStuResultInfoButton = new JButton("修改成绩信息");
        JButton updateTeaInfoButton = new JButton("修改个人信息");
        JButton backButton = new JButton("返回上一级");

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
                    if (teacherInfo.getTea_state().equals("停用")) {
                        JOptionPane.showMessageDialog(jFrame, "对不起，你的信息状态处于停用状态，无法修改你的成绩信息");
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
                        if (teacherInfo.getTea_state().equals("停用")) {
                            JOptionPane.showMessageDialog(jFrame, "对不起，你的信息状态处于停用状态，无法修改你的成绩信息");
                        } else {
                            updateTeaInfo(tea_id);
                            jFrame.dispose();
                        }
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(jFrame, "没有专业信息文件,无法修改本人信息");
                    }
                }
            }
        });
        // 为返回按钮添加事件监听和处理操作
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    teaMenuTest(tea_id);
                    jFrame.dispose();
                }
            }
        });
        // 为窗体添加事件监听和处理操作
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                teaMenuTest(tea_id);
            }
        });
    }

    /**
     * 教师权限下修改成绩信息的方法
     *
     * @param tea_id 教师编号
     */
    private void updateStudentResultInfo(int tea_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        jFrame.setLayout(null);

        JLabel updateStuResultInfoLabel = new JLabel("修改成绩信息");

        JLabel sr_idLabel = new JLabel("成绩编号");

        JComboBox sr_idBox = new JComboBox();

        JLabel sr_resultLabel = new JLabel("考试成绩");

        JTextField sr_resultField = new JTextField();

        jFrame.add(sr_resultField);
        jFrame.add(sr_idBox);

        jFrame.add(sr_idLabel);
        jFrame.add(sr_resultLabel);

        jFrame.add(updateStuResultInfoLabel);

        JButton submitButton = new JButton("修改");
        JButton backButton = new JButton("返回");


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
        stuResModel.setColumnIdentifiers(new Object[]{"成绩编号", "学生姓名", "课程名称", "考试成绩",
                "信息创建时间", "信息更新时间", "课程所授教师姓名"});
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
            JOptionPane.showMessageDialog(jFrame, "没有可修改的数据");
            updateStudentResultInfo(tea_id);
            jFrame.dispose();
        }

        // 为修改按钮添加事件监听和处理操作
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
                            JOptionPane.showMessageDialog(jFrame, "成绩输入错误,请重新输入");
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
                                JOptionPane.showMessageDialog(jFrame, "修改成功");
                                updateStudentResultInfo(tea_id);
                                jFrame.dispose();
                            } else {
                                JOptionPane.showMessageDialog(jFrame, "修改失败");
                                updateStudentResultInfo(tea_id);
                                jFrame.dispose();
                            }
                        }
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(jFrame, "成绩输入错误,请重新输入");
                        updateStudentResultInfo(tea_id);
                        jFrame.dispose();
                    }
                }
            }
        });
        // 为返回按钮添加事件监听和处理操作
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    updateTeaInfoFunction(tea_id);
                    jFrame.dispose();
                }
            }
        });
        // 为窗体按钮添加事件监听和处理操作
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                updateTeaInfoFunction(tea_id);
            }
        });
    }

    /**
     * 教师权限下修改个人信息的方法
     *
     * @param tea_id 教师编号
     */
    private void updateTeaInfo(int tea_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        jFrame.setLayout(null);
        JLabel updateTeaInfoLabel = new JLabel("修改个人信息");

        JLabel tea_majorLabel = new JLabel("所授专业");

        JComboBox tea_majorBox = new JComboBox(majorNameFile());

        jFrame.add(tea_majorBox);

        jFrame.add(tea_majorLabel);

        JButton submitButton = new JButton("修改");
        JButton backButton = new JButton("返回");

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
        teaModel.setColumnIdentifiers(new Object[]{"教师编号", "教师用户名", "教师密码", "教师姓名", "教师所授专业",
                "信息创建时间", "信息更新时间", "教师信息状态"});
        Object[] rowData = {teacherInfo.getTea_id(), teacherInfo.getTea_uName(), teacherInfo.getTea_pwd(),
                teacherInfo.getTea_name(), teacherInfo.getTea_major(), teacherInfo.getTea_createDate(),
                teacherInfo.getTea_updateDate(), teacherInfo.getTea_state()};
        teaModel.addRow(rowData);

        JTable teaTable = new JTable(teaModel);
        JScrollPane teaJsc = new JScrollPane(teaTable);
        jFrame.add(teaJsc);

        teaJsc.setBounds(300, 40, 450, 180);
        teaTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        // 为修改按钮添加事件监听和处理操作
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
                        JOptionPane.showMessageDialog(jFrame, "修改成功");
                        updateTeaInfo(tea_id);
                        jFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(jFrame, "修改失败");
                        updateTeaInfo(tea_id);
                        jFrame.dispose();
                    }
                }
            }
        });
        // 为返回按钮添加事件监听和处理操作
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    updateTeaInfoFunction(tea_id);
                    jFrame.dispose();
                }
            }
        });
        // 为窗体添加事件监听和处理操作
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                updateTeaInfoFunction(tea_id);
            }
        });
    }

    /**
     * 教师权限下删除功能页面的方法
     *
     * @param tea_id 登录后教师的编号
     */
    private void delTeaInfoFunction(int tea_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        jFrame.setLayout(null);
        JLabel updateInfoLabel = new JLabel("删除信息功能界面");
        JButton delStuResultInfoButton = new JButton("删除成绩信息");
        JButton backButton = new JButton("返回上一级");

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
        // 为删除成绩信息按钮添加事件监听和处理操作
        delStuResultInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == delStuResultInfoButton) {
                    if (teacherInfo.getTea_state().equals("停用")) {
                        JOptionPane.showMessageDialog(jFrame, "对不起，你的信息状态为停用状态，无法删除成绩信息");
                    } else {
                        delStudentResultInfoFunction(tea_id);
                        jFrame.dispose();
                    }
                }
            }
        });
        // 为返回按钮添加事件监听和处理操作
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    teaMenuTest(tea_id);
                    jFrame.dispose();
                }
            }
        });
        // 为窗体按钮添加事件监听和处理操作
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                teaMenuTest(tea_id);
            }
        });
    }

    /**
     * 教师权限下删除成绩信息页面的方法
     *
     * @param tea_id 教师编号
     */
    private void delStudentResultInfoFunction(int tea_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        // 设置窗体布局为绝对布局
        jFrame.setLayout(null);
        // 实例化标签对象
        JLabel delStuResultInfoLabel = new JLabel("删除成绩信息");
        JLabel sr_idLabel = new JLabel("成绩编号");
        JComboBox sr_idBox = new JComboBox();
        JButton submitButton = new JButton("删除");
        JButton backButton = new JButton("返回");

        ResultCourseService resultCourseService = new ResultCourseServiceImpl();
        DefaultTableModel stuResModel = new DefaultTableModel();
        List<ResultCourseInfo> resultCourseInfoList = resultCourseService.queryStuResultInfoList(tea_id);
        stuResModel.setColumnIdentifiers(new Object[]{"成绩编号", "学生姓名", "课程名称", "考试成绩", "成绩创建时间",
                "成绩更新时间", "课程所授教师姓名"});
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
        // 设置各组件的坐标和大小
        delStuResultInfoLabel.setBounds(300, 0, 200, 30);
        sr_idLabel.setBounds(20, 40, 100, 30);
        sr_idBox.setBounds(120, 40, 120, 30);
        submitButton.setBounds(70, 200, 150, 30);
        backButton.setBounds(70, 240, 150, 30);
        stuResJsc.setBounds(300, 40, 450, 240);
        // 为窗体设置坐标，大小并使窗体可见
        jFrame.setSize(800, 350);
        jFrame.setLocation(300, 200);
        jFrame.setVisible(true);

        if (sr_idBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(jFrame, "没有可删除的数据");
            delTeaInfoFunction(tea_id);
            jFrame.dispose();
        }
        // 为删除按钮添加事件监听和处理操作
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submitButton) {
                    int sr_id = (Integer) sr_idBox.getSelectedItem();
                    StudentResultService studentResultService = new StudentResultServiceImpl();
                    int rows = studentResultService.delStudentResultInfo(sr_id, tea_id);
                    if (rows == 1) {
                        JOptionPane.showMessageDialog(jFrame, "删除成功");
                        delStudentResultInfoFunction(tea_id);
                        jFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(jFrame, "删除失败");
                        delStudentResultInfoFunction(tea_id);
                        jFrame.dispose();
                    }
                }
            }
        });
        // 为返回按钮添加事件监听和处理操作
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    delTeaInfoFunction(tea_id);
                    jFrame.dispose();
                }
            }
        });
        // 为窗体添加事件监听和处理操作
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                delTeaInfoFunction(tea_id);
            }
        });
    }

    /**
     * 学生信息功能页面的方法
     *
     * @param stu_id 学生编号
     */
    private void stuMenuTest(int stu_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        jFrame.setLayout(null);
        JLabel adMenuLabel = new JLabel("学生功能界面");
        JButton queryInfoButton = new JButton("查询信息功能");
        JButton updateInfoButton = new JButton("修改信息功能");
        JButton quitButton = new JButton("退出登录");

        adMenuLabel.setBounds(100, 0, 200, 30);
        queryInfoButton.setBounds(70, 40, 150, 30);
        updateInfoButton.setBounds(70, 80, 150, 30);

        quitButton.setBounds(70, 200, 150, 30);

        jFrame.add(adMenuLabel);
        jFrame.add(queryInfoButton);
        jFrame.add(updateInfoButton);
        jFrame.add(quitButton);
        // 为窗体设置坐标，大小并使窗体可见
        jFrame.setSize(320, 350);
        jFrame.setLocation(500, 200);
        jFrame.setVisible(true);
        // 为查询信息按钮添加事件监听和处理操作
        queryInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == queryInfoButton) {
                    queryStuInfoFunction(stu_id);
                    jFrame.dispose();
                }
            }
        });
        // 为修改信息按钮添加事件监听和处理操作
        updateInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == updateInfoButton) {
                    updateStuInfoFunction(stu_id);
                    jFrame.dispose();
                }
            }
        });
        // 为退出登录按钮添加事件监听和处理操作
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == quitButton) {
                    showMainMenu();
                    jFrame.dispose();
                }
            }
        });
        // 为窗体添加事件监听和处理操作
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                showMainMenu();
            }
        });
    }

    /**
     * 学生权限下查询信息功能的方法
     *
     * @param stu_id 学生编号
     */
    private void queryStuInfoFunction(int stu_id) {
        Frame jFrame = new JFrame("学生教学信息管理系统");
        jFrame.setLayout(null);
        JLabel queryInfoLabel = new JLabel("查询信息功能界面");
        JButton queryStuResultInfoButton = new JButton("查询成绩信息");
        JButton queryTeaInfoButton = new JButton("查询个人信息");
        JButton backButton = new JButton("返回上一级");

        queryInfoLabel.setBounds(100, 0, 200, 30);
        queryStuResultInfoButton.setBounds(70, 40, 150, 30);
        queryTeaInfoButton.setBounds(70, 80, 150, 30);

        backButton.setBounds(70, 200, 150, 30);

        jFrame.add(queryInfoLabel);
        jFrame.add(queryStuResultInfoButton);
        jFrame.add(queryTeaInfoButton);
        jFrame.add(backButton);
        // 为窗体设置坐标，大小并使窗体可见
        jFrame.setSize(320, 350);
        jFrame.setLocation(500, 200);
        jFrame.setVisible(true);
        // 为查询成绩信息按钮添加事件监听和处理操作
        queryStuResultInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == queryStuResultInfoButton) {
                    queryStuResultInfo(stu_id);
                    jFrame.dispose();
                }
            }
        });
        // 为查询个人信息按钮添加事件监听和处理操作
        queryTeaInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == queryTeaInfoButton) {
                    queryStuInfo(stu_id);
                    jFrame.dispose();
                }
            }
        });
        // 为返回按钮添加事件监听和处理操作
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    stuMenuTest(stu_id);
                    jFrame.dispose();
                }
            }
        });
        // 为窗体添加事件监听和处理操作
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                stuMenuTest(stu_id);
            }
        });
    }

    /**
     * 学生权限下查询个人信息功能的方法
     *
     * @param stu_id 学生编号
     */
    private void queryStuInfo(int stu_id) {
        JFrame jFrame = new JFrame("学生成绩信息管理系统");
        jFrame.setLayout(null);
        JButton backButton = new JButton("返回");
        JLabel queryLabel = new JLabel("查询个人信息");

        StudentService studentService = new StudentServiceImpl();
        StudentInfo studentInfo = studentService.queryStuInfo(stu_id);
        DefaultTableModel stuModel = new DefaultTableModel();
        stuModel.setColumnIdentifiers(new Object[]{"学生编号", "学生用户名", "学生密码", "学生姓名", "学生性别",
                "学生年龄", "学生手机号", "学生专业", "信息创建时间", "信息更新时间", "学生信息状态"});
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
        // 为窗体设置坐标，大小并使窗体可见
        jFrame.setSize(500, 300);
        jFrame.setLocation(400, 200);
        jFrame.setVisible(true);
        jFrame.add(stuJsc);
        // 为返回按钮添加事件监听和处理操作
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
     * 学生权限下查询成绩功能的方法
     *
     * @param stu_id 学生编号
     */
    private void queryStuResultInfo(int stu_id) {
        JFrame jFrame = new JFrame("学生成绩信息管理系统");
        jFrame.setLayout(null);
        JButton backButton = new JButton("返回");
        JLabel queryLabel = new JLabel("查询成绩信息");
        ResultCourseService resultCourseService = new ResultCourseServiceImpl();
        List<ResultCourseInfo> resultCourseInfoList = resultCourseService.queryStudentResultInfoList(stu_id);
        DefaultTableModel stuResModel = new DefaultTableModel();
        stuResModel.setColumnIdentifiers(new Object[]{"成绩编号", "学生姓名", "课程名称", "考试成绩", "信息创建时间",
                "信息更新时间", "课程所授教师姓名"});
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
        // 为窗体设置坐标，大小并使窗体可见
        jFrame.setSize(500, 300);
        jFrame.setLocation(400, 200);
        jFrame.setVisible(true);
        // 为返回按钮添加事件监听和处理操作
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    queryStuInfoFunction(stu_id);
                    jFrame.dispose();
                }
            }
        });
        // 为窗体添加事件监听和处理操作
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                queryStuInfoFunction(stu_id);
            }
        });
    }

    /**
     * 学生权限下修改信息功能的方法
     *
     * @param stu_id 学生编号
     */
    private void updateStuInfoFunction(int stu_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        jFrame.setLayout(null);
        JLabel updateInfoLabel = new JLabel("修改信息功能界面");
        JButton updateStuInfoButton = new JButton("修改个人信息");
        JButton backButton = new JButton("返回");
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
        // 为修改个人信息按钮添加事件监听和处理操作
        updateStuInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == updateStuInfoButton) {
                    try {
                        if (studentInfo.getStu_state().equals("停用")) {
                            JOptionPane.showMessageDialog(jFrame, "对不起，你的信息状态为停用状态，无法修改你的个人信息");
                        } else {
                            updateStuInfo(stu_id);
                            jFrame.dispose();
                        }
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(jFrame, "没有专业信息文件,无法修改本人信息");
                    }
                }
            }
        });
        // 为返回按钮添加事件监听和处理操作
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    stuMenuTest(stu_id);
                    jFrame.dispose();
                }
            }
        });
        // 为窗体添加事件监听和处理操作
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                stuMenuTest(stu_id);
            }
        });
    }

    /**
     * 学生权限下修改个人信息功能的方法
     *
     * @param stu_id 学生编号
     */
    private void updateStuInfo(int stu_id) {
        JFrame jFrame = new JFrame("学生教学信息管理系统");
        // 设置窗体布局为绝对布局
        jFrame.setLayout(null);
        // 实例化标签对象
        JLabel queryStuInfoLabel = new JLabel("修改个人信息");
        JLabel stu_ageLabel = new JLabel("年龄");
        JLabel stu_phoneLabel = new JLabel("手机号");
        JLabel stu_majorLabel = new JLabel("专业");
        JComboBox stu_majorBox = new JComboBox(majorNameFile());
        JTextField stu_ageField = new JTextField();
        JTextField stu_phoneField = new JTextField();
        JButton submitButton = new JButton("修改");
        JButton backButton = new JButton("返回");

        StudentService studentService = new StudentServiceImpl();
        StudentInfo studentInfo = studentService.queryStuInfo(stu_id);
        DefaultTableModel stuModel = new DefaultTableModel();
        stuModel.setColumnIdentifiers(new Object[]{"学生编号", "学生用户名", "学生密码", "学生姓名", "学生性别",
                "学生年龄", "学生手机号", "学生专业", "信息创建时间", "信息更新时间", "学生信息状态"});
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

        // 为窗体设置坐标，大小并使窗体可见
        jFrame.setSize(800, 280);
        jFrame.setLocation(300, 200);
        jFrame.setVisible(true);
        // 为修改按钮添加事件监听和处理操作
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
                            JOptionPane.showMessageDialog(jFrame, "年龄或手机号输入错误");
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
                                JOptionPane.showMessageDialog(jFrame, "修改个人信息成功");
                                updateStuInfo(stu_id);
                                jFrame.dispose();
                            } else {
                                JOptionPane.showMessageDialog(jFrame, "修改失败");
                                stu_ageField.setText("");
                                stu_phoneField.setText("");
                            }
                        }
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(jFrame, "年龄输入错误");
                        stu_ageField.setText("");
                    }
                }
            }
        });
        // 为返回按钮添加事件监听和处理操作
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    updateStuInfoFunction(stu_id);
                    jFrame.dispose();
                }
            }
        });
        // 为窗体添加事件监听和处理操作
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                updateStuInfoFunction(stu_id);
            }
        });
    }

    /**
     * 读取专业名称信息文件
     *
     * @return 专业名称数组
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
     * 读取课程名称信息文件
     *
     * @return 课程名称数组
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
     * 获取当前系统时间
     *
     * @return 当前系统时间
     */
    private String currentTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return simpleDateFormat.format(date);
    }
}