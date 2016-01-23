package base;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundEffect {
    private static Clip clip;
        
        public static void play(String filename)
        {
            try
            {
               clip = AudioSystem.getClip();
                File music = new File(filename);
               
                clip.open(AudioSystem.getAudioInputStream(music));
                clip.start();
            }
            catch (Exception exc)
            {
                exc.printStackTrace(System.out);
            }
        }
        public static void stop(Clip clip){
            clip.stop();
            clip.setFramePosition(0);
        }
        public static Clip getClip()
        {
            return clip;
        }
}