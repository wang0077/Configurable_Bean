package IO;/**
 * @Auther: wAnG
 * @Date: 2021/10/23 00:50
 * @Description:
 */

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

    private static final String SUFFIX = "java";

    private static final String DELIMITER = ".";

    @Override
    public boolean write(String context, String URL,String filName) {

        boolean Success = false;

        try {
            File file = new File(filName + DELIMITER + SUFFIX);
            FileOutputStream outputStream = new FileOutputStream(file);
            FileChannel channel = outputStream.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            String string = "java nio";
            buffer.put(string.getBytes());
            buffer.flip();
            int writeSize = channel.write(buffer);
            Success = writeSize != 0;
            channel.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Success;
    }
}
