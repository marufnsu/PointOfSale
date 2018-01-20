package pos;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class BeepSoundNotifier implements IPropertyListener {

    @Override
    public void onPropertyEvent(String name, String value) {
        if (name.equals("sale.total")) {
            InputStream in;
            try {
                in = new FileInputStream(new File("beep.wav"));
                AudioStream sound = new AudioStream(in);
                AudioPlayer.player.start(sound);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error coming from BeepSound Notifier class");
            }
        }
    }
}
