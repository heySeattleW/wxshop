package com.bjdvt.platform.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.imageio.ImageIO;


import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;

public class MyFileUtils {
	
	public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
	/**
     * 获取文件后缀
     * @param fileName
     * @return
     */
    public static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成新的文件名
     * @param fileOriginName 源文件名
     * @return
     */
    public static String getNewFileName(String fileOriginName){
        return getUUID() + getSuffix(fileOriginName);
    }
	 public static boolean upload(MultipartFile file, String path, String fileName){

	       
	        String realPath = path + "/" + fileName;
	        String lessrealPath = path + "/less." + fileName;
	        File dest = new File(realPath);

	        //判断文件父目录是否存在
	        if(!dest.getParentFile().exists()){
	            dest.getParentFile().mkdir();
	        }

	        try {
	            //保存文件
	        	System.out.println("filename="+realPath);
	        	
	            file.transferTo(dest);
	           
	            compressImage(realPath,lessrealPath);
	            return true;
	        } catch (IllegalStateException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            return false;
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            return false;
	        }

	    }
	 private static void compressImage(String realPath,String tofileName) {
		
         try {
        	 BufferedImage sourceImg =ImageIO.read(new FileInputStream(realPath)); 
	            if(sourceImg.getWidth()>600) {
	            	double scale=600.0/sourceImg.getWidth();
	            	Thumbnails.of(realPath).scale(scale).outputQuality(1.0).toFile(tofileName);
	            }
         }
         catch(Exception e) {
        	 e.printStackTrace();
         }
	 }
	 public static byte[] readFileToByteArray(File file) throws IOException {  
		
         InputStream in = null;  

         try {  

             in = openInputStream(file);  
             
             byte buffer[]=new byte[in.available()]; 
             //IOUtils.readFully(in, buffer);
             return buffer;

         } finally {  

           //  IOUtils.closeQuietly(in);  

         }  

     }  
	 public static FileInputStream openInputStream(File file) throws IOException {  

         if (file.exists()) {  

             if (file.isDirectory()) {  

                 throw new IOException("File '" + file + "' exists but is adirectory");  

             }  

             if (file.canRead() == false) {  

                 throw new IOException("File '" + file + "' cannot be read");  

             }  

         } else {  

             throw new FileNotFoundException("File '" + file + "' does notexist");  

         }  

         return new FileInputStream(file);  

     }  
	 

}
