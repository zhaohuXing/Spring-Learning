package com.sprint.resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.InputStreamResource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;

public class ResourceTest {
	@Test
	public void testByteArrayResource() {
		//可以读取多次,所以每次都是false
		Resource resource = new ByteArrayResource("Hello World".getBytes());
		if (resource.exists()) {
			dumpStream(resource);
		}
		Assert.assertEquals(false, resource.isOpen());
	}

	@Test
	public void testInputStreamResource() {
		//只读取一次,所以是true
		ByteArrayInputStream bis = new ByteArrayInputStream("Hello World".getBytes());
		Resource resource = new InputStreamResource(bis);	
		if (resource.exists()) {
			dumpStream(resource);	
		}
		Assert.assertEquals(true, resource.isOpen());
	}

	@Test
	public void testFileSystemResource() {
		//读取多次，所以是false	
		File file = new File("desgin.txt");	
		Resource resource = new FileSystemResource(file);
		if (resource.exists()) {
			dumpStream(resource);			
		}
		Assert.assertEquals(false, resource.isOpen());
	}

	@Test
	public void testClasspathResourceByDefaultClassLoader() throws IOException {
		//为啥不输出
		Resource resource = new ClassPathResource("test.properties");
		if (resource.exists()) {
			dumpStream(resource);
		}

		Assert.assertEquals(false, resource.isOpen());
	}

	@Test
	public void testClasspathResourceByClassLoader() throws IOException {
		//为啥不输出呢
		ClassLoader cl = this.getClass().getClassLoader();
		Resource resource = new ClassPathResource("test.txt", cl);
		if (resource.exists()) {
			dumpStream(resource);
		}
		System.out.println("path:" + resource.getFile().getAbsolutePath());
		Assert.assertEquals(false, resource.isOpen());
	}

	@Test
	public void testClasspathResourceByClass() throws IOException {
		//为什么不输出呢
		Class clazz = this.getClass();
		Resource resource = new ClassPathResource("test.txt", clazz);
		if (resource.exists()) {
			dumpStream(resource);
		}
		Assert.assertEquals(false, resource.isOpen());
	}


	private void dumpStream(Resource resource) {
		InputStream is = null;
		try {
			is = resource.getInputStream();	
			byte[] descBytes = new byte[is.available()];
			is.read(descBytes);		
			System.out.println(new String(descBytes));
		} catch (IOException e) {
			e.printStackTrace();				
		} finally {
			try {
				//关闭资源
				is.close();
			} catch (IOException e) {
					
			}	
		} 

	}


}
