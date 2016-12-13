package mySpringBootApp.company;

import mySpringBootApp.entities.User;
import mySpringBootApp.entities.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@Controller
public class JspController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/")
    public String jspIndex() {
        return "userIndex";
    }

    @RequestMapping(value = "/jspTest")
    public String jspTest() {
        return "test";
    }

    @RequestMapping(value = "/createUser")
    public String create(String email, String name) {
        try {
            User user = new User(email, name);
            userDao.save(user);

            return "userIndex";
        }
        catch (Exception e) {
            return "userIndex";
        }
    }

    @RequestMapping("/getAllUsers")
    public String getUser(Model model) {
        Iterable<User> i = userDao.findAll();
        Iterator<User> itr = i.iterator();
        ArrayList<User> users = new ArrayList<>();
        while(itr.hasNext()) {
            User user = itr.next();
            users.add(user);
        }
        model.addAttribute("users", users);
        return "allUsers";
    }

    @RequestMapping("/getUserById")
    public String getUser(long id, Model model) {
        User user = userDao.findOne(id);
        model.addAttribute("user", user);
        return "singleUser";
    }

    @RequestMapping("/edit")
    public String edit(long id, String email, String name, Model model) {
        try {
            User user = userDao.findOne(id);
            model.addAttribute("user", user);
            return "edit";
        } catch (Exception e) {
            return "edit" + e.toString();
        }
    }

    @RequestMapping("/updateUser")
    public String updateUser(long id, String email, String name, Model model) {
        try {
            User user = userDao.findOne(id);
            user.setEmail(email);
            user.setName(name);
            userDao.save(user);
            Iterable<User> i = userDao.findAll();
            Iterator<User> itr = i.iterator();
            ArrayList<User> users = new ArrayList<>();
            while(itr.hasNext()) {
                User u = itr.next();
                users.add(u);
            }
            model.addAttribute("users", users);
            return "allUsers";
        }
        catch (Exception e) {
            return "edit" + e.toString();
        }
    }
}