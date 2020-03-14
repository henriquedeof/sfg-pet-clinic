package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners") //prefixing this String
@Controller
public class OwnerController {

    @RequestMapping({"", "/", "/index", "/index.html"})//now I consider my prefix and all suffixes.
    public String listOwners(){
        return "owners/index";
    }

}
