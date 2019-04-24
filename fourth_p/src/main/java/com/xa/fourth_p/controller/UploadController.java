package com.xa.fourth_p.controller;

import com.xa.fourth_p.pojo.Goods;
import com.xa.fourth_p.pojo.UserInfo;
import com.xa.fourth_p.service.GoodsService;
import com.xa.fourth_p.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class UploadController {
    @Autowired
    UserService us;

    @Autowired
    GoodsService gs;

    @RequestMapping("getUserPhoto")//上传头像
    public String getUserPhoto (@RequestParam("upfile") MultipartFile upfile, HttpSession session) throws IOException {
        if(!upfile.isEmpty()) {
            String path = "D:\\Program Files\\ideaprj\\fourth_p\\src\\main\\resources\\static\\img\\" + upfile.getOriginalFilename();//创建新的文件及路径
            File newFile = new File(path);//创建文件
            upfile.transferTo(newFile);//将获取到的文件转换为创建的文件
            String img = "img/";
            img +=upfile.getOriginalFilename();

            UserInfo user = (UserInfo) session.getAttribute("user");
            user.setHeadportrait(img);
            us.updateUser(user);
            return "personal-center";
        }else {
            return "form-line";
        }
    }

    @RequestMapping("exitUser")
    public String exitUser(HttpSession session){
        session.removeAttribute("user");
        return "login";
    }

    @RequestMapping("getGoodsPhoto")//上传商品图片
    public String getGoodsPhoto (@RequestParam("upfile") MultipartFile upfile, HttpSession session) throws IOException {
        if(!upfile.isEmpty()) {
            String path = "D:\\Program Files\\ideaprj\\fourth_p\\src\\main\\resources\\static\\img\\" + upfile.getOriginalFilename();//创建新的文件及路径
            File newFile = new File(path);//创建文件
            upfile.transferTo(newFile);//将获取到的文件转换为创建的文件
            String img = "img/";
            img +=upfile.getOriginalFilename();
            Goods goods =(Goods) session.getAttribute("goods");
            Goods g2 = gs.getOneGoodsByName(goods.getGoodsname());

            g2.setGoodsphoto(img);
            gs.updateGoods(g2);
            return "goods";
        }else {
            return "updateGoods2";
        }
    }

    @PostMapping("testupload")
    @ResponseBody
    public Object testupload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        String filePath = "D:\\Program Files\\ideaprj\\fourth_p\\src\\main\\resources\\static\\img\\";
        String fileName = "";
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            if (file.isEmpty()) {
                return "img/uptouxiang.bmp";
            }
            fileName = file.getOriginalFilename();
            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                return "img/uptouxiang.bmp";
            }
        }
        fileName ="img/" + fileName;
        return fileName;
    }
}
