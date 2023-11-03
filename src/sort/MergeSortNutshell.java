package sort;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import static com.sun.deploy.cache.Cache.copyFile;

public class MergeSortNutshell {

    public static void mergesort (File A) throws IOException {
        File copy = File.createTempFile ("Mergesort", ".bin");
        copyFile(A, copy);
        RandomAccessFile src = new RandomAccessFile (A, "rw");
        RandomAccessFile dest = new RandomAccessFile (copy, "rw");
        FileChannel srcC = src.getChannel();
        FileChannel destC = dest.getChannel();
        MappedByteBuffer srcMap = srcC.map (FileChannel.MapMode.READ_WRITE,
                0, src.length());
        MappedByteBuffer destMap = destC.map (FileChannel.MapMode.READ_WRITE,
                0, dest.length());
        mergesort (destMap, srcMap, 0, (int) A.length());
        // The following two invocations are only needed on Windows platform:
        //closeDirectBuffer (srcMap);
        //closeDirectBuffer (destMap);
        src.close();
        dest.close();
        copy.deleteOnExit();
    }
    static void mergesort (MappedByteBuffer A, MappedByteBuffer result, int start, int end) throws IOException {
        if(end-start<8){
            return;
        }
        if(end-start==8){
            result.position (start);
            int left = result.getInt();
            int right = result.getInt();
            if (left > right) {
            result.position (start);
            result.putInt (right);
            result.putInt (left);
            }
            return;
        }
        int mid = (end + start)/8*4;
        mergesort (result, A, start, mid);
        mergesort (result, A, mid, end);
        result.position (start);
        for (int i = start, j = mid, idx=start; idx < end; idx += 4) {
            int Ai = A.getInt (i);
            int Aj=0;
            if(j<end){
                Aj=A.getInt(j);
            } if(j>=end||(i<mid&&Ai<Aj)){
                result.putInt (Ai);
                i+=4;
            }else{
                result.putInt (Aj);
                j+=4;
            }
        }
    }

    public static void main(String[] args) {

    }
}
