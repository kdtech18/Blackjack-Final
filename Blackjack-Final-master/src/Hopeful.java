import java.awt.*;
import java.util.Timer;

/**
 * Created by AustinP11 on 1/8/17.
 */
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
