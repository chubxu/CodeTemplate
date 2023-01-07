package org.chubxu.easyexcel.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import org.chubxu.easyexcel.domain.Student;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName EasyexcelController
 * @Description Eaxyexcel操作接口
 * @Since 1.0.0
 * @Date 2022/12/21 22:01
 * @Author chubxu
 */
@RestController
@RequestMapping("/easyexcel")
public class EasyexcelController {

    @GetMapping("/download")
    public void download(HttpServletResponse response) {
        try {
            // 准备数据
            List<Student> studentList = new ArrayList<>(10);
            for (int i = 0; i < 10; i++) {
                Student s = new Student();
                s.setAge(i * 10 + 1);
                s.setName("name" + i);
                s.setAddress("address" + i);
                studentList.add(s);
            }

            // 设置响应
            response.setContentType("application/vnd.excel");
            response.setCharacterEncoding("utf-8");
            String fileName = URLEncoder.encode("file", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

            // 写入数据
            EasyExcel.write(response.getOutputStream(), Student.class).sheet("sheet1").doWrite(studentList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/upload")
    public void upload(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(), Student.class, new ReadListener<Student>() {
                @Override
                public void invoke(Student s, AnalysisContext analysisContext) {
                    System.out.println(s);
                }

                @Override
                public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                    System.out.println("read finished");
                }
            }).sheet("sheet1").doRead();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/read")
    public void readExcel() {
        File file = new File("H:\\Code\\CodeTemplate\\JavaCodeTemplate\\spring\\springboot05-easyexcel\\src\\main\\resources\\file.xlsx");

        EasyExcel.read(file, Student.class, new ReadListener<Student>() {
            @Override
            public void invoke(Student s, AnalysisContext analysisContext) {
                System.out.println(s);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println("read finished");
            }
        }).sheet("sheet1").doRead();
    }

    @PostMapping("/write")
    public void write(@RequestBody Student student) {
        File file = new File("H:\\Code\\CodeTemplate\\JavaCodeTemplate\\spring\\springboot05-easyexcel\\src\\main\\resources\\file.xlsx");

        EasyExcel.write(file, Student.class).sheet("sheet1").doWrite(Collections.singleton(student));

        // 写入成功后，我们尝试读取下文件
        EasyExcel.read(file, Student.class, new ReadListener<Student>() {
            @Override
            public void invoke(Student s, AnalysisContext analysisContext) {
                System.out.println(s);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println("read finished");
            }
        }).sheet("sheet1").doRead();
    }
}
