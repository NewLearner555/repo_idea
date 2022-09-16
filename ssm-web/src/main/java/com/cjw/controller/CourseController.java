package com.cjw.controller;

import com.cjw.domain.Course;
import com.cjw.domain.CourseVO;
import com.cjw.domain.ResponseResult;
import com.cjw.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/findCourseByCondition")
    public ResponseResult findCourseByCondition(@RequestBody CourseVO courseVO){
        List<Course> courseByCondition = courseService.findCourseByCondition(courseVO);

        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", courseByCondition);

        return responseResult;
    }

    /*
        课程图片上传
     */
    @RequestMapping("/courseUpload")
    public ResponseResult fileUpload(@RequestParam("File")MultipartFile File, HttpServletRequest request) throws IOException {


        if(File.isEmpty()){
            throw new RuntimeException();
        }

        String realPath = request.getServletContext().getRealPath("/");
        //截取到 webapps目录路径
        String substring = realPath.substring(0, realPath.indexOf("ssm-web"));


        //获取上传文件的原始文件名
        String originalFilename = File.getOriginalFilename();

        //防止重复，生成新文件名
        //使用 UUID 或者 当前时间 都可以
        String newFileName = System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));
        //System.out.println(newFileName);


        String uploadPath= substring+"upload\\";
        File filePath = new File(uploadPath, newFileName);
        //System.out.println(filePath);


        if(!filePath.getParentFile().exists()){
            filePath.getParentFile().mkdirs();
            System.out.println("创建目录" +filePath);
        }
        //图片就进行了真正的上传
        File.transferTo(filePath);

        //将文件名和文件路径 返回，进行响应
        Map<String, String> map = new HashMap<>();
        map.put("fileName",newFileName);
        map.put("filePath","http://localhost:8080/upload/"+ newFileName);
        //map.put("filePath",substring+"upload/"+ newFileName);

        ResponseResult responseResult = new ResponseResult(true, 200, "图片上传成功", map);
        return responseResult;
    }
}
