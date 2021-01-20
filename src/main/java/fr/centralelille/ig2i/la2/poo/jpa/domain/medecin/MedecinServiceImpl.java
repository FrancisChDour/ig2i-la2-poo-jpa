package fr.centralelille.ig2i.la2.poo.jpa.domain.medecin;

import fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions.BusinessException;
import fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions.ErrorMessage;
import fr.centralelille.ig2i.la2.poo.jpa.repository.MedecinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MedecinServiceImpl implements MedecinService {

    private final MedecinRepository medecinRepository;

    @Override
    public Medecin findMedecin(String idMedecin) throws MedecinNotFoundException {
        return Optional.ofNullable(medecinRepository.getMedecinByIdMedecin(idMedecin))
                .orElseThrow(() -> new MedecinNotFoundException(idMedecin));
    }

    @Override
    public String createMedecin(Medecin medecin) throws BusinessException {
        Optional.ofNullable(medecin).orElseThrow(() -> new BusinessException(ErrorMessage.builder()
                .error("medecin.notProvided")
                .message("Aucun médecin fourni")
                .build()));

        medecin.setIdMedecin(UUID.randomUUID().toString());

        medecinRepository.save(medecin);
        return medecin.getIdMedecin();
    }
}
