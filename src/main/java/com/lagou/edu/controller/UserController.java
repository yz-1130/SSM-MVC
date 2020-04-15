package com.lagou.edu.controller;

import com.lagou.edu.dao.UserDao;
import com.lagou.edu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;
    /**
     * 向用户登录页面跳转
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLogin(){
        return  "login";
    }

    @RequestMapping(value = "/toUpdate",method = RequestMethod.GET)
    public String toUpdate(){
        return  "update";
    }

    @RequestMapping(value = "/toInsert",method = RequestMethod.GET)
    public String toInsert(){
        return  "insert";
    }

    @RequestMapping(value = "/toStudent",method = RequestMethod.GET)
    public String toStudent(){
        return  "student";
    }

    @RequestMapping(value = "/toDelete",method = RequestMethod.GET)
    public ModelAndView toDelete(HttpServletRequest request , Model model){
        return  delete(request,model);
    }
    /**
     * 用户登录
     * @param user
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user, Model model, HttpSession session){
        //获取用户名和密码
        String username=user.getUsername();
        String password=user.getPassword();
        //些处横板从数据库中获取对用户名和密码后进行判断
        if(username!=null&&username.equals("admin")&&password!=null&&password.equals("admin")){
            //将用户对象添加到Session中
            session.setAttribute("USER_SESSION",user);
            //重定向到主页面的跳转方法
            return "student";
        }
        model.addAttribute("msg","用户名或密码错误，请重新登录！");
        return "login";
    }

   /* @RequestMapping(value = "/register")
    public String register(HttpSession session,User user, Model model){
        HttpSession httpSession = session;
        User user1 =user;
        Model model1 = model;


        session.setAttribute("USER_SESSION",user);

        //保存数据

        return "register:";
    }*/

    @RequestMapping(value = "/student")
    public ModelAndView student(){
        ModelAndView modelAndView = new ModelAndView();

        List<User> userList = userDao.findAll();
        modelAndView.addObject("userList",userList);

        //保存数据

        return modelAndView;
    }

    @Transactional
    @RequestMapping(value = "/delete")
    public ModelAndView delete(HttpServletRequest request , Model model){
       Long id = Long.valueOf(Integer.parseInt(request.getParameter("id")));

       User user = new User();
       user.setId(id);
       userDao.delete(user);

        //保存数据

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("sucess","sucess");
        return  new ModelAndView("redirect:/student");
    }

    @Transactional
    @RequestMapping(value = "/update")
    public ModelAndView update(HttpServletRequest request , Model model){
        Long id = Long.valueOf(request.getParameter("id").trim());
        String username = request.getParameter("username").trim();
        String phone = request.getParameter("phone").trim();
        String passwd = request.getParameter("password").trim();
        User user = new User();
        user.setId(id);
        user.setPhone(phone);
        user.setPassword(passwd);
        user.setUsername(username);
        User save = userDao.save(user);

        return  new ModelAndView("redirect:/student");

    }
    @Transactional
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ModelAndView insert(HttpServletRequest request , HttpServletResponse response,Model model){
        String username = request.getParameter("username");
        String phone = request.getParameter("phone");
        String passwd = request.getParameter("password");
        User user = new User();
        user.setPhone(phone);
        user.setPassword(passwd);
        user.setUsername(username);
        userDao.save(user);

        return new ModelAndView("redirect:/student");


    }
}