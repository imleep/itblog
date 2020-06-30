package edu.agic.itblog.contrller;

import edu.agic.itblog.entity.FileEty;
import edu.agic.itblog.model.ReturnModel;
import edu.agic.itblog.service.FileService;
import edu.agic.itblog.util.ReturnUtil;
import edu.agic.itblog.util.TokenUtil;
import edu.agic.itblog.util.UUIDUtil;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/27 0:48
 */
@Controller
@RequestMapping("/file")
public class FileController {

    String dirPattern = "yyyyMMdd";
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dirPattern);

    @Autowired
    FileService fileService;

    @Value("${uploadFile.location}")
    String rootPath;

    @PostMapping("/upload/{type}")
    @ResponseBody
    public ReturnModel upload(MultipartFile file, @PathVariable("type") String type, HttpServletRequest request) throws IOException {
        System.out.println(type);
        if (file == null) {
            System.out.println("文件内容为空");
            return ReturnUtil.get(5003, null);
        }

        // 获得用户userid
        String userid = "avatar".equalsIgnoreCase(type)?"831cfa267f8f56a0acbb9dde2cb67108":TokenUtil.parseToUserid(request.getHeader("token"));
        // 开始处理文件
        System.out.println(userid);
        if (file.getSize() > 0) {
            FileEty fileEty = process(userid, LocalDateTime.now(), file);
            // 判断路径
            File uploadDir = new File(rootPath + "/" + dtf.format(fileEty.getUploadtime()));
            if (!uploadDir.exists()) uploadDir.mkdirs();
            // 开始上传文件
            File uploadFile = new File(uploadDir.getAbsolutePath(), fileEty.getFileid() + "_" + fileEty.getFilename());
            file.transferTo(uploadFile);
            // 存入数据库
            fileService.insert(fileEty);
            return ReturnUtil.get(5000, fileEty);
        } else {
            return ReturnUtil.get(5001, null);
        }
    }

    @GetMapping("/download/{fileid}")
    public void download(@PathVariable("fileid") String fileid, HttpServletResponse response) throws IOException {
        // 从数据库获取文件信息
        FileEty fileEty = fileService.selectOneByFileid(fileid);
        // 获取文件的真实路径
        File file = new File(rootPath + "/" +  dtf.format(fileEty.getUploadtime())+ "/" + fileEty.getFileid() + "_" + fileEty.getFilename());
        FileInputStream fileInputStream = new FileInputStream(file);
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileEty.getFilename(), "UTF-8"));
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.copy(fileInputStream, outputStream);
        IOUtils.closeQuietly(fileInputStream);
        IOUtils.closeQuietly(outputStream);
    }

    private FileEty process(String userid, LocalDateTime now, MultipartFile multipartFile) {
        // 创建文件返回FileEty对象
        String fileid = UUIDUtil.get();
        String filetype = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        String filename = multipartFile.getOriginalFilename();
        Long size = multipartFile.getSize();
        FileEty fileEty = new FileEty(fileid, filetype, filename, userid, size, now);
        return fileEty;
    }


}