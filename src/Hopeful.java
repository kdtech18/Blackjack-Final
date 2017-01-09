import java.awt.*;
import java.util.Timer;

public class Hopeful {
    Toolkit toolkit;
    Timer timer;

    public Hopeful(int seconds)
    {
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new HelpHopeful(), seconds * 1000);
    }
}
