package com.example.vendorTask.Controller;

import com.example.vendorTask.Domain.Vendor;
import com.example.vendorTask.Service.VendorService;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@Validated
public class VendorController {

    @Autowired
    private VendorService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {

        /*List<Vendor> listVendor = service.listAll();
        model.addAttribute("listVendor", listVendor);
        System.out.print("Get / ");*/

        return findPaginated(0,model);
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("vendor", new Vendor());
        return "new";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Validated
    public String saveVendor(@Valid @ModelAttribute("vendor") Vendor vendor) {

        if(vendor.getName().equals(""))
            return "new";
        if(vendor.getBankAccountNumber().equals(""))
            return "new";
        if(vendor.getBankName().equals(""))
            return "new";

        service.save(vendor);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditVendorPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        Vendor vendor = service.get(id);
        mav.addObject("vendor", vendor);
        return mav;

    }
    @RequestMapping("/delete/{id}")
    public String deleteVendor(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }

    @GetMapping("/page/{pageno}")
    public String findPaginated(@PathVariable int pageno,Model model){

        Page<Vendor> listVendor = service.getVendByPaginate(pageno,5);

        model.addAttribute("listVendor",listVendor);
        model.addAttribute("currPage",pageno);
        model.addAttribute("totalPages",listVendor.getTotalPages());
        model.addAttribute("totalItem",listVendor.getTotalElements());
        return "index";
    }
}
