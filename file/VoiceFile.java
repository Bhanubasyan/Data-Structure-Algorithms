import javax.sound.sampled.*;
import java.io.File;

public class VoiceFile {

  public static void main(String[] args) {
    try {
      // Audio format define
      AudioFormat format = new AudioFormat(
          16000, // sample rate
          16, // sample size
          1, // mono
          true, // signed
          true // big endian
      );

      DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

      if (!AudioSystem.isLineSupported(info)) {
        System.out.println("Mic not supported");
        return;
      }

      TargetDataLine line = (TargetDataLine) AudioSystem.getLine(info);
      line.open(format);
      line.start();

      System.out.println("Recording... Speak now!");

      AudioInputStream audioStream = new AudioInputStream(line);

      File file = new File("output.wav");

      // Recording ko alag thread me chalate hain
      new Thread(() -> {
        try {
          AudioSystem.write(audioStream, AudioFileFormat.Type.WAVE, file);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }).start();

      // 5 sec record karo
      Thread.sleep(5000);

      line.stop();
      line.close();

      System.out.println("Recording saved!");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}