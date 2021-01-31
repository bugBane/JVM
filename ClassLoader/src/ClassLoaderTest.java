import java.io.IOException;
import java.io.InputStream;

/*
    小试牛刀：自构建类加载器
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {
        Object object = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        }.loadClass("ClassLoaderTest").getDeclaredConstructor().newInstance();
        System.out.println(object.getClass().toString());
        // 不同的类加载器对instanceof关键字运算的结果的影响
        System.out.println(object instanceof ClassLoaderTest);
    }
}
