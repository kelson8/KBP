package me.Kelson.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;

public class FTPClient {
	private URLConnection client;
	private String host;
	private String username;
	private String password;
    private String remoteFile;
    private String error;
    private String success;

    public FTPClient(String host, String username, String password){
    	this.host = host;
    	this.username = username;
    	this.password = password;
    }
    public FTPClient(){
    	
    }
    
    public void setHost(String host){
    	this.host = host;
    }
    
    public void setUser(String username){
    	this.username = username;
    }
    
    public void setPassword(String password){
    	this.password = password;
    }
    
    public void setRemoteFile(String file){
    	remoteFile = file;
    }
    
    public synchronized String getSucMsg(){
    	if(success != null)
    		return success;
    	return null;
    }
    
    public synchronized String getErrMsg(){
    	if(error != null)
    		return error;
    	return null;
     }
    
    public synchronized boolean uploadFile(String fileLoc){
    	try {
    		InputStream is = new FileInputStream(fileLoc);
    		@SuppressWarnings("resource")
			BufferedInputStream bis = new BufferedInputStream(is);
    		OutputStream os = client.getOutputStream();
    		BufferedOutputStream bos = new BufferedOutputStream(os);
    		
    		byte[] buffer = new byte[1024];
    		
    		int count;
    		while((count = bis.read(buffer)) > 0)
    			bos.write(buffer, 0, count);
    		bos.close();
    		success="Uploaded!";
    		return true;
    	} catch(Exception e){
    		StringWriter sw = new StringWriter();
    		PrintWriter pw = new PrintWriter(sw, true);
    		e.printStackTrace(pw);
            error = sw.getBuffer().toString();
            return false;
    	}
    }
    
    public synchronized boolean downloadFile(String fileLoc){
    	try {
    	InputStream is = client.getInputStream();
		BufferedInputStream bis = new BufferedInputStream(is);
		OutputStream os = new FileOutputStream(fileLoc);
		BufferedOutputStream bos = new BufferedOutputStream(os);
		
		byte[] buffer = new byte[1024];
		
		int count;
		while ((count = bis.read(buffer)) > 0)
			bos.write(buffer, 0, count);
		bos.close();
		is.close();
		success="Downloaded!";
		
		return true;
    	} catch(Exception e){
    		StringWriter sw = new StringWriter();
    		PrintWriter pw = new PrintWriter(sw, true);
    		e.printStackTrace(pw);
            error = sw.getBuffer().toString();
            return false;
    	}
    }
    public synchronized boolean connect(){
    	try {
    		URL url = new URL("ftp://" + username + ":" + password + "@"+ host 
    				+ "/" + remoteFile + ";type=i");
    		client = url.openConnection();
    		return true;
    	} catch(Exception e){
    		StringWriter sw = new StringWriter();
    		PrintWriter pw = new PrintWriter(sw, true);
    		e.printStackTrace(pw);
            error = sw.getBuffer().toString();
            return false;
    	}
    }
}
