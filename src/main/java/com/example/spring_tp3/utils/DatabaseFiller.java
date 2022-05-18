package com.example.spring_tp3.utils;

import com.example.spring_tp3.models.entities.Developer;
import com.example.spring_tp3.models.entities.Editor;
import com.example.spring_tp3.models.entities.Game;
import com.example.spring_tp3.repository.DeveloperRepository;
import com.example.spring_tp3.repository.EditorRepository;
import com.example.spring_tp3.repository.GameRepository;
import com.example.spring_tp3.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.example.spring_tp3.models.entities.User;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DatabaseFiller implements InitializingBean {

    private final GameRepository gameRepository;
    private final EditorRepository editorRepository;
    private final DeveloperRepository developerRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public DatabaseFiller(GameRepository gameRepository, EditorRepository editorRepository, DeveloperRepository developerRepository, UserRepository userRepository, PasswordEncoder encoder) {
        this.gameRepository = gameRepository;
        this.editorRepository = editorRepository;
        this.developerRepository = developerRepository;
        this.userRepository = userRepository;
        this.encoder = encoder;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        setUpListGame();
    }


    private void setUpListGame() throws Exception{

        Developer d = Developer.builder()
                .name("Nintendo")
                .parentCompany("Kyoto (Japan)")
                .creationDate(LocalDate.of(1989, 9, 23))
                .games(null)
                .build();
        developerRepository.save(d);

        Editor e = Editor.builder()
                .name("Nintendo")
                .parentCompany("Kyoto (Japan)")
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
                .parentCompany("Virginia (United States)")
                .creationDate(LocalDate.of(1984, 9, 27))
                .games(null)
                .build();
        developerRepository.save(d);

        e = Editor.builder()
                .name("Sony")
                .parentCompany("Tokyo (Japan)")
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

        d = Developer.builder()
                .name("Capcom")
                .parentCompany("Osaka (Japan)")
                .creationDate(LocalDate.of(1979, 5, 30))
                .games(null)
                .build();
        developerRepository.save(d);

        e = Editor.builder()
                .name("Capcom")
                .parentCompany("Osaka (Japan)")
                .creationDate(LocalDate.of(1979, 5, 30))
                .games(null)
                .build();
        editorRepository.save(e);

        g = Game.builder()
                .title("Resident Evil")
                .releaseDate(LocalDate.of(1996, 03, 22))
                .genre("survival horror")
                .portage("Playstation, Saturn, PC")
                .getLicence(true)
                .developer(d)
                .editor(e)
                .build();
        gameRepository.save(g);

        e = Editor.builder()
                .name("Ubisoft")
                .parentCompany("Montréal (Canada)")
                .creationDate(LocalDate.of(1986, 01, 01))
                .games(null)
                .build();
        editorRepository.save(e);

        d = Developer.builder()
                .name("Ubisoft Montréal")
                .parentCompany("Montréal (Canada)")
                .creationDate(LocalDate.of(1986, 01, 01))
                .games(null)
                .build();
        developerRepository.save(d);

        g = Game.builder()
                .title("Assassin's Creed")
                .releaseDate(LocalDate.of(2077, 11, 13))
                .genre("RPG, aventure")
                .portage("PS3, XB360")
                .getLicence(true)
                .developer(d)
                .editor(e)
                .build();
        gameRepository.save(g);

        e = Editor.builder()
                .name("Square Enix")
                .parentCompany("Tokyo (Japan)")
                .creationDate(LocalDate.of(1975, 9, 22))
                .games(null)
                .build();
        editorRepository.save(e);

        d = Developer.builder()
                .name("Dontnod Entertainment")
                .parentCompany("Paris (France)")
                .creationDate(LocalDate.of(2088, 05, 01))
                .games(null)
                .build();
        developerRepository.save(d);

        g = Game.builder()
                .title("Life is strange")
                .releaseDate(LocalDate.of(2015, 01, 30))
                .genre("Aventure, Point-and-click")
                .portage("PC, PS3, XBOX360")
                .getLicence(true)
                .developer(d)
                .editor(e)
                .build();
        gameRepository.save(g);

        User u = User.builder()
                .username("manon")
                .password(encoder.encode("pass"))
                .email("manon@mail.com")
                .roles(List.of("USER", "ADMIN"))
                .isNotLocked(true)
                .build();
        userRepository.save(u);

        u = User.builder()
                .username("cassian")
                .password(encoder.encode("chat"))
                .email("cassian@mail.com")
                .roles(List.of("USER"))
                .isNotLocked(true)
                .build();
        userRepository.save(u);
    }

}
