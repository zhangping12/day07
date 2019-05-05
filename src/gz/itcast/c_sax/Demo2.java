package gz.itcast.c_sax;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * 读取contact.xml文件，完整输出文档内容
 */
public class Demo2 {
    public static void main(String[] args) throws Exception {
        //1.创建SAXParser对象
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        MyDefaultHandler2 handler = new MyDefaultHandler2();
        //2.读取xml文件
        parser.parse(new File("./src/contact.xml"),handler);
        String content = handler.getContent();
        System.out.println(content);
    }
}
