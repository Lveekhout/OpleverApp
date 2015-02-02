package nl.lveekhout.files;

import com.sun.deploy.util.SyncFileAccess;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/**
 * Created by leekhout on 20-1-2015.
 * class TestFileChannel
 */

public class TestFileChannel {
    FileLock fileLock;

    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            TestFileChannel testFileChannel = new TestFileChannel();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public TestFileChannel() throws IOException, InterruptedException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("C:\\Temp\\17_Opleveren\\TEST.xls", "rw");
        fileLock = randomAccessFile.getChannel().tryLock();
        if (fileLock!=null) {
            System.out.println("File locked");
        } else {
            System.out.println("File failed to lock");
        }
        fileLock.release();
        randomAccessFile.close();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        fileLock.release();
        System.out.println("finalize");
    }
}
