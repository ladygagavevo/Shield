import java.applet.*;
import java.awt.event.*;  
import java.awt.*;
 
public class PlayAudio extends Applet 
implements ActionListener{
AudioClip audio;  
Button btExit,btOpen,btPlay,btLoop,btStop;
/**
 *<br>方法?明：初始化Applet
 *<br>?入??：
 *<br>返回?型：
 */
public void init() {
//加??音文件
 audio = getAudioClip(getDocumentBase(),"1.mp3");//?里放上你加在新建文件?里面的歌曲名?
//构造按?
 setLayout(new FlowLayout()); 
 btPlay=new Button("Play");                   
 btPlay.addActionListener(this); 
 btLoop=new Button("Loop"); 
 btLoop.addActionListener(this); 
 btStop=new Button("Stop"); 
 btStop.addActionListener(this); //?Play按?添加一??听事件
//?按?添加到Applet中
 add(btPlay);
 add(btLoop);
 add(btStop);
 
}
 
public void actionPerformed(ActionEvent e) {
 
  //如果??的是Play按?
    if (e.getSource()==btPlay) {
       play();
    }
    //如果??的是loop按?
    if (e.getSource()==btLoop) {
       loop();
    }
    //如果??的是stop按?
    if (e.getSource()==btStop) {
       stop();
    }
}
/**
 *<br>方法?明：播放?音
 *<br>?入??：
 *<br>返回?型：
 */
public void play(){
      if (audio!=null) stop();
    audio.play();
}
/**
 *<br>方法?明：循?播放?音
 *<br>?入??：
 *<br>返回?型：
 */
public void loop(){
      if (audio!=null)
    audio.loop();
}
/**
 *<br>方法?明：停止播放?音
 *<br>?入??：
 *<br>返回?型：
 */
public void stop(){
      if (audio!=null)
          audio.stop();
      
}
} 