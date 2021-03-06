import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.*;  

import javax.swing.*;
import sun.audio.*;
import java.awt.event.*;
import java.io.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.applet.*;
import java.text.*;


import java.applet.*; 
import java.awt.*; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.text.*;


public class GradeDemo extends JFrame 
{
 private Container cp,cp2;
 private JLabel tyLabel, codeLabel, nameLabel, sortLabel, g0Label, g1Label, g2Label, g3Label,xx;
 private JTextField jtfCode, jtfName, jtfSort, jtfGrade0, jtfGrade1, jtfGrade2, jtfGrade3; 
 private JButton jbWriteout, clrButton, jbSave, jbOpenFile, jbDelete, jbUpdate, jbAdd, jbSearch, jbForward, jbBack, jbSort, jblogout, jbview,jbchange,jbbye,jbClear ;
 private JTextArea textarea , textarea2;
 private JComboBox types;
 private final String[] EXAMINEE = {"SHEILD", "Hydra"}; 
 public String dc[],cg[] ;
 private SimpleDateFormat nowdate=null;

Thread t = null; 
 int recordNumber;
 ArrayList<Examinee> examList = new ArrayList<Examinee>();

 
 public GradeDemo() 
 {  
     nowdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 

//==GMT標準時間往後加八小時
nowdate.setTimeZone(TimeZone.getTimeZone("GMT+8"));

//==取得目前時間
String sdate = nowdate.format(new java.util.Date());
   
  setBak();

  setTitle("Marvel Universe"+sdate);
  Container c = getContentPane();
  JPanel jp = new JPanel(); //創建個JPanel
  jp.setOpaque(false); //把JPanel設置為透明 這樣就不會遮住後面的背景 這樣你就能在JPanel隨意加元件了

  setSize(1400, 700);
  setLocationRelativeTo(null) ;//locate in middle
  setResizable(false);      //固定大小
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setLayout(new BorderLayout());

  codeLabel = new JLabel("ID number");
  codeLabel.setForeground(Color.white);
  jtfCode = new JTextField(20);
  
  nameLabel = new JLabel("Name");
  nameLabel.setForeground(Color.white);
  jtfName = new JTextField(20);
  
  tyLabel = new JLabel("陣營");
  tyLabel.setForeground(Color.white);
  types = new JComboBox(EXAMINEE);
  
  sortLabel = new JLabel("超能力");
  sortLabel.setForeground(Color.white);
  jtfSort = new JTextField(20);

  g0Label = new JLabel("Sheild level:");
  g0Label.setToolTipText("請輸入成員等級");
  g0Label.setForeground(Color.white);
  jtfGrade0 = new JTextField(20);
  
  g1Label = new JLabel("通緝星數");
  g1Label.setForeground(Color.white);
  jtfGrade1 = new JTextField(20);
  jtfGrade1.setEditable(false);  //灰色區塊
  
  g2Label = new JLabel("");
  jtfGrade2 = new JTextField(20);
  jtfGrade2.setEditable(false);
  
  g3Label = new JLabel("");
  jtfGrade3 = new JTextField(20);
  jtfGrade3.setEditable(false);
  
    
  jbWriteout = new JButton("匯出檔案");
  jbWriteout.setContentAreaFilled(false); 
    jbWriteout.setForeground(Color.GREEN);
  clrButton = new JButton("清除");
    clrButton.setContentAreaFilled(false); 
    clrButton.setForeground(Color.GREEN);
  jbOpenFile = new JButton("開檔");
    jbOpenFile.setContentAreaFilled(false); 
    jbOpenFile.setForeground(Color.GREEN);
  jbAdd = new JButton("新增");
   jbAdd.setContentAreaFilled(false); 
    jbAdd.setForeground(Color.GREEN);
  jbDelete = new JButton("刪除");
    jbDelete.setContentAreaFilled(false); 
    jbDelete.setForeground(Color.GREEN);
  jbUpdate = new JButton("修改");
    jbUpdate.setContentAreaFilled(false); 
    jbUpdate.setForeground(Color.GREEN);
  jbForward = new JButton("<<");
    jbForward.setContentAreaFilled(false); 
    jbForward.setForeground(Color.GREEN);
  jbForward.setEnabled(false);
  jbSearch = new JButton("搜尋");
    jbSearch.setContentAreaFilled(false); 
    jbSearch.setForeground(Color.GREEN);
  jbBack = new JButton(">>");
    jbBack.setContentAreaFilled(false); 
    jbBack.setForeground(Color.GREEN);
  jbSort = new JButton("看圖片"); 
    jbSort.setContentAreaFilled(false); 
    jbSort.setForeground(Color.GREEN);
  jblogout = new JButton("登出");
  jblogout.setContentAreaFilled(false); 
    jblogout.setForeground(Color.CYAN);
    jbview = new JButton("檢視全部名單");
  jbview.setContentAreaFilled(false); 
    jbview.setForeground(Color.CYAN);    
     jbbye = new JButton("格式化");
    jbbye.setContentAreaFilled(false); 
    jbbye.setForeground(Color.GREEN);
  
    jbClear = new JButton("Clear Textarea");
   jbClear.setContentAreaFilled(false); 
   jbClear.setForeground(Color.GREEN);
    
  textarea = new JTextArea(20,100);
  textarea.setEditable(false); 
  textarea.setOpaque(false);
  textarea.setBorder(null);
  textarea.setForeground(Color.GREEN);
  textarea.setBackground(new Color(2,100, 230, 0));
  //textarea.setBorder(BorderFactory.createLineBorder(Color.BLUE));//邊框顏色  

  
  cp = getContentPane();
  cp.setLayout(new GridLayout(1,2,7,10));
  JPanel newp = new JPanel();
  newp.setOpaque(false);
  newp.setLayout(new BorderLayout(5,10));
  cp.add(newp);
  //cp.add(new JScrollPane(textarea));
  

  JPanel cpan2 = new JPanel();
    cp.add(cpan2);
  cpan2.setOpaque(false);
  cpan2.setLayout(new GridLayout(1,2,5,100));
  cpan2.add(textarea);
        
  JPanel cpan = new JPanel();
  cpan.setOpaque(false);
  cpan.setLayout(new GridLayout(2,2,5,10));
  cpan.add(codeLabel); //Code
  cpan.add(jtfCode);
  cpan.add(nameLabel); //Name
  cpan.add(jtfName);
  cpan.add(tyLabel);   //Type
  cpan.add(types);
  cpan.add(sortLabel); //Sort      
  cpan.add(jtfSort);
  cpan.add(g0Label);   //學測
  cpan.add(jtfGrade0);
  cpan.add(g1Label);   //指考數    
  cpan.add(jtfGrade1);
  JPanel span = new JPanel();

  span.setOpaque(false);
 c.add(jp);
 jp.add(jblogout);
 jp.add(jbview);
 //jp.add(jbchange);
  setVisible(true);
  span.setLayout(new GridLayout(4,3,5,10));
  span.add(jbWriteout);
  span.add(clrButton);
  span.add(jbOpenFile);
  span.add(jbAdd);
  span.add(jbDelete);
  span.add(jbUpdate);
  span.add(jbForward);
  span.add(jbSearch);
  span.add(jbBack);
  span.add(jbSort);
  span.add(jbbye);
  span.add(jbClear);
         /*Sound a = new Sound();
  new MusicWindow();*/
  
  newp.add(cpan, BorderLayout.NORTH);
  newp.add(span, BorderLayout.SOUTH);

  //Open File
  FileReader f=null;
        try {
    f=new FileReader("exam.txt");
   }catch(IOException e){
    System.out.println("檔案開啟錯誤");
    System.exit(-1);
   }
        BufferedReader p = new BufferedReader(f); 
        StringTokenizer st;
        //Examinee w;
        try {
    String input = p.readLine();
    
    while(input!=null)
    {
     st = new StringTokenizer(input);
     String[] data = new String[6];
     for(int i = 0; i < 6; i++)
      data[i] = st.nextToken(); //把每一行的資料存入data[]
     if(data[2].equals("SHEILD"))
     {
      Examinee w = new StudentMay(data[0], data[1], data[2] ,data[3], Integer.parseInt(data[4]));  
      examList.add(w); 
     }
     else
     {
      Examinee w = new StudentAugust(data[0], data[1], data[2] ,data[3],Double.parseDouble(data[5]));
      examList.add(w); 
     }
     input = p.readLine();
    }
    textarea.append("此檔案之資料瀏覽紀錄：\n");
    Chooser();
  } catch(IOException e){
    System.out.println("檔案讀取錯誤");
    System.exit(-1);
   }catch(NumberFormatException e){
    System.out.println("數字轉換錯誤");
    System.exit(-1);
   }
   
        try{
   p.close();
  } catch(IOException e){
   System.out.println("檔案關閉失敗");
   }
  
   
  // register
  types.addItemListener(new ListHandler());
  jbWriteout.addActionListener(new WriteoutHandler());
  clrButton.addActionListener(new ClrButtonHandler());
  jbOpenFile.addActionListener(new OpenFileHandler());
  jbAdd.addActionListener(new AddHandler());
  jbDelete.addActionListener(new DeleteHandler());
  jbUpdate.addActionListener(new UpdateHandler());
  jbForward.addActionListener(new ForwardHandler());
  jbSearch.addActionListener(new SearchHandler());
  jbBack.addActionListener(new BackHandler());
  jbSort.addActionListener(new SortHandler());
  jblogout.addActionListener(new LogoutHandler());
  jbview.addActionListener(new ViewHandler());
  //jbchange.addActionListener(new ChangeHandler());
  jbbye.addActionListener(new ByeHandler());
  jbClear.addActionListener(new ClearHandler());
 }

 public static void main( String[] args ) 
 {
   

   JPasswordUI pw = new JPasswordUI();
      //Sound a = new Sound();
  //new MusicWindow();
 
 }
 public void BackHandler(){
   if(textarea.getText() == "")
{
    System.out.println("empty string");
}
   
 }
 
 public void setBak(){
((JPanel)this.getContentPane()).setOpaque(false);
ImageIcon img = new ImageIcon(/*"C:\\Users\\islab_1\\Desktop\\2)\\sheild\\Background2.jpg"*/"E:\\_\\marvel\\sheild\\Background2.jpg");
JLabel background = new JLabel(img);this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
}

 public void Chooser()
 {
  if(examList.get(recordNumber) instanceof  StudentMay) //學測
  {
   StudentMay s1 = (StudentMay)examList.get(recordNumber);
   types.setSelectedIndex(0);
   jtfCode.setText(s1.getCode());
   jtfName.setText(s1.getName());
   jtfSort.setText(s1.getSort());
   jtfGrade0.setText("" + s1.getGrade());
   jtfGrade1.setText("");
   textarea.append(s1.toString() + "\n");
  }
  else
  {
   StudentAugust s2= (StudentAugust)examList.get(recordNumber); 
    
   types.setSelectedIndex(1);
   jtfCode.setText(s2.getCode());
   jtfName.setText(s2.getName());
   jtfSort.setText(s2.getSort());
   jtfGrade0.setText("");
   jtfGrade1.setText("" + s2.getMath());
   textarea.append(s2.toString() + "\n");
     
  }
 }
 
 private class ListHandler implements ItemListener 
 {
  public void itemStateChanged(ItemEvent e) 
  {
   if(types.getSelectedIndex() == 1) //選指考
   { 
    jtfGrade0.setEditable(false);
    jtfGrade0.setText("-1");
    jtfGrade1.setEditable(true);
    jtfGrade2.setEditable(true);
    jtfGrade3.setEditable(true);
    g1Label.setToolTipText("請輸入該Hydra成員通緝星數");
   } 
   else 
   {
    jtfGrade0.setEditable(true);
    g0Label.setToolTipText("Please enter this SHEILD agent level");
    jtfGrade1.setEditable(false);
    jtfGrade2.setEditable(false);
    jtfGrade3.setEditable(false);
   }   
  }
 }

 private class WriteoutHandler implements ActionListener 
 {
  public void actionPerformed(ActionEvent e) 
  {/*Sound a = new Sound();
  new MusicWindow();*/
   String fileDir = "My Documents\\";
            File f = new File("exam5.txt");    
            JFileChooser jf = new JFileChooser(new File("."));
            jf.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            jf.setSelectedFile(f); 
   FileNameExtensionFilter filter1 = new FileNameExtensionFilter("Java 原始碼", "java");
   FileNameExtensionFilter filter2 = new FileNameExtensionFilter("txt文件", "txt");
   jf.setFileFilter(filter1);
   jf.setFileFilter(filter2);
            
   int status = jf.showSaveDialog(null);

   if(status == JFileChooser.APPROVE_OPTION)
   {
    try{
    f = jf.getSelectedFile();
    PrintWriter p = new PrintWriter(f);
    
    for(int i = 0;i < examList.size(); i++)
    {
     if(examList.get(i) instanceof  StudentMay)
     {
      StudentMay s1=(StudentMay)examList.get(i);
      p.println(s1.getCode()+ "\t" +s1.getName()+"\tSHEILD\t" + s1.getSort() + "\t" + s1.getGrade() + "\t -1 ");
     }
     if(examList.get(i) instanceof  StudentAugust)
     {
      StudentAugust s2=(StudentAugust)examList.get(i);
      p.println(s2.getCode()+ "\t" +s2.getName()+"\tHydra\t" + s2.getSort() + "\t -1 \t" + s2.getMath() /*+ "\t" + s2.getChinese() + "\t" + s2.getEnglish()*/);
      
     }   
    }
    textarea.append("匯出完成! 檔案路徑:" + f);
    p.close();
    }catch(FileNotFoundException ex)
    {JOptionPane.showMessageDialog(null, "找不到此檔案!");}
   }
  }
 }

 private class ClrButtonHandler implements ActionListener 
 {
  public void actionPerformed(ActionEvent e) 
  {
   jtfCode.setText("");
   jtfName.setText("");
   jtfSort.setText("");
   jtfGrade0.setText("");
   jtfGrade1.setText("");

  }
 }
  private class ClearHandler implements ActionListener 
  {
   public void actionPerformed(ActionEvent e) 
  {
textarea.setText("");
  }
 }
 private class OpenFileHandler implements ActionListener  
 {

  public void actionPerformed(ActionEvent e) 
  {/*Sound a = new Sound();
  new MusicWindow();*/
   JFileChooser fc = new JFileChooser(new File("."));
   FileNameExtensionFilter filter1 = new FileNameExtensionFilter("Java 原始碼", "java");
   FileNameExtensionFilter filter2 = new FileNameExtensionFilter("txt文件", "txt");
   fc.setFileFilter(filter1);
   fc.setFileFilter(filter2);
   int status = fc.showOpenDialog(null);

   if(status == JFileChooser.APPROVE_OPTION) 
   {
    File f = fc.getSelectedFile();
    BufferedReader r = null;
    try {
     r = new BufferedReader(new FileReader(f));
    } catch(FileNotFoundException ex) {
     JOptionPane.showMessageDialog(null, "找不到檔案");
     System.exit(-1);
    }
    
    int choice ;
    choice = JOptionPane.showConfirmDialog(null,"是否要跳轉至此檔案瀏覽??","跳轉確認", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
    if (choice == JOptionPane.NO_OPTION)
    {
     String result = "";
     try {
      String input = r.readLine();
      while(input != null) 
      {
       result = result + input + "\n";
       input = r.readLine();
      }
     } catch(IOException ex) {
      JOptionPane.showMessageDialog(null, "資料讀取錯誤");
      System.exit(-1);
     }

     
     textarea.append("\t\t=====開啟檔案=====\n");
     textarea.append("准考證號碼\t姓名\t入學方式\tSUPERPOWER\tSHEILD總級分\tHydra(數)\n");
     textarea.append(result + "(p.s.為讀檔需求，-1表示無此資料)\n\t\t=================\n下面為上次最後的瀏覽紀錄:\n");
     Chooser();
    }
    else
    {    
     StringTokenizer st;
     examList.clear();
     recordNumber = 0;
     try 
     {
       String input = r.readLine();
       
       while(input!=null)
       {
        st = new StringTokenizer(input);
        String[] data = new String[6];
        for(int i = 0; i < 6; i++)
         data[i] = st.nextToken(); //把每一行的資料存入data[]
        if(data[2].equals("SHEILD"))
        {
         Examinee w = new StudentMay(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]));  
         examList.add(w); 
        }
        else
        {
         Examinee w = new StudentAugust(data[0], data[1], data[2], data[3],Double.parseDouble(data[5]));
         examList.add(w); 
        }
        input = r.readLine();
       }
     } catch(IOException ex){
       System.out.println("檔案讀取錯誤");
       System.exit(-1);
      }catch(NumberFormatException ex){
       System.out.println("數字轉換錯誤");
       System.exit(-1);
      }
     textarea.append("已跳轉至檔案:" + f + "\n");
     textarea.append("此檔案之資料瀏覽紀錄：\n");
     Chooser();    

    }
    try {    
     r.close();
    } catch(IOException ex) {
     JOptionPane.showMessageDialog(null, "檔案關閉錯誤");
     System.exit(-1);
    }

   }
  }
 }
 
 private class AddHandler implements ActionListener 
 {
  public void actionPerformed(ActionEvent e) 
  {
            Examinee w;
   String c = jtfCode.getText();
            String n = jtfName.getText();
   String gp;
   String s = jtfSort.getText();
               int iii=0;
             
            for(int xx=0;xx<n.length();xx++){
            
              if(n.substring(xx,xx+1).equals("0"))
              { JOptionPane.showMessageDialog(null,"名字不能有數字","87",JOptionPane.PLAIN_MESSAGE);
                  iii=1;}
             if(n.substring(xx,xx+1).equals("1"))
              { JOptionPane.showMessageDialog(null,"名字不能有數字","87",JOptionPane.PLAIN_MESSAGE);
                  iii=1;}
             if(n.substring(xx,xx+1).equals("2"))
              { JOptionPane.showMessageDialog(null,"名字不能有數字","87",JOptionPane.PLAIN_MESSAGE);
                  iii=1;}
             if(n.substring(xx,xx+1).equals("3"))
              { JOptionPane.showMessageDialog(null,"名字不能有數字","87",JOptionPane.PLAIN_MESSAGE);
                  iii=1;}
             if(n.substring(xx,xx+1).equals("4"))
              { JOptionPane.showMessageDialog(null,"名字不能有數字","87",JOptionPane.PLAIN_MESSAGE);
                  iii=1;}
              if(n.substring(xx,xx+1).equals("5"))
              { JOptionPane.showMessageDialog(null,"名字不能有數字","87",JOptionPane.PLAIN_MESSAGE);
                  iii=1;}
               if(n.substring(xx,xx+1).equals("6"))
              { JOptionPane.showMessageDialog(null,"名字不能有數字","87",JOptionPane.PLAIN_MESSAGE);
                  iii=1;}
                if(n.substring(xx,xx+1).equals("7"))
              { JOptionPane.showMessageDialog(null,"名字不能有數字","87",JOptionPane.PLAIN_MESSAGE);
                  iii=1;}
                 if(n.substring(xx,xx+1).equals("8"))
              { JOptionPane.showMessageDialog(null,"名字不能有數字","87",JOptionPane.PLAIN_MESSAGE);
                  iii=1;}
                  if(n.substring(xx,xx+1).equals("9"))
              { JOptionPane.showMessageDialog(null,"名字不能有數字","87",JOptionPane.PLAIN_MESSAGE);
                  iii=1;}

            }if(iii==0){
   try
   {
    if(types.getSelectedIndex() == 0) //選學測
    {
     gp = "SHEILD";
     int g0 = Integer.parseInt(jtfGrade0.getText());
     jtfGrade1.setText("-1"); 
     jtfGrade2.setText("-1"); 
     jtfGrade3.setText("-1");
     w = new StudentMay(c, n, gp, s, g0);
     examList.add(w);
     textarea.append("新增完成\n");
    }      
    else
    {
     gp = "Hydra";
     double g1 = Double.parseDouble(jtfGrade1.getText());
     double g2 = Double.parseDouble(jtfGrade1.getText());
     double g3 = Double.parseDouble(jtfGrade1.getText());
     jtfGrade0.setText("-1");
     w = new StudentAugust(c, n, gp, s, g1);
     examList.add(w);
     textarea.append("新增完成\n");
     
    }
    } catch(Exception ex)
    {
     JOptionPane.showMessageDialog(null, "若想更改此成員資料，\n請輸入完整後按「修改」鍵，謝謝!!");
    }}
            }}
 
 
  private class ByeHandler implements ActionListener 
 {

  public void actionPerformed(ActionEvent e) 
  {   
   int choice ;
   choice = JOptionPane.showConfirmDialog(null,"確定要格式化資料??","確認", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
   if (choice == JOptionPane.YES_OPTION)
   {examList.clear();
    textarea.append("格式化完成\n"); 
    jtfCode.setText("");
    jtfName.setText("");
    jtfSort.setText("");
    jtfGrade0.setText("");
    jtfGrade1.setText("");
 
     }
   else
    JOptionPane.showMessageDialog(null, "已取消動作");         
  }
 }

  
 private class DeleteHandler implements ActionListener 
 {
  public void actionPerformed(ActionEvent e) 
  {   
   int choice ;
   choice = JOptionPane.showConfirmDialog(null,"確定刪除此筆資料??","刪除確認", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
   if (choice == JOptionPane.YES_OPTION)
   {
    examList.remove(recordNumber);
    textarea.append("刪除完成\n"); 
    jtfCode.setText("");
    jtfName.setText("");
    jtfSort.setText("");
    jtfGrade0.setText("");
    jtfGrade1.setText("");
    recordNumber--;
   }
   else
    JOptionPane.showMessageDialog(null, "已取消動作");         
  }
 }
 
 private class UpdateHandler implements ActionListener 
 {
  public void actionPerformed(ActionEvent e) 
  {
   String c = jtfCode.getText();
            String n = jtfName.getText();
            int iii=0;
            //if(c.length()>6){JOptionPane.showMessageDialog(null,"id 2 long","87",JOptionPane.PLAIN_MESSAGE);}else{
           for(int xx=0;xx<n.length();xx++){
            
              if(n.substring(xx,xx+1).equals("0"))
              { JOptionPane.showMessageDialog(null,"名字不能有數字","87",JOptionPane.PLAIN_MESSAGE);
                  iii=1;}
             if(n.substring(xx,xx+1).equals("1"))
              { JOptionPane.showMessageDialog(null,"名字不能有數字","87",JOptionPane.PLAIN_MESSAGE);
                  iii=1;}
             if(n.substring(xx,xx+1).equals("2"))
              { JOptionPane.showMessageDialog(null,"名字不能有數字","87",JOptionPane.PLAIN_MESSAGE);
                  iii=1;}
             if(n.substring(xx,xx+1).equals("3"))
              { JOptionPane.showMessageDialog(null,"名字不能有數字","87",JOptionPane.PLAIN_MESSAGE);
                  iii=1;}
             if(n.substring(xx,xx+1).equals("4"))
              { JOptionPane.showMessageDialog(null,"名字不能有數字","87",JOptionPane.PLAIN_MESSAGE);
                  iii=1;}
              if(n.substring(xx,xx+1).equals("5"))
              { JOptionPane.showMessageDialog(null,"名字不能有數字","87",JOptionPane.PLAIN_MESSAGE);
                  iii=1;}
               if(n.substring(xx,xx+1).equals("6"))
              { JOptionPane.showMessageDialog(null,"名字不能有數字","87",JOptionPane.PLAIN_MESSAGE);
                  iii=1;}
                if(n.substring(xx,xx+1).equals("7"))
              { JOptionPane.showMessageDialog(null,"名字不能有數字","87",JOptionPane.PLAIN_MESSAGE);
                  iii=1;}
                 if(n.substring(xx,xx+1).equals("8"))
              { JOptionPane.showMessageDialog(null,"名字不能有數字","87",JOptionPane.PLAIN_MESSAGE);
                  iii=1;}
                  if(n.substring(xx,xx+1).equals("9"))
              { JOptionPane.showMessageDialog(null,"名字不能有數字","87",JOptionPane.PLAIN_MESSAGE);
                  iii=1;}

            }if(iii==0){
            String gp;
   String s = jtfSort.getText();  
   
   try
   {
    
    if(examList.get(recordNumber) instanceof  StudentMay)
    {     
     gp = "SHEILD";
     
     int g0 = Integer.parseInt(jtfGrade0.getText());
     if(types.getSelectedIndex()==1){
       JOptionPane.showMessageDialog(null,"好人不會變壞人","87",JOptionPane.PLAIN_MESSAGE);
     }else{
     StudentMay s1=(StudentMay)examList.get(recordNumber);
 
     
     s1.setCode(c);
     s1.setName(n);
     s1.setGroup(gp);
     s1.setSort(s);
     s1.setGrade(g0);    
     textarea.append("修改完成↓↓↓\n");
     textarea.append(s1.toString()+ "\n");
     }      }
    else
    {
      if(types.getSelectedIndex()==0){
    JOptionPane.showMessageDialog(null,"壞人不會變好人","87",JOptionPane.PLAIN_MESSAGE);
     }else{
     gp = "Hydra";
     double g1 = Double.parseDouble(jtfGrade1.getText());
     double g2 = Double.parseDouble(jtfGrade2.getText());
     double g3 = Double.parseDouble(jtfGrade3.getText());
     
     StudentAugust s2=(StudentAugust)examList.get(recordNumber);
     s2.setCode(c);
     s2.setName(n);
     s2.setGroup(gp);
     s2.setSort(s);
     s2.setMath(g1);
     textarea.append("修改完成↓↓↓\n");
     textarea.append(s2.toString() + "\n");
     }}
    
   }  catch(Exception ex)
    {
     JOptionPane.showMessageDialog(null, "選擇錯誤!!");
     jtfGrade0.setText("");
     jtfGrade1.setText("");
     jtfGrade2.setText("");
     jtfGrade3.setText("");
   }}
  }
  }//}
 
 private class SearchHandler implements ActionListener 
 {
  public void actionPerformed(ActionEvent e) 
  {      
   String code = jtfCode.getText();
   int check = 0;
   if(code.equals(""))
    JOptionPane.showMessageDialog(null,"Please enter ID number");
   else
   {
                for(int i = 0;i < examList.size(); i++)
    {
                    if(examList.get(i) instanceof  StudentMay)
     {
                        StudentMay s1=(StudentMay)examList.get(i);
                        if(jtfCode.getText().equals(s1.getCode())) 
      {
                            textarea.append("查詢結果:\n" + s1.toString()+"\n"); 
                            types.setSelectedIndex(0);            
                            jtfCode.setText(s1.getCode());
       jtfName.setText(s1.getName());
       jtfSort.setText(s1.getSort());
       jtfGrade0.setText(" " + s1.getGrade());
       jtfGrade1.setText("");
       recordNumber = i;
       check = 1;
       break;
       }
     }
     
                    if(examList.get(i) instanceof  StudentAugust)
     {
                        StudentAugust s2=(StudentAugust)examList.get(i); 
                        if(jtfCode.getText().equals(s2.getCode()))
      {
       textarea.append("查詢結果:\n" + s2.toString() + "\n"); 
                            types.setSelectedIndex(1);
       jtfCode.setText(s2.getCode());
       jtfName.setText(s2.getName());
       jtfSort.setText(s2.getSort());
       jtfGrade0.setText("");
       jtfGrade1.setText("" + s2.getMath());
       recordNumber = i;
       check = 1;
       break;
      }
     }
    }
    if(check == 0)
     JOptionPane.showMessageDialog(null,"This person doesn't exsist");
   }
  }
 }
 
 private class ForwardHandler implements ActionListener 
 {
  public void actionPerformed(ActionEvent e) 
  {
   recordNumber--;
 
   if(recordNumber < 0 )
   {
    JOptionPane.showMessageDialog(null, "You have reached begining of search results"); 
   /*if user has reached the begining of results, disable back button*/
    jbForward.setEnabled(false);
    jbBack.setEnabled(true);
       recordNumber++;
   }
   else
   {
    jbForward.setEnabled(true);
    jbBack.setEnabled(true);
Chooser();

    }
   }
 }
  
 private class BackHandler implements ActionListener 
 {
  public void actionPerformed(ActionEvent e) 
  {
   recordNumber++;

   if(recordNumber >= examList.size()) //表示搜索的數字大於清單長度
   {
    JOptionPane.showMessageDialog(null, "You have reached end of search results"); 
    /*if user has reached the end of results, disable forward button*/
    jbForward.setEnabled(true);
    jbBack.setEnabled(false);
    // dec by one to counter last inc
    recordNumber -- ; 
   }
   else
   { 
    jbBack.setEnabled(true);
    jbForward.setEnabled(true);
    Chooser();
   }
  }
 }
 
 private class LogoutHandler implements ActionListener
 {
   public void actionPerformed(ActionEvent e){
   JPasswordUI pw = new JPasswordUI();
   setVisible(false);
   }}
 
 
 private class SortHandler implements ActionListener 
 {
  public void actionPerformed(ActionEvent e) 
  {/*Sound a = new Sound();
  new MusicWindow();*/
    String c = jtfCode.getText();

 JFrame frame = new JFrame();
  ImageIcon icon = new ImageIcon(/*"C:\\Users\\islab_1\\Desktop\\2)\\sheild\\"+c+".jpg"*/"E:\\_\\marvel\\sheild\\"+c+".jpg");
  JLabel label = new JLabel(icon);

  frame.add(label);
 frame.pack();
  frame.setVisible(true);
  }
 }
 
 private class ViewHandler implements ActionListener 
 {
  public void actionPerformed(ActionEvent e) 
  {
     textarea.append("\nAll Members:\n");
     int i=0;
    for(;i<examList.size();i++){
     if(examList.get(i) instanceof  StudentMay) //學測
  {
   StudentMay s1 = (StudentMay)examList.get(i);
   textarea.append(s1.toString() + "\n");
  }
  else
  {
   StudentAugust s2= (StudentAugust)examList.get(i); 
    
   textarea.append(s2.toString() + "\n");
  }}
    if(i==0){
      textarea.append("None\n");
    }else{
      textarea.append("That's all\n");
    }
  }
 }}

