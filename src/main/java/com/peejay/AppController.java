package com.peejay;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public String report(ModelMap model) {
        Module module1 = new Module("module1");
        Module module2 = new Module("module2");
        Module module3 = new Module("module3");
        List<Module> modules = Arrays.asList(module1, module2, module3);
        Report report = new Report(modules);
        model.addAttribute("report", report);
        return "report";
    }

    @RequestMapping(value = "/report/module1", method = RequestMethod.GET)
    public String module1(ModelMap model) {
        return "modules/module1";
    }

    @RequestMapping(value = "/report/module2", method = RequestMethod.GET)
    public String module3(ModelMap model) {
        return "modules/module2";
    }

    @RequestMapping(value = "/report/module3", method = RequestMethod.GET)
    public String module2(ModelMap model) {
        return "modules/module3";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {
        model.addAttribute("message", "Hello unknown visitor!");
        return "index";
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String welcomeName(@PathVariable String name, ModelMap model) {
        model.addAttribute("message", "Hello " + name + "!");
        return "index";
    }

    @ModelAttribute("allDevelopers")
    public List<String> allDevelopers() {
        return Arrays.asList("Per", "Tomas", "Bengt");
    }

}