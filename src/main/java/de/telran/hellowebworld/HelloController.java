package de.telran.hellowebworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello-mvc/{name}", method = RequestMethod.GET)
    public String hello(@PathVariable String name, Model model) {
        model.addAttribute("helloText", "Hello, " + name);
        return "hello-mvc";
    }

    //    @RequestMapping(value = "/hello-simple/{name}", method = RequestMethod.GET)
    @GetMapping(value = "/hello-simple/{name}")
    @ResponseBody
    public String helloSimpleText(@PathVariable String name) {
        return "Hello simply, " + name;
    }

    @RequestMapping(value = "/hello-json/{name}", method = RequestMethod.GET)
    @ResponseBody
    public JsonName helloJsonText(@PathVariable String name) {
        JsonName jsonName = new JsonName(name);
        return jsonName;
    }

    @RequestMapping(value = "/hello-json", method = RequestMethod.POST)
//    @PostMapping("/hello-json")
    @ResponseBody
    public JsonName helloJsonText(@RequestBody JsonName incomingData) {
        incomingData.name = "Hello, " + incomingData.name;
        return incomingData;
    }

    @PutMapping("/hello-json")
    @ResponseBody
    public JsonName helloJsonText2(@RequestBody JsonName incomingData) {
        StringBuilder stringBuilder = new StringBuilder();
        String first = String.valueOf(incomingData.name.charAt(0)).toUpperCase();
        incomingData.name = stringBuilder.replace(0, 1, first).append(incomingData.name.substring(1)).toString();
        return incomingData;
    }


    @DeleteMapping("/hello-json")
    @ResponseBody
    public JsonName helloJsonText3(@RequestBody JsonName incomingData) {
        incomingData.name = incomingData.name + " was deleted";
        return incomingData;
    }
}
