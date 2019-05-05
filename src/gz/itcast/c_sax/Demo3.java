package gz.itcast.c_sax;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.List;

/**
 * 使用sax解析把xml文档封装成对象
 */
public class Demo3 {
    public static void main(String[] args) throws Exception {
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        MyDefaultHandler3 handler = new MyDefaultHandler3();
        parser.parse(new File("./src/contact.xml"),handler);
        List<Contact> list = handler.getList();
        for (Contact contact : list) {
            System.out.println(contact);
        }
    }
}
