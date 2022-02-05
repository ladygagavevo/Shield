import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.applet.*;
public class Sound
{
    public static void main(String args[])
    {
        new MusicWindow();
    }
 
}
 
 
class MusicWindow extends JFrame implements ActionListener
{
    JButton [] musicButton;
    File musicFile;
    URI uri;
    URL url;
    AudioClip clip;
    String[] musicName = {"1.wav"};
    MusicWindow()
    {
           musicButton = new JButton[2];
           Box musicBox = Box.createHorizontalBox();
         
            /*musicButton[0] = new JButton("play");
            musicButton[0].addActionListener(this);
            musicBox.add(musicButton[0]);
            musicButton[1] = new JButton("stop");
            musicButton[1].addActionListener(this);
            musicBox.add(musicButton[1]);*/
                          
                 musicFile = new File(musicName[0]);
                    uri = musicFile.toURI();
                    try
                    {
                        url = uri.toURL();
                    }
                    catch(Exception exp)
                    {
                    }
             
                    clip = Applet.newAudioClip(url);
                    clip.play();
        setLayout(new FlowLayout());
        add(musicBox);
        setBounds(120,125,250,150);
        //setVisible(true);

         
         
    }
    public void actionPerformed(ActionEvent e)
    {
        JButton button = (JButton)e.getSource();
        if ( clip != null)
            clip.stop();
             
         
        for ( int i = 0; i < musicButton.length; i++ )
        {
            if ( button == musicButton[0] )
            {
                
                for ( int j = 0; j < 3; j++ )
                {
                 
                    musicFile = new File(musicName[j]);
                    uri = musicFile.toURI();
                    try
                    {
                        url = uri.toURL();
                    }
                    catch(Exception exp)
                    {
                    }
             
                    clip = Applet.newAudioClip(url);
                    clip.play();
                     
                }
            }
            else
            {
                 clip.stop();
            }
                
                    
         }
    }
          
}
