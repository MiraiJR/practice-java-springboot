package com.miraijr.command_side.modules.user.adapter.out.persistence.redis;

import org.springframework.data.repository.CrudRepository;

public interface UserRepositoryRedis extends CrudRepository<UserEntityRedis, Long> {

}
