package pe.edu.pucp.gtics.lab1221.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.pucp.gtics.lab1221.entity.Games;
import pe.edu.pucp.gtics.lab1221.repository.GamesRepository;
import pe.edu.pucp.gtics.lab1221.repository.PlatformsRepository;

import java.util.List;

@Controller
@RequestMapping("/juegos")
public class GamesController {

    @Autowired
    GamesRepository juegosRepository;

    @Autowired
    PlatformsRepository plataformasRepository;

    @GetMapping(value={"/lista"})
    public String listaJuegos (Model model){
        List<Games> lista=juegosRepository.findAll(Sort.by("precio").ascending());
        model.addAttribute("listajuegos",lista);

        return "juegos/lista";
    }

    public String editarJuegos(){
        return "";
    };

    public String guardarJuegos(){
        return "";
    };

}
