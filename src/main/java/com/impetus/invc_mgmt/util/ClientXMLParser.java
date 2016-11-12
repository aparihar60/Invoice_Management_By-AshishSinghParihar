package com.impetus.invc_mgmt.util;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.impetus.invc_mgmt.model.Client;

// TODO: Auto-generated Javadoc
/**
 * The Class ClientXMLParser is responsible for parsing the xml file(which
 * consist the multiple client data) of client list.
 */
public class ClientXMLParser {

	/** The logger. */
	private static Logger logger = Logger.getLogger(ClientXMLParser.class);
	/** The clist. */
	private List<Client> clist = new ArrayList<Client>();

	/**
	 * Retreive client list from xml.
	 * 
	 * @param xmlFile
	 *            the xml file
	 * @return the list
	 */
	public List<Client> retreiveClientListFromXML(MultipartFile xmlFile) {

		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile.getInputStream());

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("client");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					Client c1 = new Client();

					c1.setClientfname(eElement
							.getElementsByTagName("clientfname").item(0)
							.getTextContent());

					c1.setClientlname(eElement
							.getElementsByTagName("clientlname").item(0)
							.getTextContent());

					c1.setClientaddress(eElement
							.getElementsByTagName("clientaddress").item(0)
							.getTextContent());

					c1.setClientemail(eElement
							.getElementsByTagName("clientemail").item(0)
							.getTextContent());

					c1.setClientcompany(eElement
							.getElementsByTagName("clientcompany").item(0)
							.getTextContent());

					c1.setClientcontactno(Long.valueOf(eElement
							.getElementsByTagName("clientcontactno").item(0)
							.getTextContent()));

					clist.add(c1);

				}
				return clist;
			}
		} catch (Exception e) {
			logger.info("xml not correct");
			

		}

		return null;
	}

}
