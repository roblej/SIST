package pm.client;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Reader;

public class FactoryFrame extends JFrame {

    private static SqlSessionFactory factory;

    static{
        try {
            Reader r = Resources.getResourceAsReader("pm/config/conf.xml");
            factory = new SqlSessionFactoryBuilder().build(r);
            r.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public FactoryFrame(){
            this.setBounds(300,300,800,600);
            this.setVisible(true);

            System.out.println("factory = " + factory);

            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

        }
    public static void main(String[] args) {
        new FactoryFrame();
    }
}
