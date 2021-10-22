package compiler;/**
 * @Auther: wAnG
 * @Date: 2021/10/23 00:58
 * @Description:
 */

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.List;

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
    public void compilerToLocal(String fileUrl,String desc) {
        StandardJavaFileManager standardFileManager = compiler.getStandardFileManager(null, null, null);

        Iterable<? extends JavaFileObject> iterable = standardFileManager.getJavaFileObjects(new File(fileUrl));

        // 编译参数 把结果文件生成与原文件同一个目录
        List<String> options = Arrays.asList("-d", desc);
        // 注解处理器的 类
        List<String> classes = null;
        // 创建一个编译任务
        JavaCompiler.CompilationTask task = compiler.getTask(null, standardFileManager, null, options, classes, iterable);
        //JavaCompiler.CompilationTask 实现了 Callable 接口
        Boolean result = task.call();
        System.out.println(result ? "成功" : "失败");
    }
}
