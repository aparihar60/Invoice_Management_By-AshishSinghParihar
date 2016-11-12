package com.impetus.invc_mgmt.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.impetus.invc_mgmt.bean.FileUploadForm;
import com.impetus.invc_mgmt.model.Client;
import com.impetus.invc_mgmt.model.Tenant;
import com.impetus.invc_mgmt.model.User;
import com.impetus.invc_mgmt.service.ClientService;
import com.impetus.invc_mgmt.util.ClientXMLParser;

public class FileUploadControllerTest {
	@Autowired
	private MockHttpServletRequest request;

	javax.servlet.http.HttpSession session;
	FileUploadController fileUploadController = new FileUploadController();

	@Test
	public void testDisplayForm() {
		assertEquals("fileupload", fileUploadController.displayForm());
	}

	/*
	 * @Test public void testSave() { FileUploadForm uploadForm = new
	 * FileUploadForm(); ClientService clientService =
	 * Mockito.mock(ClientService.class); this.request = new
	 * MockHttpServletRequest(); Model model = Mockito.mock(Model.class);
	 * this.session = (MockHttpSession) request.getSession();
	 * List<MultipartFile> files = new ArrayList<MultipartFile>(); MultipartFile
	 * multipartFile = Mockito.mock(MultipartFile.class);
	 * files.add(multipartFile); List<Client> clist = new ArrayList<Client>();
	 * ClientXMLParser clientXMLParser = Mockito.mock(ClientXMLParser.class);
	 * Mockito.when(clientXMLParser
	 * .retreiveClientListFromXML(multipartFile)).thenReturn(clist);
	 * ReflectionTestUtils.setField(fileUploadController, "clientService",
	 * clientService); User user = new User(); Tenant tenant = new Tenant();
	 * tenant.setTenantid(1); user.setTenant(tenant);
	 * session.setAttribute("user", user); uploadForm.setFiles(files);
	 * List<Client> clientlist = new ArrayList<Client>();
	 * Mockito.when(clientService.getAllClients(1)).thenReturn(clientlist);
	 * assertEquals("showclient", fileUploadController.save(uploadForm, model,
	 * session));
	 * 
	 * }
	 */
	@Test
	public void testSavetenantlogo() {
		FileUploadForm uploadForm = new FileUploadForm();
		ClientService clientService = Mockito.mock(ClientService.class);
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		this.session = (MockHttpSession) request.getSession();
		List<MultipartFile> files = new ArrayList<MultipartFile>();
		MultipartFile multipartFile = Mockito.mock(MultipartFile.class);
		uploadForm.setFileToUpload(multipartFile);
		ReflectionTestUtils.setField(fileUploadController, "clientService",
				clientService);
		User user = new User();
		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		assertEquals("edittenant",
				fileUploadController.savetenantlogo(uploadForm, model, session));
	}

}
