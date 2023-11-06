package up.code.codeup.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import up.code.codeup.entity.Materia;
import up.code.codeup.repository.MateriaRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MateriaService {

    @Autowired
    private MateriaRepository repository;

    public List<Materia> buscarMaterias() {
        return repository.findAll();
    }

    public Materia buscarMateriaPorId(int id) {
        Optional<Materia> materia = repository.findById(id);
        if (materia.isPresent()) {
            Materia materiaExistente = materia.get();
            return materiaExistente;
        }
        return null;
    }

}
