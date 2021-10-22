package compiler;/**
 * @Auther: wAnG
 * @Date: 2021/10/23 00:58
 * @Description:
 */

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 *
 *@description:
 *@author: wAnG
 *@time: 2021/10/23 12:58 上午
 *
 */


public class JavaBeanCompiler implements Compiler{

    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

    @Override
    public void compiler(String fileUrl) {
        compiler.run(null,null,null,fileUrl);
        URL[] urls = new URL[0];
        try {
            urls = new URL[] {new URL("file:/"+fileUrl)};
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        URLClassLoader loader = new URLClassLoader(urls);
    }
}
