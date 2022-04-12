package com.example.spring_tp3.utils;

import com.example.spring_tp3.models.entities.Developer;
import com.example.spring_tp3.models.entities.Editor;
import com.example.spring_tp3.models.entities.Game;
import com.example.spring_tp3.repository.DeveloperRepository;
import com.example.spring_tp3.repository.EditorRepository;
import com.example.spring_tp3.repository.GameRepository;
import org.h2.engine.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DatabaseFiller implements InitializingBean {

    private final GameRepository gameRepository;
    private final EditorRepository editorRepository;
    private final DeveloperRepository developerRepository;

    public DatabaseFiller(GameRepository gameRepository, EditorRepository editorRepository, DeveloperRepository developerRepository) {
        this.gameRepository = gameRepository;
        this.editorRepository = editorRepository;
        this.developerRepository = developerRepository;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        setUpListGame();
    }


    private void setUpListGame() throws Exception{

        Developer d = Developer.builder()
                .name("Nintendo")
                .parentCompany("Kyoto")
                .creationDate(LocalDate.of(1989, 9, 23))
                .games(null)
                .build();
        developerRepository.save(d);

        Editor e = Editor.builder()
                .name("Nintendo")
                .parentCompany("Kyoto")
                .creationDate(LocalDate.of(1989, 9, 23))
                .games(null)
                .build();
        editorRepository.save(e);

        Game g = Game.builder()
                .title("Ocarina of Time")
                .releaseDate(LocalDate.of(1998, 11, 21))
                .genre("RPG action-adventure")
                .portage("Gamecube, 3DS")
                .getLicence(true)
                .developer(d)
                .editor(e)
                .build();
        gameRepository.save(g);

        d = Developer.builder()
                .name("Naughty Dog")
                .parentCompany("Virginia")
                .creationDate(LocalDate.of(1984, 9, 27))
                .games(null)
                .build();
        developerRepository.save(d);

        e = Editor.builder()
                .name("Sony")
                .parentCompany("Tokyo")
                .creationDate(LocalDate.of(1946, 5, 7))
                .games(null)
                .build();
        editorRepository.save(e);

        g = Game.builder()
                .title("The last of us")
                .releaseDate(LocalDate.of(2013, 6, 14))
                .genre("survival horror")
                .portage("PS3, PS4")
                .getLicence(true)
                .developer(d)
                .editor(e)
                .build();
        gameRepository.save(g);

    }

}
