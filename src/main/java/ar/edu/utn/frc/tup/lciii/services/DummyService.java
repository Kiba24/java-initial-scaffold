package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.models.Dummy;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface DummyService {

    List<Dummy> getDummies();

    Dummy getDummy(Long id);

    Dummy createDummy(Dummy dummy);

    Dummy updateDummy(Dummy dummy);

}
