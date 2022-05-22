import java.io.File;
import java.util.TimerTask;

public class FileWatcherTask extends TimerTask {

    private long timeStamp;
    private File file;
    private FileWatcher fileWatcher;

    public FileWatcherTask(FileWatcher fw){
        fileWatcher = fw;
        timeStamp = fw.timeStamp;
        file = fw.file;
    }

    public void run() {
        try {

            long timeStamp = file.lastModified();

            if( this.timeStamp != timeStamp ) {
                System.out.println("File edited !");
                this.timeStamp = timeStamp;
                FtpClient.UploadFile(file.getPath(), fileWatcher.rFile);
                System.out.println("New file uploaded");
            }

        } catch (Exception ex) {
            System.out.println("error running thread " + ex.getMessage());
        }
    }

}
