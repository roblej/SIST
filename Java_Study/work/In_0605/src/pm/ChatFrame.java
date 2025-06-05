/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pm;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author 쌍용교육센터
 */
public class ChatFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ChatFrame.class.getName());

    /**
     * Creates new form ChatFrame
     */
    
    CardLayout card;
    
    Socket s;
    ObjectInputStream in;
    ObjectOutputStream out;
    boolean enter;
    
    //서버쪽에서 데이터가 넘어오는지? 항상 감시하는 스레드
    Thread t = new Thread() {

		@Override
		public void run() {
			bk:while(true) {
				try {
					Object obj = in.readObject();//서버로부터 데이터가 올 때까지
												 //대기한다
					Protocol p = (Protocol) obj;
					
					switch(p.getCmd()) {
					case 1: //어떤 누군가가 접속했을 때 수행
						//명단을 받아서 user_list라는 JList에 넣어준다.
						card.show(getContentPane(), "roomlist");
						user_list.setListData(p.getUser_names());
						room_list.setListData(p.getRoom_names());
						break;
					case 2:						
						ta.append(p.getMsg());
						ta.append("\n");
						input_tf.setText("");
						break;
					case 3:
						break bk;
					case 4:
						//내가 방을 만들고 반드시 4번 프로토콜을 받는다
						//명단과 입장메세지
						join_list.setListData(p.getUser_names());
						ta.append(p.getMsg());
						card.show(getContentPane(), "ChatRoom");
						break;
					case 5:
						card.show(getContentPane(), "roomlist");
                        user_list.setListData(p.getUser_names());
                        room_list.setListData(p.getRoom_names());
						break;
						
					}
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			closed();
			
			System.exit(0);
		}
    	
    };
    //채팅화면 필요한 객체
    JPanel card3,card3_E,card3_S;
    JButton out_bt,send_bt;
    JLabel card3_user;
    JTextArea ta;
    JTextField input_tf;
    JList<String> join_list;
    
    public ChatFrame() {
        initComponents();//화면구성
        setVisible(true);//화면 보여주기
        
        
        //이벤트감지자 등록
        this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				//접속이 안된 상태면 바로 종료
				//그렇지 않다면 3번 프로토콜 생성 후 전송만 하자
				if(s==null) {
					System.exit(0);
					
				}
				else {
					Protocol p = new Protocol();
					p.setCmd(3);
					
					try {
						out.writeObject(p);//나와 유일하게 연결된 복사본에게만 전송
						out.flush();
						t.stop();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
			}
        	
		});
        
        jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String n = jTextField1.getText().trim();
				if(n.length()<1) {
					JOptionPane.showMessageDialog(ChatFrame.this, "대화명을 입력하세요");
					jTextField1.setText("");
					jTextField1.requestFocus();//커서갖다놓기
					return;
				}else {
					//서버접속
					try {
						s = new Socket("192.168.10.102",5555);
						out = new ObjectOutputStream(s.getOutputStream());
						in = new ObjectInputStream(s.getInputStream());
						t.start();
						
						card.show(getContentPane(), "roomlist");
						//처음 접속했다는 의미로 프로토콜 데이터 보내야함
						Protocol p = new Protocol();
						p.setCmd(1);
						p.setMsg(n);//대화명
						
						//서버로 보낸다
						out.writeObject(p);
						out.flush();
						
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
			}
		});
        
        jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = JOptionPane.showInputDialog(ChatFrame.this,"방 제목을 입력하세요");
				if(str != null && str.trim().length()>0) {
					//방 제목을 1자라도 입력한 경우!
					//방을 만들 수 있는 프로토콜 생성
					Protocol p = new Protocol();
					p.setCmd(4);
					p.setMsg(str);//방 제목 담기
					try {
						out.writeObject(p);
						out.flush();
//						card.show(getContentPane(), "ChatRoom");
						
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
			}
		});
        jButton3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//방 참여
				int idx = room_list.getSelectedIndex();
				if(idx!=-1) {//선택된 값이 0이 아닐때
					String choose = room_list.getSelectedValue();
					System.out.println(choose);
					Protocol p = new Protocol();
					p.setCmd(6);
					p.setMsg(choose);
					try {
						out.writeObject(p);
						out.flush();
//						card.show(getContentPane(), "ChatRoom");
						
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
				
			}
		});
        
        out_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Protocol p = new Protocol();
				p.setCmd(5);
				try {
					out.writeObject(p);
					out.flush();
//					card.show(getContentPane(), "ChatRoom");
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
        
        send_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = input_tf.getText();
				
				Protocol p = new Protocol();
				p.setCmd(2);
				p.setMsg(str);
				try {
					out.writeObject(p);
					out.flush();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		room_list.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                int cnt = e.getClickCount();
                if(cnt==2){
                    jButton3.doClick();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        card1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        card2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        user_list = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        room_list = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();

//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(card = new java.awt.CardLayout());

        card1.setLayout(new java.awt.BorderLayout());

        jLabel1.setMaximumSize(new java.awt.Dimension(437, 535));
        jLabel1.setMinimumSize(new java.awt.Dimension(437, 535));
        ImageIcon icon = new ImageIcon("src/images/chat.png");
        Image img = icon.getImage().getScaledInstance(437,535,Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(img);
        jLabel1.setIcon(icon2);
        jLabel1.setPreferredSize(new java.awt.Dimension(437, 535));
        card1.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel2.setText("대화명 :");
        jPanel2.add(jLabel2);

        jTextField1.setColumns(10);
        jPanel2.add(jTextField1);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jButton1.setText("로그인");
        
        jPanel3.add(jButton1);

        jPanel1.add(jPanel3);

        card1.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(card1, "first");

        card2.setPreferredSize(new java.awt.Dimension(437, 535));
        card2.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new java.awt.GridLayout(4, 0));

        jButton2.setText("방 만들기");
        jPanel6.add(jButton2);

        jButton4.setText("쪽지 보내기");
        jPanel6.add(jButton4);

        jButton3.setText("방 참여");
        jPanel6.add(jButton3);

        jButton5.setText("종료");
        jPanel6.add(jButton5);

        jPanel4.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        jLabel4.setText("[대기실]");
        jPanel4.add(jLabel4, java.awt.BorderLayout.NORTH);

        user_list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { ""};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(user_list);

        jPanel4.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        card2.add(jPanel4, java.awt.BorderLayout.LINE_END);

        jPanel5.setLayout(new java.awt.BorderLayout());

        room_list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(room_list);

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel3.setText("[방목록]");
        jPanel5.add(jLabel3, java.awt.BorderLayout.NORTH);

        card2.add(jPanel5, java.awt.BorderLayout.CENTER);

        getContentPane().add(card2, "roomlist");
        
        //card3-------------------------------------------------------------------
        card3 = new JPanel(new BorderLayout());
        card3.setPreferredSize(new java.awt.Dimension(437, 535));
        card3_E = new JPanel(new BorderLayout());
        card3_E.setPreferredSize(new java.awt.Dimension(100, 535));
        card3_S = new JPanel(new BorderLayout());
        
        card3.add(new JScrollPane(ta=new JTextArea()));
        ta.setEditable(false);
        
        card3_E.add(card3_user = new JLabel("참여자"),BorderLayout.NORTH);
        card3_E.add(new JScrollPane(join_list=new JList<String>()));
        card3_E.add(out_bt=new JButton("나가기"),BorderLayout.SOUTH);
        
        card3.add(card3_E,BorderLayout.EAST);
        
        card3_S.add(input_tf = new JTextField());
        card3_S.add(send_bt = new JButton("보내기"),BorderLayout.EAST);
        
        card3.add(card3_S,BorderLayout.SOUTH);
        
        getContentPane().add(card3, "ChatRoom");
        
        //------------------------------------------------------------------------
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void closed() {
    	try {
			if(out != null)
				out.close();
			if(in != null)
				in.close();
			if(s != null)
				s.close();
    	}catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
    	System.exit(0);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
             
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> new ChatFrame().setVisible(true));
        new ChatFrame();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel card1;
    private javax.swing.JPanel card2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JList<String> room_list;
    private javax.swing.JList<String> user_list;
    // End of variables declaration//GEN-END:variables
}
