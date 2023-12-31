package kr.co.th.dogCat.common.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;

public class FileUtil {

	public static boolean fileUpload(HttpServletRequest request, MultipartRequest multi) {
		try {
			
			Enumeration<?> files = multi.getFileNames();

			String element = ""; //
			String filesystemName = "";
			String originalFileName = "";
			String contentType = "";
			long length = 0;

			if(null != multi.getFile(element)){
	            if (files.hasMoreElements()) { // 다음 정보가 있으면 Like rs.next()

	                element = (String)files.nextElement(); // file을 반환

	                filesystemName 			= multi.getFilesystemName(element); // 서버에 업로드된 파일명을 반환
	                originalFileName 		= multi.getOriginalFileName(element); // 사용자가 업로드한 파일명을 반환
	                contentType 			= multi.getContentType(element);	// 업로드된 파일의 타입을 반환
	                length 					= multi.getFile(element).length(); // 파일의 크기를 반환 (long타입)
	            }
	        }else {
	        	return false;
	        }
			
		
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
		return true;
		
	}
	
	

}
