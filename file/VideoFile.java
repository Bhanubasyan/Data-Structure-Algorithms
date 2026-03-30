import org.opencv.core.*;
import org.opencv.videoio.*;

public class VideoFile {
  static {
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
  }

  public static void main(String[] args) {

    VideoCapture camera = new VideoCapture(0); // 0 = default webcam

    if (!camera.isOpened()) {
      System.out.println("Camera not opened");
      return;
    }

    int width = 640;
    int height = 480;

    VideoWriter writer = new VideoWriter(
        "output.avi",
        VideoWriter.fourcc('M', 'J', 'P', 'G'),
        20,
        new Size(width, height));

    Mat frame = new Mat();

    System.out.println("Recording... Press any key to stop");

    while (true) {
      if (camera.read(frame)) {
        writer.write(frame);
      }

      if (System.in.available() > 0)
        break;
    }

    camera.release();
    writer.release();

    System.out.println("Video saved as output.avi");
  }
}