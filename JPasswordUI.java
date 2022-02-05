import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JPasswordUI extends JFrame
{
    private JLabel Jlb_ID = new JLabel("�b��");
    private JLabel Jlb_PW = new JLabel("�K�X");
    private JPasswordField jpw = new JPasswordField(8);
    private JTextField jid = new JTextField();
    private JButton Jbtn_YES = new JButton("�T�w");
    private JButton Jbtn_NO = new JButton("�M��");
    private ButtonHandler hbtHandler = new ButtonHandler();  //�B�z���s�ƥ�
    private JTextField jtfName;
    
    public JPasswordUI()
    {
        
        super("��J�b���K�X");       
        Container c = getContentPane(); 
        c.setLayout(null);        
        c.setBackground(Color.yellow);         
        //�]�wJlb_ID�j�p��m����ܦr��
        jtfName = new JTextField(20);
        c.add(jtfName);
        Jlb_ID.setLocation(20,10);
        Jlb_ID.setSize(50,20);
        Jlb_ID.setFont(new Font("Serif",Font.BOLD,16));
        c.add(Jlb_ID);        
        //�]�w�b����J�ؤj�p��m����ܦr��
        jid.setLocation(70,10);
        jid.setSize(100,20);
        c.add(jid);        
        //�]�wJlb_PW�j�p��m����ܦr��
        Jlb_PW.setLocation(20,50);
        Jlb_PW.setSize(50,20);
        Jlb_PW.setFont(new Font("Serif",Font.BOLD,16));
        c.add(Jlb_PW);        
        //�]�w�K�X��J�ؤj�p��m����ܦr��
        jpw.setLocation(70,50);
        jpw.setSize(100,20);
        jpw.setEchoChar('��');
        jpw.setToolTipText("�K�X����8�Ӧr��");
        c.add(jpw);        
        jpw.addActionListener(hbtHandler);  
        
        //�]�w�T�w���s�j�p��m����ܦr��
        Jbtn_YES.setLocation(10,90);
        Jbtn_YES.setSize(80,20);
        Jbtn_YES.addActionListener(hbtHandler);
        c.add(Jbtn_YES);
        //�]�w�M�����s�j�p��m����ܦr��
        Jbtn_NO.setLocation(100,90);
        Jbtn_NO.setSize(80,20);
        Jbtn_NO.addActionListener(hbtHandler);
        c.add(Jbtn_NO);
        
        //�]�w����
        setSize(200,150);
        setLocation(300,200); 
         setResizable(false);//������j���s�L�� 
         setVisible(true);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    } 
    
    private class ButtonHandler implements ActionListener 
    {
        public void actionPerformed(ActionEvent evtE) 
        {
            if(evtE.getSource() == Jbtn_YES)
            {  
                String pw = jpw.getText();
               String pw2 = jid.getText();
                if(pw.equals("1234")&&pw2.equals("1234")){
                  JOptionPane.showMessageDialog(null,"Wellcome to level 7!!","Hello Director",JOptionPane.PLAIN_MESSAGE);
                Sound a = new Sound();
                  GradeDemo f = new GradeDemo();
                 new MusicWindow();
                 f.setVisible(true);
                 setVisible(false);
                }else{
                JOptionPane.showMessageDialog(null,"�ϥΪ̱b���αK�X���~","Inane warning",JOptionPane.WARNING_MESSAGE);
                }
            }else if(evtE.getSource() == Jbtn_NO)
            {   jpw.setText("");
                 jid.setText("");
            }
        }
    }
}