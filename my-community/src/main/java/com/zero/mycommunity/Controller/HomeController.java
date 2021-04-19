package com.zero.mycommunity.Controller;



import com.zero.mycommunity.dao.DiscussPostMapper;
import com.zero.mycommunity.dao.UserMapper;
import com.zero.mycommunity.entity.DiscussPost;
import com.zero.mycommunity.entity.Page;
import com.zero.mycommunity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/index")//首页
    public String IndexPage(Model model, Page page){
        page.setRows(discussPostMapper.selectDiscussPostRows(0));
        page.setPath("/index");
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0, page.getOffset(), page.getLimit());
        //这里还需要通过帖子里的userid查询user
        List<Map<String ,Object>>discussPosts=new ArrayList<>();
        if(list!=null){
            for (DiscussPost post:list){
                Map<String,Object>mp=new HashMap<>();
                mp.put("post",post);
                User user = userMapper.selectById(post.getUserId());
                mp.put("user",user);
                discussPosts.add(mp);
            }
        }
        model.addAttribute("discussPosts",discussPosts);
        return "index";
    }
}
