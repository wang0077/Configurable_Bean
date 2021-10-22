package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Auther: wAnG
 * @Date: 2021/10/23 00:40
 * @Description:
 */
public class localRead implements  Reader{


    @Override
    public String reader(String URL) {
        StringBuilder s = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(URL);
            FileChannel channel = fileInputStream.getChannel();
            // 创建缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            // 读取数据到缓冲区
            channel.read(buffer);
            buffer.flip();
            s = new StringBuilder();
            while (buffer.remaining() > 0) {
                byte b = buffer.get();
                s.append((char)b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s == null ? null : s.toString();
    }
}
