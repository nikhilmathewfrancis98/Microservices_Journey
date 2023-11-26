package com.kenInternational.controller;
/**
 * We are tring to use the Servlet request here to take the request values
 *      getStudentBean(HttpServletRequest req){
 *         Enumeration<String> attrnames = req.getAttributeNames();
 *         attrnames.asIterator().forEachRemaining(System.out::println);
 *
 *           PrintWriter out = res.getWriter();
 * //        res.setContentType("text/plain");
 *
 *         Enumeration<String> parameterNames = req.getParameterNames();
 *
 *         while (parameterNames.hasMoreElements()) {
 *
 *             String paramName = parameterNames.nextElement();
 *             System.out.println(paramName+"\t");
 * //            out.write(paramName);
 * //            out.write("n");
 * //            System.out.println("\n");
 *             String[] paramValues = req.getParameterValues(paramName);
 *             for (int i = 0; i < paramValues.length; i++) {
 *                 String paramValue = paramValues[i];
 *                 System.out.println(paramValue+"\t");
 *
 *             }
 *
 *         }
 */
import com.kenInternational.Model.StudentModal;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@RestController
@RequestMapping("/students") // This is the base url for this class
public class StudentController {
    @GetMapping("/all-Students")
    // Return the list of students in the Json format 
    public ResponseEntity<List<StudentModal>> getStudents(){
        List<StudentModal> studentModalList=new ArrayList<>();
        studentModalList.add(new StudentModal(23,"Nikhil","Math"));
        studentModalList.add(
                new StudentModal(233,"Malabari","Gang"));
//        ResponseEntity.ok(studentModalList);
//        new ResponseEntity<>(studentModalList,HttpStatus.OK);
//          ResponseEntity.ok().header("Check","List-Values").body(studentModalList);
        return ResponseEntity.status(HttpStatus.OK).body(studentModalList);
    }

    @GetMapping("/student-bean")
    public StudentModal getStudentBean() {
        return new StudentModal(23,"Nikhil","Math"); // A single object is returned
    }
    /**
     * We are going to use the @PathVariable to get the URI template variable
     * passing the {id} via URI template
     */
    @GetMapping("/getById/{id}/{first-name}/{last-name}")
    public StudentModal getTheStudent(@PathVariable("id") int studentId,
                                        @PathVariable("first-name") String fname,
                                      @PathVariable("last-name") String Lname){
        return new StudentModal(studentId,fname,Lname);
    }

    // Getting the details using the @RequestParam
    // http://localhost:8080/getUsingParam?id=303&f-name=Barack&L-name=Obama
    @GetMapping("/getUsingParam")
    public StudentModal getUsingParam(@RequestParam("id") int Stu_id,
                                    @RequestParam("f-name") String fName,
                                      @RequestParam("L-name") String LName){
        return new StudentModal(Stu_id,fName,LName);
    }

    @PutMapping("updateStudent/{id}/update") // here we can give also as students/{id}
    public StudentModal updateStudent(@PathVariable("id") int Student_id, @RequestBody StudentModal studentModal){

        return  new StudentModal(Student_id,studentModal.getFName(),studentModal.getLName());
    }
    @PostMapping("/createStudent")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<StudentModal> createStudent(@RequestBody StudentModal studentModal){
        StudentModal s=new StudentModal(studentModal.getId(),studentModal.getFName(), studentModal.getLName());
        return new ResponseEntity<>(s,HttpStatus.CREATED);
    }
    /**
     * Like the above code implement delete mapping
     */

    /**
     * ResponseEntity implementation
     */
    @GetMapping
    public ResponseEntity<StudentModal> Students(){
        StudentModal s=new StudentModal(211,"Babu","Namboothiri");
//        ResponseEntity.ok(s);
//        ResponseEntity.ok().header("Custom_header","Nikhil's List").body(s);
        return new ResponseEntity<>(s,HttpStatus.OK);
    }
}
