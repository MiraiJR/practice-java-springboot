package com.miraijr.examing.modules.user.adapter.out.persistence.redis;

import org.springframework.data.repository.CrudRepository;

public interface UserRepositoryRedis extends CrudRepository<UserEntityRedis, Long> {

}
