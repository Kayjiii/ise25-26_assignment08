package de.seuhd.campuscoffee.domain.implementation;

import de.seuhd.campuscoffee.domain.exceptions.NotFoundException;
import de.seuhd.campuscoffee.domain.model.objects.Pos;
import de.seuhd.campuscoffee.domain.ports.api.CrudService;
import de.seuhd.campuscoffee.domain.ports.data.PosDataService;
import de.seuhd.campuscoffee.domain.tests.TestFixtures;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CrudServiceTest {

    @Mock
    private PosDataService posDataService;

    @InjectMocks
    private PosServiceImpl posService;

    @Test
    void deletePosNotExists() {
        Pos pos = TestFixtures.getPosFixtures().getFirst();
        Objects.requireNonNull(pos.id());

        posService.delete(pos.id());

        verify(posDataService).delete(pos.id());
    }

}
