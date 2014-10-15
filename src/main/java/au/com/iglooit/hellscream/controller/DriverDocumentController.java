package au.com.iglooit.hellscream.controller;

import au.com.iglooit.hellscream.model.vo.ClientFile;
import au.com.iglooit.hellscream.model.vo.DriverFileResponse;
import au.com.iglooit.hellscream.model.vo.JsonResponse;
import au.com.iglooit.hellscream.service.drive.DriveDocService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 18/09/2014
 * Time: 4:42 PM
 */
@Controller
public class DriverDocumentController {
    @Resource
    private DriveDocService driveDocService;

    @RequestMapping(value = "/driver", method = RequestMethod.GET)
    public String driver() {
        return "drive/driver";
    }

    @RequestMapping(value = "/ws/drive",
            method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    public
    @ResponseBody
    DriverFileResponse contactUsEmail(@RequestBody ClientFile vo) {
        return driveDocService.storeFileToDrive(vo);
    }
}
