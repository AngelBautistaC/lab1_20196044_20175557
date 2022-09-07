package pe.edu.pucp.gtics.lab1221.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.pucp.gtics.lab1221.entity.Distributors;
import pe.edu.pucp.gtics.lab1221.repository.DistributorsRepository;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/editar")
    public String editarDistribuidoras(Model model,
                                       @RequestParam("id") int id) {
        Optional<Distributors> optDistribuidora = distributorsRepository.findById(id);

        if(optDistribuidora.isPresent()){
            Distributors distributors =optDistribuidora.get();
            model.addAttribute("distributors", distributors);
            return "distribuidoras/editar";
        } else {
            return "redirect:/distribuidoras/listar";
        }
    }


    @GetMapping(value={"/nuevo"})
    public String nuevaDistribuidora(){


        return "/distribuidoras/nuevo";
    }

    @PostMapping("/guardar")
    public String guardarDistribuidora(Distributors distribuidoras){
        distributorsRepository.save(distribuidoras);
        return "redirect:/distribuidoras/lista";
    }

    public String borrarDistribuidora(){
        return "";
    };

}
