package gz.itcast.a_dom4j_write;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;


import java.io.File;
import java.io.FileOutputStream;

/**
 * 修改xml内容
 * 增加：文档，标签，属性
 * 修改：属性值，文本
 * 删除：标签，属性
 */
public class Demo3 {

    /**
     * 增加：文档，标签，属性
     */
    @Test
    public void test1() throws Exception {
        /**
         * 1、创建文档
         */
        Document doc = DocumentHelper.createDocument();
        /**
         * 2、增加标签
         */
        Element rootElem = doc.addElement("contactList");
        Element contactElem = rootElem.addElement("contact");
        contactElem.addElement("name");
        /**
         * 3.增加属性
         */
        contactElem.addAttribute("id","001");
        contactElem.addAttribute("name","eric");

        //把修改后的Document对象写出到xml文档中
        FileOutputStream out = new FileOutputStream("d://contact.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(out);
        writer.write(doc);
        writer.close();
    }

    /**
     * 修改：属性值，文本
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        Document doc = new SAXReader().read(new File("./src/contact.xml"));
        /**
         * 方案一：修改属性值 1、得到标签对象 2、得到属性对象 3、修改属性值
         */
        /*//1.1 得到标签对象
        Element contactElem = doc.getRootElement().element("contact");
        //1.2 得到属性对象
        Attribute idAttr = contactElem.attribute("id");
        //1.3修改属性值
        idAttr.setValue("003");*/
        /**
         * 方案二：修改属性值
         */
        //1.1 得到标签对象
       /* Element contactElem = doc.getRootElement().element("contact");
        contactElem.addAttribute("id","004");*/

        /**
         * 修改文本 1.得到标签对象 2.修改文本
         */
        Element nameElem = doc.getRootElement().element("contact").element("name");
        nameElem.setText("李四");

        FileOutputStream out = new FileOutputStream("d://contact.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(out,format);
        writer.write(doc);
        writer.close();
    }

    /**
     * 删除：标签，属性
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {
        Document doc = new SAXReader().read(new File("./src/contact.xml"));
        /**
         * 1.删除标签  1.1 得到标签对象 1.2删除标签对象
         */
       /* //1.1 得到标签对象
        Element ageElem = doc.getRootElement().element("contact").element("age");
        //1.2删除标签对象
        ageElem.detach();
        //ageElem.getParent().remove(ageElem);*/

        /**
         * 2.删除属性 2.1 得到属性对象 2.2删除属性
         */
        //2.1 得到属性对象
        //得到第二个contact标签
         Element contactElem = (Element) doc.getRootElement().elements().get(1);
        //2.2得到属性对象
        Attribute idAttr = contactElem.attribute("id");
        //2.3删除属性
        idAttr.detach();
//        idAttr.getParent().remove(idAttr);

        FileOutputStream out = new FileOutputStream("d://contact.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(out,format);
        writer.write(doc);
        writer.close();
    }
}
