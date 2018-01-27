package com.MVCProject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    // Controller method to show the initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // Controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    // New controller method to read form data and add it to the model
    @RequestMapping("/processFormTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        String theName = request.getParameter("studentName");

        theName = theName.toUpperCase();

        String result = "Yo!  " + theName;

        model.addAttribute("message", result);

        return "helloworld";
    }

    @RequestMapping("/processFormThree")
    public String processFormThree(@RequestParam("studentName") String theName, Model model) {

        theName = theName.toUpperCase();

        String result = theName + "!  What up dawg?";

        model.addAttribute("message", result);

        return "helloworld";
    }
}
