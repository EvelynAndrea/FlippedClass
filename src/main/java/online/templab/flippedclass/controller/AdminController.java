package online.templab.flippedclass.controller;

import online.templab.flippedclass.pojo.dto.StudentFilter;
import online.templab.flippedclass.pojo.dto.TeacherFilter;
import online.templab.flippedclass.entity.Student;
import online.templab.flippedclass.entity.Teacher;
import online.templab.flippedclass.service.StudentService;
import online.templab.flippedclass.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import seminar.config.SeminarConfig;

/**
 * @author Cesare
 *
 * @author jly
 * @date 2018.12.17
 */

/**
 * test
 */


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final TeacherService teacherService;
    private final StudentService studentService;

    @Autowired
    public AdminController(TeacherService teacherService,StudentService studentService) {
        this.teacherService=teacherService;
        this.studentService=studentService;
    }

    @RequestMapping(value = {"/", "/login"})
    public String adminLogin() {
        return "admin/login";
    }

    @GetMapping("/index")
    public String index() {
        return "admin/index";
    }

    @GetMapping("/teacherManage")
    public String teacherManage() {
        return "admin/teacherManage";
    }

    //TODO:Many Method need @valid for entity check.

    @PostMapping("/teacherList")
    public String teacherList(Model model, TeacherFilter filter) {
        List<Teacher> teachers=teacherService.listBy TeachersByFilter(filter);
        int sumPage = (teachers.size() - 1) / filter.getCount() + 1;
        int page = filter.getPage() < 1 ? 1 : (filter.getPage() > sumPage ? sumPage : filter.getPage());
        int fromIndex = (page - 1) * filter.getCount();
        int toIndex = page * filter.getCount();
        toIndex = toIndex > teachers.size() ? teachers.size() : toIndex;

        //Using this converter to make this declaration recognizable for freemarker template.
        Boolean mNewFilter = filter.isNewFilter();
        Number mFromIndex = fromIndex, mSumPage = sumPage, mPage = page;
        model.addAttribute("newFilter", mNewFilter);
        model.addAttribute("fromIndex", mFromIndex);
        model.addAttribute("sumPage", mSumPage);
        model.addAttribute("page", mPage);
        model.addAttribute("teachers", teachers.subList(fromIndex, toIndex));
        return "admin/teacherList";
    }

    @PutMapping("/teacher")
    public @ResponseBody
    ResponseEntity<Object> addTeacher(@RequestBody Teacher teacher) {
        //teacher.setPassword(SeminarConfig.DEFAULT_PASSWORD);
        // teacher.setActivated(false);
        if (teacherService.insert(teacher)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @PatchMapping(value = "/teacher")
    public @ResponseBody
    ResponseEntity<Object> updateTeacher(@RequestBody Teacher teacher) {
        if (accountManageService.updateTeacher(teacher)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @PatchMapping("/teacher/{teacherNum}/resetPwd")
    public @ResponseBody
    ResponseEntity<Object> resetTeacherPassword(@PathVariable String teacherNum) {
        if (accountManageService.teacherResetPassword(teacherNum)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @DeleteMapping("/teacher/{teacherNum}")
    public @ResponseBody
    ResponseEntity<Object> deleteTeacher(@PathVariable String teacherNum) {
        if (teacherService.delete(teacherNum)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @DeleteMapping("/teacher")
    public @ResponseBody
    ResponseEntity<Object> deleteTeacher(@RequestBody String[] teacherNum) {
        for (String s : teacherNum) {
            if (!teacherService.delete(s)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(s);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }


    @GetMapping("/studentManage")
    public String studentManage() {
        return "admin/studentManage";
    }

    @PostMapping("/studentList")
    public String studentList(Model model, StudentFilter filter) {
        List<Student> students = studentService.getStudentsByFilter(filter);
        //总页数
        int sumPage = (students.size() - 1) / filter.getCount() + 1;
        //页面大小？
        int page = filter.getPage() < 1 ? 1 : (filter.getPage() > sumPage ? sumPage : filter.getPage());
        int fromIndex = (page - 1) * filter.getCount();
        int toIndex = page * filter.getCount();
        toIndex = toIndex > students.size() ? students.size() : toIndex;

        //Using this converter to make this declaration recognizable for freemarker template.
        Boolean mNewFilter = filter.isNewFilter();
        Number mFromIndex = fromIndex, mSumPage = sumPage, mPage = page;
        model.addAttribute("newFilter", mNewFilter);
        model.addAttribute("fromIndex", mFromIndex);
        model.addAttribute("sumPage", mSumPage);
        model.addAttribute("page", mPage);
        model.addAttribute("students", students.subList(fromIndex, toIndex));
        return "admin/studentList";
    }

    @PutMapping("/student")
    public @ResponseBody
    ResponseEntity<Object> addStudent(@RequestBody Student student) {
        if (studentService.insert(student)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @PatchMapping("/student")
    public @ResponseBody
    ResponseEntity<Object> updateStudent(@RequestBody Student student) {
        if (accountManageService.updateStudent(student)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @PatchMapping("/student/{studentNum}/resetPwd")
    public @ResponseBody
    ResponseEntity<Object> resetStudentPassword(@PathVariable String studentNum) {
        if (accountManageService.studentResetPassword(studentNum)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @DeleteMapping("/student/{studentNum}")
    public @ResponseBody
    ResponseEntity<Object> deleteStudent(@PathVariable String studentNum) {
        if (studentService.delete(studentNum)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/student")
    public @ResponseBody
    ResponseEntity<Object> deleteStudent(@RequestBody String[] studentNum) {
        for (String s : studentNum) {
            if (!studentService.delete(s)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(s);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
