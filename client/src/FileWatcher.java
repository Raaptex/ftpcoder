import java.io.File;
import java.util.Timer;

public class FileWatcher {
    public long timeStamp;
    public File file;
    public String rFile;

    public FileWatcher( String file, String r ) {
        this.file = new File(file);
        this.timeStamp = this.file.lastModified();
        this.rFile = r;
        System.out.println("FW Enabled");
    }

    public void run() {
        Timer timer = new Timer();
        timer.schedule(new FileWatcherTask(this),100, 100);
    }
}