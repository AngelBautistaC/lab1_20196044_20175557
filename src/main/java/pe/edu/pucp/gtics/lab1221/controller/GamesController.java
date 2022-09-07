package pe.edu.pucp.gtics.lab1221.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.pucp.gtics.lab1221.entity.Games;
import pe.edu.pucp.gtics.lab1221.entity.Platforms;
import pe.edu.pucp.gtics.lab1221.repository.GamesRepository;
import pe.edu.pucp.gtics.lab1221.repository.PlatformsRepository;

import java.util.List;
import java.util.Optional;

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
    @GetMapping(value = {"/editar"})
    public String editarJuegos(Model model, @RequestParam("id") int id){
        List<Platforms> lista=plataformasRepository.findAll();
        model.addAttribute("listado",lista);

        Optional<Games> optJuegos = juegosRepository.findById(id);
        if (optJuegos.isPresent()) {
            Games juegos = optJuegos.get();
            model.addAttribute("juegos", juegos);
            return "juegos/editar";
        } else {
            return "redirect:/juegos/lista";
        }
    };
    @PostMapping(value = {"/guardar"})
    public String guardarJuegos(Games juegos){
        juegosRepository.save(juegos);
        return "redirect:/juegos/lista";
    };

}
