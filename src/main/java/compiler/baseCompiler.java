package compiler;/**
 * @Auther: wAnG
 * @Date: 2021/10/23 00:59
 * @Description:
 */

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 *
 *@description:
 *@author: wAnG
 *@time: 2021/10/23 12:59 上午
 *
 */


public abstract class baseCompiler implements Compiler {

    static JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

}
