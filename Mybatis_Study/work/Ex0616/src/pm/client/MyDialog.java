/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package pm.client;


import pm.vo.EmpVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyDialog extends JDialog {
    EmpFrame parent;

    public MyDialog(EmpFrame parent, boolean modal, String str){
        super(parent, modal);
        this.parent = parent;
        this.setTitle(str);

        initComponents();//화면구성
        jButton1.setText(str);
        empno_tf.setEditable(true);//활성화

        //이벤트 감지자 등록
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //추가모드에서 클릭했는지? 아니면 검색모드에서 클릭했는지?
                String msg = e.getActionCommand();
                //System.out.println(msg);
                if(msg.equals("검색")){
                    // 사용자가 입력한 값이 무엇인지 모르기 때문에
                    // 모두 가져온다.
                    String empno = empno_tf.getText().trim();
                    String ename = ename_tf.getText().trim();
                    String job = job_tf.getText().trim();
                    String hdate = hdate_tf.getText().trim();
                    String sal = sal_tf.getText().trim();

                    EmpVO vo = new EmpVO();
                    if(empno.length() > 0)
                        vo.setEmpno(empno);
                    if(ename.length() > 0)
                        vo.setEname(ename);
                    if(job.length() > 0)
                        vo.setJob(job);
                    if(hdate.length() > 0)
                        vo.setHiredate(hdate);
                    if(sal.length() > 0)
                        vo.setSal(sal);

                    parent.search(vo);
                }
            }
        });

        this.setVisible(true);
    }

    public MyDialog(EmpFrame parent, boolean modal, EmpVO vo) {
        super(parent, modal);
        this.parent = parent;
        
        initComponents();//화면구성
        empno_tf.setText(vo.getEmpno());
        ename_tf.setText(vo.getEname());
        job_tf.setText(vo.getJob());
        hdate_tf.setText(vo.getHiredate());
        sal_tf.setText(vo.getSal());
        comm_tf.setText(vo.getComm());
        dname_tf.setText(vo.getDname());


        //이벤트 감지자 등록
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();//현재 창객체를 메모리상에서 삭제!
            }
        });
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //저장버튼을 클릭할 때마다 수행하는 곳
                String empno = empno_tf.getText().trim();
                String ename = ename_tf.getText().trim();
                String job = job_tf.getText().trim();
                String hdate = hdate_tf.getText().trim();
                String sal = sal_tf.getText().trim();
                String comm = comm_tf.getText().trim();
                if(comm.length() < 1){
                    comm = null;
                }
                String dname = dname_tf.getText().trim();
                
                EmpVO vo = new EmpVO();
                vo.setEmpno(empno);
                vo.setEname(ename);
                vo.setJob(job);
                vo.setHiredate(hdate);
                vo.setSal(sal);
                vo.setComm(comm);
                vo.setDname(dname);
                
                parent.updateData(vo);// EmpFrame에 있는 함수호출
                dispose();
            }
        });

        setVisible(true);
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        empno_tf = new JTextField();
        jPanel2 = new JPanel();
        jLabel2 = new JLabel();
        ename_tf = new JTextField();
        jPanel3 = new JPanel();
        jLabel3 = new JLabel();
        job_tf = new JTextField();
        jPanel4 = new JPanel();
        jLabel4 = new JLabel();
        hdate_tf = new JTextField();
        jPanel5 = new JPanel();
        jLabel5 = new JLabel();
        sal_tf = new JTextField();
        jPanel6 = new JPanel();
        jLabel6 = new JLabel();
        comm_tf = new JTextField();
        jPanel7 = new JPanel();
        jLabel7 = new JLabel();
        dname_tf = new JTextField();
        jPanel8 = new JPanel();
        jButton1 = new JButton();
        jButton2 = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(8, 1));

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel1.setText("사번:");
        jPanel1.add(jLabel1);

        empno_tf.setEditable(false);
        empno_tf.setColumns(6);
        jPanel1.add(empno_tf);

        getContentPane().add(jPanel1);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel2.setText("이름:");
        jPanel2.add(jLabel2);

        ename_tf.setColumns(6);
        jPanel2.add(ename_tf);

        getContentPane().add(jPanel2);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel3.setText("직종:");
        jPanel3.add(jLabel3);

        job_tf.setColumns(6);
        jPanel3.add(job_tf);

        getContentPane().add(jPanel3);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel4.setText("입사일:");
        jPanel4.add(jLabel4);

        hdate_tf.setColumns(6);
        jPanel4.add(hdate_tf);

        getContentPane().add(jPanel4);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel5.setText("급여:");
        jPanel5.add(jLabel5);

        sal_tf.setColumns(6);
        jPanel5.add(sal_tf);

        getContentPane().add(jPanel5);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel6.setText("보너스:");
        jPanel6.add(jLabel6);

        comm_tf.setColumns(6);
        jPanel6.add(comm_tf);

        getContentPane().add(jPanel6);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel7.setText("부서명:");
        jPanel7.add(jLabel7);

        dname_tf.setColumns(6);
        dname_tf.setEditable(false);//비활성화
        jPanel7.add(dname_tf);

        getContentPane().add(jPanel7);

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jButton1.setText("저장");
        jPanel8.add(jButton1);

        jButton2.setText("취소");
        jPanel8.add(jButton2);

        getContentPane().add(jPanel8);

        //setBounds(300,200,200,300);
        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JTextField comm_tf;
    private JTextField dname_tf;
    private JTextField empno_tf;
    private JTextField ename_tf;
    private JTextField hdate_tf;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JTextField job_tf;
    private JTextField sal_tf;
    // End of variables declaration//GEN-END:variables
}
