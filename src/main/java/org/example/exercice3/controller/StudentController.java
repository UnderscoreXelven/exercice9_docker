    package org.example.exercice3.controller;

    import org.example.exercice3.model.Student;
    import org.example.exercice3.service.StudentService;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;

    @Controller
    public class StudentController {
        private StudentService studentService;

        public StudentController(StudentService studentService) {
            this.studentService = studentService;
        }

        @GetMapping("/")
        public String home(){
            return "accueil";
        }

        @GetMapping("/etudiant/list")
        public String listStudents(Model model){
            model.addAttribute("students", studentService.getAllStudents());
            System.out.println(studentService.getAllStudents());
            return "studentList";
        }

        @GetMapping("/etudiant/{id}")
        public String studentDetails(@PathVariable("id") int id, Model model){
            model.addAttribute("student", studentService.getStudentById(id));
            return "studentDetail";
        }

        @GetMapping("/etudiant/search")
        public String searchStudent(@RequestParam(value = "name") String name, Model model){
            model.addAttribute("student", studentService.getStudentByName(name));
            return "studentDetail";
        }

        @GetMapping("/etudiant/add")
        public String addStudent(Model model){
            model.addAttribute("student", new Student());
            return "addStudent";
        }

        @PostMapping("/etudiant/add")
        public String saveStudent(@ModelAttribute Student student) {
            studentService.addStudent(student);
            return "redirect:/etudiant/list";
        }

    }
