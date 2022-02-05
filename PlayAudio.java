import java.applet.*;
import java.awt.event.*;  
import java.awt.*;
 
public class PlayAudio extends Applet 
implements ActionListener{
AudioClip audio;  
Button btExit,btOpen,btPlay,btLoop,btStop;
/**
 *<br>��k?���G��l��Applet
 *<br>?�J??�G
 *<br>��^?���G
 */
public void init() {
//�[??�����
 audio = getAudioClip(getDocumentBase(),"1.mp3");//?����W�A�[�b�s�ؤ��?�������q���W?
//�۳y��?
 setLayout(new FlowLayout()); 
 btPlay=new Button("Play");                   
 btPlay.addActionListener(this); 
 btLoop=new Button("Loop"); 
 btLoop.addActionListener(this); 
 btStop=new Button("Stop"); 
 btStop.addActionListener(this); //?Play��?�K�[�@??�v�ƥ�
//?��?�K�[��Applet��
 add(btPlay);
 add(btLoop);
 add(btStop);
 
}
 
public void actionPerformed(ActionEvent e) {
 
  //�p�G??���OPlay��?
    if (e.getSource()==btPlay) {
       play();
    }
    //�p�G??���Oloop��?
    if (e.getSource()==btLoop) {
       loop();
    }
    //�p�G??���Ostop��?
    if (e.getSource()==btStop) {
       stop();
    }
}
/**
 *<br>��k?���G����?��
 *<br>?�J??�G
 *<br>��^?���G
 */
public void play(){
      if (audio!=null) stop();
    audio.play();
}
/**
 *<br>��k?���G�`?����?��
 *<br>?�J??�G
 *<br>��^?���G
 */
public void loop(){
      if (audio!=null)
    audio.loop();
}
/**
 *<br>��k?���G�����?��
 *<br>?�J??�G
 *<br>��^?���G
 */
public void stop(){
      if (audio!=null)
          audio.stop();
      
}
} 