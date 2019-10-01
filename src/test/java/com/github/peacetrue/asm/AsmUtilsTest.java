package com.github.peacetrue.asm;

import com.github.peacetrue.util.ClassLoaderUtils;
import org.junit.Assert;
import org.junit.Test;
import org.objectweb.asm.commons.Method;


/**
 * @author xiayx
 */
public class AsmUtilsTest {

    @Test
    public void printContentByString() {
        AsmUtils.printContent(AsmUtilsTest.class.getName());
    }

    @Test
    public void printContentByByteArray() {
        AsmUtils.printContent(ClassLoaderUtils.loadClass(AsmUtilsTest.class.getName()));
    }

    @Test
    public void write() throws Exception {
        byte[] classBytecode = ClassLoaderUtils.loadClass("com.github.peacetrue.asm.AsmUtils");
        AsmUtils.write("com.github.peacetrue", "Generated", classBytecode);
        byte[] generatedClassBytecode = ClassLoaderUtils.loadClass("com.github.peacetrue.Generated");
        Assert.assertArrayEquals(classBytecode, generatedClassBytecode);
    }

    @Test
    public void writeByClassName() throws Exception {
        byte[] classBytecode = ClassLoaderUtils.loadClass("com.github.peacetrue.asm.AsmUtils");
        String className = "com.github.peacetrue.Generated";
        AsmUtils.write(className, classBytecode);
        byte[] generatedClassBytecode = ClassLoaderUtils.loadClass(className);
        Assert.assertArrayEquals(classBytecode, generatedClassBytecode);
    }


    @Test
    public void replaceStatic() throws Exception {
        String source = "com.github.peacetrue.asm.Source";
        byte[] bytes = AsmUtils.replaceStatic(
                source,
                "com.github.peacetrue.asm.Target",
                Method.getMethod("void print1(String)"),
                Method.getMethod("String print2(String)"));
        ClassLoaderUtils.defineClass(source, bytes);
        String name = "i have changed";
        Source.print1(name);
        Assert.assertEquals("logger:" + name, Source.print2(name));
    }


}
