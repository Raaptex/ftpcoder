public class Main {

    public static void main(String[] args) {
        new FtpClient("192.168.1.224", 21, "debian", "root");
        FileWatcher fw = new FileWatcher("C:\\Users\\raptex\\Desktop\\code.txt", "/home/debian/code.txt");
        fw.run();
    }

}
