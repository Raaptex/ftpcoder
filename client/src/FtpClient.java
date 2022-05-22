import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;

public class FtpClient {

    private static FTPClient ftpClient;

    public FtpClient(String s, int p, String u, String p_) {
        ftpClient = new FTPClient();
        try {

            ftpClient.connect(s, p);
            ftpClient.login(u, p_);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void UploadFile(String localFile, String remoteFile) throws IOException {
        File firstLocalFile = new File(localFile);
        InputStream inputStream = new FileInputStream(firstLocalFile);
        boolean done = ftpClient.storeFile(remoteFile, inputStream);
        inputStream.close();
    }

    public static void DownloadFile(String localFile, String remoteFile) throws IOException {
        File downloadFile1 = new File(localFile);
        OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
        boolean success = ftpClient.retrieveFile(remoteFile, outputStream1);
        outputStream1.close();
    }

}
