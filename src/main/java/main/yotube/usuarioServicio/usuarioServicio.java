package main.yotube.usuarioServicio;

import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.UUID;

import main.yotube.usuario.usuario;
import org.springframework.stereotype.Service;

@Service
public class usuarioServicio {
    
    private final Map<UUID, usuario> usuarios = new HashMap();
    
    public usuario crear(final usuario us) {
        UUID id = UUID.randomUUID();
        return usuarios.put(id, us);
    }
    

    public usuario encontrarPorId(final UUID id) {
        return usuarios.get(id);
        
    }
    
//    public List<usuario> encontrarTodos() {
//        return usuarios.keySet().stream()
//                .map(usuarios::get)
//                .toList();
//    }
    public Map<UUID,usuario> imprimirLista(){
        for (Map.Entry<UUID, usuario> entry : usuarios.entrySet()) {
            UUID key = entry.getKey();
            usuario value = entry.getValue();
            }return usuarios;
}
    
    public void eliminar(final UUID id) {
        usuarios.remove(id);
    }
}
