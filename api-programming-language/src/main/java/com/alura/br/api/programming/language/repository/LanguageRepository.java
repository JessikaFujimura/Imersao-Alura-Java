package com.alura.br.api.programming.language.repository;

import com.alura.br.api.programming.language.entity.Language;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LanguageRepository extends MongoRepository<Language,String> {
}
