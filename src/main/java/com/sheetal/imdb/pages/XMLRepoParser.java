package com.sheetal.imdb.pages;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.openqa.selenium.By;

public class XMLRepoParser {

	public By getByElementFromRepo(String pageName, String loc) {
		String locatorType = null;
		String locatorValue = null;
		String repoFilePath="src/test/resources/or/IMDbRepo.xml";
		
		try {
			File repoXmlFile = new File(repoFilePath);

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory
					.newDocumentBuilder();
			Document document = documentBuilder.parse(repoXmlFile);
			document.getDocumentElement().normalize();

			NodeList nodeList = document.getElementsByTagName("PageNode");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node pageNode = nodeList.item(i);
				if ((pageNode.getAttributes().getNamedItem("name")
						.getTextContent().toString().equalsIgnoreCase(pageName))) {

					for (int j = 0; j < pageNode.getChildNodes().getLength(); j++) {
						if (!pageNode.getChildNodes().item(j).getNodeName()
								.toString().startsWith("#")) {
							if (pageNode.getChildNodes().item(j)
									.getAttributes().getNamedItem("name")
									.getTextContent().toString()
									.equalsIgnoreCase(loc)) {
								locatorType = pageNode.getChildNodes().item(j)
										.getAttributes()
										.getNamedItem("locator_type")
										.getTextContent().toString();
								locatorValue = pageNode.getChildNodes().item(j)
										.getAttributes()
										.getNamedItem("locator")
										.getTextContent().toString();
							}

						}

					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		By locator = null;

		if (locatorType.equalsIgnoreCase("Id")) {
			locator = By.id(locatorValue);
		} else if (locatorType.equalsIgnoreCase("Name")) {
			locator = By.name(locatorValue);
		} else if (locatorType.equalsIgnoreCase("CssSelector")) {
			locator = By.cssSelector(locatorValue);
		} else if (locatorType.equalsIgnoreCase("LinkText")) {
			locator = By.linkText(locatorValue);
		} else if (locatorType.equalsIgnoreCase("PartialLinkText")) {
			locator = By.partialLinkText(locatorValue);
		} else if (locatorType.equalsIgnoreCase("TagName")) {
			locator = By.tagName(locatorValue);
		} else if (locatorType.equalsIgnoreCase("Xpath")) {
			locator = By.xpath(locatorValue);
		} else if (locatorType.equalsIgnoreCase("ClassName")) {
			locator = By.className(locatorValue);
		}

		return locator;
	}
}