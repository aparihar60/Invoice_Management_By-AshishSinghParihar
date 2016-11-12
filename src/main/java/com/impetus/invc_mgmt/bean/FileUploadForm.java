package com.impetus.invc_mgmt.bean;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

// TODO: Auto-generated Javadoc
/**
 * The Class FileUploadForm consist the attributes of file upload and their
 * getter/setter.
 */
public class FileUploadForm {

	/** The files. */
	private List<MultipartFile> files;

	/** The file to upload. */
	private MultipartFile fileToUpload;

	// getter setter
	/**
	 * Gets the file to upload.
	 * 
	 * @return the file to upload
	 */
	public MultipartFile getFileToUpload() {
		return fileToUpload;
	}

	/**
	 * Sets the file to upload.
	 * 
	 * @param fileToUpload
	 *            the new file to upload
	 */
	public void setFileToUpload(MultipartFile fileToUpload) {
		this.fileToUpload = fileToUpload;
	}

	/**
	 * Gets the files.
	 * 
	 * @return the files
	 */
	public List<MultipartFile> getFiles() {
		return files;
	}

	/**
	 * Sets the files.
	 * 
	 * @param files
	 *            the new files
	 */
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

}
