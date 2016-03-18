package com.olivebranch.xpath.html;

import com.google.common.io.Resources;
import com.olivebranch.xpath.Query;
import com.olivebranch.xpath.Text;
import org.junit.Test;
import org.xml.sax.InputSource;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Find a div button in html document using various methods.
 *
 * @author Benjamin Paige
 */
public class DivButton {

    @Test
    public void findByTextAlone() throws  Exception {

        String html = new String(Files.readAllBytes(Paths.get(Resources.getResource("FakePage.html").toURI()))
        , Charset.defaultCharset());

        XPath xPath =  XPathFactory.newInstance().newXPath();

        String content = xPath.compile(Text.where("Approve").isPresent().query()).evaluate(new InputSource(new StringReader(html)));
    }

    @Test
    public void findByTextInDiv() throws Exception {
        String html = new String(Files.readAllBytes(Paths.get(Resources.getResource("FakePage.html").toURI()))
        , Charset.defaultCharset());

        XPath xPath =  XPathFactory.newInstance().newXPath();

        String content = xPath.compile(new Query("//div").query()).evaluate(new InputSource(new StringReader(html)));
    }
}
