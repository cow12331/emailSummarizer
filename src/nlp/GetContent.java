package nlp;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GetContent {
	public ArrayList<String> getContent() {
		ArrayList<String> allContent = new ArrayList<String>();

		try {
			String emailContent = "";
			int count = 0;
			File f = new File("Accommodation.xml");
			SAXReader reader = new SAXReader();
			Document doc = reader.read(f);
			Element root = doc.getRootElement();
			for (Iterator i = root.elementIterator("thread"); i.hasNext();) {
				Element thread1 = (Element) i.next();
				for (Iterator i2 = thread1.elementIterator("DOC"); i2.hasNext();) {
					Element docc = (Element) i2.next();
					for (Iterator i3 = docc.elementIterator("Text"); i3
							.hasNext();) {
						Element text = (Element) i3.next();
						for (Iterator i4 = text.elementIterator("Sent"); i4
								.hasNext();) {
							Element sent = (Element) i4.next();
							if(!(sent.getText().substring(0, 1).equals(">"))
									&& !(sent.getText().substring(0,1).equals(" "))) {
								emailContent += sent.getText() + "\n";
							}
						}
					}
					allContent.add(emailContent);
					emailContent = "";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allContent;
	}
}
