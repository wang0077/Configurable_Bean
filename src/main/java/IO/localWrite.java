package IO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 *@description:
 *@author: wAnG
 *@time: 2021/10/23 12:50 上午
 *
 */


public class localWrite implements Write{

    private static  String SUFFIX = "java";

    private static final String DELIMITER = ".";

    private int bufferSize = 1024;

    ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
    @Override
    public boolean write(String context, String URL,String filName) {

        boolean Success = false;
        FileChannel channel = null;

        FileOutputStream outputStream = null;
        try {
            File file = new File(filName + DELIMITER + SUFFIX);
            outputStream = new FileOutputStream(file);
            channel = outputStream.getChannel();
            buffer.put(context.getBytes());
            buffer.flip();
            int writeSize = channel.write(buffer);
            Success = writeSize != 0;

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(channel != null){
                    channel.close();
                }
                if(outputStream != null){
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Success;
    }


    public void setBufferSize(int size){
        this.bufferSize = size;
        this.buffer = ByteBuffer.allocate(size);
    }

    public static void setSUFFIX(String SUFFIX) {
        localWrite.SUFFIX = SUFFIX;
    }
}
