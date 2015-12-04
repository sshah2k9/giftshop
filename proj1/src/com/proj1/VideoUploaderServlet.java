package com.proj1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.proj1.adapters.ItemAdapter;
import com.proj1.model.Item;
import com.proj1.utils.Utilities;

/**
 * Servlet implementation class VideoUploaderServlet
 */
@WebServlet("/VideoUploaderServlet")
public class VideoUploaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String filePath;
	private String fileNamePrefix = "vFile_";
	private int MAX_FILE_SIZE;
	private int MAX_REQUEST_SIZE;
	private static Gson gson = (new GsonBuilder()).create();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VideoUploaderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Actions
	// ------------------------------------------------------------------------------------

	public void init() throws ServletException {

		if (Utilities.isWindows()) {
			this.filePath = "C:\\My_data\\junk\\";
		} else if (Utilities.isMac()) {
			this.filePath = "/Users/Sunil/projects/project1/data/";
		} else {
			this.filePath = System.getenv("OPENSHIFT_DATA_DIR");
		}

		MAX_FILE_SIZE = 1024 * 1024 * 40; // 40 MB
		MAX_REQUEST_SIZE = 1024 * 1024 * 42; // 42 MB

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!ServletFileUpload.isMultipartContent(request)) {
			// if not, we stop here
			PrintWriter writer = response.getWriter();
			writer.println("Error: Form must have enctype=multipart/form-data.");
			writer.flush();
			return;
		}

		// configures upload settings
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// sets temporary location to store files
		// factory.setRepository(new
		// File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);

		// sets maximum size of upload file
		upload.setFileSizeMax(MAX_FILE_SIZE);

		// sets maximum size of request (include file + form data)
		upload.setSizeMax(MAX_REQUEST_SIZE);

		// creates the directory if it does not exist
		File uploadDir = new File(filePath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		JsonObject jsonObject = new JsonObject();
		try {
			List<FileItem> formItems = upload.parseRequest(request);

			if (formItems != null && formItems.size() > 0) {
				// iterates over form's fields
				for (FileItem item : formItems) {
					// processes only fields that are not form fields
					if (!item.isFormField()) {
						String extension = FilenameUtils.getExtension(item.getName());
						String fileName = fileNamePrefix + System.nanoTime() + "." + extension;
						File storeFile = new File(filePath + fileName);
						item.write(storeFile);
						jsonObject.addProperty("fileName", fileName);
						response.setContentType("application/json");
						response.getOutputStream().print(gson.toJson(jsonObject));
					}
				}
			}
		} catch (Exception ex) {
			request.setAttribute("message", "There was an error: " + ex.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
