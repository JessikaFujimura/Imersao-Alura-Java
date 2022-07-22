package com.alura.br.api.programming.language.controller;

import com.alura.br.api.programming.language.entity.Language;
import com.alura.br.api.programming.language.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class languageController {

    @Autowired
    private LanguageRepository languageRepository;

    @GetMapping(value = "/languages")
    public List<Language> getLanguage(){
        return languageRepository.findAll();
    }

    @PostMapping("/languages")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Language postLanguage(@RequestBody Language language){
        return languageRepository.save(language);
    }

    @PatchMapping("/languages/{id}")
    public Language patchLanguage(@RequestBody Language language ,
                                  @PathVariable("id") String id ){
        Language entity = languageRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Linguagem não encontrada!"));
        entity.setImage(language.getTitle());
        entity.setImage(language.getImage());
        entity.setRanking(language.getRanking());
        return languageRepository.save(entity);

    }

    @DeleteMapping("/languages/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void deleteLanguage(@PathVariable("id") String id) {
        languageRepository.deleteById(id);
    }
}
