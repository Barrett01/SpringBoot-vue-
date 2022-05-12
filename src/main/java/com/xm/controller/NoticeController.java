package com.xm.controller;

import com.xm.api.BaseResponse;
import com.xm.api.StatusCode;
import com.xm.entity.Notice;
import com.xm.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    //根据id查询公告详情
    @GetMapping("/notice/{id}")
    public BaseResponse selectNoticeById(@PathVariable("id") Integer id) {
        Notice notice = noticeService.selectNoticeById(id);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(notice);
        return retMsg;
    }

    //按发表日期查询公告列表
    @GetMapping("/notices")
    public BaseResponse selectNoticesOrderByDate() {
        List<Notice> notices = noticeService.selectNoticesOrderByDate();
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(notices);
        return retMsg;
    }


    //发布公告
    @PostMapping("/notice")
    public BaseResponse insertNotice(@RequestBody Notice notice) {
        noticeService.insertNotice(notice);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        return retMsg;
    }

    //修改公告
    @PutMapping("/notice")
    public BaseResponse updateNotice(@RequestBody Notice notice) {
        noticeService.updateNotice(notice);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        return retMsg;
    }

    //删除公告
    @DeleteMapping("/notice/{id}")
    public BaseResponse deleteNoticeById(@PathVariable("id") Integer id) {
        noticeService.deleteNoticeById(id);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        return retMsg;
    }

}
