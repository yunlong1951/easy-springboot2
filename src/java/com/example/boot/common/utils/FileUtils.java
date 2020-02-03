package com.example.boot.common.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.example.boot.common.config.UploadPath;


public class FileUtils {
	
	/**
	 *  单个文件保存
	 * @param path 上传文件配置
	 * @param multRequest 文件内容 request
	 * @return 文件保存之后的路径
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static Map<String, String> saveFile(UploadPath path,MultipartRequest multRequest) throws IllegalStateException, IOException{
		//获取全部的文件
		Iterator it = multRequest.getFileNames();
		String staticPath = ""; //文件资源路径(文件展示路径 )
		String uploadPath = ""; //文件的上传路径 ( 真实路径 )
		Map<String, String> map = new HashMap<String, String>();
		int i = 0;
		//只循环一次, 只保存第一个文件
		while(it.hasNext()) {
			if(i>=1) {
				break;
			}
			MultipartFile file = multRequest.getFile(it.next().toString());
			if (file != null) {
				// 文件上传开始
				// 生成文件夹
				String folder = FileUtils.createFolderWithDate(path.getUploadFolder());
				//生成文件名
				String fileName = FileUtils.getRandomName(file.getOriginalFilename());
				uploadPath = folder + fileName;
				staticPath = path.getStaticPath()+DateUtils.dateToStr(new Date(), "yyyyMMdd")+"/"+fileName;
				file.transferTo(new File(uploadPath));
				
			}
			i++;
		}
		map.put("staticPath", staticPath);
		map.put("uploadPath", uploadPath);
		return map;
	}
	/**
	 * 上传多个文件
	 * @param path
	 * @param multRequest
	 * @return 
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static Map<String, Object> saveFiles(UploadPath path,MultipartRequest multRequest) throws IllegalStateException, IOException{
		//获取全部的文件
		Iterator it = multRequest.getFileNames();
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> staticList = new ArrayList<String>();
		List<String> uploadList = new ArrayList<String>();
		while(it.hasNext()) {
			MultipartFile file = multRequest.getFile(it.next().toString());
			if (file != null) {
				// 文件上传开始
				String staticPath = ""; //文件资源路径(文件展示路径 )
				String uploadPath = ""; //文件的上传路径 ( 真实路径 )
				// 生成文件夹
				String folder = FileUtils.createFolderWithDate(path.getUploadFolder());
				//生成文件名
				String fileName = FileUtils.getRandomName(file.getOriginalFilename());
				uploadPath = folder + fileName;
				staticPath = path.getStaticPath()+DateUtils.dateToStr(new Date(), "yyyyMMdd")+"/"+fileName;
				file.transferTo(new File(uploadPath));
				staticList.add(staticPath);
				uploadList.add(uploadPath);
			}
		}
		map.put("uploadList", uploadList);
		map.put("uploadList", uploadList);
		return map;
	}
	/**
	 *  根据原始的文件名生成随机文件名
	 * @param fileName
	 * @return
	 */
	public static String getRandomName(String fileName) {
		String type = FileUtils.getFileType(fileName);
		return CommonUtils.uuid()+type;
	}
	/**
	 *  根据日期创建文件夹
	 * @param rootPath 根目录
	 * @return 生成的路径
	 */
	public static String createFolderWithDate(String rootPath) {
		String folder = rootPath+DateUtils.dateToStr(new Date(), "yyyyMMdd")+"/";
		FileUtils.createFolder(folder);
		return folder;
	}
	public static void createFolder(String path) {
		File file = new File(path);
		if(!file.exists()&&!file.isDirectory()) {
			file.mkdirs();
		}
	}
	/**
	 * 
	 * @return 根据日期生成的目录
	 */
	public static String createFilePath() {
		String filePath = DateUtils.dateToStr(new Date(),"yyyyMMdd");
		return filePath;
	}
	public static String getFileType(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}
	public static void main(String[] args) {
		System.out.println(FileUtils.getFileType("gggg.mp4"));
	}
}
