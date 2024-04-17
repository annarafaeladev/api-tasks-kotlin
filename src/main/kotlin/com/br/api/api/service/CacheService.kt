package com.br.api.api.service

import com.br.api.api.interfaces.CacheServiceConfig
import org.springframework.cache.annotation.CacheEvict
import org.springframework.stereotype.Service

@Service
class CacheService : CacheServiceConfig {

    @CacheEvict("allTasks", allEntries = true)
    override fun clearTaskCache() {
    }
}