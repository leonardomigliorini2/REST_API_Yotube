package main.yotube.usuarioControlador;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import main.yotube.usuario.usuario;
import main.yotube.usuarioServicio.usuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class usuarioControlador {

    @Autowired
    private usuarioServicio UsuarioServicio;

    @GetMapping
    public Map<UUID,usuario> usuarios(@RequestParam(required = false) String filtro) {
        return UsuarioServicio.imprimirLista();
        
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void crearusuario(@RequestBody usuario us){
        UsuarioServicio.crear(us);
    }
    @GetMapping("/{id}")
    public usuario encontrarUsuarioPorId(@PathVariable UUID id){
       return UsuarioServicio.encontrarPorId(id);
    }
}
