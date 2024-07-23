package ar.edu.utn.frc.tup.lciii.services.Implementation;

import ar.edu.utn.frc.tup.lciii.entities.DummyEntity;
import ar.edu.utn.frc.tup.lciii.models.Dummy;
import ar.edu.utn.frc.tup.lciii.repositories.DummyRepository;
import ar.edu.utn.frc.tup.lciii.services.DummyService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class DummyServiceImpl implements DummyService {

    @Autowired
    private DummyRepository dummyRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<Dummy> getDummies() {
        List<DummyEntity> dummyEntities = dummyRepository.findAll();
        return Arrays.asList(modelMapper.map(dummyEntities, Dummy[].class));
    }

    @Override
    public Dummy getDummy(Long id) {
        return modelMapper.map(dummyRepository.findById(id),Dummy.class);
    }

    @Override
    public Dummy createDummy(Dummy dummy) {
        DummyEntity savedDummy =
                dummyRepository.save(modelMapper.map(dummy,DummyEntity.class));
        return modelMapper.map(savedDummy,Dummy.class);
    }

    @Override
    public Dummy updateDummy(Dummy dummy) {
        Optional<DummyEntity> toUpdateOptional = dummyRepository.findById(dummy.getId());

        if (toUpdateOptional.isEmpty()){
            throw  new EntityNotFoundException("Not found");
        }

        DummyEntity toUpdate = toUpdateOptional.get();
        toUpdate.setName(dummy.getName());
        DummyEntity savedEntity =
                    dummyRepository.save(modelMapper.map(toUpdate,DummyEntity.class));
        return modelMapper.map(savedEntity,Dummy.class);
    }
}
