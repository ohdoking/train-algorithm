package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestFolders {

	
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testSimple() throws Exception {
		
		String xml =
	            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
	            "<folder name=\"c\">" +
	                "<folder name=\"program files\">" +
	                    "<folder name=\"uninstall information\" />" +
	                "</folder>" +
	                "<folder name=\"users\" />" +
	            "</folder>";
		
		Collection<String> collection = new HashSet<String>();
		collection.add("uninstall information");
		collection.add("users");
		assertEquals(collection, Folders.folderNames(xml, 'u'));
		
	}
	
	@Test
	void testComplicate() throws Exception {
		
		String xml =
	            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
	            "<folder name=\"c\">" +
	                "<folder name=\"program files\">" +
	                	"<folder name=\"arogram files\">" +
		                	"<folder name=\"arogram files\">" +
			                    "<folder name=\"uninstall information\" />" +
			                    "<folder name=\"aninstall information\" />" +
			                    "<folder name=\"aninstall information\" />" +
			                    "<folder name=\"aninstall information\" />" +
			                    "<folder name=\"aninstall information\" />" +
			                    "<folder name=\"uuuninstall information\" />" +
		                    "</folder>" +
		                "</folder>" +
	                "</folder>" +
	                "<folder name=\"users\" />" +
	                "<folder name=\"asers\" />" +
	                "<folder name=\"asers\" />" +
	                "<folder name=\"asers\" />" +
	                "<folder name=\"asers\" />" +
	                "<folder name=\"asers\" />" +
	                "<folder name=\"asers\" />" +
	                "<folder name=\"ussdf\" />" +
	            "</folder>";
		
		Collection<String> collection = new HashSet<String>();
		collection.add("uninstall information");
		collection.add("users");
		collection.add("ussdf");
		collection.add("uuuninstall information");
		assertEquals(collection, Folders.folderNames(xml, 'u'));
		
	}
	
	@Test
	void testDuplicate() throws Exception {
		
		String xml =
	            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
	            "<folder name=\"c\">" +
	                "<folder name=\"program files\">" +
	                    "<folder name=\"uninstall information\" />" +
	                "</folder>" +
	                "<folder name=\"users\" />" +
	                "<folder name=\"users\" />" +
	            "</folder>";
		
		Collection<String> collection = new HashSet<String>();
		collection.add("uninstall information");
		collection.add("users");
		assertEquals(collection, Folders.folderNames(xml, 'u'));
		
	}

}
