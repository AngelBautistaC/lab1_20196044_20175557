package pe.edu.pucp.gtics.lab1221.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.pucp.gtics.lab1221.entity.Distributors;
import pe.edu.pucp.gtics.lab1221.repository.DistributorsRepository;

import java.util.List;

@Controller
@RequestMapping("/distribuidoras")
public class DistributorsController {

    @Autowired
    DistributorsRepository distributorsRepository;


    @GetMapping(value={"/lista"})
    public String listaDistribuidoras (Model model){
        List<Distributors> lista=distributorsRepository.findAll(Sort.by("nombre"));
        model.addAttribute("distribuidoraslista",lista);

        return "distribuidoras/lista";
    }

    public String editarDistribuidoras(){
        return "";
    };


    @GetMapping(value={"/nuevo"})
    public String nuevaDistribuidora(){


        return "/distribuidoras/nuevo";
    }


    @PostMapping(value={"/guardar"})
    public String guardarDistribuidora(Distributors distribuidoras){
        distributorsRepository.save(distribuidoras);
        return "redirect:/distribuidoras/lista";
    }

    public String borrarDistribuidora(){
        return "";
    };

}
