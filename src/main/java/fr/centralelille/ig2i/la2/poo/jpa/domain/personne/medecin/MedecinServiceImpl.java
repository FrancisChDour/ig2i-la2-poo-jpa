package fr.centralelille.ig2i.la2.poo.jpa.domain.personne.medecin;

import fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions.BusinessException;
import fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions.ErrorMessage;
import fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions.NotFoundException;
import fr.centralelille.ig2i.la2.poo.jpa.repository.MedecinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MedecinServiceImpl implements MedecinService {

    private final MedecinRepository medecinRepository;

    @Override
    public Medecin findMedecin(String idMedecin) throws MedecinNotFoundException {
        return Optional.ofNullable(medecinRepository.getMedecinById(idMedecin))
                .orElseThrow(() -> new MedecinNotFoundException(idMedecin));
    }

    @Override
    public String createMedecin(Medecin medecin) throws BusinessException {
        Optional.ofNullable(medecin).orElseThrow(() -> new BusinessException(ErrorMessage.builder()
                .error("medecin.notProvided")
                .message("Aucun médecin fourni")
                .build()));

        medecin.setId(UUID.randomUUID().toString());

        medecinRepository.save(medecin);
        return medecin.getId();
    }

    @Override
    public List<Medecin> getSubordonnedMedecin(String idMedecin) throws NotFoundException {
        Medecin medecin = Optional.ofNullable(medecinRepository.getMedecinById(idMedecin))
                .orElseThrow(() -> new MedecinNotFoundException(idMedecin));

        return Optional.ofNullable(medecin.getService())
                .map(fr.centralelille.ig2i.la2.poo.jpa.domain.Service::getMedecins)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.builder()
                        .error("medecin.noServiceManaged")
                        .message("This medecin does no mange any service")
                        .build()));
    }
}
