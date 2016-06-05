package dev.dungdm93.gjt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class F04Controller {
    @Autowired
    private GjtService gjtService;

    @ResponseBody
    @RequestMapping("/F04")
    public String method(@RequestParam int lhs, @RequestParam int rhs) {
        int result = gjtService.boundedMultiply(lhs, rhs);
        return String.format("New logic result : %d", result);
    }
}
